package com.wyattk.tilegame.util;

import com.wyattk.tilegame.tile.TileNull;

import java.util.HashMap;

public class TileVoter {
    private HashMap<String, Float> tileChances;
    private float maxPercent;

    public TileVoter(){
        tileChances = new HashMap<>();
        maxPercent = 0;
    }

    public TileVoter add(String tileId, float chance){
        tileChances.putIfAbsent(tileId, chance);
        maxPercent += chance;
        return this;
    }

    public void add(String tileId){
        if(1f - maxPercent <= 0) return;
        tileChances.putIfAbsent(tileId, 1f - maxPercent);
        maxPercent = 1f;
    }

    public String getTileVote(){
        if(maxPercent <= 0 ) return TileNull.ID;
        float rand = GameRandom.getFloat(0, maxPercent);
        float total = 0;
        for(String key: tileChances.keySet()){
            if(total + tileChances.get(key) > rand)
                return key;
            total += tileChances.get(key);
        }
        return TileNull.ID;
    }
}
