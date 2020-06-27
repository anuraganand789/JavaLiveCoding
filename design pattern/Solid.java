//1. Single Utility / Use
//2. Open-Close principle
//3. Liskov's substitution principle
//4. Interface doing specific work
//5. Dependecny Injection 

import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collection;

public class Solid{
    class SimpleCalc{
        public int sum(final int x, final int y){
	    return x + y;
	}
        
	public int sub(final int x, final int y){
	    return x - y;
	}

	public int mul(final int x, final int y){
	    return x * y;
	}
	 
    }

    class ScientificCalc extends SimpleCalc {
        public int square(final int x) {
	    return mul(x, x);
	}
    }

    public SimpleCalc getCalculator(){
        return new ScientificCalc();
    }
    interface Runnable{
        void run();
    }
    interface Callable<T> {
	T    call();
    }


    public void writeToConsole(final Collection<Integer> collectionOfInts){
       for(Integer val : collectionOfInts) System.out.println(val); 
    }

    public static void main(String... args) {
	Solid solid = new Solid();
        SimpleCalc cal = solid.new ScientificCalc();

	ArrayList<Integer> arrList = new ArrayList<>();
	arrList.add(12); arrList.add(13);

	LinkedList<Integer> linkList = new LinkedList<>();
	linkList.add(15);

	Set<Integer> setOfInts = new HashSet<>();
	setOfInts.add(10);

	solid.writeToConsole(arrList);
	solid.writeToConsole(linkList);
	solid.writeToConsole(setOfInts);
    }
}
