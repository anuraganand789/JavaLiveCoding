public class SingletonClass{
    final StackWalker walker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);

    private static SingletonClass INSTANCE;

    private SingletonClass(){
        if(SingletonClass.class != walker.getCallerClass()) throw new IllegalAccessError("Private Constructor can not be invoked from outside the class");
    }

    public void display(){
        System.out.println("Yes I am displaying");
    }

    public static SingletonClass instance(){
        if(INSTANCE == null){
	    synchronized(SingletonClass.class){
                if(INSTANCE == null){
		   INSTANCE = new SingletonClass(); 
	        }
	    }
	}
	return INSTANCE;
    }

}
