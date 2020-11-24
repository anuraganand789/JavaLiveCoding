import java.util.Map;
import java.util.HashMap;

import java.util.function.LongFunction;

public class LongFunctionImpl{
    private static record Person(long id, String name){
       @Override
       public String toString(){
           return String.format("ID => %d, Name => %s.%n", id, name);
       }
    }

    //Dummy Database
    private static class PersonRepository{
        final static Map<Long, Person> mapOfPersons = new HashMap<>(10);
        static 
        {
            long count  = 100L;
            while(count < 110){
                mapOfPersons.put(count, new Person(count, String.format("Person Number %d", count++)));
            }
        }
        
    }

    //Person Service class
    private static class PersonService implements LongFunction<Person>{
        @Override
	public Person apply(final long id){ return PersonRepository.mapOfPersons.get(id); }
    }

    //Person Service class
    private static LongFunction personService = new LongFunction<Person>(){
                                                   @Override
	                                           public Person apply(final long id){ return PersonRepository.mapOfPersons.get(id); }
                                                };

    //Person Service class
    private static LongFunction personServiceLambda1 = (final long id) -> PersonRepository.mapOfPersons.get(id);
    private static LongFunction personServiceLambda2 = id -> PersonRepository.mapOfPersons.get(id);
    private static LongFunction personServiceLambda3 = PersonRepository.mapOfPersons::get;
    
    public static void main(final String ... args){
        long personID = 109L;

        System.out.format("%s .. Person is : %s.%n", "Regular Class" , new PersonService().apply(personID));

	personID = 102L;
        System.out.format("%s .. Person is : %s.%n", "Anonymous Class", personService.apply(personID++));

        System.out.format("%s .. Person is : %s.%n", "Lambda 1", personServiceLambda1.apply(personID++));
        System.out.format("%s .. Person is : %s.%n", "Lambda 2", personServiceLambda2.apply(personID++));
        System.out.format("%s .. Person is : %s.%n", "Lambda 3", personServiceLambda3.apply(personID++));
    }
}
