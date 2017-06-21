package pl.edu.pja.stable.services.dao;

import pl.edu.pja.stable.entity.Client;
import pl.edu.pja.stable.managers.SessionManager;

import java.util.List;

/**
 * Created by Magdalena on 2017-06-16.
 */
public class ClientService {

    public ClientService() {
    }

    /**
     * Zwraca listę klientów
     *
     * @return List<Client>
     */
    public List<Client> getAllClients() {
        return SessionManager.getClientDao().getAll();
    }

    public void saveClient(Client c) {
        SessionManager.getClientDao().addEntity(c);
    }
}
