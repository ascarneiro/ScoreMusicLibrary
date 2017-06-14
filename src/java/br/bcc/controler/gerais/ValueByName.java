/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.bcc.controler.gerais;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 *
 * Este Objeto foi criado com o intuito de padronizar a forma com que são
 * passados os parametros para execucoes SQL's, assim como que os mesmos serão
 * buscados
 *
 * E uma extenção do LinkedHashMap que ja possui em seu motor os tratamentos
 * para conversão do tipo conforme necessidade do usuario
 *
 * @author ascarneiro
 */
public class ValueByName extends LinkedHashMap<Object, Object> {

    HashMap<Object, String> restricoes = new HashMap<Object, String>();

    public ValueByName() {
    }

    /**
     * Constroi um objeto do meu tipo, de acordo com o MAP passado por parâmetro
     */
    public ValueByName(Map byName) {
        super();
        putAll(byName);
    }

    /**
     * Pemite informar como que sera aplicada a restricao na utilização do
     * parâmetro, no momento de um UPDATE OU DELETE
     */
    public Object put(Object key, String restricao, Object value) {
        restricoes.put(key, restricao);
        return super.put(key, value);
    }

    
     /**
     * Retorna o valor contido no HashMap no formato String
     */
    public String getAsString(String chave) {
        if (containsKey(chave)) {
            return get(chave) == null ? "" : get(chave).toString();
        }
        return "";
    }

    /**
     * Retorna o valor contido no HashMap no formato Long
     */
    public Long getAsLong(String chave) {
        if (containsKey(chave)) {
            return Long.valueOf(getAsString(chave));
        }
        return 0L;
    }

    /**
     * Retorna o valor contido no HashMap no formato Integer
     */
    public Integer getAsInteger(String chave) {
        if (containsKey(chave)) {
            return Integer.valueOf(getAsString(chave));
        }
        return 0;
    }

    /**
     * Retorna o valor contido no HashMap no formato Date
     */
    public String getAsDate(String chave, int formato) {
        if (containsKey(chave)) {
            Date data = (Date) get(chave);
            return Funcoes.dateToString(data, formato);
        }
        return "";
    }

    /**
     * Retorna o tipo de restricao que o usuario designou no momento em que
     * passou o parâmetro para ca.. Método utilizado para restricao de UPDATES e DELETES
     */
    public String getRestricao(String chave) {
        Object o = restricoes.get(chave);
        return String.valueOf(o == null ? " = " : o);
    }
}
