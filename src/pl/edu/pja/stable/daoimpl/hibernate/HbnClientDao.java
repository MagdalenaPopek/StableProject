package pl.edu.pja.stable.daoimpl.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.edu.pja.stable.dao.IClientDao;
import pl.edu.pja.stable.entity.Client;

import javax.persistence.Entity;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * Created by Magdalena on 2017-06-08.
 */
public class HbnClientDao implements IClientDao{

    Session session = HibernateSessionManager.getSession();

    public HbnClientDao(){}

    @Override
    public List<Client> getAll() {
        return session.createQuery("from Client").list();
    }

    @Override
    public void addEntity(Client entity) {
        Transaction t = session.beginTransaction();
        session.saveOrUpdate(entity);
        t.commit();
    }

    @Override
    public void deleteEntity(Client entity) {
    }

    @Override
    public void updateEntity(Client entity) {

    }
}
