import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class SumOfIntArray{
    public static void main(String ...args){
        final int[] ints = {1, 2, 3, 4, 5, 6};

	int sum = 0;
	for(int intValue : ints) sum += intValue;
	System.out.println("Tradiiontal Sum " + sum);
	
	sum = 0;

	sum = Arrays.stream(ints).sum();
	System.out.println("Functional Stream 'sum' function Sum " + sum);

	sum = 0;

	sum = Arrays.stream(ints).reduce(0, Integer::sum);
	System.out.println("Functional Stream 'reduce' function Sum " + sum);

	final AtomicInteger sumInt = new AtomicInteger(0);
	Arrays.stream(ints).forEach( intValue -> sumInt.set( intValue + sumInt.get()));
	System.out.println("Functional Stream should not be done this way " + sumInt.get()); 

    }
}
