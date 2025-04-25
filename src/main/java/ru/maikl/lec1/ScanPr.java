package ru.maikl.lec1;

import java.util.*;

public class ScanPr {
    public static void main(String[] args) {
//        Scanner sc = new Scanner("Hello 30").useDelimiter(" ");
        Scanner sc = new Scanner("Hello \n30");
        System.out.println(" Input name: ");
        String name = sc.next();
        sc.nextLine();
        System.out.println(" Input age: ");
        int age = sc.nextInt();
        System.out.println("Your name: " + name + "\nYour age: " + age);
        if (sc.hasNext()) {

            System.out.println("I/O Exception");
        }
        sc.ioException();
        sc.close();
        String st = "A B C D E";
        String[] sts = st.split(" ");
        List<String > stsList = new ArrayList<>();
        for (String s : sts) {
            stsList.add(s);
            System.out.println(s);
        }
        System.out.println(stsList);


        String st1 = "1 2 3 4 5";
        Scanner sc1 = new Scanner(st1);
        int[] stStreams = Arrays.stream(sc1.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println("Stream: " + Arrays.toString(stStreams));

        Scanner scThread = new Scanner(System.in);
        Object lock = new Object();
        Runnable task = () -> {
            synchronized (lock) {
                System.out.println("Enter name: ");
                String inputName = scThread.nextLine();
                System.out.println("Thread Name: " + Thread.currentThread().getName() + ", input: " + inputName);
            }
        };

        new Thread(task).start();
        new Thread(task).start();





    }
}
