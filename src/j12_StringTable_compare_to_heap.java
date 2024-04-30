// StringTable 中的字符串在运行时会被加载到串池中 ["a", "b", "ab"]  hashtable结构，不能扩容
public class j12_StringTable_compare_to_heap {
    // 常量池中的信息，都会被 以懒惰式地 加载到运行时常量池中，这时a b ab 都是常量池中的符号，还没有变为java字符串的对象
    // ldc #2 会把 a 符号变为 "a" 字符串对象
    // ldc #3 会把 b 符号变为 "b" 字符串对象
    // ldc #4 会把 ab 符号变为 "ab" 字符串对象
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        String s4 = s1 + s2;

        System.out.println(s3 == s4);  // s3是字面量，运行时位于运行时常量池中，s4是字符串对象，运行时位于堆中

        String s5 = "a" + "b";  // 这行代码在执行地时候，会到串池中寻找"ab"参数，发现已经存在了，就用的是串池中的"ab"
                                // javac在编译期间会对这句代码进行优化，结果已经在编译期确定为 "ab"，所以它就相当于字面量
        System.out.println(s3 == s5);
    }
}
