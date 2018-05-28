package com.ct.em.enumset;

import java.util.EnumSet;
import static com.ct.em.enumset.AlarmPoints.*;

/**
 * Created by Herdsric-M-003 on 2018/5/25.
 */
class EnumSets {
    public static void main(String[] args) {
        EnumSet<AlarmPoints> alarmPointss = EnumSet.noneOf(AlarmPoints.class);
        alarmPointss.add(BATHROOM);
        System.out.println(alarmPointss);
        alarmPointss.addAll(EnumSet.of(STAIR1,STAIR2,KITCHEN));
        System.out.println(alarmPointss);
        alarmPointss = EnumSet.allOf(AlarmPoints.class);
        alarmPointss.removeAll(EnumSet.of(STAIR1,STAIR2,KITCHEN));
        System.out.println(alarmPointss);
        alarmPointss.removeAll(EnumSet.range(OFFICE1,OFFICE4));
        System.out.println(alarmPointss);
        alarmPointss = EnumSet.complementOf(alarmPointss);
        System.out.println(alarmPointss);
    }
}
