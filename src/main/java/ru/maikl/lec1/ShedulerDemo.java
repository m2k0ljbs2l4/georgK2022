package ru.maikl.lec1;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ShedulerDemo {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        Runnable task = () -> System.out.println("Тик " + System.currentTimeMillis());
        scheduler.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS);

        Thread.sleep(3000);
        scheduler.shutdown();

        System.out.println("Scheduler завершён");
    }
}
