package pl.edu.pja.stable.daoimpl.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.edu.pja.stable.dao.IStallDao;
import pl.edu.pja.stable.entity.Stall;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * Created by Magdalena on 2017-06-19.
 */
public class HbnStallDao implements IStallDao {

    Session session = HibernateSessionManager.getSession();

    public HbnStallDao(){}

    /*public List<Stall> findByName(String name) {
        Query query = session.createQuery("from Stall c where c.compName like ':name' ");
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public List <Stall> findByString(String searchColumnName, String searchText) {
        Query query = session.createQuery("from Stall e where e."+searchColumnName
                +" like '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List <Stall> findByDate(String searchColumnName, Date searchText) {
        Query query = session.createQuery("from Stall e where e."+searchColumnName
                +" = '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List <Stall> findByInteger(String searchColumnName, Integer searchText) {
        Query query = session.createQuery("from Stall e where e."+searchColumnName
                +" = '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List <Stall> findByBoolean(String searchColumnName, Boolean searchText) {
        Query query = session.createQuery("from Stall e where e."+searchColumnName
                +" = '"+searchText+"' ");
        return query.getResultList();
    }*/

    @Override
    public List<Stall> getAll() {
        return session.createQuery("from Stall").list();
    }

    @Override
    public void addEntity(Stall entity) {
        Transaction t = session.beginTransaction();
        session.saveOrUpdate(entity);
        t.commit();
    }

    @Override
    public void deleteEntity(Stall entity) {

    }

    @Override
    public void updateEntity(Stall entity) {

    }
}
