public class PairTest {

    static class Pair<A>{
        private A firstValue;
	private A secondValue;

	public Pair(final A firstValue, final A secondValue) { 
	    this.firstValue = firstValue;
	    this.secondValue = secondValue;
	}

	@Override
	public String toString() {
	    return firstValue + " " + secondValue;
	}
    }

    static class Pair2<F, S>{
        private F first;
	private S second;

	public Pair2(final F first, final S second) {
	    this.first = first;
	    this.second = second;
	}
	
	public void setSecond(final S second) {
	    this.second = second;
	}

	@Override
	public String toString(){
	    return first + " " + second;
	}

    }

    public static void main(String... args) {
        final Pair<Integer> vertex = new Pair<Integer>(100, 200);
	System.out.println("Vertex " + vertex);

        final Pair<Float> coordinates = new Pair<Float>(100f, 200f);
	System.out.println("My current position on google map " + coordinates);

        final Pair<String> fullName = new Pair<String>("Anurag" , "Anand");
	System.out.println("My Full Name is " + fullName);

        final Pair2<String, Integer> studentID = new Pair2<String, Integer>("Anurag" , 1000);
	System.out.println("My Id is -> " + studentID); 
	studentID.setSecond(1100);
	System.out.println("My Id is -> " + studentID); 
    }
    
}
