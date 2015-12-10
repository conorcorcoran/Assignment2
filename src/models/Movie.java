package models;

import static com.google.common.base.MoreObjects.toStringHelper;

import java.awt.List;
import java.util.ArrayList;
import java.util.Objects;

public class Movie {

	static Long counter = 01;

	public Long id;

	public String title;
	public String year;
	public String url;
	
	public List<Rating> ratings = new ArrayList<>();

	public Movie(Long id, String title, String year, String url)
	{
		this.id = counter++;
		this.title = title;
		this.year = year;
		this.url = url;
	}

	public String toString()
	{
		return toStringHelper(this).addValue(id)
				.addValue(title)
				.addValue(year)
				.addValue(url)                                                            
				.toString();
	}
	
	public double meanMovieRating()
	{
		double averageRating = 0;
		double sum = 0;

		for(int i = 0;i<ratings.size();i++)
		{
			sum += ratings.get(i).rating;
		}
		averageRating = sum / ratings.size();
		
		return averageRating;

	}

	@Override
	public int hashCode()
	{
		return Objects.hashCode(this.id, this.title, this.year, this.url);
	}

	@Override
	public boolean equals(final Object obj)
	{
		if(obj instanceof Movie)
		{
			final Movie other = (Movie) obj;
			return Objects.equals(title, other.title)
					&& Objects.equals(year, other.year)
					&& Objects.equals(url, other.url);
		}
		else
		{
			return false;
		}	
	}

}
