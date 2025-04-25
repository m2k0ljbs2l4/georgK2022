package ru.maikl.s2test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class GreeterInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("greet")) {
            return "Hello, " + args[0] + "!";
        }
        throw new UnsupportedOperationException("Not supported yet." + method.getName());
    }
}
