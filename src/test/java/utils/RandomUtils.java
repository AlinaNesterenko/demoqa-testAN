package utils;
import java.security.SecureRandom;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

import com.github.javafaker.Faker;

public class RandomUtils {

  Faker faker = new Faker(new Locale("en-GB"));

  public static String getRandomString(int len) {
    String AB = "QWERTYUIOPLKJHGFDSAZXCVBNMqwertyuioplkjhgfdsazxcvbnm";
    SecureRandom rnd = new SecureRandom();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < len; i++)
      sb.append(AB.charAt(rnd.nextInt(AB.length())));
    return sb.toString();
  }

  public static String getRandomNumber(int len) {
    String AB = "01234567890";
    SecureRandom rnd = new SecureRandom();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < len; i++)
      sb.append(AB.charAt(rnd.nextInt(AB.length())));
    return sb.toString();
  }

  public static String getRandomEmail() {
    return getRandomString(10) + "@mail.com";
  }

  public static String getRandomAddress() {
    return getRandomString(10) + " street, " + getRandomString(10) + " city, " + getRandomNumber(6);
  }

  public static int getRandomInt(int min, int max) {
    return ThreadLocalRandom.current().nextInt(min, max + 1);
  }

  public static String getRandomItemFromArray(String[] array) {
    int index = getRandomInt(0, array.length - 1);
    return array[index];
  }

  public static String getRandomPhone() {
    return String.format("+%s (%s) %s - %s - %s", getRandomInt(1, 9), getRandomInt(111, 999),
        getRandomInt(111, 999), getRandomInt(11, 99), getRandomInt(11, 99));

  }

  public static String getRandomGender() {
    String[] genders = {"Male", "Female", "Other"};
    return getRandomItemFromArray(genders);
  }

  public static String getRandomDay() {
    Integer intDay = getRandomInt(1, 28);
    return intDay.toString();
  }

  public static String getRandomMonth() {
    String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
        "October", "November", "December"};
    return getRandomItemFromArray(months);
  }

  public static String getRandomYear() {
    Integer intYear = getRandomInt(1900, 2018);
    return intYear.toString();
  }

  public static String getRandomSubj() {
    String[] subjects = {"Physics", "Chemistry", "Commerce", "Accounting", "Economics", "Civics"};
    return getRandomItemFromArray(subjects);
  }

  public static String getRandomHobby() {
    String[] hobbies = {"Sports", "Reading", "Music"};
    return getRandomItemFromArray(hobbies);
  }

  public static String getRandomState() {
    String[] states = {"NCR", "Haryana", "Rajasthan"};
    String randomState = getRandomItemFromArray(states);
    return randomState;
  }

  public static String getRandomCity(String randomState) {
    String [] cityListNCR = {"Delhi", "Gurgaon", "Noida"},
        cityListHar = {"Karnal", "Panipat"},
        cityListRaj = {"Jaipur", "Jaiselmer"};

      switch (randomState) {
        case  ("NCR"):
          return getRandomItemFromArray(cityListNCR);
        case ("Haryana"):
          return getRandomItemFromArray(cityListHar);
        case ("Rajasthan"):
          return getRandomItemFromArray(cityListRaj);
        default:
          return " ";
      }

    }

}