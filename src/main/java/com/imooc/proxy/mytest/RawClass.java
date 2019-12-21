package com.imooc.proxy.mytest;

public class RawClass implements Saveable{
  public void save(){
    System.out.println("save to hbase");
  }
}
