package example;

import org.junit.jupiter.api.Test;

public class MyProgram {
    @Test
    public static void m1() {
        System.out.println("all good from MyProgram class");
    }

    public static void m2() {
        System.out.println("i m a static method but without test annotation!");
    }

    @Test
    public static void m3() {
        throw new RuntimeException("Boom");
    }

    public static void m4() {
    }

    @Test
    public static void m5() {
    }

    public static void m6() {
    }

    @Test
    public static void m7() {
        throw new RuntimeException("Crash");
    }


}
