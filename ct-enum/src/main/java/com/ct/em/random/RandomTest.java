package com.ct.em.random;

/**
 * Created by Herdsric-M-003 on 2018/5/25.
 */
class RandomTest {
    public static void main(String[] args) {
        for (int i=0; i < 20; i++){
            System.out.println(Enums.random(Activity.class));
        }
    }
}
