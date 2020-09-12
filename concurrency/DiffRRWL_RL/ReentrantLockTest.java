import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest{
    private final ReentrantLock lock = new ReentrantLock();

    private int intValue = 0;

    public void read(){
        lock.lock();
	final String threadName = Thread.currentThread().getName();
	System.out.println(threadName + " has acquired the read lock ");
	try{
	    Thread.sleep(1000);
	    System.out.println(threadName + " Current Value " + intValue);
	}catch(final InterruptedException ex){
	    System.out.println(threadName + " has been interrupted " + ex.getMessage());
	}finally{
	    System.out.println(threadName + " has relesed the read lock ");
	    lock.unlock();
	}
    }
}
