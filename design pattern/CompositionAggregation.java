import java.math.BigInteger;

public class CompositionAggregation {
    class Hydrogen{}
    class Oxygen {}
    //Composition
    class Water{
        Hydrogen hydrogen = new Hydrogen();
	Oxygen[] twoOxygen = { new Oxygen(), new Oxygen() };
    }
    
    //Aggregation
    class Person{
        final String name = "name";
	final int age = 12;
	final BigInteger UID = BigInteger.ONE;
    }

    //Aggregation
    //Author can be an entity --> living or machine
    class Author{
        java.util.Set<Book> books;
    }
    
    //Composition
    class Book{
        Author author;
    }

}

