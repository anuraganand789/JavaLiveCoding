import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockTest{
    private int testValue = 0;

    private ReentrantReadWriteLock lock      = new ReentrantReadWriteLock();
    private Lock                   readLock  = lock.readLock();
    private Lock                   writeLock = lock.writeLock();

    private void write(){
        writeLock.lock();
	final String threadName = Thread.currentThread().getName();
	System.out.println(threadName + " has acquired write lock ");
	try{
            System.out.println(threadName  + " New Value " + testValue);
	}finally{
	    System.out.println(threadName + " has release write lock ");
	    writeLock.unlock();
	}
    }

    private void read(){
        readLock.lock();
	final String threadName = Thread.currentThread().getName();
	System.out.println(threadName + " has acquired read lock ");
	try{
            System.out.println(threadName  + " Current Value " + testValue);
	}finally{
	    System.out.println(threadName + " has release read lock ");
	    readLock.unlock();
	}
    }

    public static void main(final String ...args) throws InterruptedException{
        final ReentrantReadWriteLockTest lockTest = new ReentrantReadWriteLockTest();

	final Runnable read = lockTest::read;
	final Runnable write = lockTest::write;

	final Thread writer_1 = new Thread(write);
	final Thread writer_2 = new Thread(write);

	final Thread reader_1  = new Thread(read);
	final Thread reader_2  = new Thread(read);
	final Thread reader_3  = new Thread(read);
	final Thread reader_4  = new Thread(read);
	final Thread reader_5  = new Thread(read);
	final Thread reader_6  = new Thread(read);

	writer_1.start();
	writer_2.start();

	reader_6.start();
	reader_5.start();
	reader_4.start();
	reader_3.start();
	reader_2.start();
	reader_1.start();

	writer_1.join();
	writer_2.join();

	reader_6.join();
	reader_5.join();
	reader_4.join();
	reader_3.join();
	reader_2.join();
	reader_1.join();

    }
}
