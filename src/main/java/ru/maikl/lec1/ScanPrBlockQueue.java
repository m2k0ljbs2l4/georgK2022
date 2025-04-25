package ru.maikl.lec1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ScanPrBlockQueue {
    private static volatile boolean running = true;

    public static void main(String[] args) throws InterruptedException {
//        BlockingQueue<String> inputQueue = new LinkedBlockingQueue<>();
//        Scanner sc = new Scanner(System.in);
//
//        Thread inputThread = new Thread(() -> {
//            while (true) {
//                System.out.println(">>> ");
//                String line = sc.nextLine();
//                inputQueue.offer(line);
//            }
//        });
//        inputThread.setDaemon(true);
//        inputThread.start();
//
//
//        new Thread(() -> {
//            while (true) {
//                try {
//                    String data = inputQueue.take();
//                    System.out.println("Обработано: " + data);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//
//        Runnable task = () -> {
//            Scanner scanner = new Scanner("1 2 3 4"); // свой источник
//            while (scanner.hasNextInt()) {
//                System.out.println(Thread.currentThread().getName() + ": " + scanner.nextInt());
//            }
//        };
//        new Thread(task).start();
//        new Thread(task).start();

        Thread t = new Thread(() -> {
            while (true) {
                System.out.println("Я живу...");

                try {
                    System.out.println("Сохраняю важные данные...");
                    Thread.sleep(2000);
                    System.out.println("Данные сохранены!");
                } catch (InterruptedException ignored) {
                    break;
                } finally {
                    System.out.println("Закрытие ресурсов...");
                }
            }
        });

        // Без этого программа не завершится
        t.setDaemon(true);
        t.start();
        // С этим программа не завершится
//        t.join();

        System.out.println("Главный поток завершён");

//        Thread background = new Thread(() -> {
//            while (running) {
//                System.out.println("I work");
//                try {
//                    Thread.sleep(5000);
//                    System.out.println("...");
//                } catch (InterruptedException ignored) {
//                    break;
//                }
//            }
//            System.out.println("Finish work");
//
//        });
//        background.start();
//        Thread.sleep(3000);
//
//        running = false;
//        background.join();
//
//        System.out.println("Main thread finished");
    }
}
