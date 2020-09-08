public final class Singleton{
     private final Singleton singleton = new Singleton();
     private Singleton(){}

     public Singleton instance(){
         return singleton;
     }
}
