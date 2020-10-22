public class PersonClone{

    static Person clone(final Person person){
	final Person clone = new Person();
	clone.setFirstName(person.getFirstName());
	clone.setLastName(person.getLastName());
	clone.setCountry(person.getCountry());
        return clone;
    }

    public static void main(final String ... args){
        final Person person_1  =  new Person("Anurag" , "Anand" , "India");

        final Person p2  =  clone(person_1); 
        p2.setFirstName("Anand");
        p2.setLastName("Anand");

	final Person personFromIndia   = new Person(null, null, "India");
	final Person personFromAmerica = new Person(null, null, "America");
	final Person personFromRussia = new Person(null, null, "Russia");

	final Person alex = clone(personFromAmerica);
	alex.setFirstName("Alex");
	alex.setLastName("Mark");

	final Person theCherno   = clone(personFromRussia);
	theCherno.setFirstName("Yuri");
	theCherno.setLastName("Cherkoiv");


	final Person cloneNumberOne = (Person) person_1.clone();
	System.out.format("Original Object -> %s.%n", person_1);
	cloneNumberOne.setCountry("Kenya");
	System.out.format("Clonned Object -> %s.%n", cloneNumberOne);

    }
}
