package com.example.ymsdemo.test.jdk8test;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * jdk8已经加入了对base64编码的支持
 */
public class jdk8Base64 {
    public static void main(String[] args) {
        final String text = "Base64 finally in Java 8!";
        final String encoded = Base64.getEncoder()
                .encodeToString( text.getBytes(StandardCharsets.UTF_8));
        System.out.println( encoded);

        final String decoded = new String(
                Base64.getDecoder().decode(encoded),StandardCharsets.UTF_8
        );
        System.out.println(decoded);
    }
}
