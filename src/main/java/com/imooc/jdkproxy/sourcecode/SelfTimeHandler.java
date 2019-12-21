package com.imooc.jdkproxy.sourcecode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SelfTimeHandler implements InvocationHandler {
  
  private Object target;
  
  public SelfTimeHandler(Object target) {
    this.target = target;
  }
  
  @Override
  public void invoke(Object o, Method m) {
    try {
      long startTime = System.currentTimeMillis();
      System.out.println("汽车开始行驶...");
      m.invoke(target);
      long endTime = System.currentTimeMillis();
      System.out.println("汽车结束行驶...汽车行驶时间: "+ (endTime - startTime) + "毫秒!");
    } catch (IllegalAccessException | InvocationTargetException e) {
      e.printStackTrace();
    }
  }
}
