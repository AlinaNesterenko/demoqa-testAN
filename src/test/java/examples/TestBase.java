package examples;

import org.junit.jupiter.api.BeforeAll;

import com.codeborne.selenide.Configuration;

public class TestBase {
  @BeforeAll
  static void setUp() {
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.browserSize="1024x800";
    Configuration.pageLoadStrategy = "eager";
    Configuration.timeout = 10000;

  }
}
