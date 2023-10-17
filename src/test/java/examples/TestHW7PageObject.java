package examples;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ResultModal;

public class TestHW7PageObject extends TestBase {


  RegistrationPage registrationPage = new RegistrationPage();
  TestData testData = new TestData();
  ResultModal resultForm = new ResultModal();
  @Test
  void fillFormTest()  {



    registrationPage.openPage()
        .setFirstName(testData.firstName)
        .setLastName(testData.lastName)
        .setUserEmail(testData.userEmail)
        .setGender(testData.userGender)
        .setUserNumber(testData.userNumber)
        .setDateOfBirth(testData.userDayB, testData.userMonthB, testData.userYearB)
        .setSubjects(testData.userSubj)
        .setHobbies(testData.userHobby)
        .uploadPicture(testData.userImg)
        .setCurrentAddress(testData.userAddress)
        .setState(testData.userState).setCity(testData.userCity)
        .submitAction();

    resultForm.checkResultText("Student Name", testData.firstName + " " + testData.lastName)
        .checkResultText("Student Email", testData.userEmail)
        .checkResultText("Mobile", testData.userNumber)
        .checkResultText("Gender", testData.userGender)
        .checkResultText("Date of Birth", testData.userDayB + " " + testData.userMonthB + "," +  testData.userYearB)
        .checkResultText("Subjects",testData.userSubj)
        .checkResultText("Hobbies",testData.userHobby)
        .checkResultText("Picture", testData.userImg)
        .checkResultText("Address",testData.userAddress)
        .checkResultText("State and City", testData.userState + " " + testData.userCity);


  }
  }
