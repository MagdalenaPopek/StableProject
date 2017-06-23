package pl.edu.pja.stable.daoimpl.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.edu.pja.stable.dao.IGroomDao;
import pl.edu.pja.stable.entity.Groom;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * Created by Magdalena on 2017-06-19.
 */
public class HbnGroomDao implements IGroomDao {

    Session session = HibernateSessionManager.getSession();

    public HbnGroomDao(){}

   /* public List<Groom> findByName(String name) {
        Query query = session.createQuery("from Groom c where c.compName like ':name' ");
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public List <Groom> findByString(String searchColumnName, String searchText) {
        Query query = session.createQuery("from Groom e where e."+searchColumnName
                +" like '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List <Groom> findByDate(String searchColumnName, Date searchText) {
        Query query = session.createQuery("from Groom e where e."+searchColumnName
                +" = '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List <Groom> findByInteger(String searchColumnName, Integer searchText) {
        Query query = session.createQuery("from Groom e where e."+searchColumnName
                +" = '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List <Groom> findByBoolean(String searchColumnName, Boolean searchText) {
        Query query = session.createQuery("from Groom e where e."+searchColumnName
                +" = '"+searchText+"' ");
        return query.getResultList();
    }*/

    @Override
    public List<Groom> getAll() {
        return session.createQuery("from Groom").list();
    }

    @Override
    public void addEntity(Groom entity) {
        Transaction t = session.beginTransaction();
        session.saveOrUpdate(entity);
        t.commit();
    }

    @Override
    public void deleteEntity(Groom entity) {

    }

    @Override
    public void updateEntity(Groom entity) {

    }
}
