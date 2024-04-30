public class j14_StringTable_intern {

    // ["ab", "a", "b"]
    public static void main(String[] args) {
        // 堆 new String("a")；new String("b")；new String("ab")
        String s = new String("a")+new String("b");
        String s2 = s.intern();  // intern的作用是将这个字符串对象尝试放入串池，如果串池中已存在就不放入，如果串池中不存在就放入。返回值是将串池中字符串对象返回
        System.out.println(s2 == "ab");  // s2和s现在都指向串池中的字符串对象
        System.out.println(s == "ab");

        m1();

    }


    public static void m1(){
        String x = "ab";  // 现在串池中已经有"ab"

        String s = new String("a") + new String("b");
        String s2 = s.intern();  // 这里尝试把字符串对象放入串池失败了，所以s仍然是堆中的字符串对象。返回值是串池中本就存在的"ab"

        System.out.println(s2 == x);  // x本来就是串池中的字面量
        System.out.println(s == x);  // s是堆中的字符串对象

    }
}
