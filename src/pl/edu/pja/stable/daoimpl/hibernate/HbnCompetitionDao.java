package pl.edu.pja.stable.daoimpl.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.edu.pja.stable.dao.ICompetitionDao;
import pl.edu.pja.stable.entity.Client;
import pl.edu.pja.stable.entity.Competition;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * Created by Magdalena on 2017-06-19.
 */
public abstract class HbnCompetitionDao implements ICompetitionDao {

    Session session = HibernateSessionManager.getSession();

    public HbnCompetitionDao(){}

    public List<Competition> findByName(String compName) {
        Query query = session.createQuery("from Competition c where c.compName like ':compName' ");
        query.setParameter("compName", compName);
        return query.getResultList();
    }

    @Override
    public List <Competition> findByString(String searchColumnName, String searchText) {
        Query query = session.createQuery("from Competition e where e."+searchColumnName
                +" like '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List <Competition> findByDate(String searchColumnName, Date searchText) {
        Query query = session.createQuery("from Competition e where e."+searchColumnName
                +" = '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List <Competition> findByInteger(String searchColumnName, Integer searchText) {
        Query query = session.createQuery("from Competition e where e."+searchColumnName
                +" = '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List <Competition> findByBoolean(String searchColumnName, Boolean searchText) {
        Query query = session.createQuery("from Competition e where e."+searchColumnName
                +" = '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List<Competition> getAll() {
        return session.createQuery("from Competition").list();
    }

    @Override
    public void addEntity(Competition entity) {
        Transaction t = session.beginTransaction();
        session.saveOrUpdate(entity);
        t.commit();
    }

    @Override
    public void deleteEntity(Competition entity) {

    }

    @Override
    public void updateEntity(Competition entity) {

    }
}
