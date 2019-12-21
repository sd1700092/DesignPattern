package com.imooc.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimeHandler implements InvocationHandler {
  private Object target;
  
  public TimeHandler(Object target) {
    this.target = target;
  }
  
  /**
   * 参数:
   * @param proxy 被代理对象
   * @param method 被代理对象的方法
   * @param args 方法的参数
   * @return 方法的返回值
   * @throws Throwable e
   */
  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    long startTime = System.currentTimeMillis();
    System.out.println("汽车开始行驶...");
    method.invoke(target);//相当于调用target.method方法
    long endTime = System.currentTimeMillis();
    System.out.println("汽车结束行驶...汽车行驶时间: " + (endTime - startTime) + "毫秒!");
    return null;
  }
}
