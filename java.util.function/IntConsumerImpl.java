import java.util.function.IntConsumer;

import java.util.Arrays;

public class IntConsumerImpl {
    
    class IntCons implements IntConsumer{
        
	@Override
	public void accept(final int intValue){
	    System.out.print("Regular Class " + intValue + " The Value is less Than 10 " + (intValue < 10) + " ");
	}
    }

    final IntConsumer anonIntCons = new IntConsumer(){
	                                          @Override
	                                          public void accept(final int intValue){
	                                              System.out.print("Anonymous Class " + intValue + " The Value is less Than 10 " + (intValue < 10) + " ");
	                                          }
                                         };


    public static void main(final String... args){
        final IntConsumerImpl obj = new IntConsumerImpl();
	final IntCons cons = obj.new IntCons();

	final int[] ints = {1, 5, 10, 12};

	Arrays.stream(ints).peek(cons::accept).map(x -> x * x ).forEach(System.out::println);
	System.out.println();

	Arrays.stream(ints).peek(obj.anonIntCons::accept).map(x -> x * x ).forEach(System.out::println);
	System.out.println();

	final IntConsumer consLambda_1 = (int intValue) -> 
	                          { System.out.print("consLambda_1 Class " + intValue + " The Value is less Than 10 " + (intValue < 10) + " "); };
	Arrays.stream(ints).peek(consLambda_1::accept).map(x -> x * x ).forEach(System.out::println);
	System.out.println();

	final IntConsumer consLambda_2 = (intValue) -> 
	                          { System.out.print("consLambda_2 Class " + intValue + " The Value is less Than 10 " + (intValue < 10) + " "); };
	Arrays.stream(ints).peek(consLambda_2::accept).map(x -> x * x ).forEach(System.out::println);
	System.out.println();

	final IntConsumer consLambda_3 = consLambda_2::accept;
	Arrays.stream(ints).peek(consLambda_3::accept).map(x -> x * x ).forEach(System.out::println);
	System.out.println();

    }
}
