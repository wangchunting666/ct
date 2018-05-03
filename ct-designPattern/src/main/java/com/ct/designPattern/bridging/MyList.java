package com.ct.designPattern.bridging;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Herdsric-M-003 on 2018/5/2.
 */
public class MyList<T> {
    private List<T> list;
    private Object[] arr;
    public MyList(List<T> list){
        this.list = list;
        arr = this.list.toArray();
    }
    public void sort(){
        Arrays.sort(arr);
    }
    public int binarySearch(T key){
        int pos = Arrays.binarySearch(arr,key);
        return pos;
    }
    public void descriptionList() throws Exception{
        System.out.println("list:");
        for(T t:list){System.out.print(t+" ");}
        System.out.println("");
    }
    public void descriptionArray() throws Exception{
        System.out.println("array:");
        for(Object t:arr){System.out.print(t+" ");}
        System.out.println("");
    }
    public void fill(){
        ListIterator<T> i = list.listIterator();
        for(Object obj:arr){
            i.next();
            i.set((T)obj);
        }
    }
}
