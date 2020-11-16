import java.util.function.IntToLongFunction;

public class IntToLongFunctionImpl{

    private static void display(int intValue){
        System.out.format("This is an int %d.%n", intValue);
    }

    private static void display(long longValue){
        System.out.format("This is a long %d.%n", longValue);
    }

    private static long intToLong(final int intValue) { System.out.println("inside intToLong function"); return intValue * 1L; }

    private static class IntToL implements IntToLongFunction{
        @Override
	public long applyAsLong(final int intValue ){
	    return intValue * 1L;
	}
    }

    
    private final static IntToLongFunction intToLAnon = new IntToLongFunction(){
                                                                 @Override
                                                                 public long applyAsLong(final int intValue ){
                                                                     return intValue * 1L;
                                                                 }
                                                         };
    
    private final static IntToLongFunction intToLLambda = (final int intValue) -> intValue * 1L;

    private final static IntToLongFunction intToLLambda2 = (intValue) -> intValue * 1L;

    private final static IntToLongFunction intToLLambda3 = IntToLongFunctionImpl::intToLong;

    public static void main(final String ... args){
	final int intValue = 10;
	display(intValue);

        display((new IntToL()).applyAsLong(intValue));
        display(intToLAnon    .applyAsLong(intValue));
        display(intToLLambda  .applyAsLong(intValue));
        display(intToLLambda2 .applyAsLong(intValue));
        display(intToLLambda3 .applyAsLong(intValue));
   }
}
