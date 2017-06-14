package br.metodista.dao;

import gerais.ValueByName;
import gerais.Funcoes;
import gerais.User;
import java.sql.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta classe foi criada com o intuito de centralizar as regras de banco como
 * UPDATE, DELETE, INSERT assim como a criacao e destruição de conexao.
 *
 *
 */
public class JDBC {

    private static final Logger logger = Logger.getLogger(JDBC.class.getName());
    private static Connection conn;
    private static HashMap<Integer, JDBC> jdbc = new HashMap<Integer, JDBC>();

    private JDBC() {
    }

    /**
     * Retorna uma instancia da classe JDBC e somente uma por usuário
     */
    public static JDBC getInstance(User user) {
        return JDBC.getInstance(user.getConnectionName(), user.getNmUsuario(), user.getDsSenha());
    }

    private static JDBC getInstance(String n, String u, String p) {
        try {
            if (!Funcoes.isNull(n)
                    || (!Funcoes.isNull(u)
                    && !Funcoes.isNull(p))) {

                int hash = 0;
                if (!Funcoes.isNull(u)
                        && !Funcoes.isNull(p)) {
                    hash = n.concat(u).concat(p).hashCode();
                    if (!jdbc.containsKey(hash)) {
                        jdbc.put(hash, new JDBC(n, u, p));
                    }

                } else if (!Funcoes.isNull(u)) {
                    hash = n.hashCode();
                    if (!jdbc.containsKey(hash)) {
                        jdbc.put(hash, new JDBC(n));
                    }
                }
                return jdbc.get(hash);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Somente será possivel a criacão do objeto pelo método
     * getInstance(Controle)
     */
    private JDBC(String n)
            throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        JDBC.conn = DriverManager.getConnection(n.startsWith("jdbc:mysql:") ? n : "jdbc:mysql://localhost/".concat(n));
    }

    /**
     * Somente será possivel a criacão do objeto pelo método
     * getInstance(Controle)
     */
    private JDBC(String n, String u, String p)
            throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        JDBC.conn = DriverManager.getConnection(n.startsWith("jdbc:mysql:") ? n : "jdbc:mysql://localhost/".concat(n), u, p);
    }

    /**
     * Encerrar a conexão
     */
    public void encerraConexao() {
        if (JDBC.conn != null) {
            try {
                JDBC.conn.close();
            } catch (SQLException ex) {
                logger.log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Executa um comando SQL passado por parâmetri e retorno o conteudo deste
     * se houver em um ArrayList<ValuesByName>
     */
    public ArrayList<ValueByName> executaSQL(String query, Object[] params) {
        PreparedStatement stmt = null;
        ArrayList<ValueByName> registros = new ArrayList<ValueByName>();
        try {
            stmt = JDBC.conn.prepareStatement(query);
            if (!query.contains(SQL.CREATE)
                    && !query.contains(SQL.DROP)
                    && !query.contains(SQL.ALTER)) {
                addParams(stmt, params);
            }

            ValueByName valores = null;
            ResultSet rs = stmt.executeQuery();

            if (!query.contains(SQL.INSERT)
                    && !query.contains(SQL.UPDATE)
                    && !query.contains(SQL.DELETE)
                    && !query.contains(SQL.DROP)
                    && !query.contains(SQL.CREATE)
                    && !query.contains(SQL.ALTER)) {
                ResultSetMetaData meta = rs.getMetaData();
                while (rs.next()) {
                    valores = new ValueByName();
                    for (int col = 1; col <= meta.getColumnCount(); col++) {
                        valores.put(meta.getColumnName(col).toUpperCase(), rs.getObject(col));
                    }
                    registros.add(valores);
                }
                return registros;
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ex) {
                logger.log(Level.SEVERE, null, ex);
            }
        }
        return registros;
    }

    /**
     * Executa um comando SQL retornando verdadeiro caso tudo ocorrer nos
     * conformes
     */
    public boolean execSQL(String query, Object[] params) {
        boolean sucess = true;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = JDBC.conn.prepareStatement(query);
            if (!query.contains(SQL.CREATE)
                    && !query.contains(SQL.DROP)
                    && !query.contains(SQL.ALTER)) {
                addParams(stmt, params);
            }
            ValueByName valores = null;
            if (query.contains(SQL.INSERT)
                    || query.contains(SQL.UPDATE)
                    || query.contains(SQL.DELETE)) {
                
                
                stmt.getConnection().setAutoCommit(true);
                stmt.executeUpdate();
                
            } else {
                rs = stmt.executeQuery();
            }
            
            ArrayList<ValueByName> registros = new ArrayList<ValueByName>();
            //
            if (!query.contains(SQL.INSERT)
                    && !query.contains(SQL.UPDATE)
                    && !query.contains(SQL.DELETE)
                    && !query.contains(SQL.DROP)
                    && !query.contains(SQL.CREATE)
                    && !query.contains(SQL.ALTER)) {

                ResultSetMetaData meta = rs.getMetaData();
                while (rs.next()) {
                    valores = new ValueByName();
                    for (int col = 1; col <= meta.getColumnCount(); col++) {
                        valores.put(meta.getColumnName(col), rs.getObject(col));
                    }
                    registros.add(valores);
                }
            }
            return true;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
            sucess = false;
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ex) {
                logger.log(Level.SEVERE, null, ex);
                sucess = false;
            }
        }
        return sucess;
    }

    private void addParams(PreparedStatement stmt, Object[] params)
            throws SQLException {
        Object[] parametros;
        if ((params.length == 1) && ((params[0] instanceof Collection))) {
            parametros = ((Collection) params[0]).toArray();
        } else {
            parametros = params;
        }

        int index = 1;
        for (Object parametro : parametros) {
            stmt.setObject(index++, parametro);
        }   
    }

    /**
     * Utilizado para execução de StoredProcedures(Procedures)
     */
    public ValueByName executaProc(String nmProcedure, ValueByName parameters) throws Exception {
        ArrayList<ValueByName> p = getDadosParametrosStoredProcedure(nmProcedure);
        StringBuilder parametros = new StringBuilder("");
        if (!p.isEmpty()) {
            parametros.append("(");
            for (int param = 0; param < p.size() - 1; param++) {
                parametros.append("?,");
            }
            parametros.append("?)");
        }

        StringBuilder plSQL = new StringBuilder();
        plSQL.append(SQL.BEGIN);
        plSQL.append(nmProcedure.concat(parametros.toString()).concat(";"));
        plSQL.append(SQL.END);
        CallableStatement stmt = conn.prepareCall(plSQL.toString());
        ValueByName out = new ValueByName();
        for (ValueByName valueByName : p) {
            if (valueByName.getAsString("IN_OUT").contains("OUT")) {
                stmt.registerOutParameter(valueByName.getAsString("ARGUMENT_NAME"), getTipoParametro(valueByName.getAsString("DATA_TYPE")));
                out.put(valueByName.getAsString("ARGUMENT_NAME"), valueByName.getAsString("ARGUMENT_NAME"));
            }
            stmt.setObject(valueByName.getAsString("ARGUMENT_NAME"), parameters.get(valueByName.getAsString("ARGUMENT_NAME")));
        }
        Set<Entry<Object, Object>> e = out.entrySet();
        ValueByName retorno = new ValueByName();
        stmt.execute();
        for (Entry<Object, Object> entry : e) {
            retorno.put(entry.getKey(), stmt.getObject(entry.getKey().toString()));
        }
        return retorno;
    }

    /**
     * Utilizado para inserir valores na tabela definida pelo argumento nmTabela
     * Insere os valores contidos no argumento valores
     *
     * Atenção -> As chaves devem ser exatamente o nome dos atributos contidos
     * na tabela.
     */
    public boolean insert(String nmTabela, ValueByName vlInserir) throws Exception {
        StringBuilder insert = new StringBuilder();
        Set<Entry<Object, Object>> entrySet = vlInserir.entrySet();
        insert.append(SQL.INSERT.concat(nmTabela).concat("("));
        //Colunas(Nomes)

        String s = "";
        for (Entry<Object, Object> e : entrySet) {
            s = s.concat(e.getKey().toString()).concat(",");
        }
        s = s.substring(0, s.length() - 1);
        insert.append(s.concat(")"));


        
        insert.append(SQL.VALUES.concat("("));
        
        s = "";
        String p = "";
        for (Entry<Object, Object> e : entrySet) {
            s = s.concat("?").concat(",");
            p = p.concat(":").concat(e.getKey().toString()).concat(",");
        }
        s = s.substring(0, s.length() - 1);
        insert.append(s);
        insert.append(")");
        ArrayList<String> parametrosSql = Funcoes.getParametrosSql(p);
        ArrayList<Object> valores = Funcoes.getValores(parametrosSql, vlInserir);
        return execSQL(insert.toString(), valores.toArray());
    }

    /**
     * tilizado para execução de StoredProcedures(Functions)
     */
    public ValueByName execFunction(String nmFunction, ValueByName parameters) throws Exception {
        ArrayList<String> params = Funcoes.toBindVariable(getDadosParametrosStoredProcedure(nmFunction));
        StringBuilder parametros = new StringBuilder("");
        if (!params.isEmpty()) {
            parametros.append("(");
            for (int param = 0; param < params.size(); param++) {
                parametros.append(params.get(param));
                if (params.size() > 1) {
                    parametros.append(",");
                }
            }
            parametros.append(") VL_COLUNA");
        }

        StringBuilder sql = new StringBuilder();
        sql.append(SQL.SELECT);
        sql.append(nmFunction.concat(parametros.toString()));
        sql.append(SQL.FROM_DUAL);
        ArrayList<Object> valores = Funcoes.getValores(params, parameters);
        return executaSQL(sql.toString(), valores.toArray()).get(0);
    }

    /**
     * Retorna as informações sobre os parametros de um determinado objeto
     * StoredProcedure, definido pelo argumento nmStoredProc
     *
     * -> Meta dados
     */
    private ArrayList<ValueByName> getDadosParametrosStoredProcedure(String nmStoredProc) {
        StringBuilder sql = new StringBuilder();
        sql.append(SQL.SQL_PARAMETROS_STORED_PROCS);
        return executaSQL(sql.toString(), new Object[]{nmStoredProc});
    }

    /**
     * Retorna as informações sobre as coluanas de um determinado objeto Table,
     * definido pelo argumento nmTabela
     *
     * -> Meta dados
     */
    private ArrayList<ValueByName> getDadosColunaTabela(String nmTabela) {
        StringBuilder sql = new StringBuilder();
        sql.append(SQL.SQL_COLUNAS_TABELA);
        return executaSQL(sql.toString(), new Object[]{nmTabela});
    }

    /**
     * Retorna o tipo correspondente no Java para cada tipo de coluna(Meta dado)
     * do Oracle.
     */
    private int getTipoParametro(String tipo) {
        if (tipo.equalsIgnoreCase("VARCHAR2")) {
            return java.sql.Types.VARCHAR;
        } else if (tipo.equalsIgnoreCase("NUMBER")) {
            return java.sql.Types.NUMERIC;
        } else if (tipo.equalsIgnoreCase("DATE")) {
            return java.sql.Types.DATE;
        } else if (tipo.equalsIgnoreCase("CLOB")) {
            return java.sql.Types.CLOB;
        } else if (tipo.equalsIgnoreCase("BLOB")) {
            return java.sql.Types.BLOB;
        }
        return java.sql.Types.VARCHAR;
    }

    /**
     * Utilizado para excluisão de registros de uma tabela, definida pelo
     * argumento nmTabela
     *
     * Atenção -> As restricoes bem como os valores a serem restringidos devem
     * ser repassados com muito cuidado atraves do argumento restricoes
     *
     * Caso não houverem restricoes, a execlusão sera a mais abrangente.
     *
     *
     */
    public boolean delete(String nmTabela, ValueByName restricoes) throws Exception {
        StringBuilder delete = new StringBuilder();
        Set<Entry<Object, Object>> entrySet = restricoes.entrySet();
        delete.append(SQL.DELETE.concat(nmTabela));

        //Restricoes
        String p = "";
        delete.append(SQL.WHERE);
        for (Entry<Object, Object> e : entrySet) {
            delete.append(SQL.AND.concat(e.getKey().toString()).concat(restricoes.getRestricao(e.getKey().toString())).concat(e.getValue().toString()));
        }


        CallableStatement stmt = conn.prepareCall(delete.toString());
        ArrayList<String> parametrosSql = Funcoes.getParametrosSql(delete.toString());
        ArrayList<Object> valores = Funcoes.getValores(parametrosSql, restricoes);
        return execSQL(delete.toString(), valores.toArray());
    }

    /**
     * Utilizado para atualização dos registros de uma determinada tabela, sendo
     * esta definidade pelo argumento nmTabela.
     *
     * valoresAtualizar -> Argumento que contém os valores a serem setados na
     * tabela durante a atualização.
     *
     * restricoes -> Corresponde as restricoes a serem utilizadas no momento de
     * atualização dos registros na tabela.
     *
     * Atenção -> Assim como no Delete, deve se tomar bastante cuidado quanto a
     * definição das restricoes para execução deste DML, pois caso não houverem
     * restricoes definidas pelo argumento, a execução deste também será a mais
     * abrangente.
     *
     *
     */
    public boolean update(String nmTabela, ValueByName valoresAtualizar, ValueByName restricoes) throws Exception {
        StringBuilder update = new StringBuilder();

        //Atualizar
        update.append(SQL.UPDATE.concat(nmTabela));
        String s = "";
        String p = "";
   
        Set<Entry<Object, Object>> entrySet = valoresAtualizar.entrySet();
        
        for (Entry<Object, Object> e : entrySet) {
            if (Funcoes.isNull(s)) {
                s = s.concat(SQL.SET);
            }
            s = s.concat(e.getKey().toString()).concat(SQL.EQUAL).concat("?").concat(",");
            p = p.concat(e.getKey().toString()).concat(SQL.EQUAL).concat(":".concat(e.getKey().toString())).concat(",");
        }
        s = s.substring(0, s.length() - 1);
        update.append(s);

        //Restricoes
        entrySet = restricoes.entrySet();
        update.append(SQL.WHERE);
        for (Entry<Object, Object> e : entrySet) {
            update.append(SQL.AND.concat(e.getKey().toString()).concat(restricoes.getRestricao(e.getKey().toString())).concat(e.getValue().toString()));
        }
        ArrayList<String> parametrosSql = Funcoes.getParametrosSql(p.toString());
        ArrayList<Object> valores = Funcoes.getValores(parametrosSql, valoresAtualizar);
        return execSQL(update.toString(), valores.toArray());
    }
}