package com.ct.em.Statement;

import java.util.EnumMap;

/**
 * Created by Herdsric-M-003 on 2018/5/25.
 */
enum Category {
    MONEY(Input.NICKEL,Input.DIME,Input.QUARTER,Input.DOLLAR),
    ITEM_SELECTION(Input.TOOTHPASTE,Input.CHIPS,Input.SODA,Input.SOAP),
    QUIT_TRANSACTION(Input.ABORT_TRANSACTION),
    SHUT_DOWN(Input.STOP);
    private Input[] values;
    Category(Input... types){values = types;}
    private static EnumMap<Input,Category> categories = new EnumMap<Input, Category>(Input.class);
    static {
        for (Category c : Category.class.getEnumConstants()){
            for (Input type:c.values){
                categories.put(type,c);
            }
        }
    }
    public static Category categorize(Input input){
        return categories.get(input);
    }
}
