package com.wyattk.tilegame.material;

import com.wyattk.tilegame.Reference;
import com.wyattk.tilegame.util.IdBuilder;
import com.wyattk.tilegame.util.IdType;

public class MaterialPick extends MaterialTool {

    public static final String ID = IdBuilder.id(Reference.GAME_ID, IdType.MATERIAL, "pick");

    public MaterialPick(){
        super(ID, "pick", 10);
    }
}
