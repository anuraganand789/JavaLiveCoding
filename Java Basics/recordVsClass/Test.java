public class Test{
    public static void main(final String... args){
        final PersonClass personClass   = new PersonClass("Anurag", "Anand", 12);
        personClass.print();
        System.out.format("Just The firstName of PersonClas is %s.%n",
                           personClass.firstName());

        final PersonRecord personRecord = new PersonRecord("Anurag", "Anand", 12);
        personRecord.print();
        System.out.println();
        System.out.format("Just The firstName of PersonRecord is %s.%n",
                           personRecord.firstName());
    }
}
