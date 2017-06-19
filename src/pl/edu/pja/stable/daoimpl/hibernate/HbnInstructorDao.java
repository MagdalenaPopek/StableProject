package pl.edu.pja.stable.daoimpl.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.edu.pja.stable.dao.IInstructorDao;
import pl.edu.pja.stable.entity.Instructor;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * Created by Magdalena on 2017-06-19.
 */
public class HbnInstructorDao implements IInstructorDao {

    Session session = HibernateSessionManager.getSession();

    public HbnInstructorDao(){}

    public List<Instructor> findByName(String name) {
        Query query = session.createQuery("from Instructor c where c.compName like ':name' ");
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public List <Instructor> findByString(String searchColumnName, String searchText) {
        Query query = session.createQuery("from Instructor e where e."+searchColumnName
                +" like '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List <Instructor> findByDate(String searchColumnName, Date searchText) {
        Query query = session.createQuery("from Instructor e where e."+searchColumnName
                +" = '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List <Instructor> findByInteger(String searchColumnName, Integer searchText) {
        Query query = session.createQuery("from Instructor e where e."+searchColumnName
                +" = '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List <Instructor> findByBoolean(String searchColumnName, Boolean searchText) {
        Query query = session.createQuery("from Instructor e where e."+searchColumnName
                +" = '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List<Instructor> getAll() {
        return session.createQuery("from Instructor").list();
    }

    @Override
    public void addEntity(Instructor entity) {
        Transaction t = session.beginTransaction();
        session.saveOrUpdate(entity);
        t.commit();
    }

    @Override
    public void deleteEntity(Instructor entity) {

    }

    @Override
    public void updateEntity(Instructor entity) {

    }
}
