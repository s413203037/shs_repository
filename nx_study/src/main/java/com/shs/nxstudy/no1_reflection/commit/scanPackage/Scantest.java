package com.shs.nxstudy.no1_reflection.commit.scanPackage;

public class Scantest {
    public static void main(String[] args) throws Exception {
        PackageScan ps = new PackageScan();
        ps.scanPackage("com.nx_shs.homework.no1_reflection.practice");
//        Class.forName("com.nx_shs.homework.no1_reflection.practice.ClassLoadProcess");
    }
}
