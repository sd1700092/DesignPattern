package com.imooc.proxy.cnblogs;

public class ProxyTest {
  public static void main(String[] args) {
    RealSubject subject = new RealSubject();
    Proxy p = new Proxy(subject);
    p.request();
  }
}
