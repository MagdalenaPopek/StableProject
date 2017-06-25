package pl.edu.pja.stable.services.dao;

import pl.edu.pja.stable.entity.Owner;
import pl.edu.pja.stable.entity.Horse;
import pl.edu.pja.stable.managers.SessionManager;

import java.util.List;

/**
 * Created by Magdalena on 2017-06-20.
 */
public class OwnerAndHorseServiceOld {

    public OwnerAndHorseServiceOld() {
    }

    /**
     * Zwraca listę klientów
     *
     * @return List<Client>
     */
    public List<Owner> getAllClients() {
        return SessionManager.getOwnerDao().getAll();
    }

    public void saveOwner(Owner o) {
        SessionManager.getOwnerDao().addEntity(o);
    }

    /**
     * Zwraca listę koni danego właściciela
     *
     * @return List<Horse>
     */
    public List<Horse> getAllHorses() {
        return SessionManager.getHorseDao().getAll();
    }

    public void saveHorse(Horse h) {
        SessionManager.getHorseDao().addEntity(h);
    }
}
