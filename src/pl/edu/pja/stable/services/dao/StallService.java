package pl.edu.pja.stable.services.dao;

import pl.edu.pja.stable.entity.Stall;
import pl.edu.pja.stable.managers.SessionManager;

import java.util.List;

/**
 * Created by Magdalena on 2017-06-16.
 */
public class StallService {

    public StallService() {
    }

    /**
     * Zwraca listę klientów
     *
     * @return List<Stall>
     */
    public List<Stall> getAllStalls() {
        return SessionManager.getStallDao().getAll();
    }

    public void saveStall(Stall c) {
        SessionManager.getStallDao().addEntity(c);
    }
}
