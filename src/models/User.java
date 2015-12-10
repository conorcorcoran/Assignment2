package models;

import static com.google.common.base.MoreObjects.toStringHelper;

import java.awt.List;
import java.util.ArrayList;
import java.util.Objects;

public class User 
{
	static Long   counter = 0l;

	public Long   id;
	public String firstName;
	public String lastName;
	public int age;
	public String gender;
	public String occupation;

	public List<Rating> ratings = new ArrayList<>();

	public User(Long id, String firstName, String lastName, int age, String gender, String occupation)
	{
		this.id        = counter++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.occupation = occupation;
	}


	public String toString()
	{
		return toStringHelper(this).addValue(id)
				.addValue(firstName)
				.addValue(lastName)
				.addValue(age)
				.addValue(gender)   
				.addValue(occupation)
				.toString();
	}
	
	public List<Rating> getRatings()
	{
		if(ratings.size()==0)
		{
			System.out.println("User has no rating anything yet");
		}
		return ratings;
	}


	@Override
	public int hashCode()
	{
		return Objects.hashCode(this.lastName,this.firstName,this.gender,this.age);
	}

	@Override
	public boolean equals(final Object obj)
	{
		if(obj instanceof User)
		{
			final User other = (User) obj;
			return Objects.equals(firstName, other.firstName)
					&& Objects.equals(lastName, other.firstName)
					&& Objects.equals(gender, other.gender)
					&& Objects.equals(age, other.age)
					&& Objects.equals(occupation, other.occupation);
		}
		else
		{
			return false;
		}
	}


}
