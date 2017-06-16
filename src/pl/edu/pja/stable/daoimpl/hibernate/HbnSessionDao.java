package pl.edu.pja.stable.daoimpl.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pl.edu.pja.stable.dao.ISessionDao;
import pl.edu.pja.stable.managers.HibernateSessionManager;

import javax.transaction.Transaction;

/**
 * Created by artur.popek on 2017-06-16.
 */
public class HbnSessionDao implements ISessionDao {

    Session session = HibernateSessionManager.getSession();

    @Override
    public Transaction beginTransaction() {
        return (Transaction) session.beginTransaction();
    }

    @Override
    public void close() {
        session.close();
    }

    public SessionFactory getSessionFactory() {
        return session.getSessionFactory();
    };

}
