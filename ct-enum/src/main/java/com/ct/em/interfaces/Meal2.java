package com.ct.em.interfaces;

import com.ct.em.random.Enums;

/**
 * Created by Herdsric-M-003 on 2018/5/25.
 */
enum Meal2 {
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);
    private Food[] values;
    private Meal2(Class<? extends Food> kind){
        values = kind.getEnumConstants();
    }
    interface Food {
        enum Appetizer implements Food {
            SALAD,SOUP,SPRING_ROLLS;
        }
        enum MainCourse implements Food {
            LASAGNE,BURRITO,PAD_THAI,LENTILS,HUMMOUS,VINDALOO;
        }
        enum Dessert implements Food {
            TIRAMISU,GELATO,BLACK_FOREST_CAKE,FRUIT,CREME_CARAMEL;
        }
        enum Coffee implements Food {
            BLACK_COFFEE,DECAF_COFFEE,ESPRESSO,LATTE,CAPPUCCINO,TEA,HERB_TEA;
        }
    }

    public Food randomSelect(){
        return Enums.random(values);
    }

    public static void main(String[] args) {
        for(int i=0; i<10; i++){
            for (Meal2 meal:Meal2.values()) {
                System.out.println(meal.randomSelect());
            }
            System.out.println("------------------------");
        }
    }
}
