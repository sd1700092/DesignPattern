package com.imooc.proxy;

public class CarTimeProxy implements Moveable {
  private Moveable m;
  
  public CarTimeProxy(Moveable m) {
    this.m = m;
  }
  
  @Override
  public void move() {
    long startTime = System.currentTimeMillis();
    System.out.println("汽车开始行驶...");
    m.move();
    long endTime = System.currentTimeMillis();
    System.out.println("汽车结束行驶，行驶时间：" + (endTime - startTime) + "毫秒!");
  }
}
