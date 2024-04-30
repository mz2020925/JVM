import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* StringTable本身是哈希表的结构，通过增加“桶”的数量可以提高性能
* -XX:StringTableSize=200000 -XX:+PrintStringTableStatistics
* */
public class j17_StringTable_gc_optimization {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i++) {
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("linux.words"), "utf-8"))){
                String line;
                long start = System.nanoTime();
                while (true){
                    line = reader.readLine();  // 每个单词会被读取到StringTable中，并以Hash表的结构存储，这些单词会一起组成一个字符串
                    if(line == null){
                        break;
                    }
                    line.intern();
                }
                System.out.println("cost:"+(System.nanoTime()-start)/1000000);
            }
        }
    }
}
