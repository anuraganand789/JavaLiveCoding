import java.util.concurrent.TimeUnit;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class FutureTaskTest {

    private static void display(){
        final String threadName = Thread.currentThread().getName();
	try{
	    System.out.println("Thread [ " + threadName + "] is going to sleep.");
	    Thread.sleep(1000);
	    System.out.println("Thread [ " + threadName + "] is awake.");
	}catch(final InterruptedException ex){
	    System.out.println(threadName + " has been interrupted");
	}
    }

    public static void main(final String ...args) throws InterruptedException{
	//FutureTaskTest.display();

	final FutureTask<String> futureTask = new FutureTask<String>(FutureTaskTest::display, "Task has Completed");

	final ExecutorService    threadPool = Executors.newCachedThreadPool();

	threadPool.execute(futureTask);

	System.out.println("Future Task Has Completed " + futureTask.isDone());
	if(!futureTask.isDone()) futureTask.cancel(true);
	System.out.println("Future Task is Cancelled " + futureTask.isCancelled());

	threadPool.shutdown();

	threadPool.awaitTermination(1, TimeUnit.MINUTES);


    }
}
