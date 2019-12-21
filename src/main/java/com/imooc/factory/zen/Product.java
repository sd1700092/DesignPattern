package com.imooc.factory.zen;

public abstract class Product {
    public void method1() {}
    
    public abstract void method2();
}

class ConcreteProduct1 extends Product {
    
    @Override
    public void method2() {
    
    }
}

class ConcreteProduct2 extends Product {
    
    @Override
    public void method2() {
    
    }
}