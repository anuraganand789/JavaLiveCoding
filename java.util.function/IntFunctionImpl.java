import java.util.function.IntFunction;

public class IntFunctionImpl{
    private class IntFuncImpl implements IntFunction<Integer>{
	@Override
	public Integer apply(final int intValue) { return Integer.valueOf(intValue); }
    }

    final IntFunction<Integer> anonClass = new IntFunction<Integer>() {
                                      
				      @Override
				      public Integer apply(final int intValue) { return Integer.valueOf(intValue); }
    
                                  };
    final IntFunction<Integer> lambdaWithDataType    = (int intValue) -> { return Integer.valueOf(intValue); };
    final IntFunction<Integer> lambdaWithoutDataType = (intValue) -> Integer.valueOf(intValue); 

    final IntFunction<Integer> lambdaWithMethodReference = Integer::valueOf;

    public static void main(final String... args){
	final IntFunctionImpl obj = new IntFunctionImpl();
	final IntFuncImpl func = obj.new IntFuncImpl();
        Integer val = func.apply(19);
	System.out.println(val);

	val = obj.anonClass.apply(10);
	System.out.println(val);

	val = obj.lambdaWithDataType.apply(10);
	System.out.println(val);

	val = obj.lambdaWithoutDataType.apply(12);
	System.out.println(val);

	val = obj.lambdaWithMethodReference.apply(23);
	System.out.println(val);
    }
}
