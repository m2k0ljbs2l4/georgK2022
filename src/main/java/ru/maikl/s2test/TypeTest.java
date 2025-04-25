package ru.maikl.s2test;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;

public class TypeTest {
    class MyGenericClass<T> {
        T value;
    }

    class ArrayBox<T> {
        T value;
        T[] array;
    }
    class GenericBox extends ArrayBox<Integer> {}

    class ContHolder {
        String name;
        List<String> list;
        List<? extends Number> listNumber;

        public void honk() {
            System.out.println("hello");
        }
    }

    public static void main(String[] args) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException {
        Field field1 = ContHolder.class.getDeclaredField("name");
        Type type1 = field1.getGenericType();
        System.out.println("Type1: " + type1);
        System.out.println("Type1 class: " + type1.getClass());

        Field field2 = ContHolder.class.getDeclaredField("list");
        Type type2 = field2.getGenericType();
        System.out.println("Type2: " + type2);
        System.out.println("Type2 class: " + type2.getClass());
        ParameterizedType pt = (ParameterizedType) type2;
        System.out.println("Type2: " + Arrays.toString(pt.getActualTypeArguments()));

        Field field3 = ContHolder.class.getDeclaredField("listNumber");
        Type type3 = field3.getGenericType();
        System.out.println("Type3: " + type3);
        System.out.println("Type3 class: " + type3.getClass());
        ParameterizedType pt1 = (ParameterizedType) field3.getGenericType();
        Type arg3 = pt1.getActualTypeArguments()[0];
        System.out.println(arg3);
        System.out.println(arg3.getClass());
        System.out.println(arg3);
        System.out.println("Type3: " + Arrays.toString(pt1.getActualTypeArguments()));

        Type type = field3.getGenericType();
        Type[] typeArgs = ((ParameterizedType) type).getActualTypeArguments();
        System.out.println(Arrays.toString(typeArgs));
        Type wildcard = typeArgs[0];
        System.out.println("---");
        System.out.println(wildcard);
        System.out.println("---");
        Type[] upperBounds = ((WildcardType) wildcard).getUpperBounds();
        System.out.println(Arrays.toString(upperBounds));
        System.out.println("---");
        for (Type upperBound : upperBounds) {
            System.out.println(upperBound);
        }
        System.out.println(upperBounds[0].getTypeName());
        System.out.println(upperBounds[0].getClass());

        Field fArrayBox1 = ArrayBox.class.getDeclaredField("value");
        Type type4 = fArrayBox1.getGenericType();
        System.out.println("Type4: " + type4);
        System.out.println("Type4 class: " + type4.getClass());
        Field fArrayBox2 = ArrayBox.class.getDeclaredField("array");
        Type type5 = fArrayBox2.getGenericType();
        System.out.println("Type5: " + type5);
        System.out.println("Type5 class: " + type5.getClass());
        System.out.println("---");
        TypeVariable<?>[] typeParams = ArrayBox.class.getTypeParameters();
        for (TypeVariable<?> typeParam : typeParams) {
            System.out.println(typeParam);
        }
        System.out.println("---");
        System.out.println(ContHolder.class);
        System.out.println(ContHolder.class.getName());
        System.out.println("---");
        Class<?> clazz = Class.forName("ru.maikl.s2test.TypeTest$ContHolder");
        System.out.println(clazz);
        Object obj = new Object();
        Class<?> clazz2 = clazz.getDeclaringClass();
        Class<?> clazz3 = clazz.getSuperclass();
        System.out.println(clazz2);
        System.out.println(clazz2.getName());
        System.out.println(clazz2.isAssignableFrom(TypeTest.class));
        System.out.println(clazz3.isAssignableFrom(TypeTest.class));
        System.out.println(clazz3.isInstance(new TypeTest().new ContHolder()));

        Field field = clazz.getDeclaredField("name");
        System.out.println(field.getName());
        System.out.println(field.getType());
        System.out.println(field.getGenericType());

    }
}
