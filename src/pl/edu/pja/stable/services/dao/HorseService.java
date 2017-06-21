package pl.edu.pja.stable.services.dao;

import pl.edu.pja.stable.entity.Horse;
import pl.edu.pja.stable.managers.SessionManager;

import java.util.List;

/**
 * Created by Magdalena on 2017-06-16.
 */
public class HorseService {

    public HorseService() {
    }

    /**
     * Zwraca listę klientów
     *
     * @return List<Horse>
     */
    public List<Horse> getAllHorses() {
        return SessionManager.getHorseDao().getAll();
    }

    public void saveHorse(Horse c) {
        SessionManager.getHorseDao().addEntity(c);
    }
}
