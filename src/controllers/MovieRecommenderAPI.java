package controllers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import utils.Serializer;
import utils.Serializer;
import models.Movie;
import models.Rating;
import models.TopMovieCalculator;
import models.User;

public class MovieRecommenderAPI 
{
	private Serializer serializer;
	public Map<Long, User> userIndex = new HashMap<>();
	public Map<Long, Movie> movieIndex = new HashMap<>();


	public MovieRecommenderAPI()
	{ }

	public MovieRecommenderAPI(Serializer serializer)
	{
		this.serializer = serializer;
	}

	public User addUser(String firstName, String lastName, int age, String gender, String occupation)
	{
		User user = new User(firstName, lastName, age, gender, occupation);
		userIndex.put(user.id, user);
		return user;
	}

	public Movie addMovie(String title, String year, String url)
	{
		Movie movie = new Movie(title, year, url);
		movieIndex.put(movie.id, movie);
		return movie;
	}

	public void removeUser(Long id) 
	{
		User user = userIndex.remove(id);
	}

	public Collection<User> getUsers ()
	{
		return userIndex.values();
	}

	public void store() throws Exception
	{
		serializer.push(userIndex);
		serializer.push(User.counter);
		serializer.push(movieIndex);
		serializer.push(Movie.counter);
		serializer.write(); 
	}

	public void deleteUsers() 
	{
		userIndex.clear();
	}
	
	public void addRating(Long userId,Long movieId,int rating) throws Exception
	{
		Rating userRating = new Rating(userId,movieId,rating);

		User user = userIndex.get(userId);
		user.ratings.add(userRating);

		Movie movie = movieIndex.get(movieId);
		movie.ratings.add(userRating);
	}
	
	public ArrayList<Movie> topTenMovies()
	{
		ArrayList<Movie> topTenMovies = new ArrayList<>();
		ArrayList<TopMovieCalculator> allAverageRatings = new ArrayList<>();
		ArrayList<Movie>tempList = new ArrayList<>();

		for(Movie movie : getMovies())
		{
			
			if(movie.ratings.size() > 50)
			{
				allAverageRatings.add(new TopMovieCalculator(movie.id,movie.averageRating()));
			}
		}
		Collections.sort(allAverageRatings);
		for(TopMovieCalculator movie : allAverageRatings)
		{
			tempList.add(movieIndex.get(movie.movieId));
		}
		topTenMovies = new ArrayList<Movie>(tempList.subList(tempList.size()-10, tempList.size()));
		
		System.out.println(topTenMovies);

		return topTenMovies;
	}
	public Collection<Movie> getMovies ()
	{
		return movieIndex.values();
	}


}