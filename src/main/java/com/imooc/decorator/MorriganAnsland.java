package com.imooc.decorator;

import javax.swing.*;
import java.awt.*;

public class MorriganAnsland {
    public static void main(String[] args) {
        Morrigan m0 = new original();
        m0.display();
        Morrigan m1 = new Succubus(m0);
        m1.display();
        Morrigan m2 = new Girl(m0);
        m2.display();
    }
}

interface Morrigan {
    void display();
}

class original extends JFrame implements Morrigan {
    
    private String t = "Morrigan0.jpg";
    
    public original() {
        super("《恶魔战士》中的莫莉卡安斯兰");
    }
    
    public void setImage(String t) {
        this.t = t;
    }
    
    @Override
    public void display() {
        this.setLayout(new FlowLayout());
        JLabel l1 = new JLabel(new ImageIcon("src/main/java/com/imooc/decorator/" + t));
        this.add(l1);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

class Changer implements Morrigan {
    
    Morrigan m;
    
    public Changer(Morrigan m) {
        this.m = m;
    }
    
    @Override
    public void display() {
        m.display();
    }
}

class Succubus extends Changer {
    
    public Succubus(Morrigan m) {
        super(m);
    }
    
    @Override
    public void display() {
        setChanger();
        super.display();
    }
    
    private void setChanger() {
        ((original) super.m).setImage("Morrigan1.jpg");
    }
}

class Girl extends Changer {
    
    public Girl(Morrigan m) {
        super(m);
    }
    
    @Override
    public void display() {
        setChanger();
        super.display();
    }
    
    private void setChanger() {
        ((original) super.m).setImage("Morrigan2.jpg");
    }
}