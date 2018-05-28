package com.ct.em.enummap;

import com.ct.em.enumset.AlarmPoints;

import java.util.EnumMap;
import java.util.Map;

/**
 * Created by Herdsric-M-003 on 2018/5/25.
 */
class EnumMaps {
    public static void main(String[] args) {
        EnumMap<AlarmPoints,Command> em = new EnumMap<AlarmPoints, Command>(AlarmPoints.class);
        em.put(AlarmPoints.KITCHEN, new Command() {
            @Override
            public void action() {
                System.out.println("Kitchen fire!");
            }
        });
        em.put(AlarmPoints.BATHROOM, new Command() {
            @Override
            public void action() {
                System.out.println("Batchroom alert!");
            }
        });
        for(Map.Entry<AlarmPoints,Command> entry:em.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue());
            entry.getValue().action();
        }
    }
}
