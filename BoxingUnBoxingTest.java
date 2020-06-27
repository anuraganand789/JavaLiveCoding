import java.util.List;
import java.util.ArrayList;

public class BoxingUnBoxingTest{
    public static void main(String... args) {
        int age = 12;
	int age2 = 11;

	//BOXING
	List<Integer> listOfAges = new ArrayList<>();
	listOfAges.add(age);
	listOfAges.add(age2);
	listOfAges.add(101);
	listOfAges.add(Integer.valueOf(1000));

	List<Float> listOfFloats = new ArrayList<>();
	listOfFloats.add(12f); // => Float.valueOf(12f)


	//UNBOXING
	Integer ageInteger = listOfAges.get(0);
	int ageInt = listOfAges.get(0).intValue();

    }
}
