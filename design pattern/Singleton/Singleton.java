public final class Singleton{
     private final Singleton singleton = new Singleton();

     private Singleton(){}

     public static Singleton instance(){
         return singleton;
     }
}
