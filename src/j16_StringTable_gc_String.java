/*
 * 演示StringTable垃圾回收
 * -Xmx10m -XX:+PrintStringTableStatistics -XX:+PrintGCDetails -verbose:gc
 * */
public class j16_StringTable_gc_String {
    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        try {

        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println(i);
        }

        // m1();  // 执行此方法后，StringTable statistics: Number of entries
    }

    public static void m1() throws InterruptedException {
        int i = 0;
        try {
            for (int j = 0; j < 100; j++) {
                String.valueOf(j).intern();
                i++;
            }
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println(i);
        }
    }
}
