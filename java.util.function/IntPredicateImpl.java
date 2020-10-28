import java.util.function.IntPredicate;
import java.util.List;
//IllegalArgumentException
class IntPredicateImpl{
    class Person {
        private int salary;
        private int age;
	private String name;

	public Person(final String name, final int age, final int salary){
	    if(name == null || name.trim().isEmpty()) 
	        throw new IllegalArgumentException("Name can not be empty");
	    this.name = name;

	    if(age < 0) 
	        throw new IllegalArgumentException("Age Can not be less than zero");
	    this.age = age;

	    if(salary < 0) 
	        throw new IllegalArgumentException("Salary Can not be less than zero");
	    this.salary = salary;
	}

	public String getName(){ return name; }
	public int getAge() { return age; }
	public int getSalary() { return salary; }

	public void setName(final String name){ this.name = name; }
        public void setAge(final int age){ this.age = age; }
        public void setSalary(final int salary){ this.salary = salary; }
    }

    final static IntPredicate i_greaterThanThirty = (int age) -> age > 30;
    final static IntPredicate ageAboveThirty      = (age) -> age > 30;

    final static IntPredicate salaryAbove20K      = (int salary) -> salary > 20_000;
    final static IntPredicate salaryAbove50K      = (int salary) -> salary > 50_000;

    public static void main(final String ... args){
        final IntPredicateImpl parentObj = new IntPredicateImpl();

        final Person personOne    =   parentObj.new Person("Anurag", 35, 50_000);
        final Person personTwo    =   parentObj.new Person("Rajneesh", 20, 20_000);
        final Person personThree  =   parentObj.new Person("Durgesh", 41, 12_000);
        final Person personFour   =   parentObj.new Person("Kamlesh", 25, 70_000);

        List<Person> listOfPerson = List.of(personOne, personTwo, personThree, personFour);
        
	long totalPersonAboveThirty = listOfPerson
	                                   .stream()
	                                   .mapToInt(Person::getAge)
					   .filter(ageAboveThirty)
					   .count();

	System.out.format("Total Person above thirty %d.%n", totalPersonAboveThirty);

	long totalNoOfPeopleWithSalaryAbove50k = listOfPerson
	                                                     .stream()
							     .mapToInt(Person::getSalary)
							     .filter(salaryAbove50K)
							     .count();
       System.out.format("Total Number of person with salary more than 50K %d.%n", totalNoOfPeopleWithSalaryAbove50k);
    }
}
