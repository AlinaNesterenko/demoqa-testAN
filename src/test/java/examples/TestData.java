package examples;
import java.util.Locale;

import com.github.javafaker.Faker;


import static utils.RandomUtils.getRandomCity;
import static utils.RandomUtils.getRandomDay;
import static utils.RandomUtils.getRandomState;
import static utils.RandomUtils.getRandomYear;

public class TestData {
  Faker faker = new Faker(new Locale("en-GB") );
  String firstName = faker.name().firstName();
  String lastName = faker.name().lastName();
  String userEmail = faker.internet().emailAddress();
  String[] genders = {"Male", "Female", "Other"};
  String userGender = faker.options().option(genders);
  String userNumber = "1" + faker.number().randomNumber(9,true);
  String userAddress = faker.address().fullAddress();
  String userDayB = getRandomDay();
  String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
      "October", "November", "December"};
  String userMonthB = faker.options().option(months);
  String userYearB = getRandomYear();
  String[] subjects = {"Physics", "Chemistry", "Commerce", "Accounting", "Economics", "Civics"};
  String userSubj = faker.options().option(subjects);
  String[] hobbies = {"Sports", "Reading", "Music"};
  String userHobby = faker.options().option(hobbies);
  String userState = getRandomState();
  String userCity = getRandomCity(userState);
  String userImg = "1.png";

}
