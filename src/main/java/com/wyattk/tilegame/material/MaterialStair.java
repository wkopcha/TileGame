package com.wyattk.tilegame.material;

import com.wyattk.tilegame.Game;
import com.wyattk.tilegame.Reference;
import com.wyattk.tilegame.tile.Tile;
import com.wyattk.tilegame.tile.TileNull;
import com.wyattk.tilegame.tile.TileStairsDown;
import com.wyattk.tilegame.tile.TileStairsUp;
import com.wyattk.tilegame.util.IdBuilder;
import com.wyattk.tilegame.util.IdType;

public class MaterialStair extends Material {

    public static final String ID = IdBuilder.id(Reference.GAME_ID, IdType.MATERIAL, "stair");

    public MaterialStair(){
        super(ID, "stairs");
    }

    @Override
    public void interact(int xChange, int yChange){
        int x = Game.WORLD.getPlayer().getPosition().getX() + xChange;
        int y = Game.WORLD.getPlayer().getPosition().getY() + yChange;
        Tile t=  Game.WORLD.getTile(x,y);

        for(int a=0; a<Game.WORLD.getMaxX(); a++)
            for(int b=0; b<Game.WORLD.getMaxY(); b++)
                if(Game.WORLD.getTile(a,b).getId().equals(TileStairsDown.ID)){
                    super.interact(xChange,yChange);
                    return;
                }

        if(!t.getId().equals(TileStairsDown.ID) && !t.getId().equals(TileStairsUp.ID) && !t.getId().equals(TileNull.ID)) {
            Game.WORLD.putTile(x,y, new TileStairsDown(t.getPosition()));
            Game.WORLD.getPlayer().getInventory().takeMaterial(this, 1);
        }else
            super.interact(xChange,yChange);
    }
}
