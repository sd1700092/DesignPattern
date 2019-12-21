package com.imooc.proxy.mytest;

public class RawWithLogClass implements Saveable{
  Saveable saveable;
  
  public RawWithLogClass(Saveable saveable) {
    this.saveable = saveable;
  }
  
  public void save(){
    System.out.println("log begin");
    saveable.save();
    System.out.println("log end");
  }
}
