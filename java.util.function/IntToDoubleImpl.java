
import java.util.function.IntToDoubleFunction;

public class IntToDoubleImpl {
    private final class IntToDblImpl implements IntToDoubleFunction{
        @Override
	public double applyAsDouble(final int intValue){
	   return Math.sqrt(intValue);
	}
    }

    private final IntToDoubleFunction sqrtAnon = new IntToDoubleFunction(){
                                                          @Override
						          public double applyAsDouble(final int intValue){
						              return Math.sqrt(intValue);
						          }
						      };
    private final IntToDoubleFunction sqrtLambda_1 = (int intValue) -> Math.sqrt(intValue);
    private final IntToDoubleFunction sqrtLambda_2 = (intValue) -> Math.sqrt(intValue);
    private final IntToDoubleFunction sqrtLambda_3 = Math::sqrt;

    public static void main(final String ... args){
        final IntToDoubleImpl obj = new IntToDoubleImpl();

	final IntToDblImpl sqrtUsingClass = obj.new IntToDblImpl();

	final int value = 10;
	System.out.format("[%s] Sqrt of %d == %f.%n", "Class", value, sqrtUsingClass.applyAsDouble(value));
	System.out.format("[%s] Sqrt of %d == %f.%n", "sqrtLambda_1", value, obj.sqrtLambda_1.applyAsDouble(value));
	System.out.format("[%s] Sqrt of %d == %f.%n", "sqrtLambda_2", value, obj.sqrtLambda_2.applyAsDouble(value));
	System.out.format("[%s] Sqrt of %d == %f.%n", "sqrtLambda_3", value, obj.sqrtLambda_3.applyAsDouble(value));
    }
}
