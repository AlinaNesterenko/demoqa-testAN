package examples;


import java.util.Locale;
import java.util.Random;

import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;

import pages.RegistrationPage;
import pages.components.ResultModal;





public class TestHW7PageObject extends TestBase {


  RegistrationPage registrationPage = new RegistrationPage();
  TestData testData = new TestData();
  ResultModal resultForm = new ResultModal();
  @Test
  void fillFormTest()  {
    String firstName = testData.firstName;
    String lastName = testData.lastName;
    String userEmail = testData.userEmail;
    String userGenter = testData.userGender;
    String userNumber = testData.userNumber;
    String userAddress = testData.userAddress;
    String userDayB = testData.userDayB;
    String userMonthB = testData.userMonthB;
    String userYearB = testData.userYearB;
    String userSybj = testData.userSubj;
    String userHobby = testData.userHobby;
    String userState = testData.userState;
    String userCity = testData.userCity;
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
