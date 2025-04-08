package ru.maikl.lec1;

import java.util.Arrays;

public class L1Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] ints = new int[10];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = i;
        }
        ArraysPr arraysPr = new ArraysPr(ints);
        System.out.println(Arrays.toString(ints));
        System.out.println(arraysPr);

        int[][] ints2 = new int[3][0];
        System.out.println(Arrays.toString(ints2));
        System.out.println(Arrays.toString(ints2[0]));
        System.out.println(ints2[0].length);

        int[] as  = new int[3];
        int[] bs = as;
        as[0] = 30;
        System.out.println(as[0]);
        System.out.println(bs[0]);
        System.out.println(as == bs);
        System.out.println(as.equals(bs));
        System.out.println("Bye");
        System.out.println("Bye");
    }
}
