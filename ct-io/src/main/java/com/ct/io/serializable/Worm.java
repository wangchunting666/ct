package com.ct.io.serializable;

import java.io.*;
import java.util.Random;

/**
 * Created by Herdsric-M-003 on 2018/5/24.
 */
class Worm implements Serializable{
    private static Random rand = new Random(47);
    private Data[] d={
            new Data(rand.nextInt(10)),
            new Data(rand.nextInt(10)),
            new Data(rand.nextInt(10)),
    };
    private Worm next;
    private char c;
    public Worm(int i,char x){
        System.out.println("print constructor:"+i);
        this.c = x;
        if(--i > 0){
            this.next = new Worm(i,(char)(x+1));
        }
    }
    public Worm(){
        System.out.println("default constructor");
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(":");
        builder.append(c);
        builder.append("(");
        for (Data dt:d){
            builder.append(dt);
        }
        builder.append(")");
        if(next != null){
            builder.append(next);
        }
        return builder.toString();
    }

    public static void main(String[] args) throws Exception{
        Worm worm = new Worm(6,'a');
        System.out.println("worm = "+worm);

        FileOutputStream fos = new FileOutputStream("worm.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(worm);
        oos.close();
        fos.close();

        FileInputStream fis = new FileInputStream("worm.out");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Worm worm1 = (Worm) ois.readObject();
        System.out.println("worm1 = "+worm1);
        ois.close();
        fis.close();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos1 = new ObjectOutputStream(baos);
        oos1.writeObject(worm1);
        oos1.close();
        System.out.println("storage worm1 = "+baos.toString());

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois1 = new ObjectInputStream(bais);
        Worm worm2 = (Worm)ois1.readObject();
        ois1.close();
        System.out.println("worm2 = "+worm2);
    }
}
