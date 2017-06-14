/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.bcc.controler.gerais;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author ascarneiro
 */
public class Funcoes {

    public static ArrayList<String> getParametrosSql(String sql) {
        ArrayList set = new ArrayList();
        if (sql != null) {
            sql = sql.toUpperCase();
            int index = sql.indexOf(":");
            while (index != -1) {
                int count = countCharacter(sql.substring(0, index), '\'');
                if (count % 2 == 0) {
                    StringBuilder parameter = new StringBuilder();
                    index += 1;
                    while ((index < sql.length()) && (validateCharacter(sql.charAt(index)))) {
                        parameter.append(sql.charAt(index));
                        index++;
                    }
                    set.add(parameter.toString());
                }
                index = sql.indexOf(":", index + 1);
            }
        }
        return set;
    }

    private static int countCharacter(String string, char character) {
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == character) {
                count++;
            }
        }
        return count;
    }

    private static boolean validateCharacter(char character) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVXYWZ_abcdefghijklmnopqrstuvxywz1234567890";
        return characters.indexOf(character) != -1;
    }

    public static ArrayList<ValueByName> toArrayList(ResultSet rs) throws SQLException {
        ArrayList linhas = new ArrayList();
        if (rs != null) {
            while (rs.next()) {
                ResultSetMetaData meta = rs.getMetaData();
                ValueByName linha = new ValueByName();
                for (int i = 1; i <= meta.getColumnCount(); i++) {
                    linha.put(meta.getColumnName(i), rs.getObject(meta.getColumnName(i)));
                }
                linhas.add(linha);
            }
        }
        return linhas;
    }

    public static int getTipoValor(Object valor) {
        if ((valor instanceof Timestamp)) {
            return 93;
        }
        if ((valor instanceof Integer)) {
            return 4;
        }
        if ((valor instanceof Double)) {
            return 8;
        }
        if ((valor instanceof Float)) {
            return 6;
        }
        return 12;
    }

    public static String dateToString(Date data, int formato) {
        if ((data == null)) {
            return "";
        }
        String mascara = "dd/MM/yyyy HH:mm:ss";
        switch (formato) {
            case 1:
                mascara = "dd/MM/yyyy HH:mm:ss";
                break;
            case 2:
                mascara = "dd/MM/yyyy";
                break;
            case 3:
                mascara = "HH:mm:ss";
                break;
            case 4:
                mascara = "HH:mm";
                break;
            case 5:
                mascara = "dd/MM/yyyy HH:mm";
                break;
            case 6:
                mascara = "MM/yyyy";
                break;
            case 7:
                mascara = "yyyy";
                break;
            case 8:
                mascara = "yyyyMMddhhmmss";
                break;
            case 9:
                mascara = "dd/MM HH:mm";
                break;
            case 10:
                mascara = "ddMMyy";
                break;
            case 11:
                mascara = "MM";
                break;
            case 12:
                mascara = "dd/MM/yy";
                break;
            case 13:
                mascara = "ddMMyyyy";
                break;
            case 14:
                mascara = "dd";
                break;
            case 15:
                mascara = "HH";
                break;
            case 16:
                mascara = "dd/MM/yyyy HH";
                break;
            case 17:
                mascara = "ddMMyyyy HH:mm:ss";
                return new SimpleDateFormat(mascara).format(Long.valueOf(data.getTime()));
        }
        return "";
    }

    public static ArrayList<Object> getValores(ArrayList parametros, ValueByName valueByName) {
        ArrayList<Object> valores = new ArrayList<Object>();
        if (!parametros.isEmpty()) {
            for (Object e : parametros) {
                valores.add(valueByName.get(e.toString().replace(":", "")));
            }
        }
        return valores;
    }

    public static ArrayList<Object> getValores(ValueByName valueByName) {
        Set<Entry<Object, Object>> entrySet = valueByName.entrySet();
        ArrayList<Object> valores = new ArrayList<Object>();
        for (Entry<Object, Object> e : entrySet) {
            valores.add(e.getValue());
        }
        return valores;
    }

    public static boolean isNull(Object object) {
        return "null".equalsIgnoreCase(String.valueOf(object)) || "".equals(object.toString());
    }

    public static ValueByName nameToUpper(ValueByName valueByName) {
        if ((valueByName == null) || (valueByName.isEmpty())) {
            return valueByName;
        }
        ValueByName retorno = new ValueByName();
        Iterator it = valueByName.keySet().iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            retorno.put(key.toUpperCase(), valueByName.get(key));
        }
        return retorno;
    }

    public static ArrayList<String> toBindVariable(ArrayList<ValueByName> parametros) {
        ArrayList retorno = new ArrayList();
        for (ValueByName valueByName : parametros) {
            if (valueByName.getAsInteger("POSITION") > 0) {
                retorno.add(":".concat(valueByName.getAsString("ARGUMENT_NAME")));
            }
        }
        return retorno;
    }
}
