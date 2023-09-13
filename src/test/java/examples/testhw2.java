package examples;

//import java.lang.module.Configuration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Wait;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.files.DownloadActions.click;

public class testhw2 {

  @BeforeAll
  static void SetUp() {
    System.out.println("__setUp()");
    Configuration.browserSize="1024x800";

  }
  //@Test
  //void firstTest() {
  //  System.out.println("_______firstTest()");
//
 // }

  @Test
  void FillFormTest() throws InterruptedException {
    open("https://demoqa.com/automation-practice-form");


    executeJavaScript("$('#fixedban').remove()");
    executeJavaScript("$('footer').remove()");

  //enter values
    $("#firstName").setValue("Alina");
    $("#lastName").setValue("N");
    $("#userEmail").setValue("Alina@mail.com");


   // Object gender;
  //  $("#gender-radio-2").click ();
    $(byText("Female")).click();
    $("#userNumber").setValue("1234567890");
    $("#dateOfBirthInput").click();
    $(".react-datepicker__month-dropdown-container").$(byText("September")).click();
    $(".react-datepicker__year-select").selectOption("1990");
    $(".react-datepicker__day--002").click();
   // $("#subjectsInput").setValue("Test");
   //$(byText("Reading")).click();
    $("#subjectsInput").setValue("Chemistry").pressEnter();
    $(byText("Reading")).click();
    $("#currentAddress").setValue("Street, appartment, home, town, district, region, country");



    //  $(byText("Select state")).click();
    $("#state").click();
    $("#stateCity-wrapper").$(byText("NCR")).click();
   $("#city").click();
    $("#stateCity-wrapper").$(byText("Delhi")).click();
    $("#submit").click();


    executeJavaScript("document.getElementById('submit').click()");


    $(".modal-content").shouldHave(text("Alina N"));
    $(".modal-content").shouldHave(text("Alina@mail.com"));
    $(".modal-content").shouldHave(text("Female"));
    $(".modal-content").shouldHave(text("1234567890"));
    $(".modal-content").shouldHave(text("02 September,1990"));
    $(".modal-content").shouldHave(text("Chemistry"));
 //   $(".modal-content").shouldHave(text("hw2-2.png"));
    $(".modal-content").shouldHave(text("Street, appartment, home, town, district, region, country"));
    $(".modal-content").shouldHave(text("NCR Delhi"));




//    $("#submit").click();
// read values
 /*   $("#output #name").shouldHave(text("Alina"));
    $("#output #email").shouldHave(text("alina@mail.com"));
    $("#output #currentAddress").shouldHave(text("Street"));
    $("#output #permanentAddress").shouldHave(text("town"));
  */
  }


  }
