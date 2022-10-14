package com.cydeo.tests.day10_javafaker_driver_util;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerPractice {

    @Test
    public void test_java_faker() {

        Faker faker = new Faker();
        System.out.println("faker.chuckNorris().fact() = " + faker.chuckNorris().fact());
        System.out.println("faker.name().firstName() = " + faker.name().firstName());
        System.out.println("faker.name().lastName() = " + faker.name().lastName());
        System.out.println("faker.name().fullName() = " + faker.name().fullName());
        System.out.println("faker.address().city() = " + faker.address().city());
        System.out.println("faker.numerify(\"###-###-####\") = " + faker.numerify("###-####-####"));
        System.out.println("faker.numerify(\"773-###-####\") = " + faker.numerify("773-###-####"));
        System.out.println("faker.numerify(\"######\") = " + faker.numerify("######"));
        System.out.println("faker.letterify(\"???\") = " + faker.letterify("???"));
        System.out.println("faker.bothify(\"##??##??\") = " + faker.bothify("##??##??"));
        System.out.println("faker.finance().creditCard().replaceAll(\"-\", \"\") = " + faker.finance().creditCard().replaceAll("-", ""));
        System.out.println("faker.chuckNorris().fact().replaceAll(\"Chuck Norris\", \"Adam\") = " + faker.chuckNorris().fact().replaceAll("Chuck Norris", "Adam"));
        System.out.println("faker.beer().hop() = " + faker.beer().hop());
        System.out.println("faker.gameOfThrones().dragon() = " + faker.gameOfThrones().dragon());


    }
}
