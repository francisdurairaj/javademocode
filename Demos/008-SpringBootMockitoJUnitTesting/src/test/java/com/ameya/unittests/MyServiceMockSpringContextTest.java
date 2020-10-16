package com.ameya.unittests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ameya.daos.MyDAO;
import com.ameya.services.MyService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyServiceMockSpringContextTest {
	
	@MockBean
	MyDAO dataServiceMock;
	
	@Autowired
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

	@RunWith(SpringRunner.class) - Spring Runner is used to launch up a spring context
	 in unit tests.
	@SpringBootTest - This annotation indicates that the context under test is a 
	@SpringBootApplication.
 	The complete SpringBootMockitoUnitTesting Application is launched up during the unit test.
	@MockBean MyDAO dataServiceMock - @MockBean annotation creates a mock for MyDAO.
 	This mock is used in the Spring Context instead of the real MyDAO.
	@Autowired MyService businessImpl - Pick the MyService from the Spring Context 
	and autowire it in.
	
	Launching the entire spring context makes the unit test slower. 
	Unit tests will also start failing if there are errors
	 in other beans in the contexts. So, the MockitoJUnitRunner approach is preferred.
 */




