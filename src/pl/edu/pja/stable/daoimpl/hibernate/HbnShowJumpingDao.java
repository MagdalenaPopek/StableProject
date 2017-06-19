package pl.edu.pja.stable.daoimpl.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.edu.pja.stable.dao.IShowJumpingDao;
import pl.edu.pja.stable.entity.ShowJumping;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * Created by Magdalena on 2017-06-19.
 */
public class HbnShowJumpingDao implements IShowJumpingDao {

    Session session = HibernateSessionManager.getSession();

    public HbnShowJumpingDao(){}

    public List<ShowJumping> findByName(String compName) {
        Query query = session.createQuery("from ShowJumping c where c.compName like ':compName' ");
        query.setParameter("compName", compName);
        return query.getResultList();
    }

    @Override
    public List <ShowJumping> findByString(String searchColumnName, String searchText) {
        Query query = session.createQuery("from ShowJumping e where e."+searchColumnName
                +" like '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List <ShowJumping> findByDate(String searchColumnName, Date searchText) {
        Query query = session.createQuery("from ShowJumping e where e."+searchColumnName
                +" = '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List <ShowJumping> findByInteger(String searchColumnName, Integer searchText) {
        Query query = session.createQuery("from ShowJumping e where e."+searchColumnName
                +" = '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List <ShowJumping> findByBoolean(String searchColumnName, Boolean searchText) {
        Query query = session.createQuery("from ShowJumping e where e."+searchColumnName
                +" = '"+searchText+"' ");
        return query.getResultList();
    }

    @Override
    public List<ShowJumping> getAll() {
        return session.createQuery("from ShowJumping").list();
    }

    @Override
    public void addEntity(ShowJumping entity) {
        Transaction t = session.beginTransaction();
        session.saveOrUpdate(entity);
        t.commit();
    }

    @Override
    public void deleteEntity(ShowJumping entity) {

    }

    @Override
    public void updateEntity(ShowJumping entity) {

    }
}
