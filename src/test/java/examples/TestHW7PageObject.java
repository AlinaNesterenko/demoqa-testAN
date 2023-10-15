package examples;


import java.util.Locale;
import java.util.Random;

import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;

import pages.RegistrationPage;
import pages.components.ResultModal;

import static com.codeborne.selenide.Condition.text;
import static utils.RandomUtils.getRandomAddress;
import static utils.RandomUtils.getRandomCity;
import static utils.RandomUtils.getRandomDay;
import static utils.RandomUtils.getRandomEmail;
import static utils.RandomUtils.getRandomGender;
import static utils.RandomUtils.getRandomHobby;
import static utils.RandomUtils.getRandomMonth;
import static utils.RandomUtils.getRandomNumber;
import static utils.RandomUtils.getRandomState;
import static utils.RandomUtils.getRandomSubj;
import static utils.RandomUtils.getRandomYear;



public class TestHW7PageObject extends TestBase {


  RegistrationPage registrationPage = new RegistrationPage();
  TestData testData = new TestData();
  ResultModal resultForm = new ResultModal();
  @Test
  void fillFormTest()  {
    Faker faker = new Faker(new Locale("en-GB") );
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = getRandomEmail();
    String userGenter = getRandomGender();
    String userNumber = getRandomNumber(10);
    String userAddress = getRandomAddress();
    String userDayB = getRandomDay();
    String userMonthB = getRandomMonth();
    String userYearB = getRandomYear();
    String userSybj = getRandomSubj();
    String userHobby = getRandomHobby();
    String userState = getRandomState();
    String userCity = getRandomCity(userState);
    String userPicture = testData.userImg;



    registrationPage.openPage()
        .setFirstName(firstName)
        .setLastName(lastName)
        .setUserEmail(userEmail)
        .setGender(userGenter)
        .setUserNumber(userNumber)
        .setDateOfBirth(userDayB, userMonthB, userYearB)
        .setSubjects(userSybj)
        .setHobbies(userHobby)
        .uploadPicture(userPicture)
        .setCurrentAddress(userAddress)
        .setState(userState).setCity(userCity)
        .submitAction();

    resultForm.checkResultText("Student Name", firstName + " " + lastName)
        .checkResultText("Student Email", userEmail)
        .checkResultText("Mobile", userNumber)
        .checkResultText("Gender", userGenter)
        .checkResultText("Date of Birth", userDayB + " " + userMonthB + "," +  userYearB)
        .checkResultText("Subjects",userSybj)
        .checkResultText("Hobbies",userHobby)
        .checkResultText("Picture", userPicture)
        .checkResultText("Address",userAddress)
        .checkResultText("State and City", userState + " " + userCity);


  }
  }
