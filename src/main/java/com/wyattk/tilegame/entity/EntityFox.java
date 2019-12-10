package com.wyattk.tilegame.entity;

import com.wyattk.tilegame.Reference;
import com.wyattk.tilegame.util.IdBuilder;
import com.wyattk.tilegame.util.IdType;
import com.wyattk.tilegame.util.Position;

public class EntityFox extends EntityPassive {

    public static final String ID = IdBuilder.id(Reference.GAME_ID, IdType.ENTITY, "fox");

    public EntityFox(Position position){
        super(position);
        setId(ID);
        setFullHealth(1);
        initHealth();
    }
}
