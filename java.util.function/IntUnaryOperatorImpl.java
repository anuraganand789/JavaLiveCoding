import java.util.function.IntUnaryOperator;

public class IntUnaryOperatorImpl{
    private static class Square implements IntUnaryOperator{
        @Override
	public int applyAsInt(final int intValue){ return intValue * intValue; }
    }

    private static final IntUnaryOperator squareAnonClass =  new IntUnaryOperator(){
        @Override
	public int applyAsInt(final int intValue){ return intValue * intValue; }
    };

    private static class Cube implements IntUnaryOperator{
        @Override
	public int applyAsInt(final int intValue) { return intValue * intValue * intValue; }
    }

    private static final IntUnaryOperator cubeAnonClass = new IntUnaryOperator(){
        @Override
	public int applyAsInt(final int intValue) { return intValue * intValue * intValue; }
    };

    private static class Utility{
        private static final int square(final int intValue) { return (int) intValue * intValue; }
        private static final int cube(final int intValue) { return (int) intValue * intValue * intValue; }
    }

    private static final IntUnaryOperator squareImpl   = (int intValue) -> intValue * intValue;
    private static final IntUnaryOperator squareImpl_2 = intValue -> intValue * intValue;
    private static final IntUnaryOperator squareImpl_3 = Utility::square;

    private static final IntUnaryOperator cubeImpl   = (int intValue) -> intValue * intValue * intValue;
    private static final IntUnaryOperator cubeImpl_2 = intValue -> intValue * intValue * intValue;
    private static final IntUnaryOperator cubeImpl_3 = Utility::cube;

    public static void main(final String ... commandLineArguments){
	final int intValue = 100;

        System.out.format("Square %s of %d -> %d.%n", "Regular Class", intValue, (new Square()).applyAsInt(intValue));
        System.out.format("Square %s of %d -> %d.%n", "Anonymous Class", intValue, squareAnonClass.applyAsInt(intValue));
        System.out.format("Square %s of %d -> %d.%n", "Lambda Long", intValue, squareImpl.applyAsInt(intValue));
        System.out.format("Square %s of %d -> %d.%n", "Lambdas Short", intValue, squareImpl_2.applyAsInt(intValue));
        System.out.format("Square %s of %d -> %d.%n", "Lambda Method Ref", intValue, squareImpl_3.applyAsInt(intValue));
        System.out.println();
        System.out.format("Cube %s of %d -> %d.%n", "Regular Class", intValue, (new Cube()).applyAsInt(intValue));
        System.out.format("Cube %s of %d -> %d.%n", "Anonymous Class", intValue, cubeAnonClass.applyAsInt(intValue));
        System.out.format("Cube %s of %d -> %d.%n", "Lambda Long", intValue, cubeImpl.applyAsInt(intValue));
        System.out.format("Cube %s of %d -> %d.%n", "Lambdas Short", intValue, cubeImpl_2.applyAsInt(intValue));
        System.out.format("Cube %s of %d -> %d.%n", "Lambda Method Ref", intValue, cubeImpl_3.applyAsInt(intValue));
    }
    
}
