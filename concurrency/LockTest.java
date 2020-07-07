import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    final Lock lock = new ReentrantLock();
    private void display(){
        final String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " is waiting to get lock ");
        synchronized(this) {
	    System.out.println(threadName + " has acquired the lock");
            try {
	        Thread.sleep(2000);
	    }catch(InterruptedException ex){
	         ex.printStackTrace();
	    }
	    System.out.println(threadName + " has released the lock ");
          }
    }
    
    private void displayWithLock(){
        final String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " is waiting to get lock ");
        lock.lock();
	System.out.println(threadName + " has acquired the lock - display with lock");
        try {
            Thread.sleep(2000);
         }catch(InterruptedException ex){
             ex.printStackTrace();
         }finally{
             System.out.println(threadName + " has released the lock display with lock");
             lock.unlock();
         }
    }

    public static void main(String ... args) throws InterruptedException{
        final LockTest obj = new LockTest();
	final Runnable run = obj::displayWithLock;

	final Thread th1 = new Thread(run);
	th1.setName("Thread 1");

	final Thread th2 = new Thread(run);
	th2.setName("Thread 2");
	
	th2.start();
	th1.start();

	th1.join();
	th2.join();
    }

}
