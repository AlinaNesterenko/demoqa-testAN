package examples;

//import java.lang.module.Configuration;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class testhw {

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
  void fillFormTest() {
    open("https://demoqa.com/text-box");
    $("#userName").setValue("Alina");
    $("#userEmail").setValue("alina@mail.com");
    $("#currentAddress").setValue("Street");
    $("#permanentAddress").setValue("town");
    $("#submit").click();

    $("#output #name").shouldHave(text("Alina"));
    $("#output #email").shouldHave(text("alina@mail.com"));
    $("#output #currentAddress").shouldHave(text("Street"));
    $("#output #permanentAddress").shouldHave(text("town"));
  }


  }
