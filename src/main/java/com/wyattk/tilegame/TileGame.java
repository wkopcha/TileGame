package com.wyattk.tilegame;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyType;
import com.wyattk.tilegame.entity.EntityFox;
import com.wyattk.tilegame.entity.player.Player;
import com.wyattk.tilegame.gui.crafting.GuiCrafting;
import com.wyattk.tilegame.gui.gameover.GuiGameOver;
import com.wyattk.tilegame.gui.inventory.GuiInventory;
import com.wyattk.tilegame.gui.movement.GuiMovement;
import com.wyattk.tilegame.gui.playerhealth.GuiPlayerHealth;
import com.wyattk.tilegame.material.*;
import com.wyattk.tilegame.recipe.RecipeBoat;
import com.wyattk.tilegame.recipe.RecipeKindling;
import com.wyattk.tilegame.recipe.RecipePick;
import com.wyattk.tilegame.recipe.RecipeStairs;
import com.wyattk.tilegame.registry.Registry;
import com.wyattk.tilegame.tile.*;
import com.wyattk.tilegame.util.IdBuilder;
import com.wyattk.tilegame.util.IdType;

public class TileGame {

    /**
     * Initializes all base game tiles
     */
    public static void init(){
        //Tiles
        Registry.registerTile(TilePlains.ID, TilePlains.class);
        Registry.registerTile(TileTree.ID, TileTree.class);
        Registry.registerTile(TileWater.ID, TileWater.class);
        Registry.registerTile(TileDesert.ID, TileDesert.class);
        Registry.registerTile(TileBeach.ID, TileBeach.class);
        Registry.registerTile(TileMountain.ID, TileMountain.class);
        Registry.registerTile(TileDesertMountain.ID, TileDesertMountain.class);
        Registry.registerTile(TileStoneWall.ID, TileStoneWall.class);
        Registry.registerTile(TileCaveFloor.ID, TileCaveFloor.class);
        Registry.registerTile(TileGem.ID, TileGem.class);



        //Entities
        Registry.registerEntity(EntityFox.ID, EntityFox.class);



        //GUIs
        Registry.registerGui(GuiMovement.ID, GuiMovement.class);
        Registry.registerGui(GuiPlayerHealth.ID, GuiPlayerHealth.class);
        Registry.registerGui(GuiGameOver.ID, GuiGameOver.class);
        Registry.registerGui(GuiInventory.ID, GuiInventory.class);
        Registry.registerGui(GuiCrafting.ID, GuiCrafting.class);




        //Materials
        Registry.registerMaterial(MaterialWood.ID, MaterialWood.class);
        Registry.registerMaterial(MaterialBoat.ID, MaterialBoat.class);
        Registry.registerMaterial(MaterialKindling.ID, MaterialKindling.class);
        Registry.registerMaterial(MaterialStair.ID, MaterialStair.class);
        Registry.registerMaterial(MaterialPick.ID, MaterialPick.class);



        //Recipes
        Registry.registerRecipe(RecipeBoat.ID, RecipeBoat.class);
        Registry.registerRecipe(RecipeKindling.ID, RecipeKindling.class);
        Registry.registerRecipe(RecipeStairs.ID, RecipeStairs.class);
        Registry.registerRecipe(RecipePick.ID, RecipePick.class);



        //Icons - Tile
        Registry.registerIcon(IdBuilder.id(Reference.GAME_ID, IdType.TILE, "none"),' ');
        Registry.registerIcon(TileNull.ID,' ');

        Registry.registerIcon(TilePlains.ID, ',', TextColor.ANSI.GREEN);
        Registry.registerIcon(IdBuilder.id(TilePlains.ID, "burning"), '&', Reference.COLOR_FIRE);
        Registry.registerIcon(IdBuilder.id(TilePlains.ID, "burnt"), '.', new TextColor.RGB(51,51,51));

        Registry.registerIcon(TileTree.ID,'^', new TextColor.RGB(0,150,0));
        Registry.registerIcon(IdBuilder.id(TileTree.ID, "burning"), '&', Reference.COLOR_FIRE);
        Registry.registerIcon(IdBuilder.id(TileTree.ID, "burnt"), '#', new TextColor.RGB(45,45,45));
        Registry.registerIcon(IdBuilder.id(TileTree.ID,"cut"), '#', new TextColor.RGB(205,95,0));

        Registry.registerIcon(TileWater.ID, new TextCharacter(
                '~',
                TextColor.ANSI.BLUE,
                TextColor.ANSI.DEFAULT,
                SGR.BOLD)
        );

        Registry.registerIcon(TileDesert.ID, ':', new TextColor.RGB(255, 195, 115));
        Registry.registerIcon(TileBeach.ID, '.', new TextColor.RGB(200, 140, 60));
        Registry.registerIcon(TileMountain.ID, new TextCharacter(
                '^',
                new TextColor.RGB(185,185,185),
                TextColor.ANSI.DEFAULT,
                SGR.BOLD)
        );
        Registry.registerIcon(TileDesertMountain.ID, new TextCharacter(
                '^',
                new TextColor.RGB(175,115,25),
                TextColor.ANSI.DEFAULT,
                SGR.BOLD)
        );

        Registry.registerIcon(TileStoneWall.ID, new TextCharacter(
                '#',
                new TextColor.RGB(175,175,175),
                TextColor.ANSI.DEFAULT,
                SGR.BOLD)
        );
        Registry.registerIcon(IdBuilder.id(TileStoneWall.ID, "broken"), new TextCharacter(
                '#',
                new TextColor.RGB(135,135,135),
                TextColor.ANSI.DEFAULT,
                SGR.BOLD,
                SGR.BLINK)
        );
        Registry.registerIcon(TileCaveFloor.ID, '.', new TextColor.RGB(51,51,51));
        Registry.registerIcon(TileStairsDown.ID, new TextCharacter(
                Symbols.ARROW_DOWN,
                new TextColor.RGB(215,175,50),
                TextColor.ANSI.DEFAULT,
                SGR.BOLD)
        );
        Registry.registerIcon(TileStairsUp.ID, new TextCharacter(
                Symbols.ARROW_UP,
                new TextColor.RGB(215,175,50),
                TextColor.ANSI.DEFAULT,
                SGR.BOLD)
        );
        Registry.registerIcon(TileGem.ID, new TextCharacter(
                '*',
                new TextColor.RGB(255,4,175),
                TextColor.ANSI.DEFAULT,
                SGR.BOLD)
        );



        //Icons - Entity
        Registry.registerIcon(Player.ID, new TextCharacter(
                '@',
                TextColor.ANSI.WHITE,
                TextColor.ANSI.DEFAULT,
                SGR.BOLD)
        );
        Registry.registerIcon(IdBuilder.id(Player.ID, "boat"), new TextCharacter(
                '±',
                new TextColor.RGB(191,101,55),
                TextColor.ANSI.DEFAULT,
                SGR.BOLD)
        );

        Registry.registerIcon(EntityFox.ID, new TextCharacter(
                '%',
                new TextColor.RGB(175,75,0),
                TextColor.ANSI.DEFAULT,
                SGR.BOLD
        ));
        Registry.registerIcon(IdBuilder.id(EntityFox.ID,"dead"), new TextCharacter(
                '%',
                new TextColor.RGB(150,0,0),
                TextColor.ANSI.DEFAULT,
                SGR.BOLD
        ));



        //Keys

        //.move
        Registry.registerKeybind(KeyType.ArrowUp, () -> {
            if(Game.WORLD.getGui(GuiCrafting.ID).shouldDisplay())
                ((GuiCrafting)Game.WORLD.getGui(GuiCrafting.ID)).moveSelection(true);
            else
                Game.WORLD.getPlayer().move(0,-1);
        });
        Registry.registerKeybind(KeyType.ArrowDown, () -> {
            if(Game.WORLD.getGui(GuiCrafting.ID).shouldDisplay())
                ((GuiCrafting)Game.WORLD.getGui(GuiCrafting.ID)).moveSelection(false);
            else
                Game.WORLD.getPlayer().move(0,1);
        });
        Registry.registerKeybind(KeyType.ArrowLeft, () -> Game.WORLD.getPlayer().move(-1,0));
        Registry.registerKeybind(KeyType.ArrowRight, () -> Game.WORLD.getPlayer().move(1,0));

        //.interact
        Registry.registerKeybind('w', () -> {
            ((GuiInventory) Game.WORLD.getGui(GuiInventory.ID)).getSelected().interact(0, -1);
        });
        Registry.registerKeybind('s', () -> {
            ((GuiInventory) Game.WORLD.getGui(GuiInventory.ID)).getSelected().interact(0, 1);
        });
        Registry.registerKeybind('a', () -> {
            ((GuiInventory) Game.WORLD.getGui(GuiInventory.ID)).getSelected().interact(-1, 0);
        });
        Registry.registerKeybind('d', () -> {
            ((GuiInventory) Game.WORLD.getGui(GuiInventory.ID)).getSelected().interact(1, 0);
        });
        //.other
        Registry.registerKeybind(KeyType.Tab, () -> Game.WORLD.getGui(GuiMovement.ID).toggle());

        Registry.registerKeybind('x', () -> {
            Game.WORLD.getGui(GuiCrafting.ID).toggle();
        });

        Registry.registerKeybind('q', () -> {
            ((GuiInventory) Game.WORLD.getGui(GuiInventory.ID)).moveSelection(true);
        });

        Registry.registerKeybind('e', () -> {
            ((GuiInventory) Game.WORLD.getGui(GuiInventory.ID)).moveSelection(false);
        });

        Registry.registerKeybind('z', () -> {
            if(Game.WORLD.getGui(GuiCrafting.ID).shouldDisplay() && ((GuiCrafting)Game.WORLD.getGui(GuiCrafting.ID)).getSelectedRecipe() != null)
                Game.WORLD.getPlayer().getInventory().craft(((GuiCrafting)Game.WORLD.getGui(GuiCrafting.ID)).getSelectedRecipe());
            else
                ((GuiInventory) Game.WORLD.getGui(GuiInventory.ID)).getSelected().interact(0, 0);
        });

    }
}
