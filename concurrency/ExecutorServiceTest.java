import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class ExecutorServiceTest{
    private static void display(){
	final String threadName = Thread.currentThread().getName();
	try{
            System.out.println(threadName + " is going to sleep ");
	    Thread.sleep(1200);
            System.out.println(threadName + " is awake ");
	}catch(final InterruptedException ex){
	    System.out.println(threadName + " is interrupted " + ex.getMessage());
	}
    }

    public static void main(final String ...args) throws InterruptedException{
        final ExecutorService     fixedThreadPool    =     Executors.newFixedThreadPool(1);
	final ExecutorService     cachedThreadPool   =     Executors.newCachedThreadPool();
	final ExecutorService     singleThreadPool   =     Executors.newSingleThreadExecutor();

        ExecutorServiceTest.display();

        final Runnable   task = ExecutorServiceTest::display;
	 
	fixedThreadPool .submit(task);
	cachedThreadPool.submit(task);
	singleThreadPool.submit(task);

	fixedThreadPool .shutdown();
	cachedThreadPool.shutdown();
	singleThreadPool.shutdown();

	fixedThreadPool .awaitTermination(1, TimeUnit.SECONDS);
	cachedThreadPool.awaitTermination(1, TimeUnit.SECONDS);
	singleThreadPool.awaitTermination(1, TimeUnit.SECONDS);
    }
}
