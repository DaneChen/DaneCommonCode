package com.dane.toollib.util;

/**
 * @author chengr
 * description:
 * create on 2021/2/25
 */
public class Test2 {

    private static boolean b1 = false;
    private static boolean b2 = true;
    private static boolean b3 = true;
    public static void main(String[] args) {

        boolean b1andb2 = b1&b2;
        boolean b2andb3 = b3&b2;
        boolean b1andandb2 = b1&&b2;
        boolean b2andandb3 = b2&&b3;
        System.out.println("b1andb2=" + b1andb2 + " b2andb3=" + b2andb3 + " b1andandb2=" + b1andandb2 + " b2andandb3=" + b2andandb3);
    }
}
