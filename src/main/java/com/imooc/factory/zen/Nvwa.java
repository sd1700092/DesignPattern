package com.imooc.factory.zen;

public class Nvwa {
    public static void main(String[] args) {
        AbstractHumanFactory yinYangLu = new HumanFactory();
        System.out.println("--早出第一批人是白色人种--");
        Human whiteHuman = yinYangLu.createHuman(WhiteHuman.class);
        whiteHuman.getColor();
        whiteHuman.talk();
        System.out.println("--早出第一批人是黑色人种--");
        Human blackHuman = yinYangLu.createHuman(BlackHuman.class);
        blackHuman.getColor();
        blackHuman.talk();
        System.out.println("--早出第一批人是黄色人种--");
        Human yellowHuman = yinYangLu.createHuman(YellowHuman.class);
        yellowHuman.getColor();
        yellowHuman.talk();
    }
}
