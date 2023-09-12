package examples;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JUnit5Examples {
  @BeforeAll

  static void SetUp() {
    System.out.println("__setUp()");
  }
  @BeforeEach

  void beforeEach() {
    System.out.println("_____beforeEach()");
  }

  @Test
  void firstTest() {
    System.out.println("_______firstTest()");

}
@Test
void secondTest() {
  System.out.println("_______secondTest()");

}
  @AfterEach

  void afterEach() {
    System.out.println("_____afterEach()");
  }
  @AfterAll

  static void tearDown() {
    System.out.println("__tearDown()");
  }
}
