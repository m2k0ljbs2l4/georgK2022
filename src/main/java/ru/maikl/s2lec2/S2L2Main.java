package ru.maikl.s2lec2;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class S2L2Main {
    public static void main(String[] args) {
        IAbstrAnimal cat1 = new Cat();
        IAbstrAnimal dog1 = new Dog();
        cat1.eat();
        dog1.eat();

        if (cat1 instanceof Cat) {
            Cat c = (Cat) cat1;
            c.eat();
            System.out.println("It's a cat");
        }

        Class<?> aClass = cat1.getClass();
        System.out.println("Class: " + aClass);
        System.out.println("Class: " + aClass.getName());

        Class<Cat> catClass = Cat.class;
        System.out.println("Class: " + catClass);
        Class<?> catClass1 = Cat.class;
        Method[] methods = catClass1.getMethods();
        Field[] fields = catClass1.getDeclaredFields();
        System.out.println(methods);
        System.out.println(fields);

        List<String> strings = new ArrayList<>();
        System.out.println(strings.getClass());
        Type type = new ArrayList<String>() {}.getClass().getGenericSuperclass();
        System.out.println(type);

    }
}
