import java.util.function.LongConsumer;

public class LongConsumerImpl{
    
    private static class LongConsumerInner implements LongConsumer{
        @Override
	public void accept(final long longValue){
	    System.out.format("%s ->> Long Value %d.%n", "Static Inner Class", longValue);
	}
    }

    private static LongConsumer longConsumerAnon = new LongConsumer(){
        @Override
	public void accept(final long longValue){
	    System.out.format("%s ->> Long Value %d.%n", "Anonymous Class", longValue);
	}
    };

    private static LongConsumer longConsumerLambdaFull      =   (final long longValue) -> System.out.format("%s ->> Long Value %d.%n", "Lambda Full", longValue);
    private static LongConsumer longConsumerLambdaShort     =   (longValue) -> System.out.format("%s ->> Long Value %d.%n", "Lambda Short", longValue);
    private static LongConsumer longConsumerLambdaMethodRef =   System.out::println; 
    private static LongConsumer longConsumerLambdaMethodRef2 =   LongConsumerImpl::print; 

    public static void main(final String ... args){
        final LongConsumerInner inner = new LongConsumerInner();
	inner.accept(10L);

	longConsumerAnon.accept(100L);
	longConsumerLambdaFull.accept(101L);
	longConsumerLambdaShort.accept(102L);
        longConsumerLambdaMethodRef .accept(103L);
        longConsumerLambdaMethodRef2.accept(105L);
    }

    private static void print(long longValue){
        System.out.format("%s ->> Long Value %d.%n", "print function", longValue);
    }
}
