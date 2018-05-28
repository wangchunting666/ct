package com.ct.em.impl;

import java.util.Random;

/**
 * Created by Herdsric-M-003 on 2018/5/25.
 */
enum CartoonCharacter implements Generator<CartoonCharacter>{
    SLAPPY,SPANKY,PUNCHY,SILLY,BOUNCY,NUTTY,BOB;
    private Random rand = new Random(47);
    @Override
    public CartoonCharacter next() {
        return values()[rand.nextInt(values().length)];
    }
}
