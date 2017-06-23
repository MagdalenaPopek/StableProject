package pl.edu.pja.stable.services.dao;

import pl.edu.pja.stable.entity.Stable;
import pl.edu.pja.stable.managers.SessionManager;

/**
 * Created by Magdalena on 2017-06-23.
 */
public class StableService {

    public StableService(){
    }

    public void removeStable(Stable stable){
        SessionManager.getStableDao().deleteEntity(stable);
    }

}
