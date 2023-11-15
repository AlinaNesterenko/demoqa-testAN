package examples;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

import pages.RegistrationPage;
import pages.components.ResultModal;

public class TestHW13Jenkins extends TestBase {


  RegistrationPage registrationPage = new RegistrationPage();
  TestData testData = new TestData();
  ResultModal resultForm = new ResultModal();

  @Test
  @Tag("jenkinsTest")
  @DisplayName("Successfull Registration")
  void fillFormTest() {

    step("Открывыем страницу регистрации", () -> {
      registrationPage.openPage();
    });
    step("Добавляем Имя", () -> {
      registrationPage.setFirstName(testData.firstName);
    });
    step("Добавляем Фамилию", () -> {
      registrationPage.setLastName(testData.lastName);
    });
    step("Добавляем Email", () -> {
      registrationPage.setUserEmail(testData.userEmail);
    });
    step("Устанавливаем пол", () -> {
      registrationPage.setGender(testData.userGender);
    });
    step("Добавляем Номер", () -> {
      registrationPage.setUserNumber(testData.userNumber);
    });
    step("Добавляем Дату рождения", () -> {
      registrationPage.setDateOfBirth(testData.userDayB, testData.userMonthB, testData.userYearB);
    });
    step("Добавляем Предмет", () -> {
      registrationPage.setSubjects(testData.userSubj);
    });
    step("Добавляем Хобби", () -> {
      registrationPage.setHobbies(testData.userHobby);
    });
    step("Загружаем фото", () -> {
      registrationPage.uploadPicture(testData.userImg);
    });
    step("Добавляем Адрес", () -> {
      registrationPage.setCurrentAddress(testData.userAddress);
    });
    step("Добавляем Штат и Город", () -> {
      registrationPage.setState(testData.userState).setCity(testData.userCity);
    });
    step("Подтверждаем регистрацию", () -> {
      registrationPage.submitAction();
    });

    step("Проверяем Имя и Фамилию студента", () -> {
      resultForm.checkResultText("Student Name", testData.firstName + " " + testData.lastName);
    });

    step("Проверяем Email", () -> {
      resultForm.checkResultText("Student Email", testData.userEmail);
    });
    step("Проверяем пол", () -> {
      resultForm.checkResultText("Gender", testData.userGender);
    });
    step("Проверяем Номер", () -> {
      resultForm.checkResultText("Mobile", testData.userNumber);
    });
    step("Проверяем Дату рождения", () -> {
      resultForm.checkResultText("Date of Birth", testData.userDayB + " " + testData.userMonthB + "," + testData.userYearB);
    });
    step("Проверяем Предмет", () -> {
      resultForm.checkResultText("Subjects", testData.userSubj);
    });
    step("Проверяем Хобби", () -> {
      resultForm.checkResultText("Hobbies", testData.userHobby);
    });
    step("Проверяем фото", () -> {
      resultForm.checkResultText("Picture", testData.userImg);
    });
    step("Проверяем Адрес", () -> {
      resultForm.checkResultText("Address", testData.userAddress);
    });
    step("Проверяем Штат и Город", () -> {
      resultForm.checkResultText("State and City", testData.userState + " " + testData.userCity);
    });

  }
}
