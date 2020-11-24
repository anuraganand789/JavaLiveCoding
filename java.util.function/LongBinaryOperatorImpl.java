import java.util.function.LongBinaryOperator;

public class LongBinaryOperatorImpl{

    private static class DoubleMax implements LongBinaryOperator{
        @Override
	public long applyAsLong(final long firstValue, final long secondValue){
	    return Long.max(firstValue, secondValue);
	}
    }

    private static final LongBinaryOperator doubleMaxAnon = new LongBinaryOperator(){
                                                          @Override
                                                          public long applyAsLong(final long firstValue, final long secondValue){
                                                              return Long.max(firstValue, secondValue);
                                                          }
                                                       };

    private static final LongBinaryOperator maxByLambda   = (long firstValue, long secondValue) -> Long.max(firstValue, secondValue);
    private static final LongBinaryOperator maxByLambda_2 = (firstValue, secondValue) -> Long.max(firstValue, secondValue);
    private static final LongBinaryOperator maxByLambda_3 = Long::max;

    private static final LongBinaryOperator minByLambda_4 = Long::min;

    private static final LongBinaryOperator divideByLambda_5 = Long::divideUnsigned;

    private static final LongBinaryOperator remainderByLambda_6 = Long::remainderUnsigned;

    public static void main(final String ... args){
	final long firstLong = 10000L, secondLong = 2222L;
        System.out.printf("%s -> Max of %d and %d is Max(%d).%n", "Regualar Class", firstLong, secondLong, new DoubleMax().applyAsLong(firstLong, secondLong));
        System.out.printf("%s -> Max of %d and %d is Max(%d).%n", "Anonymous Class", firstLong, secondLong, doubleMaxAnon.applyAsLong(firstLong, secondLong));
        System.out.printf("%s -> Max of %d and %d is Max(%d).%n", "Lambda  ", firstLong, secondLong, maxByLambda  .applyAsLong(firstLong, secondLong));
        System.out.printf("%s -> Max of %d and %d is Max(%d).%n", "Lambda 2", firstLong, secondLong, maxByLambda_2.applyAsLong(firstLong, secondLong));
        System.out.printf("%s -> Max of %d and %d is Max(%d).%n", "Lambda 3", firstLong, secondLong, maxByLambda_3.applyAsLong(firstLong, secondLong));

        System.out.printf("%s -> Min of %d and %d is Min(%d).%n", "Lambda 3", firstLong, secondLong, minByLambda_4.applyAsLong(firstLong, secondLong));

        System.out.printf("%s -> Dividend of %d and %d is DivideUnsigned(%d).%n", "Lambda 3", firstLong, secondLong, divideByLambda_5.applyAsLong(firstLong, secondLong));

        System.out.printf("%s -> Remainder of %d and %d is RemainderUnsigned(%d).%n", "Lambda 3", firstLong, secondLong, remainderByLambda_6.applyAsLong(firstLong, secondLong));

    }
    
}
