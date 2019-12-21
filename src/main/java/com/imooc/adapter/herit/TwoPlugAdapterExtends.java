package com.imooc.adapter.herit;

import com.imooc.adapter.GBTwoPlug;
import com.imooc.adapter.ThreePlugIf;

public class TwoPlugAdapterExtends extends GBTwoPlug implements ThreePlugIf {
  @Override
  public void powerWithThree() {
    System.out.println("借助继承适配器");
    this.powerWithTow();
  }
}
