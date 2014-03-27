package main;

import utilities.ListMaker;
import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.audio.AudioRenderer;
import com.jme3.input.InputManager;
import com.jme3.renderer.ViewPort;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;

/**
 *
 * @author Connor Rice
 */
public class GUI extends AbstractAppState implements ScreenController {
    
    private Nifty nifty;
    private Screen screen;
    private AssetManager assetManager;
    private AudioRenderer audioRenderer;
    private ViewPort guiViewPort;
    private InputManager inputManager;
    private SimpleApplication app;
    private ListMaker lm;
    
    public GUI() {
        
    }
    
    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        this.app = (SimpleApplication) app;
        this.lm = new ListMaker();
        
    }
    
    public void mainMenu() {
        nifty.gotoScreen("main");
    }
    
    public void bubbleSort() {
        nifty.gotoScreen("bubble");
    }
    
    public void quickSort() {
        nifty.gotoScreen("quick");
    }
    
    public void mergeSort() {
        nifty.gotoScreen("merge");
    }
    
    public void exchangeSort() {
        nifty.gotoScreen("exchange");
    }
    
    public void insertionSort() {
        nifty.gotoScreen("insertion");
    }
    
    public void radixSort() {
        nifty.gotoScreen("radix");
    }
    
    public void shellSort() {
        nifty.gotoScreen("shell");
    }
    
    
    public void makeIntList(int size) {
        
    }
    
    
    @Override
    public void update(float tpf) {
        //TODO: implement behavior during runtime
    }

    @Override
    public void bind(Nifty _nifty, Screen _screen) {
        nifty = _nifty;
        screen = _screen;
    }

    @Override
    public void onStartScreen() {
        
    }

    @Override
    public void onEndScreen() {
        
    }
    @Override
    public void cleanup() {
        super.cleanup();
        //TODO: clean up what you initialized in the initialize method,
        //e.g. remove all spatials from rootNode
        //this is called on the OpenGL thread after the AppState has been detached
    } 
    
}
