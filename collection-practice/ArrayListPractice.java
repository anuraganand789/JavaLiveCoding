import java.util.Arrays;
import java.util.ArrayList;
import java.util.Objects;
import java.util.List;

public class ArrayListPractice {

    static void printAtIndex(List<String> list, final int index){
        System.out.printf("AT %d index Value is %s.%n", index, list.get(index));
    }

    static void printListSize(final List<?> list){
        System.out.println("Size of the list is " + list.size());
    }
    static void listContainsThisValue(final List<?> list, final Object value){
        System.out.println("The list contains the value " + value + " " + (list.contains(value)));
    }
    static void printIndexOfValue(final List<?> list, final Object value){
        System.out.printf("The value %s is present at %d index. %n", value, (list.indexOf(value)));
    }
    static void printLastIndexOfValue(final List<?> list, final Object value){
        System.out.printf("The value %s is present at %d index. %n", value, (list.lastIndexOf(value)));
    }
    public static void main(final String... args){
	//no argument constructor 
        final ArrayList<String> arrWithSize_10 = new ArrayList<>();

	//constructor that accepts size
	final ArrayList<String> arrWithSize_0 = new ArrayList<>(0);

        //constructor that accepts collections
	final ArrayList<String> arrFromCollection = new ArrayList<>(List.of("Anurag", "Anand", "Andread Kling", "awesome_kling", "Serenity OS"));

	//add at given index
        arrWithSize_10.add(0, "My Name");
	printAtIndex(arrWithSize_10, 0);
	arrWithSize_10.add("Andrew Kelley");
	printListSize(arrWithSize_10);

	arrWithSize_10.addAll(1, arrFromCollection);
	printListSize(arrWithSize_10);
	arrWithSize_10.addAll(arrFromCollection);
	printListSize(arrWithSize_10);

	arrWithSize_10.clear();
	printListSize(arrWithSize_10);

        listContainsThisValue(arrFromCollection, "Anurag");

        arrFromCollection.forEach(System.out::println);
	arrFromCollection.forEach(arrWithSize_10::add);
	arrWithSize_10.forEach(System.out::println);

	printIndexOfValue(arrFromCollection, "Serenity OS");

	System.out.println("Array with size zero is empty " + (arrWithSize_0.isEmpty()));

	arrFromCollection.add("Humans");
	arrFromCollection.add("Not Humans");
	arrFromCollection.add(2, "Serenity OS");
	printIndexOfValue(arrFromCollection, "Serenity OS");

	printLastIndexOfValue(arrFromCollection, "Serenity OS");

        arrFromCollection.remove(2);

	printIndexOfValue(arrFromCollection, "Serenity OS");

	printLastIndexOfValue(arrFromCollection, "Serenity OS");

	arrFromCollection.remove("Serenity OS");
	printIndexOfValue(arrFromCollection, "Serenity OS");

	printLastIndexOfValue(arrFromCollection, "Serenity OS");
	System.out.printf("Before removal ");
	arrFromCollection.forEach(System.out::println);
	arrWithSize_10.clear();
	arrWithSize_10.add("Anurag");
	arrWithSize_10.add("Anand");

	arrFromCollection.removeAll(arrWithSize_10);
	System.out.printf("After removal ");
	arrFromCollection.forEach(System.out::println);
	arrFromCollection.add(null);
	arrFromCollection.forEach(System.out::println);

	arrFromCollection.removeIf(Objects::isNull);
	System.out.println("------NULL value removed ---------");
	arrFromCollection.forEach(System.out::println);

        arrWithSize_10.add(0, "More");
	arrWithSize_10.add("Less");
	arrWithSize_10.forEach(System.out::println);

       
        arrWithSize_0.add("More");
	arrWithSize_0.add("Less");
	arrWithSize_0.forEach(System.out::println);

        System.out.println("-------------------");
	arrWithSize_10.retainAll(arrWithSize_0);
	arrWithSize_10.forEach(System.out::println);
        System.out.println("-------------------");
	arrWithSize_10.set(1, "Anurag");
	arrWithSize_10.forEach(System.out::println);
	
        System.out.println("-------------------");
	final String[] vals = arrWithSize_10.toArray(new String[arrWithSize_10.size()]);
	Arrays.stream(vals).forEach(System.out::println);
	arrWithSize_10.trimToSize();

    }
}
