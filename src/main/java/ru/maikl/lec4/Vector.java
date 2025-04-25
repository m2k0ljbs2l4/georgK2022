package ru.maikl.lec4;

import java.util.Objects;

public class Vector {
    public double x;
    public double y;
    private int z;
    private String pwd;

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector(double x, double y, int z, String pwd) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.pwd = Objects.requireNonNull(pwd, "Check pwd");
    }

    public double getArg() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public double getRho() {
        return Math.atan2(this.y, this.x);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public boolean checkPwd(String pwd) {
        return this.pwd.equals(pwd);
    }

    public static Vector cartesian(double x, double y) {
        return new Vector(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return Double.compare(x, vector.x) == 0 && Double.compare(y, vector.y) == 0 && z == vector.z && Objects.equals(pwd, vector.pwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z, pwd);
    }

    @Override
    public String toString() {
        return "Vector{" +
               "x=" + x +
               ", y=" + y +
               '}';
    }
}
