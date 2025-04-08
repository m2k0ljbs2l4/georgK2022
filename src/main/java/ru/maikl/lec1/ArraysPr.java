package ru.maikl.lec1;

import java.util.Arrays;

public class ArraysPr {
    int[] ints = new int[10];

    public ArraysPr(int[] ints) {
        this.ints = ints;
    }

    public int[] getInts() {
        return ints;
    }

    public void setInts(int[] ints) {
        this.ints = ints;
    }

    @Override
    public String toString() {
        return "ArraysPr{" +
               "ints=" + Arrays.toString(ints) +
               '}';
    }
}
