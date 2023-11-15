package examples;

import java.util.Map;

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

  //  Configuration.timeout = 10000;
    Configuration.pageLoadStrategy = "eager";
   // Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
   // Configuration.browserSize = System.getProperty("WINDOW_SIZE", "1920X1280");
    Configuration.browser = System.getProperty("browser","chrome");
    Configuration.browserVersion = System.getProperty("version","110");
    Configuration.browserSize = System.getProperty("size", "1920X1280");
    Configuration.remote = System.getProperty("remote", "https://user1:1234@selenoid.autotests.cloud/wd/hub");
    Configuration.baseUrl = System.getProperty("baseUrl", "https://demoqa.com");

    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("selenoid:options", Map.<String, Object>of(
        "enableVNC", true,
        "enableVideo", true
    ));
    Configuration.browserCapabilities = capabilities;

  }

  @BeforeEach
  void addListener() {
    SelenideLogger.addListener("allure", new AllureSelenide());
  }

  @AfterEach
  void addAttachments() {
    Attach.screenshotAs("Last state");
    Attach.pageSource();
    Attach.browserConsoleLogs();
    Attach.addVideo();

    closeWebDriver();
  }
}
