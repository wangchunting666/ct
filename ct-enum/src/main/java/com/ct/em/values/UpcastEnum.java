package com.ct.em.values;

/**
 * Created by Herdsric-M-003 on 2018/5/25.
 */
class UpcastEnum {
    public static void main(String[] args) {
        Search[] searches = Search.values();
        Enum e = Search.HITHER;
        for(Enum em : e.getClass().getEnumConstants()){
            System.out.println(em);
        }
    }
}
