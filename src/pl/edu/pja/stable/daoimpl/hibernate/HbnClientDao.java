package pl.edu.pja.stable.daoimpl.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.edu.pja.stable.dao.IClientDao;
import pl.edu.pja.stable.entity.Client;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * Created by magdalena.popek on 2017-06-08.
 */
public class HbnClientDao implements IClientDao{


    Session session = HibernateSessionManager.getSession();

    public HbnClientDao(){}

    public List <Client> findByName(String name) {
        Query query = session.createQuery("from Client e where e.name like ':name' ");
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public List <Client> findByString(String searchColumnName, String searchText) {
        Query query = session.createQuery("from Employee e where e."+searchColumnName
                                                                                    +" like '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List <Client> findByDate(String searchColumnName, Date searchText) {
        Query query = session.createQuery("from Employee e where e."+searchColumnName
                +" = '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List <Client> findByInteger(String searchColumnName, Integer searchText) {
        Query query = session.createQuery("from Employee e where e."+searchColumnName
                +" = '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List <Client> findByBoolean(String searchColumnName, Boolean searchText) {
        Query query = session.createQuery("from Employee e where e."+searchColumnName
                +" = '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List<Client> getAll() {
        return session.createQuery("from Client").list();
    }

    @Override
    public void addEntity(Client entity) {
        Transaction t = session.beginTransaction();
        session.saveOrUpdate(entity);
        t.commit();
    }

    @Override
    public void deleteEntity(Client entity) {

    }

    @Override
    public void updateEntity(Client entity) {

    }
}
