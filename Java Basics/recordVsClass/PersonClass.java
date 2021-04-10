public final class PersonClass{
    
    private final String firstName;
    private final String lastName;
    private final int    age;

    public PersonClass(final String firstName, 
                       final String lastName, 
                       final int age){
        this.firstName  =  firstName;
        this.lastName   =  lastName;
        this.age        =  age;
    }

    public String firstName() { return firstName; }
    public String lastName()  { return lastName;  }
    public int    age()       { return age;       }

    public void print()       { System.out.println(toString()); }

    @Override
    public int hashCode()     { return 12;        }

    @Override
    public boolean equals(final Object targetOfComaprison) {
        return true;
    }

    @Override
    public String toString() { 
        return String.format("PersonClass[FirstName=%s, LastName=%s, Age=%d]%n", 
                              firstName,
                              lastName,
                              age);
    }


}
