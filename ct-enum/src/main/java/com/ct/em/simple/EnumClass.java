package com.ct.em.simple;

/**
 * Created by Herdsric-M-003 on 2018/5/24.
 */
class EnumClass {
    public static void main(String[] args) {
        for (Shrubbery rub:Shrubbery.values()){
            System.out.println(rub + "orignal:" +rub.ordinal());
            System.out.println(rub.compareTo(Shrubbery.CRAWLING));
            System.out.println(rub.equals(Shrubbery.CRAWLING));
            System.out.println(rub == Shrubbery.CRAWLING);
            System.out.println(rub.getDeclaringClass());
            System.out.println(rub.name());
            System.out.println("-----------------------------------");
        }
    }
}
enum Shrubbery{
    GROUND,CRAWLING,HANGING
}
