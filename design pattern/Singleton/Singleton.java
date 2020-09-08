public final class Singleton{
     private static final Singleton singleton = new Singleton();

     private Singleton(){}

     public static Singleton instance(){
         return singleton;
     }
}
