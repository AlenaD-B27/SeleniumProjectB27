package com.cydeo.tests.day10_javafaker_driver_util;

public class Singleton { // Singleton means one single object


    // 1. Create private constructor
    private Singleton(){}

    // 2. Create private static String variable
    // prevent access and provide a getter method

    private static String word;

    // This utility will return the "word" in the way we want to return

    public static String getWord(){
        if(word==null){
            System.out.println("First time call. Object word is null. " + "Assign the value now");
            word = "something";
        } else {
            System.out.println("word already has value.");
        }
        return word;
    }



}
