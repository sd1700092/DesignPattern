package com.imooc.proxy.cnblogs;

public class RealSubject implements Subject {
  @Override
  public void request() {
    System.out.println("RealSubject");
  }
}
