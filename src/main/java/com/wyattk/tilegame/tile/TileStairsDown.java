package com.wyattk.tilegame.tile;

import com.wyattk.tilegame.Game;
import com.wyattk.tilegame.Reference;
import com.wyattk.tilegame.util.IdBuilder;
import com.wyattk.tilegame.util.IdType;
import com.wyattk.tilegame.util.Position;

import java.util.ArrayList;

public class TileStairsDown extends TileStairs {

    public static final String ID = IdBuilder.id(Reference.GAME_ID, IdType.TILE, "stairsdown");

    public static ArrayList<Position> levelPositions = new ArrayList<>();

    public TileStairsDown(Position position){
        super(position);
        setId(ID);

        levelPositions.add(position);

        apply();
    }

    @Override
    public void harvest(){
        if(!Game.WORLD.getPlayer().moveLevel(1)) {
            int level = Game.WORLD.getPlayer().getPosition().getLevel() - 1;
            Game.WORLD.getPlayer().getPosition().setX(TileStairsUp.levelPositions.get(level).getX());
            Game.WORLD.getPlayer().getPosition().setY(TileStairsUp.levelPositions.get(level).getY());
        }
    }
}
