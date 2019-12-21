package com.imooc.singleton;

public class Singleton2 {
  private Singleton2(){}
  private static Singleton2 singleton;
  public static synchronized Singleton2 getInstance(){
    if(singleton == null){
      singleton = new Singleton2();
    }
    return singleton;
  }
  
  public static void main(String[] args) {
    Singleton2 singleton1 = Singleton2.getInstance();
    Singleton2 singleton2 = Singleton2.getInstance();
    System.out.println(singleton1 == null);
    System.out.println(singleton1 == singleton2);
  }
}
