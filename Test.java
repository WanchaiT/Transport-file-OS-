class A {
    void go(int n) throws Exception {
        if (n < 10) {
            throw new Exception();
        }
        System.out.println(n);
    }
}
public class Test {
    public static void main(String[] args) {
        try {
            A a = new A();
            a.go(5);
        } catch (Exception ex) {
            System.out.println("catch");
        }
    }
}
