package controllers;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.controls.Controller;
import de.lessvoid.nifty.elements.Element;
import de.lessvoid.nifty.elements.render.TextRenderer;
import de.lessvoid.nifty.input.NiftyInputEvent;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.xml.xpp3.Attributes;
import java.util.Properties;
import sortingalgorithms.BubbleSort;
import utilities.ListMaker;

/**
 *
 * @author Connor Rice
 */
public class BubbleController implements Controller {
    private Element element;
    private ListMaker lm;
    private Nifty nifty;
    private Screen screen;
    
    @Override
    public void bind(Nifty nifty, Screen screen, Element element, Properties parameter, Attributes controlDefinitionAttributes) {
        this.element = element;
        this.nifty = nifty;
        this.screen = screen;
        this.lm = new ListMaker();
    }

    @Override
    public void init(Properties parameter, Attributes controlDefinitionAttributes) {
        
    }
    
    
    public void setArraySize(String sSize) {        
        int inputSize = Integer.parseInt(sSize);
        BubbleSort bs = new BubbleSort(lm.makeIntList(inputSize, inputSize));

        Element textElement = screen.findElementByName("arraySize");
        TextRenderer textRenderer = textElement.getRenderer(TextRenderer.class);
        textRenderer.setText("Array Size: " + Integer.toString(inputSize));

        long timer = System.nanoTime();
        bs.getList();
        long time = System.nanoTime() - timer;
        Element textElementNano = screen.findElementByName("nanoTime");
        TextRenderer textRendererNano = textElementNano.getRenderer(TextRenderer.class);
        textRendererNano.setText("Time in nanoseconds: " + Long.toString(time));
        Element textElementMilli = screen.findElementByName("milliTime");
        TextRenderer textRendererMilli = textElementMilli.getRenderer(TextRenderer.class);
        textRendererMilli.setText("Time in milliseconds: " + Double.toString(time/1000000.0));
        Element textElementSec = screen.findElementByName("secondTime");
        TextRenderer textRendererSec = textElementSec.getRenderer(TextRenderer.class);
        textRendererSec.setText("Time in seconds: " + Double.toString(time/1000000000.0));
        Element textElementRange = screen.findElementByName("arrayRange");
        TextRenderer textRendererRange = textElementRange.getRenderer(TextRenderer.class);
        textRendererRange.setText("Range: " + Integer.toString(inputSize));
        Element textElementSwaps = screen.findElementByName("numSwaps");
        TextRenderer textRendererSwaps = textElementSwaps.getRenderer(TextRenderer.class);
        textRendererSwaps.setText("Swaps: " + Integer.toString(bs.getNumSwaps()));
    }
    

    @Override
    public void onStartScreen() {
        
    }

    @Override
    public void onFocus(boolean getFocus) {
        
    }

    @Override
    public boolean inputEvent(NiftyInputEvent inputEvent) {
        return false;
    }

}