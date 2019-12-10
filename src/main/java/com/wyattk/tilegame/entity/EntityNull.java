package com.wyattk.tilegame.entity;

import com.wyattk.tilegame.Game;
import com.wyattk.tilegame.Reference;
import com.wyattk.tilegame.util.IdBuilder;
import com.wyattk.tilegame.util.IdType;
import com.wyattk.tilegame.util.Position;

public class EntityNull extends Entity {

    public static final String ID = IdBuilder.id(Reference.GAME_ID, IdType.ENTITY, "null");
    public static final EntityNull NULL = new EntityNull(new Position(-1,-1, -1, Game.WORLD));

    public EntityNull(Position position){
        super(position);
        setId(ID);
    }
}
