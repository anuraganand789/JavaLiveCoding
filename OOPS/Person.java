public class Person{
    private String name;
    private String country;
    private int    age;

    public void setAge(final int age){
	if(age < 0) throw new IllegalArgumentException("Age can not be less than ZERO");
        this.age = age;
    }

    public void setName(final String name){
        if(name == null) throw new IllegalArgumentException("Name can not be NULL");
	this.name = name;
    }
    
    public void setCountry(final String country){
        if(country == null) throw new IllegalArgumentException("We do not accept Aliens");
	this.country = country;
    }

    public String getName(){
        return "[" + name + "]";
    }

    public String getCountry(){
        return "My loved " + country;
    }

    public int getAge(){
        return age * 10;
    }

    final private void connectSecretLocaion(){
	System.out.println("modified");
        System.out.println("Connected to secret Location and reading data from there");
    }
    
    final private void parseData(final String data){
        System.out.println("Parsing.data");
    }
    
    final private void decryptDate(final String decrypt) {
        System.out.println("Decrypting data");
    }


   public void calculateBankBalance(final String data){
       connectSecretLocation();
       parseData("");
       decryptData("");
       System.out.println("Bank Balance calculated");
   }

















}
