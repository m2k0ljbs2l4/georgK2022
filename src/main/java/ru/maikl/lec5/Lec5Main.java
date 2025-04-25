package ru.maikl.lec5;

import ru.maikl.lec4.Vector;

import java.util.*;

public class Lec5Main {
    public static String join(Collection<String> list, String sep) {
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s).append(sep);
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("Hello");
        strings.add("World");

        System.out.println(strings.get(0));
        strings.set(0, "Aboba strong");
        System.out.println(strings.get(0));
        System.out.println(strings.toArray());
        System.out.println(Arrays.toString(strings.toArray()));

        List<String> strings2 = new ArrayList<>(strings);
        System.out.println("-----");
        System.out.println(Arrays.toString(strings2.toArray()));

        System.out.println(strings.indexOf("World"));
        System.out.println(strings.isEmpty());

        List<Vector> vecs = List.of(Vector.cartesian(10, 20), Vector.cartesian(10, 20), Vector.cartesian(10, 20));
        vecs.get(0).setX(150);
        System.out.println(vecs.get(0));

        Map<String, Vector> mapVecs = Map.of("a", Vector.cartesian(10, 20), "b", Vector.cartesian(5, 7));
        Map<String, Vector> mapVecs1 = new HashMap<>();
        mapVecs1.put("a", Vector.cartesian(10, 20));
        mapVecs1.put("b", Vector.cartesian(5, 7));
        System.out.println(mapVecs.entrySet());
        System.out.println(mapVecs.values());
        System.out.println(mapVecs.keySet());
        System.out.println(Lec5Main.join(strings, ", "));
//        int a;
        int[] bs = new int[10];
        int i = 0;
//        int a = (bs[i++] = 10);
        bs[i++] = 10;
        int a = (bs[i++]);
        System.out.println(i);
        System.out.println(a);
        System.out.println(Arrays.toString(bs));
        int b = 0;
        a = a + b;
        System.out.println(a);
    }
}
