package com.imooc.factory;

public class FactoryTest {
  public static void main(String[] args) {
//    HairInterface hair = new LeftHair();
//    hair.draw();
//    HairInterface hair2 = new RightHair();
//    hair2.draw();
    
//    HairFactory hairFactory = new HairFactory();
//    HairInterface left = hairFactory.getHair("left");
//    left.draw();
//    HairInterface right = hairFactory.getHair("right");
//    right.draw();
  
//    HairFactory hairFactory = new HairFactory();
//    HairInterface left = hairFactory.getHairByClass("com.imooc.factory.LeftHair");
//    left.draw();
//    HairInterface right = hairFactory.getHairByClass("com.imooc.factory.RightHair");
//    right.draw();
  
//    HairFactory hairFactory = new HairFactory();
//    HairInterface left = hairFactory.getHairByClass("left");
//    left.draw();
//    HairInterface right = hairFactory.getHairByClass("right");
//    right.draw();
    
    PersonFactory personFactory = new HNFactory();
    Boy boy = personFactory.getBoy();
    boy.drawMan();
  }
}
