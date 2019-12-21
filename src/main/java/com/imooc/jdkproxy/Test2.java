package com.imooc.jdkproxy;

import com.imooc.proxy.Car;
import com.imooc.proxy.CarLogProxy;
import com.imooc.proxy.Moveable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test2 {
  public static void main(String[] args) {
    Moveable m = new Car();
    CarLogProxy car = new CarLogProxy(m);
    InvocationHandler handler = new TimeHandler(car);
    Class<? extends CarLogProxy> cls = car.getClass();
    Moveable m1 = (Moveable) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), handler);
    m1.move();
  }
}
