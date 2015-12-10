package models;

import static org.junit.Assert.*;

import org.junit.Test;

public class MovieTest {
	Movie movie = new Movie (11l,"This Is Spinal Tap","1984","www.SpinalTap.com");

	@Test
	public void testCreateMovie()
	{
		assertSame(11l, movie.id);
		assertEquals ("This Is Spinal Tap", movie.title);
		assertEquals ("1984", movie.year);
		assertEquals ("www.SpinalTap.com", movie.url);   
	}

	
	@Test
	public void testEquals()
	{
		Movie movie2 = new Movie (11l,"This Is Spianl Tap", "1984","www.SpinalTap.com"); 
		Movie movie3  = new Movie (12l,"Back To The Future", "1985","www.BTTF.com"); 

		assertEquals(movie, movie);
		assertEquals(movie, movie2);
		assertNotEquals(movie, movie3);
	} 
}
