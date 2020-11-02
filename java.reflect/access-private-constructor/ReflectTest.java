import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Constructor;

public class ReflectTest{
    
    public static void main(final String ... args) 
                                                throws 
						    InstantiationException,
						    IllegalAccessException,
						    InvocationTargetException
						    {
        Class<Person> personClass = Person.class;
	Constructor<?>[] constructors = personClass.getDeclaredConstructors();
	Constructor<?> privateConstructor = constructors[0];
	privateConstructor.setAccessible(true);

	final Person person = (Person) privateConstructor.<Person>newInstance("Anurag", "Anand");
	System.out.println(person);
    }
}
