package io.loop.test.day8;

import io.loop.test.utilities.ConfigurationReader;

public class T00_test_config_reader {

    public static void main(String[] args) {

        System.out.println("ConfigurationReader.getProperties(\"name\") = " + ConfigurationReader.getProperties("name"));
    }
}
