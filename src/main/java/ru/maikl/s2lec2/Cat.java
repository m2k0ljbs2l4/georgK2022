package ru.maikl.s2lec2;

public class Cat extends Animal {
    public String name = "Murzik";

    @Override
    public void eat() {
        System.out.println("cat eat");
    }
}
