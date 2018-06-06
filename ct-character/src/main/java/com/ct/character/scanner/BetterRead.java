package com.ct.character.scanner;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Scanner;

/**
 * Created by Herdsric-M-003 on 2018/6/6.
 */
class BetterRead {
    private static BufferedReader reader = new BufferedReader(new StringReader("Sir Robin of Camelot\n22 1.61803"));
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(reader);
        System.out.println("what is your name?");
        String name = scanner.nextLine();
        System.out.println(name);
        int age = scanner.nextInt();
        System.out.println(age);
        double favorite = scanner.nextDouble();
        System.out.println(favorite);
    }
}
