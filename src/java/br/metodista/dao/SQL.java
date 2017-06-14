/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.metodista.dao;

/**
 *
 * @author ascarneiro
 *
 *
 */
public class SQL {

    public static final String INSERT = " INSERT INTO ";
    public static final String UPDATE = " UPDATE ";
    public static final String DELETE = " DELETE FROM ";
    public static final String WHERE = " WHERE 1 = 1 ";
    public static final String AND = " AND ";
    public static final String SET = " SET ";
    public static final String EQUAL = " = ";
    public static final String SELECT_1 = " SELECT 1  ";
    public static final String SELECT = " SELECT ";
    public static final String FROM_DUAL = " FROM DUAL ";
    public static final String VALUES = " VALUES ";
    public static final String BEGIN = " BEGIN ";
    public static final String END = " END; ";
    public static final String CREATE = "CREATE ";
    public static final String DROP = "DROP ";
    public static final String ALTER = "ALTER ";
    //SQL DOS PARAMETROS DAS STORES PROCS
    public static final String SQL_PARAMETROS_STORED_PROCS = ""
            + " SELECT      *"
            + " FROM        USER_ARGUMENTS "
            + " WHERE       OBJECT_NAME	= :OBJECT_NAME "
            + " ORDER BY    POSITION";
    //SQL ATRIBUTOS TABELA
    
    
    public static final String SQL_COLUNAS_TABELA = ""
            + " SELECT      *"
            + " FROM        information_schema.columns"
            + " WHERE       TABLE_NAME	= :TABLE_NAME"
            + " ORDER BY    ORDINAL_POSITION";
}
