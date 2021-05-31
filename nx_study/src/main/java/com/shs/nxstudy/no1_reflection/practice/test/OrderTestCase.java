package com.shs.nxstudy.no1_reflection.practice.test;

/**
 * @author 奈学-肖秋平老师 Eric
 **/
@Test
public class OrderTestCase {

    @Test
    public static void m1() {System.out.println("m1 is ok."); }

    public static void m2() { }

    @Test
    public static void m3() {
        throw new RuntimeException("Boom");
    }

    public static void m4() { }

    @Test
    public static void m5() { System.out.println("m5 is ok."); }

    public static void m6() { }

    @Test
    public static void m7() {
        throw new RuntimeException("Crash");
    }

    public static void m8() { }

}
