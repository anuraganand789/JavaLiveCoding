import java.util.function.Function;

public class FunctionImpl {
    private class Person {
        private final int age;
	public Person(final int age){
	    this.age = age;
	}

	public int getAge(){ return this.age; }
    }

    //Regular Class version
    private class FuncImpl implements Function<Person, Integer>{
        @Override
	public Integer apply(final Person person){ return person.getAge(); } 
    }

    //Anonymous class version
    final Function<Person, Integer> 
    personAge = new Function<Person, Integer>(){ 
                            @Override public Integer apply(final Person person) { return person.getAge(); } 
			};
    
    //Lambda Version 1 
    final Function<Person, Integer> funclam_1 = (Person person) -> { return person.getAge(); };

    //Lambda Version 2 
    final Function<Person, Integer> funclam_2 = person -> person.getAge();

    //Lambda Version 3
    final Function<Person, Integer> funclam_3 = Person::getAge;

    public static void main(final String... args){
        final FunctionImpl obj = new FunctionImpl();
        final Person person = obj.new Person(100);
	final FuncImpl funcClassImpl = obj.new FuncImpl();

	System.out.println("Age of the person is " + funcClassImpl.apply(person));
	System.out.println("Age of the person is " + obj.personAge.apply(person));
	System.out.println("Age of the person is " + obj.funclam_1.apply(person));
	System.out.println("Age of the person is " + obj.funclam_2.apply(person));
	System.out.println("Age of the person is " + obj.funclam_3.apply(person));


    }
    
}
