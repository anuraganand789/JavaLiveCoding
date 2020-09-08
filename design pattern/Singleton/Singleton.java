public final class Singleton{
     //This code will create an object on the class load.. which is not needed
     // and it is not efficient
     //private static final Singleton singleton = new Singleton();

     private static Singleton singleton; 

     private Singleton(){}

     // Threads will wait in a queue to read the instance object.
     //Although, the instance has been already created
     //public static synchronized Singleton instance(){
     public static Singleton instance(){
	 if(null == singleton) {
	     synchronized(Singleton.class){
                 if(null == singleton)
		     singleton = new Singleton();
	     }
	 }
         return singleton;
     }
}
