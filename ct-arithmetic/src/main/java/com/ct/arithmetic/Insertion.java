package com.ct.arithmetic;

/**
 * Created by Herdsric-M-003 on 2018/4/27.
 */
public class Insertion {
    public static void sort(Comparable[] a){
        for(int i=1; i<a.length; i++){
            for(int j=i; j > 0 && less(a[j],a[j-1]); j--){
                exch(a,j,j-1);
            }
        }
    }
    public static void sort2(Comparable[] a){
        for(int i=1; i<a.length; i++){
            Comparable t = a[i];
            int j;
            for(j=i; j > 0 && less(t,a[j-1]); j--){
                a[j] = a[j-1];
            }
            a[j] = t;
        }
    }
    public static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) < 0;
    }
    public static void exch(Comparable[] a,int i, int j ){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public static void show(Comparable[] a){
        for(int i=0; i<a.length; i++){
            System.out.println(a[i] + " ");
        }
    }
    public static boolean isSorted(Comparable[] a){
        for(int i=1; i<a.length; i++){
            if(less(a[i],a[i-1])) return false;
        }
        return true;
    }
}
