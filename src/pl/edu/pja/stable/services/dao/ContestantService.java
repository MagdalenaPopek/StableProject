package pl.edu.pja.stable.services.dao;

import pl.edu.pja.stable.entity.Client;
import pl.edu.pja.stable.entity.Competition;
import pl.edu.pja.stable.entity.Contestant;
import pl.edu.pja.stable.entity.Horse;
import pl.edu.pja.stable.managers.SessionManager;

import java.util.List;

/**
 * Created by Magdalena on 2017-06-22.
 */
public class ContestantService {

    public ContestantService() {
    }

    /**
     * Zwraca listę zawodników
     *
     * @return List<Horse>
     */
    public List<Contestant> getAllContestants() {
        return SessionManager.getContestantDao().getAll();
    }

    /**
     * Zwraca listę klientów
     *
     * @return List<Horse>
     */
    public List<Client> getAllClients() {
        return SessionManager.getContestantDao().getAllClients();
    }

    /**
     * Zwraca listę koni
     *
     * @return List<Horse>
     */
    public List<Horse> getAllHorses() {
        return SessionManager.getContestantDao().getAllHorses();
    }

    /**
     * Zwraca listę koni
     *
     * @return List<Horse>
     */
    public List<Competition> getAllCompetition() {
        return SessionManager.getContestantDao().getAllCompetitions();
    }

    public void saveContestant(Contestant c) {
        SessionManager.getContestantDao().addEntity(c);
    }
}
