public final class SingletonStaticWay {
     static class Inner {
         private final static SingletonStaticWay instance = new SingletonStaticWay();
     }

     public static SingletonStaticWay instance(){
         return Inner.instance;
     }
}
