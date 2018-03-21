package com.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class Mapper {
    public static void main(String[] args) throws IOException {
        readWeatherConfig();
    }

    private static void readWeatherConfig() throws IOException {
        ClassLoader classLoader = Mapper.class.getClassLoader();
        File file = new File(classLoader.getResource("config/config.yml").getFile());

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        Weather weatherConfig = mapper.readValue(file, Weather.class);

        System.out.println(weatherConfig);
    }


}
