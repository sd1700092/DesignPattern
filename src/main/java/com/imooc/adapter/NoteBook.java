package com.imooc.adapter;

import com.imooc.adapter.herit.TwoPlugAdapterExtends;

public class NoteBook {
  private ThreePlugIf plug;
  
  public NoteBook(ThreePlugIf plug) {
    this.plug = plug;
  }
  
  public void charge(){
    plug.powerWithThree();
  }
  
  public static void main(String[] args) {
    GBTwoPlug two = new GBTwoPlug();
    ThreePlugIf three = new TwoPlugAdapter(two);
//    NoteBook nb = new NoteBook(three);
//    nb.charge();
    
    three = new TwoPlugAdapterExtends();
    NoteBook nb = new NoteBook(three);
    nb.charge();
  }
}
