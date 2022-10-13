package com.cydeo.tests.day9_properties_configurations;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties {


    @Test
    public void reading_from_properties_file_test() throws IOException {

        // Create the object of Properties class
        Properties properties = new Properties();

        // Create the object of FileInputStream
        FileInputStream file = new FileInputStream("configuration.properties");

        // Load the properties object using FileInputStream object
        properties.load(file);

        properties.getProperty("browser");
        properties.getProperty("env");



    }




}
