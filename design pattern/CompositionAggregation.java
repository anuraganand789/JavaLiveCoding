public class CompositionAggregation {
    class Hydrogen{}
    class Oxygen {}
    //Composition
    class Water{
        Hydrogen hydrogen = new Hydrongen();
	Oxygen[] twoOxygen = { new Oxygen(), new Oxygen() };
    }
    
    //Aggregation
    class Person{
        final String name;
	final int age;
	final BigInteger UID;
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

