public class j03_stack_over_memory {
    // 栈内存溢出
    // -Xss256k
    private static int count;

    public static void main(String[] args) {
        try {
            method1();
        }catch (Throwable e){
            e.printStackTrace();
            System.out.println(count);
        }
    }

    private static void method1(){
        count++;
        method1();
    }

}
