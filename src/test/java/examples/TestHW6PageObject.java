package examples;


import org.junit.jupiter.api.Test;

import pages.RegistrationPage;
import pages.components.ResultModal;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestHW6PageObject extends TestBase {

  RegistrationPage registrationPage = new RegistrationPage();
  ResultModal resultForm = new ResultModal();


  @Test
  void fillFormTest()  {


    registrationPage.openPage()
        .setFirstName("Alina")
        .setLastName("N")
        .setUserEmail("Alina@mail.com")
        .setGender("Female")
        .setUserNumber("1234567890")
        .setDateOfBirth("02", "September", "1990")
        .setSubjects("Chemistry")
        .setHobbies("Reading")
        .uploadPicture("1.png")
        .setCurrentAddress("Street, apartment, home, town, district, region, country")
        .setState("NCR").setCity("Delhi")
        .submitAction();

    resultForm.checkResultText("Student Name", "Alina N")
        .checkResultText("Student Email", "Alina@mail.com")
        .checkResultText("Mobile","1234567890")
        .checkResultText("Gender","Female")
        .checkResultText("Date of Birth","02 September,1990")
        .checkResultText("Subjects","Chemistry")
        .checkResultText("Hobbies","Reading")
        .checkResultText("Picture","1.png")
        .checkResultText("Address","Street, apartment, home, town, district, region, country")
        .checkResultText("State and City", "NCR Delhi");


  }
  }
