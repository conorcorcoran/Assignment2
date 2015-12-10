package models;

import static org.junit.Assert.*;

import org.junit.Test;

import controllers.DataLoad;
import controllers.MovieRecommenderAPI;

public class RatingTest {
	
	Rating Rating = new Rating(users[0].id,movies[0].id,3);
	MovieRecommenderAPI movieRecommender;
	DataLoad data;

	
	@Test
	public void testCreate()
	{
		assertSame (1l, Rating.userId);
		assertSame (1l, Rating.movieId);
		assertEquals(3, Rating.rating);   
	}
	
	@Test
	public void testToString()
	{
		assertEquals("User ID: " + Rating.userId + "Movie ID: " + Rating.movieId +
				"Rating: " + Rating.rating + Rating.toString());
	}
}
