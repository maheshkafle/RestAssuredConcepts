package com.restfulbooker.qa.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.concurrent.ThreadLocalRandom;

public class RestUtils {

    public static String getFirstName(){
        String generatedString = RandomStringUtils.randomAlphabetic(4);
        return ("Preeyan"+generatedString);
    }

    public static String getLastName(){
        String generatedString = RandomStringUtils.randomAlphabetic(4);
        return ("Soudyal"+generatedString);
    }

    public static String getTotalPrice(){
        String generatedInteger = String.valueOf(ThreadLocalRandom.current().nextInt());
        return generatedInteger;
    }

    public static String getIsDepositPaid(){
        boolean generatedBoolean = ThreadLocalRandom.current().nextBoolean();
        return Boolean.toString(generatedBoolean);
    }

    public static String getAdditionalNeeds(){
        String generatedString = RandomStringUtils.randomAlphabetic(4);
        return ("Breakfast"+generatedString);
    }

//    public static String createRandomDate(int startYear, int endYear) {
//        int day = createRandomIntBetween(1, 28);
//        int month = createRandomIntBetween(1, 12);
//        int year = createRandomIntBetween(startYear, endYear);
//        return String.valueOf(LocalDate.of(year, month, day));
//    }
}
