import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.BrokenBarrierException;

public class CyclicBarrierTest {
    
    private int sum(final int[] digits) {
        int sum = 0;
	for(int digit : digits) sum += digit;
	return sum;
    }
    
    final int numOfThreads = 10;
    final int[] store = new int[numOfThreads];

    final CyclicBarrier sumBarrier = new CyclicBarrier(numOfThreads, () -> System.out.println("Sum of The matrix -> " + sum(store)));

    class RowSum implements Runnable{
        final int[] forSum;
	final int[] store;
	final int   storeIndex;

	public RowSum(final int[] forSum, final int[] store, final int storeIndex){
	    this.forSum = forSum;
	    this.store = store;
	    this.storeIndex = storeIndex;
	}

	@Override
	public void run(){

	    store[storeIndex] = sum(forSum);

	    try{ 
		System.out.println(Thread.currentThread().getName() + " has hit the barrier ");
	        sumBarrier.await();
            } catch(BrokenBarrierException | InterruptedException ex) {
	        ex.printStackTrace();
	    }

	}
    }

    public static void main(String... args) throws InterruptedException{
        final CyclicBarrierTest obj = new CyclicBarrierTest();
	final int[][] matrix = new int[obj.numOfThreads][];

        int value = 1;
	for(int i = 0; i < obj.numOfThreads; ++i){
	    matrix[i] = new int[1_000];
	    for(int j = 0; j < 1_000; ++j) matrix[i][j] = value++;
	}

	final Thread[] workerThreads = new Thread[obj.numOfThreads];

	for(int i = 0; i < obj.numOfThreads; ++i) workerThreads[i] = new Thread(obj.new RowSum(matrix[i], obj.store, i));
	for(Thread worker : workerThreads) worker.start();
	for(Thread worker : workerThreads) worker.join();
    }

}
