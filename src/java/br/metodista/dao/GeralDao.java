package br.metodista.dao;

/**
 *
 * @author ascarneiro
 */
public class GeralDao {

    private gerais.User user;
    private DAO dao;

    public GeralDao() { 
        user = new gerais.User("root", "aloisk");
        dao = new DAO(user);
    }

    public DAO getDao() {
        return dao;
    }

}
