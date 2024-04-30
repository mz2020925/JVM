import java.util.ArrayList;
import java.util.List;

/*
 * 演示StringTable位置
 * 在jdk8下设置 -Xmx10m -XX:-UseGCOverheadLimit
 * */
public class j15_StringTable_in_Heap {

    public static void main(String[] args) {
        List<String> ls = new ArrayList<>();
        int i = 0;
        try {
            for (int j = 0; j < 2600000; j++) {
                ls.add(String.valueOf(j).intern());
                i++;
            }
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println(i);
        }
    }
}
