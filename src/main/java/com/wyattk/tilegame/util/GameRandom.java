package com.wyattk.tilegame.util;

import java.util.Random;

public class GameRandom {
    private static Random random = new Random();

    /**
     * @param min is the minimum integer value
     * @param max is the maximum integer value
     * @return a random integer between min and max
     */
    public static int getInt(int min, int max){
        return random.nextInt(max - min) + min;
    }

    public static float getFloat(float min, float max){
        return random.nextFloat() * (max - min) + min;
    }

    /**
     * @return a random boolean
     */
    public static boolean coinFlip(){
        return random.nextBoolean();
    }

    /**
     * @param odds is decimal form of the percentage for true
     * @return a random boolean
     */
    public static boolean coinFlip(float odds){
        return random.nextFloat() < odds;
    }
}
