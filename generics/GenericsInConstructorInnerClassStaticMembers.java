public class GenericsInConstructorInnerClassStaticMembers<T>{

    private static int count = 0;
    class Pair<V> {
        final T key;
	final V value;
	final String name;

	public Pair(final T key, final V value, final String name){
	     this.key = key;
	     this.value = value;
	     this.name = name;
	}
    }

    static class Pair2<T, V>{
        final T key;
	final V value;

	public Pair2(final T key, final V value) {
	    this.key = key;
	    this.value = value;
	}
    }
    public static void main(String... args) {
        final GenericsInConstructorInnerClassStaticMembers<String> obj = new GenericsInConstructorInnerClassStaticMembers<String>();
        GenericsInConstructorInnerClassStaticMembers<String>.Pair<Integer> pair1 = obj.new Pair<Integer>("Anurag", 25, "Asus");
        GenericsInConstructorInnerClassStaticMembers<String>.Pair<String> pair2 = obj.new Pair<String>("Anurag", "Anand", "Asus");

        GenericsInConstructorInnerClassStaticMembers.Pair2<String, Integer> pair2_1 = new GenericsInConstructorInnerClassStaticMembers.Pair2<String, Integer>("Anurag", 25);
        int val = GenericsInConstructorInnerClassStaticMembers.count;
    }
}
