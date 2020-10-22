import java.util.Collections;
import java.util.Set;
import java.util.HashSet;

public class TestDecorator{
    private static Employee newEmployee(final String firstName, final String lastName, 
                         final String team, final String company, 
			 final Set<Employee> managers, final Set<Employee> colleagues, 
			 final Set<Employee> underSupervision){
        final Employee employee = new Employee();

	employee.firstName = firstName;
	employee.lastName  = firstName;
	employee.team      = firstName;
	employee.company   = firstName;

	employee.setColleagues(colleagues);
	employee.setManagers(managers);
	employee.setUnderSupervision(underSupervision);
        
	return employee;
    }

    public static void main(final String ... args){
	//final Employee usOne        = newEmployee("us_firstname", "us_lastname", "agi" , "tiscon", new HashSet<Employee>(), new HashSet<Employee>(), new HashSet<Employee>());
	//final Employee colleagueOne = newEmployee("One_FirstName", "One_SecondName", "AGI", "TISCO", new HashSet<Employee>(), new HashSet<Employee>(), new HashSet<Employee>());
        //final Employee manager      = newEmployee("Monti", "gonti", "AGI" , "TISCO", new HashSet<Employee>(), new HashSet<Employee>(), new HashSet<Employee>());
        //final ImmutableDecoratorForEmployee employeeOne  = new ImmutableDecoratorForEmployee(newEmployee("Anurag", "Anand", "AGI", "TISCO", Set.of(manager), Set.of(colleagueOne), Set.of(usOne)));

	//System.out.println(employeeOne);

        //final Employee managerTwo = newEmployee("OneMonti", "gonti", "AGI" , "TISCO", Collections.emptySet(), Collections.emptySet(), Collections.emptySet());
	//employeeOne.managers = Set.of(managerTwo);

	//System.out.println(employeeOne);

	final Employee managerOne = newEmployee("M_FirstName_One", "M_SecondName_Two", "AGI", "tiscon", 
	                                        Collections.emptySet(), 
	                                        Collections.emptySet(), 
	                                        Collections.emptySet());
	                                          
	final Set<Employee> setOfManagers = new HashSet<>();
	setOfManagers.add(managerOne);

	final ImmutableDecoratorForEmployee newJoinee  = new ImmutableDecoratorForEmployee(newEmployee("Anurag", "Anand", "agi", "tiscon", 
	                                                                          setOfManagers, 
	                                                                          Collections.emptySet(),
	                                                                          Collections.emptySet())
					      );

	final Employee managerV = newEmployee("V_FirstName_One", "V_SecondName_Two", "AGI", "tiscon", 
	                                        Collections.emptySet(), 
	                                        Collections.emptySet(), 
	                                        Collections.emptySet());
	final Set<Employee> setOfMs = new HashSet<>();
	setOfMs.add(managerV);

	final Employee verMuchTheNewJoinee  = newEmployee("New_Anurag", "New_Anand", "agi", "tiscon", 
                                                                                  setOfMs,
	                                                                          Collections.emptySet(),
	                                                                          Collections.emptySet());
	System.out.println(newJoinee);
	System.out.println(verMuchTheNewJoinee);

	final Set<Employee> setOfManagersForNewJoinee = newJoinee.getManagers();
	final Employee newManager  = newEmployee("S_FirstName_One", "S_SecondName_Two", "SGI", "Siscon", 
	                                                                             Collections.emptySet(), 
	                                                                             Collections.emptySet(), 
	                                                                             Collections.emptySet());
	setOfManagersForNewJoinee.add(newManager);
	verMuchTheNewJoinee.getManagers().add(newManager);

	System.out.println(newJoinee);
	System.out.println(verMuchTheNewJoinee);

        
         
    }
}
