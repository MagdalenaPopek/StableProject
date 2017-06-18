package pl.edu.pja.stable.daoimpl.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by magdalena.popek on 2017-06-08.
 */
public class HibernateSessionManager {


    private static final SessionFactory sessionFactory;

    static {
        try {
            // Utwórz SessionFactory z pliku hibernate.cfg.xml
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return sessionFactory.openSession();
    }
}

