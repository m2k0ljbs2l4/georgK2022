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
    }
}
