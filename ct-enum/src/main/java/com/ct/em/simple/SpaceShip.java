package com.ct.em.simple;

/**
 * Created by Herdsric-M-003 on 2018/5/25.
 */
enum SpaceShip {
    SCOUT,CARGO,TRANSPORT,CRUISER,BATTLESHIP;
    @Override
    public String toString() {
        String id = name();
        String lower = id.substring(1).toLowerCase();
        return id.charAt(0) + lower;
    }
}
