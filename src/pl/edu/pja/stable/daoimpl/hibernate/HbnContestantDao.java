package pl.edu.pja.stable.daoimpl.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.edu.pja.stable.dao.IContestantDao;
import pl.edu.pja.stable.entity.Client;
import pl.edu.pja.stable.entity.Competition;
import pl.edu.pja.stable.entity.Contestant;
import pl.edu.pja.stable.entity.Horse;

import java.util.List;

/**
 * Created by Magdalena on 2017-06-22.
 */
public class HbnContestantDao implements IContestantDao {

    Session session = HibernateSessionManager.getSession();

    public HbnContestantDao(){}

    @Override
    public List<Contestant> getAll() {
        return session.createQuery("from Contestant").list();
    }

    @Override
    public void addEntity(Contestant entity) {
        Transaction t = session.beginTransaction();
        session.saveOrUpdate(entity);
        t.commit();
    }

    @Override
    public void deleteEntity(Contestant entity) {

    }

    @Override
    public void updateEntity(Contestant entity) {

    }

    @Override
    public List<Client> getAllClients() {
        return session.createQuery("Client from Contestant").list();
    }

    @Override
    public List<Horse> getAllHorses() {
        return session.createQuery("Horse from Contestant").list();
    }

    @Override
    public List<Competition> getAllCompetitions(){
        return session.createQuery("Competition from Contestant").list();
    }
}
