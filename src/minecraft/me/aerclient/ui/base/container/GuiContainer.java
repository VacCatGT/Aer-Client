package me.aerclient.ui.base.container;

import me.aerclient.ui.base.basic.BasicGuiElement;
import me.aerclient.ui.base.basic.UI;

import java.util.ArrayList;

/**
 * Base class for gui's that you can add UI elements to, which will then be handled by the container.
 */
public abstract class GuiContainer extends BasicGuiElement {

    private ArrayList<UI> children = new ArrayList<>();


    public GuiContainer(int xIn, int yIn, int widthIn, int heightIn) {
        super(xIn, yIn, widthIn, heightIn);
    }

    public void add(UI element){
        children.add(element);
    }


    public void remove(UI element){
        children.remove(element);
    }

    public ArrayList<UI> getChildren(){
        return children;
    }

    public int getTotalHeightOfChildren(){
        int total = 0;
        for(UI ui : children){
            total += ui.getHeight();
        }
        return total;
    }

    @Override
    public void init() {
        for(UI ui : children){
            ui.init();
        }
    }

    @Override
    public void render(int mouseX, int mouseY) {
        for(UI ui : children){
            ui.render(mouseX, mouseY);
        }
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int button) {
        for(UI ui : children){
            ui.mouseClicked(mouseX,mouseY,button);
        }
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int button) {
        for(UI ui : children){
            ui.mouseReleased(mouseX,mouseY,button);
        }
    }

    @Override
    public void keyPressed(int key) {
        for(UI ui : children){
            ui.keyPressed(key);
        }
    }
}
