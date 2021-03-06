package pl.edu.pja.stable.services.dao;

import pl.edu.pja.stable.entity.Horse;
import pl.edu.pja.stable.entity.Owner;
import pl.edu.pja.stable.managers.SessionManager;

import java.util.List;

/**
 * Created by Magdalena on 2017-06-16.
 */
public class OwnerService {

    public OwnerService() {
    }

    /**
     * Zwraca listę właścicieli
     *
     * @return List<Owner>
     */
    public List<Owner> getAllOwners() {
        return SessionManager.getOwnerDao().getAll();
    }

    /**
     * Zwraca listę koni klienta
     *
     * @return List<Horse>
     */
    public List<Horse> getHorses() {
        return SessionManager.getOwnerDao().getHorses();
    }

    public void saveOwner(Owner o) {
        SessionManager.getOwnerDao().addEntity(o);
    }

}
