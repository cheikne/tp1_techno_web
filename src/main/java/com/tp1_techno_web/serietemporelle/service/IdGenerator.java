package com.tp1_techno_web.serietemporelle.service;

import java.util.Random;

public class IdGenerator {

    private static long id = 0;

    public static long  nextId(){
        id = id + new Random().nextInt(20) + 1;

        return id;
    }
}
