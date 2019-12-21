package com.imooc.factory;

public class MCFactory implements PersonFactory {
  @Override
  public Boy getBoy() {
    return new MCBoy();
  }
  
  @Override
  public Girl getGirl() {
    return new MCGirl();
  }
}
