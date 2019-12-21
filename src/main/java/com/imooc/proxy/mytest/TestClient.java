package com.imooc.proxy.mytest;

public class TestClient {
  public static void main(String[] args) {
    Saveable saveable = new RawClass();
    RawWithLogClass rwlc = new RawWithLogClass(saveable);
    rwlc.save();
  }
}
