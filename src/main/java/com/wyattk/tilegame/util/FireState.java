package com.wyattk.tilegame.util;

public enum FireState {
    NONE,
    BURNING,
    BURNT;

    public FireState tick(){
        if (this == BURNING)
            return BURNT;
        return this;
    }
}
