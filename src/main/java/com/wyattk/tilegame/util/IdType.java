package com.wyattk.tilegame.util;

public enum IdType {
    TILE,
    ENTITY,
    GUI,
    MATERIAL,
    RECIPE;

    public String toString(){
        switch(this){
            case TILE: return "tile";
            case ENTITY: return "entity";
            case GUI: return "gui";
            case MATERIAL: return "material";
            case RECIPE: return "recipe";
            default: return "unknown";
        }
    }
}
