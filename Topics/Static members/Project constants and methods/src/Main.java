public class Main {

    public static void main(String[] args) {
        // write your code using the existing class ConstantsAndUtilities

    }

}

// Don't change this class
class MyClass {

    static int field = 10;

    public MyClass() {
        method2(); // (1)
    }

    void method1() {
        method2(); // (2)
    }

    static void method2() {
        method3(); // (3)
    }

    static void method3() {
        System.out.println(field); // (4)
    }
}