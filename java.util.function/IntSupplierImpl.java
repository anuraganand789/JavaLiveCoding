import java.util.function.IntSupplier;

public class IntSupplierImpl{
    
    private class IntSupp implements IntSupplier{
        @Override
	public int getAsInt(){
	    return (int) (Math.random() * 10);
	}
    }

    private IntSupplier intAnon = new IntSupplier(){
				      @Override
				      public int getAsInt(){
				         return (int) (Math.random() * 10);
				      }
                                  };

    private IntSupplier intLambda = () -> (int) (Math.random() * 10);

    public static void main(final String ... args){
        final IntSupplierImpl obj = new IntSupplierImpl();
	final IntSupplier     intSuppUsingClass = obj.new IntSupp();

        System.out.format("Random Int from class %d %n", intSuppUsingClass.getAsInt());

        System.out.format("Random Int from Anonymous class %d %n", obj.intAnon.getAsInt());

        System.out.format("Random Int from Lambda %d %n", obj.intLambda.getAsInt());
    }
}
