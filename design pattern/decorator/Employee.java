import java.util.Set;
public class Employee{
    public String firstName;
    public String lastName;
    public String team;
    public String company;
    private Set<Employee> managers;
    private Set<Employee> colleagues;
    private Set<Employee> underSupervision;

    public Set<Employee> getColleagues(){ 
        return this.colleagues;
    }
    public Set<Employee> getManagers(){
        return this.managers ;
    }
    public Set<Employee> getUnderSupervision(){
        return this.underSupervision;
    }

    public void setColleagues(final Set<Employee> colleagues){ 
        this.colleagues = colleagues;
    }
    public void setManagers(final Set<Employee> managers){ 
        this.managers = managers;
    }
    public void setUnderSupervision(final Set<Employee> underSupervision){ 
        this.underSupervision = underSupervision;
    }

    @Override 
    public String toString(){
        return String.format("FirstName: %s, LastName :- %s, Team :- %s, Company :- %s, SetOfManagers :- %s, SetOFColleagues :- %s, " + 
	                  "SetOfUnderSupervision %s.%n", this.firstName, this.lastName, this.team, this.company, 
			  this.managers, this.colleagues, this.underSupervision);
    }
}
