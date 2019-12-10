package com.wyattk.tilegame.gui;

import com.wyattk.tilegame.util.ErrorLog;

public abstract class Gui {
    private GuiChar[][] noDisplay;

    private int width, height, xOffset, yOffset;
    private String id;
    private GuiChar[][] display;
    private boolean enabled;
    private boolean shouldDisplay;

    public Gui(int width, int height, int xOffset, int yOffset, String id){
        this.width = width;
        this.height = height;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.id = id;
        this.display = new GuiChar[width][height];
        this.noDisplay = new GuiChar[width][height];
        for(int x=0; x<width; x++)
            for(int y=0; y<height; y++)
                noDisplay[x][y] = GuiStaticChar.EMPTY;
        this.enabled = true;
        this.shouldDisplay = true;
    }

    protected void setDisplay(GuiChar[][] display){
        if(display == null){
            ErrorLog.log("GUI","Display array is null");
            return;
        }

        if(display.length < width - 1 || display[0].length < height - 1) return;
        for(int x=0; x<width; x++)
            for(int y=0; y<height; y++)
                this.display[x][y] = display[x][y];
    }

    protected void setDisplay(GuiChar[][] display, boolean flipXY){
        if(!flipXY){
            setDisplay(display);
            return;
        }

        if(display == null){
            ErrorLog.log("GUI","Display array is null");
            return;
        }

        if(display.length < height - 1 || display[0].length < width - 1) return;

        for(int x=0; x<width; x++)
            for(int y=0; y<height; y++)
                this.display[x][y] = display[y][x];
    }

    public void enable(){
        enabled = true;
        shouldDisplay = true;
    }

    public void disable(){
        enabled = false;
    }

    public void initDisable(){
        enabled = false;
        shouldDisplay = false;
    }

    public void toggle(){
        if(enabled)
            disable();
        else
            enable();
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public int getXOffset() {
        return xOffset;
    }

    public int getYOffset(){
        return yOffset;
    }

    public boolean shouldDisplay(){
        return shouldDisplay;
    }

    public String getId(){
        return id;
    }

    public GuiChar[][] getDisplay(){
        if(enabled)
            return display;
        if(shouldDisplay)
            shouldDisplay = false;
        return noDisplay;
    }

    public void tick(){}
}
