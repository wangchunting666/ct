package com.ct.em.impl;

/**
 * Created by Herdsric-M-003 on 2018/5/25.
 */
class EnumImplementation {
    public static <T> void printNext(Generator<T> rg){
        System.out.println(rg.next());
    }

    public static void main(String[] args) {
        CartoonCharacter cartoon = CartoonCharacter.BOB;
        for (int i=0; i<10; i++){
            printNext(cartoon);
        }
    }
}
