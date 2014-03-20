package sortingalgorithms;

import com.jme3.app.SimpleApplication;
import com.jme3.niftygui.NiftyJmeDisplay;
import com.jme3.system.AppSettings;
import com.jme3.system.NanoTimer;
import de.lessvoid.nifty.Nifty;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Connor Rice
 */
public class SortingAlgorithms extends SimpleApplication {
    
    private GUI GUIState;

    public static void main(String[] args) {
        AppSettings sets = new AppSettings(false);
        SortingAlgorithms app = new SortingAlgorithms();
        sets.setFrameRate(60);
        sets.setTitle("Sorting Algorithms");
 
        app.start();
        // Don't bother me logging
        Logger.getLogger("").setLevel(Level.SEVERE);
    }

    @Override
    public void simpleInitApp() {
        setTimer(new NanoTimer());
        flyCam.setDragToRotate(true);
        inputManager.setCursorVisible(true);
        flyCam.setRotationSpeed(0.0f);

        setDisplayFps(false);
        setDisplayStatView(false);
        startGUI();
    }
    @Override
    public void simpleUpdate(float tpf) {

    }
    
    public void startGUI() {
        NiftyJmeDisplay niftyDisplay = new NiftyJmeDisplay(assetManager,
                                                          inputManager,
                                                          audioRenderer,
                                                          guiViewPort);
        Nifty nifty = niftyDisplay.getNifty();
 
        guiViewPort.addProcessor(niftyDisplay);
        GUIState = new GUI();
        stateManager.attach(GUIState);
        nifty.registerScreenController(GUIState);
        nifty.fromXml("assets/GUI.xml", "start");
    }
    
}
