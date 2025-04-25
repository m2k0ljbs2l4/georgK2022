package ru.maikl.lec4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Lec4Main {
    public static void main(String[] args) {
        Vector v = new Vector(1,5);
        v.x = 100;
        v.y = 200;

        System.out.println(v.x);
        Vector v1 = new Vector(100, 200);
        v1 = v;
        System.out.println(v1.x);
        v1.x = 500;
        System.out.println(v.x);
        System.out.println(v1.x);

        System.out.println(v1.getArg());
        System.out.println(v1.getRho());

        Vector v2 = new Vector(100, 200, 300, "null");
        v2.setZ(100);
        System.out.println(v2.getZ());
        System.out.println(v2.checkPwd("12"));

        List<Vector> vecs = new ArrayList<Vector>();
        vecs.add(Vector.cartesian(10, 20));
        vecs.add(Vector.cartesian(100, 200));

        vecs.indexOf(Vector.cartesian(10, 20));

    }

}
