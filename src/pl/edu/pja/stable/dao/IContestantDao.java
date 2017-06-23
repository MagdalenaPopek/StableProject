package pl.edu.pja.stable.dao;

import pl.edu.pja.stable.entity.Client;
import pl.edu.pja.stable.entity.Competition;
import pl.edu.pja.stable.entity.Contestant;
import pl.edu.pja.stable.entity.Horse;

import java.util.List;

/**
 * Created by Magdalena on 2017-06-22.
 */
public interface IContestantDao extends IEntityDao<Contestant> {

    public List<Client> getAllClients();

    public List<Horse> getAllHorses();

    public List<Competition> getAllCompetitions();

}
