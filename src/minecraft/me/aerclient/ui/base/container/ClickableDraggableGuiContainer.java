package me.aerclient.ui.base.container;

import me.aerclient.ui.base.basic.ClickableDraggableUI;
import me.aerclient.ui.base.basic.UI;

import java.util.ArrayList;

public abstract class ClickableDraggableGuiContainer extends ClickableDraggableUI {
    public ClickableDraggableGuiContainer(int xIn, int yIn, int widthIn, int heightIn, int dragButtonIn) {
        super(xIn, yIn, widthIn, heightIn, dragButtonIn);
    }

    private ArrayList<UI> children = new ArrayList<>();

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
        super.render(mouseX, mouseY);
        renderChildren(mouseX, mouseY);
    }

    public void renderChildren(int mouseX, int mouseY){
        for(UI ui : children){
            ui.render(mouseX, mouseY);
        }
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int button) {
        super.mouseClicked(mouseX, mouseY, button);
        for(UI ui : children){
            ui.mouseClicked(mouseX,mouseY,button);
        }
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int button) {
        super.mouseReleased(mouseX, mouseY, button);
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
