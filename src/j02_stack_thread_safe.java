public class j02_stack_thread_safe {
    public static void main(String[] args) {

    }

    public static void m1(){
        StringBuilder sb = new StringBuilder();  // 此变量没有线程安全问题
        sb.append(1);
        sb.append(2);
        sb.append(3);
        System.out.println(sb.toString());
    }

    public static void m2(StringBuilder sb){    // 此变量存在线程安全问题
        sb.append(1);
        sb.append(2);
        sb.append(3);
        System.out.println(sb.toString());
    }

    public static StringBuilder m3(){
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        sb.append(2);
        sb.append(3);

        return sb;    // 此变量存在线程安全问题
    }

}
