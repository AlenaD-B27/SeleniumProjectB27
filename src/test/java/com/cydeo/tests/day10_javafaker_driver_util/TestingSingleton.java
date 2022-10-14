package com.cydeo.tests.day10_javafaker_driver_util;

import org.testng.annotations.Test;

public class TestingSingleton {
    @Test
    public void singleton_understand_test() {

        String str1 = Singleton.getWord();
        System.out.println("str1 = " + str1);

        String str2 = Singleton.getWord();
        System.out.println("str2 = " + str2);
    }
}
