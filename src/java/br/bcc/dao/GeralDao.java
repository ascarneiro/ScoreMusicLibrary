package br.bcc.dao;

/**
 *
 * @author ascarneiro
 */
public class GeralDao {

    private br.bcc.controler.gerais.User user;
    private DAO dao;

    public GeralDao() { 
        user = new br.bcc.controler.gerais.User("root", "root");
        dao = new DAO(user);
    }

    public DAO getDao() {
        return dao;
    }

}
