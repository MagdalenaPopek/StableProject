package pl.edu.pja.stable.daoimpl.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.edu.pja.stable.dao.IHorseDao;
import pl.edu.pja.stable.entity.Groom;
import pl.edu.pja.stable.entity.Horse;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * Created by Magdalena on 2017-06-19.
 */
public class HbnHorseDao implements IHorseDao {

    Session session = HibernateSessionManager.getSession();

    public HbnHorseDao(){}

    public List<Horse> findByName(String name) {
        Query query = session.createQuery("from Horse c where c.compName like ':name' ");
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public List <Horse> findByString(String searchColumnName, String searchText) {
        Query query = session.createQuery("from Horse e where e."+searchColumnName
                +" like '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List <Horse> findByDate(String searchColumnName, Date searchText) {
        Query query = session.createQuery("from Horse e where e."+searchColumnName
                +" = '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List <Horse> findByInteger(String searchColumnName, Integer searchText) {
        Query query = session.createQuery("from Horse e where e."+searchColumnName
                +" = '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List <Horse> findByBoolean(String searchColumnName, Boolean searchText) {
        Query query = session.createQuery("from Horse e where e."+searchColumnName
                +" = '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List<Horse> getAll() {
        return session.createQuery("from Horse").list();
    }

    @Override
    public void addEntity(Horse entity) {
        Transaction t = session.beginTransaction();
        session.saveOrUpdate(entity);
        t.commit();
    }

    @Override
    public void deleteEntity(Horse entity) {

    }

    @Override
    public void updateEntity(Horse entity) {

    }
}
