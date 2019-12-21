package com.imooc.factory;

import com.imooc.util.PropertiesUtil;

public class HairFactory {
  public HairInterface getHair(String key){
    if("left".equals(key)){
      return new LeftHair();
    } else if("right".equals(key)){
      return new RightHair();
    }
    return null;
  }
  
//  public HairInterface getHairByClass(String className){
//    try {
//      HairInterface hair = (HairInterface) Class.forName(className).newInstance();
//      return hair;
//    } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
//      e.printStackTrace();
//      return null;
//    }
//  }
  
  public HairInterface getHairByClass(String key){
    try {
      HairInterface hair = (HairInterface) Class.forName(PropertiesUtil.getProperty(key)).newInstance();
      return hair;
    } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
      e.printStackTrace();
      return null;
    }
  }
}
