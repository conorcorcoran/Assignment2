package models;

import static org.junit.Assert.*;

import org.junit.Test;

import controllers.MovieRecommenderAPI;

public class UserTest {

	User john = new User (9l,"john", "power", 30, "m",  "Teacher");
	MovieRecommenderAPI movieRecommender;
	
	
	@Test
	public void testCreateUser()
	{
		assertSame (9l,john.id);
		assertEquals ("john", john.firstName);
		assertEquals ("power",john.lastName);
		assertEquals (30, john.age);   
		assertEquals ("m", john.gender); 
		assertEquals ("Teacher", john.occupation);
	}
	
	
	@Test
	public void testEquals()
	{
		User john2 = new User (1l,"john", "power", 30, "m",  "teacher"); 
		User barry   = new User (2l,"barry", "tea", 23, "m",  "barista"); 

		assertEquals(john, john);
		assertEquals(john, john2);
		assertNotEquals(john, barry);
	} 
	
	
}
