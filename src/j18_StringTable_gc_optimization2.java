import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class j18_StringTable_gc_optimization2 {
    public static void main(String[] args) throws IOException {
        List<String> address = new ArrayList<>();
        System.in.read();
        for (int i = 0; i < 10; i++) {
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("linux.words"), "utf-8"))){
                String line = null;
                long start = System.nanoTime();
                while (true){
                    line = reader.readLine();
                    if(line == null){
                        break;
                    }
                    address.add(line.intern());
                }
                System.out.println("cost:"+(System.nanoTime()-start)/1000000);
            }
        }
        System.in.read();
    }
}
