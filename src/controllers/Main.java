package controllers;

import java.util.Collection;

import models.User;
import asg.cliche.Command;
import asg.cliche.Param;
import asg.cliche.Shell;
import asg.cliche.ShellFactory;

public class Main 
{
	public MovieRecommenderAPI movieRecommender;
	public DataLoad data = new DataLoad();
	
	@Command(description="Add a new User")
	public void addUser (@Param(name="first name") String firstName, @Param(name="last name") String lastName,
			@Param(name="age") int age, @Param(name="gender") String gender, @Param(name="occupation") String occupation)
	{
		movieRecommender.addUser(firstName, lastName, age, gender, occupation);
	}

	@Command(description="Delete a User")
	public void removeUser (@Param(name="id") Long id)
	{
		movieRecommender.removeUser(id);
	}
	
	@Command(description="Delete all Users")
	public void deleteAllUsers ()
	{
		movieRecommender.deleteUsers();
	}
	
	@Command(description="Get all users")
	public void getUsers ()
	{
		Collection<User> users = movieRecommender.getUsers();
		System.out.println(users);
	}
	
	@Command(description="Add a Movie")
	public void addMovie (@Param(name="title") String title, @Param(name="year") String year, @Param(name="url") String url)
	{
		movieRecommender.addMovie(title, year, url);
	}
	
	@Command(description="Add a rating")
	public void addRating(@Param(name="userId") Long userId, @Param(name="movieId")Long movieId, @Param(name="rating") int rating) throws Exception
	{	
			movieRecommender.addRating(userId, movieId, rating);
	}
	
	@Command(description="Calculate Top 10 Movies")
	public void listTopTenMovies()
	{
		movieRecommender.topTenMovies();
	}

	public static void main(String[] args) throws Exception
	{
		Main main = new Main();
		Shell shell = ShellFactory.createConsoleShell("MR", "Welcome to the Movie Recomender - ?help for instructions", main);
		shell.commandLoop();
		main.movieRecommender.store();
	}		

}
