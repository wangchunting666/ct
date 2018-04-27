package com.ct.arithmetic;

/**
 * Created by Herdsric-M-003 on 2018/4/27.
 */
public class Divisor {
    //欧几里得算法-最大公约数
    public static int gcd(int p,int q){
        if(q == 0 ) return p;
        int r = p%q;
        return gcd(q,r);
    }
    //绝对值
    public static int abs(int x){
        if(x < 0) return -x;
        else return x;
    }
    //浮点绝对值
    public static double abs(double x){
        if(x < 0.0) return -x;
        else return x;
    }
    //判断素数
    public static boolean isPrime(int x){
        if(x < 2) return false;
        for(int i = 2; i*i <= x; i++){
            if(x % i == 0) return false;
        }
        return true;
    }
}
