package models;

import com.google.common.base.Objects;

public class Rating 
{
	public int rating;
	public long userId;
	public long movieId; 

	public Rating(Long userId,Long movieId,int rating)
	{
		this.movieId = movieId;
		this.userId = userId;
		this.rating = rating;
	}


	public void ratingCheck(int rating)
	{
		if(rating <=5 && rating >= -5)
		{
			this.rating = rating;
		}
		else  
		{
			System.out.println("The value you have input is not vaild, please choose between -5 and 5 for the rating");
		}
	}

	@Override
	public String toString()
	{
		return ("UserID: " + userId + "MovieID " + movieId + "Movie Rating: " + rating);
	}
	
	
	@Override
	  public boolean equals(final Object obj)
	  {
	    if (obj instanceof Rating)
	    {
	      final Rating other = (Rating) obj;
	      return Objects.equal(userId, other.userId) 
	          && Objects.equal(movieId,  other.movieId)
	          && Objects.equal(rating,  other.rating);    
	    }
	    else
	    {
	      return false;
	    }
	  }
	  
	
}



