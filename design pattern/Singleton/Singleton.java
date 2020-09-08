public final class Singleton{
     //This code will create an object on the class load.. which is not needed
     // and it is not efficient
     //private static final Singleton singleton = new Singleton();

     private static final Singleton singleton; 

     private Singleton(){}

     public static synchronized Singleton instance(){
         if(null == singleton) 
	     singleton = new Singleton();

         return singleton;
     }
}
