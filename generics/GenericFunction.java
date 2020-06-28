public class GenericFunction {
    
    public <T extends Number> Number sum(final T x, final T y){
        if(x instanceof Double) return x.doubleValue() + y.doubleValue();
        else if(x instanceof Short) return x.shortValue() + y.shortValue();

        return x.intValue() + y.intValue();
    }
    
    public static void main(String... args){
        final GenericFunction obj = new GenericFunction();
	System.out.println(obj.<Integer>sum(100, 1000));
	System.out.println(obj.<Double>sum(10.12, 100.10));
	System.out.println(obj.<Short>sum((short) 10, (short) 100));


    }
}
