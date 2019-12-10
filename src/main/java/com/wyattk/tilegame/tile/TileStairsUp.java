package com.wyattk.tilegame.tile;

import com.wyattk.tilegame.Game;
import com.wyattk.tilegame.Reference;
import com.wyattk.tilegame.util.IdBuilder;
import com.wyattk.tilegame.util.IdType;
import com.wyattk.tilegame.util.Position;

import java.util.ArrayList;

public class TileStairsUp extends TileStairs {

    public static final String ID = IdBuilder.id(Reference.GAME_ID, IdType.TILE, "stairsup");

    public static ArrayList<Position> levelPositions = new ArrayList<>();

    public TileStairsUp(Position position){
        super(position);
        setId(ID);

        levelPositions.add(position);

        apply();
    }

    @Override
    public void harvest(){
        Game.WORLD.getPlayer().moveLevel(-1);
        int level = Game.WORLD.getPlayer().getPosition().getLevel();
        Game.WORLD.getPlayer().getPosition().setX(TileStairsDown.levelPositions.get(level).getX());
        Game.WORLD.getPlayer().getPosition().setY(TileStairsDown.levelPositions.get(level).getY());
    }
}
