package pages;

import com.codeborne.selenide.SelenideElement;

import pages.components.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
  //create objects
  CalendarComponent calendar = new CalendarComponent();
  SelenideElement titleText = $(".practice-formwrapper"),

      firstNameInput = $("#firstName"),
      lastNameInput = $("#lastName"),
      userEmailInput = $("#userEmail"),
      genderWrapper = $("#genterWrapper"),
      userNumberInput = $("#userNumber"),
      subjectsInput = $("#subjectsInput"),
      hobbiesInput = $("#hobbiesWrapper"),
      uploadPictureInput = $("#uploadPicture"),
      currentAddressInput = $("#currentAddress"),
      stateInput = $("#state"),
      stateCityWrapper = $("#stateCity-wrapper"),
      cityInput = $("#city"),
      submitButton = $("#submit");


  //Open page
  public RegistrationPage openPage() {
    open("/automation-practice-form");

    executeJavaScript("$('#fixedban').remove()");
    executeJavaScript("$('footer').remove()");
    return this;
  }


  // create methods for test
  public RegistrationPage setFirstName(String value) {

    firstNameInput.setValue(value);
    return this;
  }

  public RegistrationPage setLastName(String value) {

    lastNameInput.setValue(value);
    return this;
  }

  public RegistrationPage setUserEmail(String value) {

    userEmailInput.setValue(value);
    return this;
  }

  public RegistrationPage setGender(String value) {

    genderWrapper.$(byText(value)).click();
    return this;
  }

  public RegistrationPage setUserNumber(String value) {

    userNumberInput.setValue(value);
    return this;
  }

  public RegistrationPage setDateOfBirth(String day, String month, String year) {

    $("#dateOfBirthInput").click();
    calendar.setDate(day, month, year);

    return this;
  }


  public RegistrationPage setSubjects(String value) {

    subjectsInput.setValue(value).pressEnter();
    return this;
  }

  public RegistrationPage setHobbies(String value) {

    hobbiesInput.$(byText(value)).click();
    return this;
  }

  public RegistrationPage uploadPicture(String value) {

    uploadPictureInput.uploadFromClasspath("1.png");
    return this;
  }

  public RegistrationPage setCurrentAddress(String value) {

    currentAddressInput.setValue(value);
    return this;
  }

  public RegistrationPage setState(String value) {

    stateInput.click();
    stateCityWrapper.$(byText(value)).click();
    return this;
  }

  public RegistrationPage setCity(String value) {

    cityInput.click();
    stateCityWrapper.$(byText(value)).click();
    return this;
  }

  public RegistrationPage submitAction() {

    submitButton.click();
    return this;
  }


}
