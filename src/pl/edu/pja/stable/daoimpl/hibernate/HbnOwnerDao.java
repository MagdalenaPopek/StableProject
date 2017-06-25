package pl.edu.pja.stable.daoimpl.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.edu.pja.stable.dao.IOwnerDao;
import pl.edu.pja.stable.entity.Horse;
import pl.edu.pja.stable.entity.Owner;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * Created by Magdalena on 2017-06-19.
 */
public class HbnOwnerDao implements IOwnerDao {

    Session session = HibernateSessionManager.getSession();

    public HbnOwnerDao(){}

    @Override
    public List<Owner> getAll() {
        return session.createQuery("from Owner").list();
    }

    @Override
    public void addEntity(Owner entity) {
        Transaction t = session.beginTransaction();
        session.saveOrUpdate(entity);
        t.commit();
    }

    @Override
    public void deleteEntity(Owner entity) {

    }

    @Override
    public void updateEntity(Owner entity) {

    }

    @Override
    public List<Horse> getHorses() {
        return session.createQuery("Horses from Owner").list();
    }
}
