//why things does not work as expected
//Difference between generics and arrays
//subtyping 
//wildcards


import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class SubtypingWildCards{


    // PECS -> 
    // Producer Extends 
    // Consumer Super
    private void display(List<? extends Number> nums){
        for(Number num : nums)
	    System.out.println(num);
        
	//Iterartor<?> ->Iterator<? extends Object>
	Iterator<?> iter = nums.iterator();

	while(iter.hasNext()) {
	    iter.next();
	    iter.remove();
	}
    }

    private <T> void add(List<? super T> list, final T value){
       list.add(value); 
    }
    public static void main(String... args) {
        Integer intg = Integer.valueOf(1);
	Number num = intg;

	Integer[] intArr = new Integer[1];
	Number[] numArr = intArr;


//	List<String>    ==> List
//	List<Person>    ==> List
//	List<Runnable>  ==> List

//      Number <- Integer is subclass
//      List<Number> <- List<Integer> is not subtype
        final SubtypingWildCards obj = new SubtypingWildCards();
	List<Integer> intList = new ArrayList<>();
	intList.add(12);
	intList.add(13);
	obj.display(intList);
	System.out.println("Size of intList " + intList.size());

	List<Double> doubleList = new ArrayList<>();
	doubleList.add(12.12);
	doubleList.add(13.14);
	obj.display(doubleList);
	System.out.println("Size of doubleList " + doubleList.size());
	obj.<Double>add(doubleList, 12.12);
	System.out.println("Size of doubleList " + doubleList.size());

    }
}
