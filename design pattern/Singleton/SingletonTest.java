public class SingletonTest{
    public static void main(final String[] args){
        final Singleton instance_1 = Singleton.instance();
        final Singleton instance_2 = Singleton.instance();
	System.out.println("instance_1 == instance_2 => " + (instance_1 == instance_2));

        final SingletonStaticWay instance_3 = SingletonStaticWay.instance();
        final SingletonStaticWay instance_4 = SingletonStaticWay.instance();
	System.out.println("instance_3 == instance_4 => " + (instance_3 == instance_4));
    
}
