import java.util.stream.IntStream;
import java.util.function.IntSupplier;

public class IntStreamImpl{

    final static IntSupplier randomValuesSupplier = () -> (int) (Math.random() * 10);
    final static IntStream   infiniteRandomValueStream = IntStream.generate(randomValuesSupplier);

    public static void main(final String ... commandLineArguments){
         infiniteRandomValueStream .limit(500) .forEach(System.out::println);
    }
}
