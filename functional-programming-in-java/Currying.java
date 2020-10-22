import java.util.function.UnaryOperator;
import java.util.function.Consumer;

public class Currying {
    
    private UnaryOperator<Integer> adderGenerator(final int adderValue){
        return (intOperand) -> intOperand + adderValue;
    }

    private UnaryOperator<Integer> multiplierGenerator(final int multiplier){
        return (intOperand) -> intOperand * multiplier;
    }

    private Consumer<String> displayComposer(final Consumer<String> displayer){
        return (stringValue) -> displayer.accept(stringValue);
    }

    private void displaySimple(final String value){
        System.out.println(value);
    }

    private void designerDisplay(final String value){
        System.out.println("***************************");
        System.out.println(value);
        System.out.println("***************************");
    }

    public static void main(String ...args){
         final Currying               curry                     = new Currying();

	 final UnaryOperator<Integer> addTwoCurry               = curry.adderGenerator(2);
	 final UnaryOperator<Integer> multiplyBy_100            = curry.multiplierGenerator(100);
         
	 final Consumer<String>       printToConsole            = curry.displayComposer(System.out::println);
	 final Consumer<String>       printToConsoleNoNewLine   = curry.displayComposer(System.out::print);

	 final Consumer<String>       designerDisplay           = curry.displayComposer(curry::designerDisplay);

	 printToConsole.accept("Add Two to 2 = " + addTwoCurry.apply(2));
	 printToConsole.accept("Add Two to 3 = " + addTwoCurry.apply(3));

	 printToConsoleNoNewLine.accept("Add Two to 4 = " + addTwoCurry.apply(4));

	 printToConsole.accept("Add Two to 2 = " + multiplyBy_100.apply(2));

	 designerDisplay.accept("Add Two to 3 = " + multiplyBy_100.apply(3));
	 designerDisplay.accept("Add Two to 4 = " + multiplyBy_100.apply(4));
    }
}
