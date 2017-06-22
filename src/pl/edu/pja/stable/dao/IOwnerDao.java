package pl.edu.pja.stable.dao;

import pl.edu.pja.stable.entity.Horse;
import pl.edu.pja.stable.entity.Owner;

import java.util.List;

/**
 * Created by Magdalena on 2017-06-19.
 */
public interface IOwnerDao extends IEntityDao<Owner> {

    public List<Horse> getHorses();

}
