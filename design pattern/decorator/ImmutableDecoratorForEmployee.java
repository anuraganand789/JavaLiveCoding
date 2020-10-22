import java.util.Set;
import java.util.HashSet;

public class ImmutableDecoratorForEmployee{
    private final Employee employee;

    public ImmutableDecoratorForEmployee(final Employee employee){
        this.employee = employee;
    }

    public String getTeam(){ return this.employee.team; };
    public String getFirstName(){ return this.employee.firstName; };
    public String getLastName(){ return this.employee.lastName; };
    public String getCompany(){ return this.employee.company; };

    public Set<Employee> getManagers(){ return wrapInSet(this.employee.getManagers()); }  
    public Set<Employee> getColleagues(){ return wrapInSet(this.employee.getColleagues());}
    public Set<Employee> getUnderSupervision(){ return wrapInSet(this.employee.getUnderSupervision()); }

    private <T> Set<T> wrapInSet(Set<T> set){
        return new HashSet<T>(set);
    }

    @Override
    public String toString(){
        return this.employee.toString();
    }
}
