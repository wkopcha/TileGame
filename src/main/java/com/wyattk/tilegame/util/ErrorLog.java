package com.wyattk.tilegame.util;

import java.util.Arrays;

public class ErrorLog {

    public static void log(String type, String message){
        System.out.println(type + " ERROR");
        System.out.println(message);
    }

    public static void log(String type, Exception e){
        System.out.println(type + " ERROR");
        System.out.println(e.toString());
        for(StackTraceElement trace: e.getStackTrace())
            System.out.println("\t"+trace.toString());
    }
}
