package pl.edu.pja.stable.services.dao;

import pl.edu.pja.stable.dao.ICompetitionDao;
import pl.edu.pja.stable.daoimpl.hibernate.HbnCompetitionDao;
import pl.edu.pja.stable.entity.Competition;
import pl.edu.pja.stable.managers.SessionManager;

import java.util.List;

/**
 * Created by Magdalena on 2017-06-16.
 */
public class CompetitionService {


    public CompetitionService() {
    }

    /**
     * Zwraca listę zawodów
     *
     * @return List<Competition>
     */
    public List<Competition> getAllCompetitions() {
        return SessionManager.getCompetitionDao().getAll();
    }

    public void saveCompetition(Competition c) {
        SessionManager.getCompetitionDao().addEntity(c);
    }



}
