package com.imooc.jdkproxy.sourcecode;
import java.lang.reflect.Method;

public class $Proxy0 implements com.imooc.proxy.Moveable {
  private InvocationHandler h;
  
  public $Proxy0(InvocationHandler h) {
    this.h = h;
  }
  
  @Override
  public void move() {
try{
Method md = com.imooc.proxy.Moveable.class.getMethod("move");
h.invoke(this, md);} catch(Exception e){ e.printStackTrace();}  }

}
