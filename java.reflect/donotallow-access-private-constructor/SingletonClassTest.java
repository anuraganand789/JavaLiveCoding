import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Constructor;
public class SingletonClassTest {
    public static void main(final String ... args)
                                                 throws 
			                                InvocationTargetException,
				                        IllegalAccessException,
							InstantiationException {
        final Class<?> singletonClass = SingletonClass.class;
	final Constructor<?>[] arrayOfConstructors = singletonClass.getDeclaredConstructors();
	final Constructor<?> privateConstructor = arrayOfConstructors[0];
	privateConstructor.setAccessible(true);
	//final SingletonClass object = (SingletonClass) privateConstructor.newInstance();
	final SingletonClass object = SingletonClass.instance(); 
	object.display();
	//final SingletonClass object1 = (SingletonClass) privateConstructor.newInstance();
	//final SingletonClass object2 = (SingletonClass) privateConstructor.newInstance();
	//System.out.println("object1 and object2 are the same instance " + (object1 == object2));
    }
}
