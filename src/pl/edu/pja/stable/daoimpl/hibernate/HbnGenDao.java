package pl.edu.pja.stable.daoimpl.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.edu.pja.stable.dao.IClientDao;
import pl.edu.pja.stable.dao.IEntityDao;
import pl.edu.pja.stable.entity.Client;
import pl.edu.pja.stable.managers.HibernateSessionManager;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * Created by magdalena.popek on 2017-06-08.
 */
public abstract class HbnGenDao<T> implements IEntityDao{

    Session session = HibernateSessionManager.getSession();

    public HbnGenDao(){}

    public List <T> findByName(String name) {
        Query query = session.createQuery("from Employee e where e.name like ':name' ");
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public List <T> findByString(String searchColumnName, String searchText) {
        Query query = session.createQuery("from Employee e where e."+searchColumnName
                                                                                    +" like '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List <T> findByDate(String searchColumnName, Date searchText) {
        Query query = session.createQuery("from Employee e where e."+searchColumnName
                +" = '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List <T> findByInteger(String searchColumnName, Integer searchText) {
        Query query = session.createQuery("from Employee e where e."+searchColumnName
                +" = '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List <T> findByBoolean(String searchColumnName, Boolean searchText) {
        Query query = session.createQuery("from Employee e where e."+searchColumnName
                +" = '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List<T> getAll() {
        return session.createQuery("from Employee").list();
    }

//    @Override
//    public void addEntity(T entity) {
//        Transaction t = session.beginTransaction();
//        session.saveOrUpdate((T) entity);
//        t.commit();
//    }
//
//    @Override
//    public void deleteEntity(T entity) {
//
//    }
//
//    @Override
//    public void updateEntity(T entity) {
//
//    }
}
