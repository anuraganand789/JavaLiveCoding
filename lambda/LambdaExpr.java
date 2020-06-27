public class LambdaExpr {
    public static void main(String... args){
       final LambdaExpr obj = new LambdaExpr();

       final Runnable runLambda = () ->  System.out.println("Hello From Lambda!!!"); 
       final Runnable runMethods = obj::none;
       final Runnable runMethods2 = obj::none;

       new Thread(runLambda).start();
       new Thread(runMethods).start();
       new Thread(runMethods2).start();

       java.util.function.BiConsumer<String, String> consumesTwo = (a, b) -> System.out.println(a + " - " + b);
       java.util.function.BiConsumer<String, String> consumesTwo2 = obj::printName;
       consumesTwo2.accept("Anurag", "Anand");

       final int x = 100, y = 200;
       java.util.function.BiFunction<Integer, Integer, Integer> add = (num1, num2) -> num1 + num2;
       java.util.function.BiFunction<Integer, Integer, Integer> add2 = obj::add; 
       add2.apply(x, y);
    }

    private void none(){
        System.out.println("Hello from none function");
    }

    private void printName(final String fName, final String lName) {
        System.out.println("Full Name -> " + fName + " - " + lName);
    }

    private int add(final int num1, final int num2) {
	final int sum = num1 + num2;
        System.out.println("Add [Sum of " + num1 + " and " + num2 + " is " + sum + "]");
	return sum;
    }


}
