import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.TimeUnit;

public class ProdConsUsingReentrantLockCondition {

    private final ReentrantLock lock         = new ReentrantLock();
    private final Condition     dataProduced = lock.newCondition();
    private final Condition     dataConsumed = lock.newCondition();

    private final int           MAX          =  5;
    private final int[]         data         =  new int[MAX];
    private       int           dataIndex    =  -1;
    private       int           dataValue    =  0;

    private void consume() {
        while(true) {
	    try{
                lock.lock();
		while(dataIndex == -1) dataProduced.await();//await(2000, TimeUnit.MILLISECONDS);
		final int consumedValue = data[dataIndex--];
		System.out.printf("%s Consumed %d.\n", Thread.currentThread().getName(), consumedValue);
		dataConsumed.signalAll();
	    }catch(InterruptedException ex){
	        ex.printStackTrace();
	    }finally{
	        lock.unlock();
	    }
	}
    }

    private void produce() {
        while(true) {
	    try{
                lock.lock();
		while(dataIndex == MAX - 1) dataConsumed.await();//await(2000, TimeUnit.MILLISECONDS);
		data[++dataIndex] = ++dataValue;
		System.out.printf("%s Produced %d.\n", Thread.currentThread().getName(), dataValue);
		dataProduced.signalAll();
	    }catch(InterruptedException ex){
	        ex.printStackTrace();
	    }finally{
	        lock.unlock();
	    }
	}
        
    }

    public static void main(String... args){
        final ProdConsUsingReentrantLockCondition pc = new ProdConsUsingReentrantLockCondition();

	final Runnable consumer = pc::consume;
	final Runnable producer = pc::produce;

	final Thread consumer1 = new Thread(consumer);
	final Thread consumer2 = new Thread(consumer);
	final Thread consumer3 = new Thread(consumer);
	final Thread consumer4 = new Thread(consumer);
	final Thread consumer5 = new Thread(consumer);
	final Thread consumer6 = new Thread(consumer);

	final Thread producer1 = new Thread(producer);
	final Thread producer2 = new Thread(producer);
	final Thread producer3 = new Thread(producer);
	final Thread producer4 = new Thread(producer);
	final Thread producer5 = new Thread(producer);
	final Thread producer6 = new Thread(producer);

        consumer1.start();
        consumer2.start();
        consumer3.start();
        consumer4.start();
        consumer5.start();
        consumer6.start();

        producer1.start();
        producer2.start();
        producer3.start();
        producer4.start();
        producer5.start();
        producer6.start();

        try{
            consumer1.join();
            consumer2.join();
            consumer3.join();
            consumer4.join();
            consumer5.join();
            consumer6.join();

            producer1.join();
            producer2.join();
            producer3.join();
            producer4.join();
            producer5.join();
            producer6.join();
	}catch(InterruptedException ex){
	    ex.printStackTrace();
	}

    }
}
