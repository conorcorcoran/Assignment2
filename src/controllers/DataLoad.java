package controllers;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

import edu.princeton.cs.introcs.In;
import models.Rating;
import models.User;
import models.Movie;


public class DataLoad 
{

	private File usersFile = new File("users.dat");
	private File movieFiles = new File("items.dat");
	private File ratingFiles = new File("ratings.dat");
	
	

	public DataLoad()
	{

	}

	public List<User> loadUserData(String fileName)
	{
		List <User> users = new ArrayList<User>();
		In inUsers = new In(usersFile);
		String delims = "[|]";
		while (!inUsers.isEmpty())
		{
			String userDetails = inUsers.readLine();
			String[] userTokens = userDetails.split(delims);
			users.add(new User(Long.parseLong(userTokens[0]),userTokens[1],userTokens[2],Integer.parseInt(userTokens[3]),userTokens[4],userTokens[5]));
			if (users!=null) 
			{
				System.out.println(users.size());
			}
		} 
		return users;
	}
	
	public List<Movie> importMovies(String fileName) throws Exception
	{
		List <Movie> movies = new ArrayList<Movie>();

		In inUsers = new In(movieFiles);
		String delims = "[|]";
		while (!inUsers.isEmpty()) 
		{
			String movieDetails = inUsers.readLine();
			String[] movieTokens = movieDetails.split(delims);
			movies.add(new Movie(Long.parseLong(movieTokens[0]),movieTokens[1],movieTokens[2],movieTokens[3]));
			if (movies!=null) 
			{
				System.out.println(movies.size());
			}
		}
		return movies;	
	}
	public List<Rating> importRatings(String fileName) throws Exception
	{
		List <Rating> ratings = new ArrayList<Rating>();
		In inUsers = new In(ratingFiles);
		String delims = "[|]";
		while (!inUsers.isEmpty()) 
		{
			String ratingDetails = inUsers.readLine();
			String[] ratingTokens = ratingDetails.split(delims);
			ratings.add(new Rating(Long.parseLong(ratingTokens[0]),Long.parseLong(ratingTokens[1]),Integer.parseInt(ratingTokens[2])));
			if (ratings!=null) 
			{
				System.out.println(ratings.size());
			}
		} return ratings;	
	}
	
}



