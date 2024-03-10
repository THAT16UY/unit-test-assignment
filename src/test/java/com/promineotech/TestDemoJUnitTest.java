package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
//import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.params.provider.Arguments.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

class TestDemoJUnitTest {
	
	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if(!expectException) {
			assertThat(testDemo.addPositve(a, b)).isEqualTo(expected);
			
			assertThatThrownBy(() -> testDemo.addPositve(a,b)).isInstanceOf(IllegalArgumentException.class);
		}
	}
	
	static Stream<Arguments> argumentsForAddPositive(){
		// @formatter:off
		return Stream.of(
				//arguments(2,-1,1,false),
				arguments(2,0,2,true),
				arguments(2,1,3,true),
				arguments(2,2,4,true),
				arguments(2,3,5,true),
				arguments(2,4,6,true),
				arguments(2,5,7,true),
				arguments(2,6,8,true),
				arguments(2,7,9,true),
				arguments(2,8,10,true),
				arguments(2,9,11,true),
				//arguments(3,-1,2,false),
				arguments(3,0,3,true),
				arguments(3,1,4,true),
				arguments(3,2,5,true),
				arguments(3,3,6,true),
				arguments(3,4,7,true),
				arguments(3,5,8,true),
				arguments(3,6,9,true),
				arguments(3,7,10,true),
				arguments(3,8,11,true),
				arguments(3,9,12,true)
		);
		// formatter:on
	}
	
	@Test 
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		//assertThat(testDemo.addPositve(2,-1)).isEqualTo(1);
		assertThat(testDemo.addPositve(2,0)).isEqualTo(2);
		assertThat(testDemo.addPositve(2,1)).isEqualTo(3);
		assertThat(testDemo.addPositve(2,2)).isEqualTo(4);
		assertThat(testDemo.addPositve(2,3)).isEqualTo(5);
		assertThat(testDemo.addPositve(2,4)).isEqualTo(6);
		assertThat(testDemo.addPositve(2,5)).isEqualTo(7);
		assertThat(testDemo.addPositve(2,6)).isEqualTo(8);
		assertThat(testDemo.addPositve(2,7)).isEqualTo(9);
		assertThat(testDemo.addPositve(2,8)).isEqualTo(10);
		assertThat(testDemo.addPositve(2,9)).isEqualTo(11);
		//assertThat(testDemo.addPositve(3,-1)).isEqualTo(2);
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		
		doReturn(5).when(mockDemo).getRandomInt();
		
		int fiveSquared = mockDemo.randomNumberSquared();
		
		assertThat(fiveSquared).isEqualTo(25);
	}
	
	
	
	
	

}
