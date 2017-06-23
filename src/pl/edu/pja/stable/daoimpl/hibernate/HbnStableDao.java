package pl.edu.pja.stable.daoimpl.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.edu.pja.stable.dao.IStableDao;
import pl.edu.pja.stable.entity.Stable;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * Created by Magdalena on 2017-06-19.
 */
public class HbnStableDao implements IStableDao {

    Session session = HibernateSessionManager.getSession();

    public HbnStableDao(){}

 /*   public List<Stable> findByName(String compName) {
        Query query = session.createQuery("from Stable c where c.compName like ':name' ");
        query.setParameter("compName", compName);
        return query.getResultList();
    }

    @Override
    public List <Stable> findByString(String searchColumnName, String searchText) {
        Query query = session.createQuery("from Stable e where e."+searchColumnName
                +" like '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List <Stable> findByDate(String searchColumnName, Date searchText) {
        Query query = session.createQuery("from Stable e where e."+searchColumnName
                +" = '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List <Stable> findByInteger(String searchColumnName, Integer searchText) {
        Query query = session.createQuery("from Stable e where e."+searchColumnName
                +" = '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List <Stable> findByBoolean(String searchColumnName, Boolean searchText) {
        Query query = session.createQuery("from Stable e where e."+searchColumnName
                +" = '"+searchText+"' ");
        return query.getResultList();
    }*/

    @Override
    public List<Stable> getAll() {
        return session.createQuery("from Stable").list();
    }

    @Override
    public void addEntity(Stable entity) {
        Transaction t = session.beginTransaction();
        session.saveOrUpdate(entity);
        t.commit();
    }

    @Override
    public void deleteEntity(Stable entity) {

    }

    @Override
    public void updateEntity(Stable entity) {

    }
}
