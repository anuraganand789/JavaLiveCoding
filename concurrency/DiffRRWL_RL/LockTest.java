public class LockTest{
    private void testReentrantLock() throws InterruptedException{
	System.out.println("Running testReentrantLock");
        final ReentrantLockTest testObj = new ReentrantLockTest();
	final Runnable read = testObj::read;

	final Thread reader_1    =    new Thread(read);
	final Thread reader_2    =    new Thread(read);
	final Thread reader_3    =    new Thread(read);
	final Thread reader_4    =    new Thread(read);
	final Thread reader_5    =    new Thread(read);
	final Thread reader_6    =    new Thread(read);
	final Thread reader_7    =    new Thread(read);
	final Thread reader_8    =    new Thread(read);
	final Thread reader_9    =    new Thread(read);
	final Thread reader_10    =    new Thread(read);

	reader_1 .start(); 
	reader_2 .start(); 
	reader_3 .start(); 
	reader_4 .start(); 
	reader_5 .start(); 
	reader_6 .start(); 
	reader_7 .start(); 
	reader_8 .start(); 
	reader_9 .start(); 
	reader_10.start(); 

	reader_1 .join(); 
	reader_2 .join(); 
	reader_3 .join(); 
	reader_4 .join(); 
	reader_5 .join(); 
	reader_6 .join(); 
	reader_7 .join(); 
	reader_8 .join(); 
	reader_9 .join(); 
	reader_10.join(); 
    }
    
    private void testReentrantReadWriteLock() throws InterruptedException{
	System.out.println("Running testReentrantReadWriteLock ");
        final ReentrantReadWriteLockTest testObj = new ReentrantReadWriteLockTest();
	final Runnable read = testObj::read;

	final Thread reader_1    =    new Thread(read);
	final Thread reader_2    =    new Thread(read);
	final Thread reader_3    =    new Thread(read);
	final Thread reader_4    =    new Thread(read);
	final Thread reader_5    =    new Thread(read);
	final Thread reader_6    =    new Thread(read);
	final Thread reader_7    =    new Thread(read);
	final Thread reader_8    =    new Thread(read);
	final Thread reader_9    =    new Thread(read);
	final Thread reader_10    =    new Thread(read);

	reader_1 .start(); 
	reader_2 .start(); 
	reader_3 .start(); 
	reader_4 .start(); 
	reader_5 .start(); 
	reader_6 .start(); 
	reader_7 .start(); 
	reader_8 .start(); 
	reader_9 .start(); 
	reader_10.start(); 

	reader_1 .join(); 
	reader_2 .join(); 
	reader_3 .join(); 
	reader_4 .join(); 
	reader_5 .join(); 
	reader_6 .join(); 
	reader_7 .join(); 
	reader_8 .join(); 
	reader_9 .join(); 
	reader_10.join(); 
    }

    public static void main(final String ...args) throws InterruptedException {
        final LockTest test = new LockTest();
	test.testReentrantLock();
	test.testReentrantReadWriteLock();
    }
}
