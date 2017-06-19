package pl.edu.pja.stable.daoimpl.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.edu.pja.stable.dao.IOwnerDao;
import pl.edu.pja.stable.entity.Owner;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * Created by Magdalena on 2017-06-19.
 */
public class HbnOwnerDao implements IOwnerDao {

    Session session = HibernateSessionManager.getSession();

    public HbnOwnerDao(){}

    public List<Owner> findByName(String name) {
        Query query = session.createQuery("from Owner c where c.compName like ':name' ");
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public List <Owner> findByString(String searchColumnName, String searchText) {
        Query query = session.createQuery("from Owner e where e."+searchColumnName
                +" like '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List <Owner> findByDate(String searchColumnName, Date searchText) {
        Query query = session.createQuery("from Owner e where e."+searchColumnName
                +" = '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List <Owner> findByInteger(String searchColumnName, Integer searchText) {
        Query query = session.createQuery("from Owner e where e."+searchColumnName
                +" = '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List <Owner> findByBoolean(String searchColumnName, Boolean searchText) {
        Query query = session.createQuery("from Owner e where e."+searchColumnName
                +" = '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List<Owner> getAll() {
        return session.createQuery("from Owner").list();
    }

    @Override
    public void addEntity(Owner entity) {
        Transaction t = session.beginTransaction();
        session.saveOrUpdate(entity);
        t.commit();
    }

    @Override
    public void deleteEntity(Owner entity) {

    }

    @Override
    public void updateEntity(Owner entity) {

    }
}
