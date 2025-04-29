package ru.maikl.s2test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        ClassLoader classLoader = Greeter.class.getClassLoader();
        Class<?>[] interfaces = {Greeter.class};
        System.out.println(Arrays.toString(interfaces));
        System.out.println(Greeter.class);
        InvocationHandler handler = new GreeterInvocationHandler();

        Greeter greeterProxy = (Greeter) Proxy.newProxyInstance(
                classLoader,
                interfaces,
                handler);
        System.out.println(greeterProxy.greet("Alex"));
        Lock lock = new ReentrantLock();
        lock.lock();

    }
}
