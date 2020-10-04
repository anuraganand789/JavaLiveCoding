import java.util.function.DoubleUnaryOperator;

public class DoubleUnaryOperatorImplementation{
    //Implementation by a regular class
    private class DBLImple implements DoubleUnaryOperator{
        @Override
	public double applyAsDouble(final double dblValue){
	    return dblValue * dblValue;
	}
    }

    //Anonymous class implementation
    final DoubleUnaryOperator dblOp = new DoubleUnaryOperator(){
        @Override
        public double applyAsDouble(final double dblValue){
            return dblValue * dblValue;
        }
    };

    //Lambda implementation 1
    final DoubleUnaryOperator dblLambda_1 = (double dblValue) -> { return dblValue * dblValue ; };

    //Lambda Implementation 2 
    final DoubleUnaryOperator dblLambda_2 = dblValue -> dblValue * dblValue;

    public static void main(final String... args){
        final DoubleUnaryOperatorImplementation obj = new DoubleUnaryOperatorImplementation();
	final DBLImple dblObj = obj.new DBLImple();
	System.out.println(dblObj.applyAsDouble(12.0));
	System.out.println(obj.dblOp.applyAsDouble(12.0));
	System.out.println(obj.dblLambda_1.applyAsDouble(12.0));
	System.out.println(obj.dblLambda_2.applyAsDouble(12.0));

    }
}
