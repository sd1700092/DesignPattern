package com.imooc.factory.zen;

public interface Human {
    public void getColor();
    public void talk();
}

class BlackHuman implements Human {
    
    @Override
    public void getColor() {
        System.out.println("黑色人种的皮肤颜色是黑色的");
    }
    
    @Override
    public void talk() {
        System.out.println("黑人会说话，一般人听不懂");
    }
}

class YellowHuman implements Human {
    
    @Override
    public void getColor() {
        System.out.println("黄色人种的皮肤颜色是黄色的");
    }
    
    @Override
    public void talk() {
        System.out.println("黄色人种会说话，一般人都是双字节。");
    }
}

class WhiteHuman implements Human {
    
    @Override
    public void getColor() {
        System.out.println("白色人种的皮肤颜色是白色的");
    }
    
    @Override
    public void talk() {
        System.out.println("白色人种会说话，一般都是单字节。");
    }
}