package models;

public class TopMovieCalculator implements Comparable<TopMovieCalculator> 
{
public Long movieId;
public double averageRating;

public TopMovieCalculator(Long movieId,double averageRating)
{
	this.movieId=movieId;
	this.averageRating = averageRating;
}

@Override
public int compareTo(TopMovieCalculator other)
{
	if(this.averageRating < other.averageRating) return -1;
	if(this.averageRating > other.averageRating) return +1;
	
	return 0;
}

@Override
public String toString()
{
	return "Movie ID: " + movieId + "Average Rating: " + averageRating;
}

}
