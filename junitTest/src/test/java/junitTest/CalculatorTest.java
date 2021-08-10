package junitTest;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

public class CalculatorTest {
	
	@Test
	public void addNumerTest()	{
		//AAA Rule
		
		//Arrange
		Calculator cal = new Calculator();
		
		//Act
		int actualResult = cal.addNumber(10, 20);
		
		//Assert
		int expectedResult = 30;
		
		assertEquals(expectedResult, actualResult);
		
	}
}
