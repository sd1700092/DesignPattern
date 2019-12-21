package com.imooc.jdkproxy;

import com.imooc.proxy.Car;
import com.imooc.proxy.Moveable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test {
  public static void main(String[] args) {
    Car car = new Car();
    InvocationHandler h = new TimeHandler(car);
    Class<? extends Car> cls = car.getClass();
  
    /**
     * loader类加载器
     * interfaces 实现接口
     * h InvocationHandler
     *
     * 动态代理实现思路
     * 实现功能:通过Proxy的new ProxyInstance返回代理对象
     * 1、声明一段源码（动态产生代理）
     * 2、编译源码（JDK Compiler API），产生新的类（代理类）
     * 3、将这个类load到内存当中，产生一个新的对象（代理对象）
     * 4、return代理对象
     */
    Moveable m = (Moveable) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), h);
    System.out.println("代理类的名字:" + m.getClass().getName());
    m.move();
  }

}
