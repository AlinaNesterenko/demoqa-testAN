package examples;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;

import examples.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
  @BeforeAll
  static void setUp() {
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.browserSize = "1024x800";
    Configuration.pageLoadStrategy = "eager";
    Configuration.timeout = 10000;
    Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("enableVNC", true);
    capabilities.setCapability("enableVideo", true);
    Configuration.browserCapabilities = capabilities;

  }

  @BeforeEach
  void addListener() {
    SelenideLogger.addListener("allure", new AllureSelenide());
  }

  @AfterEach
  void addAttachments(){
    Attach.screenshotAs("Last state");
    Attach.pageSource();
    Attach.browserConsoleLogs();
    Attach.addVideo();

    closeWebDriver();
  }
}
