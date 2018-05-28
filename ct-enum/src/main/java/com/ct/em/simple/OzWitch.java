package com.ct.em.simple;

/**
 * Created by Herdsric-M-003 on 2018/5/25.
 */
enum OzWitch {
    WEST("west"),NORTH("north"),EAST("east"),SOUTH("south");
    private String description;
    private OzWitch(String description){
        this.description = description;
    }
    public String getDescription(){
        return description;
    }
    public static void main(String[] args) {
        for (OzWitch oz:OzWitch.values()){
            System.out.println(oz + ":" + oz.getDescription());
        }
    }
}
