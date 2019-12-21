package com.imooc.proxy;

public class Client {
  public static void main(String[] args) {
//    Moveable minit = new Car2();
//    minit.move();
    
//    Car car = new Car();
//    Moveable m = new CarTimeProxy(car);
//    m.move();
    
    Car car = new Car();
    CarLogProxy clp = new CarLogProxy(car);
    CarTimeProxy ctp = new CarTimeProxy(clp);
    ctp.move();
  }
}
