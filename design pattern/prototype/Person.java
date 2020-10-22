public class Person implements Cloneable{
    private String firstName;
    private String lastName;
    private String country;

    public Person(){}
    public Person(final String firstName, final String lastName, final String country){
        this.firstName = firstName;
        this.lastName  = lastName;
        this.country   = country;
    }

    public void setFirstName(final String firstName){ this.firstName = firstName; } 
    public void setLastName(final String lastName){ this.lastName    = lastName; } 
    public void setCountry(final String country){ this.country       = country; } 

    public String getFirstName() { return firstName; } 
    public String getLastName()  { return  lastName;  } 
    public String getCountry()   { return country; } 

    @Override
    public String toString() { 
        return String.format("First Name :- %s, Last Name :- %s, Country :- %s.%n"
                             , this.firstName
			     , this.lastName
			     , this.country);
    }

    @Override
    public Object clone(){
        try{
	    final Person cloneOfPerson = (Person) super.clone();
	    cloneOfPerson.firstName = this.firstName;
	    cloneOfPerson.lastName  = this.lastName;
	    cloneOfPerson.country   = this.country;

	    return cloneOfPerson;
	}catch(CloneNotSupportedException ex){
	    ex.printStackTrace();
	}
	return null;
    }

}
