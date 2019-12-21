package com.imooc.jdkproxy.sourcecode;

import com.imooc.proxy.Car;
import com.imooc.proxy.Moveable;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Client {
  public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
    Car car = new Car();
    InvocationHandler h = new SelfTimeHandler(car);
    Moveable m = (Moveable) Proxy.newProxyInstance(Moveable.class, h);
    m.move();
  }
}
