import java.util.function.IntBinaryOperator;

public class IntBinaryOperatorImpl {
    
    //By Regular class
    private class RegularImpl implements IntBinaryOperator{
        @Override
	public int applyAsInt(final int firstIntValue, final int secondIntValue){
	    return firstIntValue > secondIntValue ? firstIntValue : secondIntValue;
	}
    }


    //Anonymnous Class Implementation
    private IntBinaryOperator sum = new IntBinaryOperator() { 
                                       @Override
				       public int applyAsInt(final int firstValue, final int secondValue){
				           return firstValue + secondValue;
				       }
				     };

    //Lambda 1 implementation
    private IntBinaryOperator sumLam_1 = (int firstValue, int secondValue) -> { return firstValue + secondValue; };

    //Lambds 2 Implementation
    private IntBinaryOperator sumLam_2 = (firstValue, secondValue) -> firstValue + secondValue;

    //Lambda 3 Implementation
    private IntBinaryOperator sumLam_3 = Integer::sum;

    public static void main(final String... args){
        final IntBinaryOperatorImpl obj = new IntBinaryOperatorImpl();
	final int firstValue = 10;
	final int secondValue = 11;

	final RegularImpl reg = obj.new RegularImpl();
	System.out.println("Max is " + reg.applyAsInt(firstValue, secondValue));

	System.out.println("Sum is " + obj.sum.applyAsInt(firstValue, secondValue));
	System.out.println("Sum is " + obj.sumLam_1.applyAsInt(firstValue, secondValue));
	System.out.println("Sum is " + obj.sumLam_2.applyAsInt(firstValue, secondValue));
	System.out.println("Sum is " + obj.sumLam_3.applyAsInt(firstValue, secondValue));

    }
}
