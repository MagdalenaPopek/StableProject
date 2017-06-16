
import pl.edu.pja.stable.managers.StableManager;

/**
 * Created by magdalena.popek on 2017-06-07.
 */
public class Main {

    public static void main(final String[] args) throws Exception {

        StableManager myStableManager = new StableManager();
        myStableManager.test();
        myStableManager.run();
        myStableManager.close();

    }
}