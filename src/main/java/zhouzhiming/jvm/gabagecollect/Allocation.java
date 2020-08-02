package zhouzhiming.jvm.gabagecollect;

public class Allocation {
    private static final int _1MB = 1024 * 1024;
    
    /**
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     */
    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];
    }
    
    /**
     * -XX:+UseSerialGC -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
     */
    public static void testPretenureSizeThreshold() {
        byte[] allocation;
        allocation = new byte[4 * _1MB];
    }
    
    /**
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:Survivor-Ratio=8 -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
     */
    public static void testTenuringThreshold() {
       byte[] allocation1, allocation2, allocation3;
       allocation1 = new byte[_1MB / 4];
       allocation2 = new byte[4 * _1MB];
       allocation3 = new byte[4 * _1MB];
       allocation3 = null;
       allocation3 = new byte[4 * _1MB];
    }
    
    public static void main(String[] args) {
//        testAllocation();
//        testPretenureSizeThreshold();
        testTenuringThreshold();
    }
}
