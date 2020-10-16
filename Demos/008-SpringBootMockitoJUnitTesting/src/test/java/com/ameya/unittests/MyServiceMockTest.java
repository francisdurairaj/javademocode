package com.ameya.unittests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.ameya.daos.MyDAO;
import com.ameya.services.MyService;

@RunWith(MockitoJUnitRunner.class)
public class MyServiceMockTest {

	@Mock
	MyDAO dataServiceMock;
	@InjectMocks
	MyService businessImpl;
	
	@Test
	public void testFindTheGreatestFromAllData() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {24,15,3});
		assertEquals(24, businessImpl.findTheGreatestFromAllData());
	}
	@Test
	public void testFindTheGreatestFromAllData_ForOneValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {15});
		assertEquals(15, businessImpl.findTheGreatestFromAllData());
	}

	@Test
	public void testFindTheGreatestFromAllData_ForNoValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		assertEquals(Integer.MIN_VALUE, businessImpl.findTheGreatestFromAllData());
	}
}

/*
 * Notes

	@RunWith(MockitoJUnitRunner.class) public class MyServicesMockTest - The JUnit Runner
	 which causes all the initialization magic with @Mock and @InjectMocks 
	 to happen before the tests are run.
	@Mock MyDAO dataServiceMock - Create a mock for DataService
	@InjectMocks MyService businessImpl - Inject the mocks as dependencies into MyService
	There are three test methods testing three different scenarios - multiple values,
	 one value and no value passed in.

	Launching the entire spring context makes the unit test slower. Unit tests will 
	also start failing if there are errors
	 in other beans in the contexts. So, the MockitoJUnitRunner approach is preferred.
 
*/
