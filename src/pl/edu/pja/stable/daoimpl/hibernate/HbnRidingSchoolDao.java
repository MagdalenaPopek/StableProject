package pl.edu.pja.stable.daoimpl.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.edu.pja.stable.dao.IRidingSchoolDao;
import pl.edu.pja.stable.entity.RidingSchool;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * Created by Magdalena on 2017-06-19.
 */
public class HbnRidingSchoolDao implements IRidingSchoolDao {

    Session session = HibernateSessionManager.getSession();

    public HbnRidingSchoolDao(){}

    /*public List<RidingSchool> findByName(String name) {
        Query query = session.createQuery("from RidingSchool c where c.compName like ':name' ");
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public List <RidingSchool> findByString(String searchColumnName, String searchText) {
        Query query = session.createQuery("from RidingSchool e where e."+searchColumnName
                +" like '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List <RidingSchool> findByDate(String searchColumnName, Date searchText) {
        Query query = session.createQuery("from RidingSchool e where e."+searchColumnName
                +" = '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List <RidingSchool> findByInteger(String searchColumnName, Integer searchText) {
        Query query = session.createQuery("from RidingSchool e where e."+searchColumnName
                +" = '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List <RidingSchool> findByBoolean(String searchColumnName, Boolean searchText) {
        Query query = session.createQuery("from RidingSchool e where e."+searchColumnName
                +" = '"+searchText+"' ");
        return query.getResultList();
    }*/

    @Override
    public List<RidingSchool> getAll() {
        return session.createQuery("from RidingSchool").list();
    }

    @Override
    public void addEntity(RidingSchool entity) {
        Transaction t = session.beginTransaction();
        session.saveOrUpdate(entity);
        t.commit();
    }

    @Override
    public void deleteEntity(RidingSchool entity) {

    }

    @Override
    public void updateEntity(RidingSchool entity) {

    }
}
