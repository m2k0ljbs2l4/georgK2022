package ru.maikl.lec1;

import java.util.concurrent.*;

public class ExecutorExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Work in Thread Pool");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
            System.out.println("Work in Thread Pool finished");
        });
        Thread.sleep(3000);
        System.out.println("Завершаем работу");
        executor.shutdownNow();
    }
}
