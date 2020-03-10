package idea_debug;

import org.junit.Test;

public class DebugTest {
    @Test
    public void ifDebug() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }
    
    @Test
    public void dropFrameDebug() {
        int i = 99;
        method1(i);
    }
    
    private void method1(int i) {
        System.out.println("method1:" + i);
        method2(i);
    }
    
    private void method2(int j) {
        j++;
        System.out.println("method2:" + j);
    }
    
    @Test
    public void multiThreadTest() {
        new Thread(() -> {
            System.out.println("1.我智商很低");
        }, "菩提树下的杨过").start();
        new Thread(() -> {
            System.out.println("2.我没有文化");
        }, "天空中的飞鸟").start();
    
        System.out.println("3.要问我是谁？");
        System.out.println("4.卧是答春绿");
    }
    
}
