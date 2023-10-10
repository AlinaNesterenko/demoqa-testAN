package examples;


import org.junit.jupiter.api.Test;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;

public class TestHW6PageObject extends TestBase {



  @Test
  void fillFormTest()  {
    open("/automation-practice-form");


    executeJavaScript("$('#fixedban').remove()");
    executeJavaScript("$('footer').remove()");

//create objects
    SelenideElement firstNameImput = $("#firstName");

  //enter values
    firstNameImput.setValue("Alina");
    $("#lastName").setValue("N");
    $("#userEmail").setValue("Alina@mail.com");
    $("#genterWrapper").$(byText("Female")).click();
    $("#userNumber").setValue("1234567890");
    $("#dateOfBirthInput").click();
    $(".react-datepicker__month-dropdown-container").$(byText("September")).click();
    $(".react-datepicker__year-select").selectOption("1990");
    $(".react-datepicker__day--002").click();
    $("#subjectsInput").setValue("Chemistry").pressEnter();
    $("#hobbiesWrapper").$(byText("Reading")).click();
    $("#uploadPicture").uploadFromClasspath("1.png");
    $("#currentAddress").setValue("Street, appartment, home, town, district, region, country");
    $("#state").click();
    $("#stateCity-wrapper").$(byText("NCR")).click();
    $("#city").click();
    $("#stateCity-wrapper").$(byText("Delhi")).click();
    $("#submit").click();



    $(".modal-content").shouldHave(text("Alina N"));
    $(".modal-content").shouldHave(text("Alina@mail.com"));
    $(".modal-content").shouldHave(text("Female"));
    $(".modal-content").shouldHave(text("1234567890"));
    $(".modal-content").shouldHave(text("02 September,1990"));
    $(".modal-content").shouldHave(text("Chemistry"));
    $(".modal-content").shouldHave(text("Reading"));
    $(".modal-content").shouldHave(text("1.png"));
    $(".modal-content").shouldHave(text("Street, appartment, home, town, district, region, country"));
    $(".modal-content").shouldHave(text("NCR Delhi"));

  }


  }
