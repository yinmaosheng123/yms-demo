package com.example.ymsdemo.test;

import java.util.HashMap;
import java.util.Map;

public class test {

    // 查找指定字符串是否存在
    public static void main(String[] args) {
        String str1 = "abcdefghijklmnabc";
        // 从头开始查找是否存在指定的字符
        System.out.println(str1.indexOf("c"));
        // 从第四个字符位置开始往后继续查找
        System.out.println(str1.indexOf("c", 3));
        //若指定字符串中没有该字符则系统返回-1
        System.out.println(str1.indexOf("x"));

        Map<String,String> map = new HashMap<>();

        str1 += " kkkkkk";
        System.out.println(str1);



    }
}
