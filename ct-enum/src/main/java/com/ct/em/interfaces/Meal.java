package com.ct.em.interfaces;

/**
 * Created by Herdsric-M-003 on 2018/5/25.
 */
class Meal {
    public static void main(String[] args) {
        for (int i=0; i<5; i++){
            for (Course course:Course.values()){
                Food food = course.randomSelection();
                System.out.println(food);
            }
            System.out.println("------");
        }
    }
}
