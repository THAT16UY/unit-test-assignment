package com.promineotech;

import java.util.Random;

public class TestDemo {
	
	public int addPositve(int a, int b) {
		if(a < 0 || b < 0) {			
			throw new IllegalArgumentException("Both parameters is zero or negative");
		}
		else {
			int sum = a + b;
			return sum;
		}
	}
	
	public void testMethod() {
		
	}
	
	public int randomNumberSquared() {
		int result = getRandomInt();
		result *= result;
		return result;
	}

	int getRandomInt() {
		Random random = new Random();

	    return random.nextInt(10) + 1;
		
	}

}
