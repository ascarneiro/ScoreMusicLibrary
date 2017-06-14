package br.bcc.dao;

import br.bcc.controler.gerais.Funcoes;
import br.bcc.controler.gerais.User;
import br.bcc.controler.gerais.ValueByName;
import java.util.*;

public class DAO {

    private User user;

    public DAO(User user) {
        this.user = user;
    }

    public ArrayList<ValueByName> execSQL(String sql) throws Exception {
        return new ArrayList<ValueByName>((ArrayList) execSQL(sql, new ValueByName()));
    }

    public ArrayList<ValueByName> execSQL(String sql, ValueByName parametros) throws Exception {
        ArrayList<String> params = Funcoes.getParametrosSql(sql);
        for (String p : params) {
            sql = sql.toUpperCase().replaceAll(":" + p, "?");
        }
        ArrayList<Object> valores = Funcoes.getValores(params, parametros);
        return new ArrayList<ValueByName>((ArrayList) JDBC.getInstance(getUser()).executaSQL(sql.toLowerCase(), valores.toArray()));
    }

    public ValueByName execSQLLinha(String sql) throws Exception {
        return execSQLLinha(sql, new ValueByName());
    }

    public ValueByName execSQLLinha(String sql, ValueByName parametros) throws Exception {
        ArrayList<ValueByName> retorno = execSQL(sql, parametros);
        return new ValueByName(retorno.get(0));
    }

    public boolean insert(String nmTabela, ValueByName parametros) throws Exception {
        return JDBC.getInstance(getUser()).insert(nmTabela, parametros);
    }

    public boolean delete(String sql) throws Exception {
        return delete(sql, new ValueByName());
    }

    public boolean delete(String nmTabela, ValueByName restringir) throws Exception {
        return JDBC.getInstance(getUser()).delete(nmTabela, restringir);
    }

    public ValueByName execProcedure(String nmProcedure, ValueByName params, ValueByName out) throws Exception {
        return JDBC.getInstance(getUser()).executaProc(nmProcedure, params);
    }

    public ValueByName execFunction(String nmFunction, ValueByName parametros) throws Exception {
        return JDBC.getInstance(getUser()).execFunction(nmFunction, parametros);
    }

    public Long getSequenciaTabela(String nmTabela, String nmAtributo) throws Exception {
        String sql = new StringBuilder().append(" SELECT (nvl(max(").append(nmAtributo).append("),0)+1) NR_SEQUENCIA ").append(nmAtributo).append(" FROM   ").append(nmTabela).toString();
        ValueByName retorno = execSQLLinha(sql);
        Long seq = !retorno.isEmpty() ? Long.valueOf(retorno.get("NR_SEQUENCIA").toString()) : null;
        return seq;
    }

    public Long getSequenciaTabela(String nmTabela) throws Exception {
        String sql = new StringBuilder().append(" SELECT ").append(nmTabela).append("_seq.nextval NR_SEQUENCIA from dual").toString();
        ValueByName retorno = execSQLLinha(sql);
        Long seq = !retorno.isEmpty() ? Long.valueOf(retorno.get("NR_SEQUENCIA").toString()) : null;
        return seq;
    }

    public Long getMaxSequenciaTabela(String nmTabela, String nmAtributo) throws Exception {
        String sql = new StringBuilder().append("SELECT nvl(max(").append(nmAtributo).append("), 0) NR_SEQUENCIA").append(nmAtributo).append(" FROM ").append(nmTabela).toString();
        ValueByName retorno = execSQLLinha(sql);
        Long seq = !retorno.isEmpty() ? Long.valueOf(retorno.get("NR_SEQUENCIA").toString()) : null;
        return seq;
    }

    public Integer getIdSessaoUsuario() throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT sid FROM v$session WHERE audsid = (select userenv('SESSIONID') from dual)");
        return Integer.valueOf(execSQL(sql.toString()).toString());
    }

    public boolean update(String nmTabela, ValueByName atualizar, ValueByName restringir) throws Exception {
        return JDBC.getInstance(getUser()).update(nmTabela, atualizar, restringir);
    }

    public ValueByName execProcedure(String nmProcedure, ValueByName parametros) throws Exception {
        ValueByName retorno = execProcedure(nmProcedure, parametros, parametros);
        return retorno;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}