package utils;
import java.util.Locale;

import com.github.javafaker.Faker;

public class RandomUtils {

  static Faker faker = new Faker(new Locale("en-GB"));

  public static String getRandomDay() {
    Integer intDay = faker.number().numberBetween(1,28);
    if (intDay < 10) {
      return "0" + intDay;
    } else {
    return Integer.toString(intDay);
  }}

  public static String getRandomYear() {
    Integer intYear = faker.number().numberBetween(1900,2018);
    return intYear.toString();
  }

  public static String getRandomState() {
    String[] states = {"NCR", "Haryana", "Rajasthan"};
    String randomState = faker.options().option(states);
    return randomState;
  }

  public static String getRandomCity(String randomState) {
    String [] cityListNCR = {"Delhi", "Gurgaon", "Noida"},
        cityListHar = {"Karnal", "Panipat"},
        cityListRaj = {"Jaipur", "Jaiselmer"};

      switch (randomState) {
        case  ("NCR"):
          return faker.options().option(cityListNCR);
        case ("Haryana"):
          return faker.options().option(cityListHar);
        case ("Rajasthan"):
          return faker.options().option(cityListRaj);
        default:
          return " ";
      }

    }

}