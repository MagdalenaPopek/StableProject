package pl.edu.pja.stable.daoimpl.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.edu.pja.stable.dao.IEnduranceRidingDao;
import pl.edu.pja.stable.entity.EnduranceRiding;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * Created by Magdalena on 2017-06-19.
 */
public class HbnEnduranceRidingDao implements IEnduranceRidingDao {

    Session session = HibernateSessionManager.getSession();

    public HbnEnduranceRidingDao(){}

    public List<EnduranceRiding> findByName(String compName) {
        Query query = session.createQuery("from EnduranceRiding c where c.compName like ':comp_name' ");
        query.setParameter("comp_name", compName);
        return query.getResultList();
    }

    @Override
    public List <EnduranceRiding> findByString(String searchColumnName, String searchText) {
        Query query = session.createQuery("from EnduranceRiding e where e."+searchColumnName
                +" like '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List <EnduranceRiding> findByDate(String searchColumnName, Date searchText) {
        Query query = session.createQuery("from EnduranceRiding e where e."+searchColumnName
                +" = '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List <EnduranceRiding> findByInteger(String searchColumnName, Integer searchText) {
        Query query = session.createQuery("from EnduranceRiding e where e."+searchColumnName
                +" = '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List <EnduranceRiding> findByBoolean(String searchColumnName, Boolean searchText) {
        Query query = session.createQuery("from EnduranceRiding e where e."+searchColumnName
                +" = '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List<EnduranceRiding> getAll() {
        return session.createQuery("from EnduranceRiding").list();
    }

    @Override
    public void addEntity(EnduranceRiding entity) {
        Transaction t = session.beginTransaction();
        session.saveOrUpdate(entity);
        t.commit();
    }

    @Override
    public void deleteEntity(EnduranceRiding entity) {

    }

    @Override
    public void updateEntity(EnduranceRiding entity) {

    }
}
