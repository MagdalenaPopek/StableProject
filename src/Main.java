
import pl.edu.pja.stable.gui.StableFrame;
import pl.edu.pja.stable.managers.StableManager;

import javax.swing.*;

/**
 * Created by magdalena.popek on 2017-06-07.
 */
public class Main {

    public static void main(final String[] args) throws Exception {

        try {
            // Set cross-platform Java L&F (also called "Metal")
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch (UnsupportedLookAndFeelException e) {
            // handle exception
        }
        catch (ClassNotFoundException e) {
            // handle exception
        }
        catch (InstantiationException e) {
            // handle exception
        }
        catch (IllegalAccessException e) {
            // handle exception
        }

        StableManager myStableManager = new StableManager();
        myStableManager.test();

        StableFrame stableFrame = new StableFrame();
        stableFrame.setVisible(true);

    }
}