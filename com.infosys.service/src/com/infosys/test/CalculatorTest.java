package com.infosys.test;

import static org.junit.Assume.assumeTrue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.infosys.service.Calculation;

@DisplayName("TestCase to test Calculator logic")
class CalculatorTest {

private Calculation calculator = new Calculation();

@DisplayName("TestCase to test addition logic")
  @Test
  void additionTest() {
	  int actualSum = calculator.addition(1, 1);
	  int expectedSum = 2;
	  assertEquals(expectedSum, actualSum);
  }

@DisplayName("TestCase to test substraction logic")
  @Test
  void substractionTest() {
	  System.out.println(System.getProperty("java.runtime.version"));
	  int actualDifference = calculator.substraction(2, 1);
	  int expectedDifference = 1;
	  assumeTrue(System.getProperty("java.runtime.version").startsWith("8"));
	  assertEquals(expectedDifference, actualDifference);
  }

  @Disabled("Business logic is not yet ready.")
  @Test
  void multiplicationTest() {
	  int actualProduct = calculator.multiplication(2, 2);
	  int expectedProduct = 4;
	  assertEquals(expectedProduct, actualProduct);
  }


}
