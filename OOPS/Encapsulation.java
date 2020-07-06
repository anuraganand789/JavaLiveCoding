public class Encapsulation{
    
    public static void main(String... args){
        Person anurag  = new Person();
	anurag.setName("Anurag");
	anurag.setCountry("India"); 
        anurag.setAge(12);
        
	System.out.printf("Name %s, Country %s, Age %d\n", anurag.getName(), anurag.getCountry(), anurag.getAge());
    }
}
