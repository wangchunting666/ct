package com.ct.em.simple;
import static com.ct.em.simple.Spiciness.*;
/**
 * Created by Herdsric-M-003 on 2018/5/25.
 */
class Burrito {
    Spiciness degree;
    public Burrito(Spiciness degree){this.degree = degree;}
    @Override
    public String toString() {
        return "Burrito is " + degree;
    }
    public static void main(String[] args) {
        System.out.println(new Burrito(HOT));
    }
}
