package ru.maikl.lec1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ScannerPr {
    public static void main(String[] args) {
        System.out.println("Hello Scanner");
        File file = new File("test.txt");
        System.out.println(file.exists());
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(file.exists());
        System.out.println("-----");

        try {
            Scanner sc = new Scanner(file);
            try {
                while (sc.hasNextLine()) {
                    System.out.println(sc.nextLine());
                }
            } catch (IllegalStateException | NoSuchElementException e) {
                System.out.println("Error opening file " + e.getMessage());
            } finally {
                sc.close();
            }
        } catch (IOException | NullPointerException e) {
            System.out.println("Error opening file " + e.getMessage());
        }

        System.out.println("-----File file-----");
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.isAbsolute());
        System.out.println(file.length() + " bytes");
        System.out.println(file.canExecute());
        System.out.println(file.getParent());
        System.out.println("o----File file-----");

        System.out.println("-----File directory-----");
        File fileDir = new File("testDir");
        fileDir.mkdir();
        System.out.println(fileDir.isDirectory());
        System.out.println(fileDir.getAbsolutePath());
        System.out.println(file.getParent());
        System.out.println("o----File directory-----");

    }
}
