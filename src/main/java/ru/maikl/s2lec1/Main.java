package ru.maikl.s2lec1;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.IntConsumer;
import java.util.stream.Stream;

public class Main {

    class RangeSpliterator implements Spliterator.OfInt {
        private int current;
        private final int end;

        public RangeSpliterator(int current, int end) {
            this.current = current;
            this.end = end;
        }

        @Override
        public OfInt trySplit() {
            return null;
        }

        @Override
        public long estimateSize() {
            return 0;
        }

        @Override
        public int characteristics() {
            return 0;
        }

        @Override
        public boolean tryAdvance(IntConsumer action) {
            return false;
        }
    }

    public static void main(String[] args) {
        BiFunction<String, Long, String> f = (s, v) -> {
            return s + v;
        };
        String st = f.apply("a", 1L);
        System.out.println(st);
        System.out.println(f.apply("a", 1L));
        System.out.println(f instanceof BiFunction);
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        System.out.println(names.getClass());
        List<String> mutableList = new ArrayList<>(List.of("A", "B", "C"));

// Supplier возвращает одну и ту же коллекцию!
        Stream<List<String>> badStream = Stream.generate(() -> mutableList)
                .limit(3);


        badStream.forEach(System.out::println);
        Object object = "Hello";
        Class<String> strClass = String.class;
        System.out.println(strClass);
        String str = strClass.cast(object);
        System.out.println(str);
        System.out.println(str.getClass());
        System.out.println(strClass.isInstance(object));


    }
}
