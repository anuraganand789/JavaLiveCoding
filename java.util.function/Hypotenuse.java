import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.function.DoubleBinaryOperator;

public class Hypotenuse{
    private final class CalHypotenuse implements DoubleBinaryOperator{
        @Override
	public double applyAsDouble(final double sideOne, final double sideTwo){
	    return sqrt(pow(sideOne, 2) + pow(sideTwo, 2));
	}
    }

    private final DoubleBinaryOperator anonHypo = new DoubleBinaryOperator(){
        @Override
	public double applyAsDouble(final double sideOne, final double sideTwo){
	    return sqrt(pow(sideOne, 2) + pow(sideTwo, 2));
	}
    };

    private static double hypotenuse(final double firstSide, final double secondSide) { return sqrt(pow(firstSide, 2) + pow(secondSide, 2)); }
    private final DoubleBinaryOperator lambdaFull  = (final double sideOne, final double sideTwo) -> sqrt(pow(sideOne, 2) + pow(sideTwo, 2));
    private final DoubleBinaryOperator lambdaShort = (sideOne, sideTwo) -> sqrt(pow(sideOne, 2) + pow(sideTwo, 2));
    private final DoubleBinaryOperator lambdaMethodRef = Hypotenuse::hypotenuse;


    public static void main(final String ... args){
        final Hypotenuse obj = new Hypotenuse();
	final CalHypotenuse calObj = obj.new CalHypotenuse();

	final double sideOne = 10.9, sideTwo = 12.5;
	double
	hypo = calObj.applyAsDouble(sideOne, sideTwo);
	System.out.format("%s => Hypotenuse of %.2f and %.2f is %.2f.%n", "Regular Class", sideOne, sideTwo, hypo);

	hypo = obj.anonHypo.applyAsDouble(sideOne, sideTwo);
	System.out.format("%s => Hypotenuse of %.2f and %.2f is %.2f.%n", "Anonymous Class", sideOne, sideTwo, hypo);

	hypo = obj.lambdaFull.applyAsDouble(sideOne, sideTwo);
	System.out.format("%s => Hypotenuse of %.2f and %.2f is %.2f.%n", "Lambda Full ", sideOne, sideTwo, hypo);

	hypo = obj.lambdaShort.applyAsDouble(sideOne, sideTwo);
	System.out.format("%s => Hypotenuse of %.2f and %.2f is %.2f.%n", "Lambda Short", sideOne, sideTwo, hypo);

	hypo = obj.lambdaMethodRef.applyAsDouble(sideOne, sideTwo);
	System.out.format("%s => Hypotenuse of %.2f and %.2f is %.2f.%n", "Method Ref", sideOne, sideTwo, hypo);

    }
}
