package pl.edu.pja.stable.services.dao;

import org.hibernate.Session;
import pl.edu.pja.stable.dao.IClientDao;
import pl.edu.pja.stable.dao.IEmployeeDao;
import pl.edu.pja.stable.daoimpl.hibernate.HbnClientDao;
import pl.edu.pja.stable.daoimpl.hibernate.HbnEmployeeDao;
import pl.edu.pja.stable.entity.Client;
import pl.edu.pja.stable.managers.HibernateSessionManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Magdalena on 2017-06-16.
 */
public class ClientAndHorseService {

    IClientDao clientDao;

    public ClientAndHorseService(){
        clientDao = (IClientDao) new HbnClientDao();
    };

    /**
     * Zwraca listę klientów
     *
     * @return List<Client>
     */
    public List<Client> getAllClients(){
        return clientDao.getAll();
    }
}
