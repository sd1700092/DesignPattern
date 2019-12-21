package com.imooc.jdkproxy.sourcecode;

import java.lang.reflect.Method;

public interface InvocationHandler {
  void invoke(Object o, Method m);
}
