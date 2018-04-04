package com.app.bundles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
    private static List<String> counties = Arrays.asList("France", "Germany", "Others");

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Specify your country from list :" + counties);
        String chosenCountry = reader.readLine();
        initLocale(chosenCountry);

        System.out.println("What is your name:");
        String userName = reader.readLine();
        ResourceBundle bundles = ResourceBundle.getBundle("Greeting");
        System.out.println(String.format("%s %s", bundles.getString("Greet"), userName));

    }

    private static void initLocale(String chosenCountry) {
        switch (chosenCountry.toLowerCase()) {
            case "france":
                Locale.setDefault(Locale.FRENCH);
                break;
            case "germany":
                Locale.setDefault(Locale.GERMAN);
                break;
            default:
                Locale.setDefault(Locale.getDefault());
        }
    }
}
