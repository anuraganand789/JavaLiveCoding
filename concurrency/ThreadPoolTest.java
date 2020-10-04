import java.util.List;
import java.util.ArrayList;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;

import java.util.concurrent.atomic.AtomicInteger;

import java.util.stream.IntStream;

public class ThreadPoolTest{
    final AtomicInteger taskId = new AtomicInteger(0);

    final int sizeOfThreadPool = 4;
    final List<Thread> poolOfThreads = new ArrayList<>();

    final BlockingQueue<Task> queueOfTasks = new ArrayBlockingQueue<>(10);

    private class TestRunnable implements Runnable{
        @Override
	public void run(){
	    final Thread currentThread = Thread.currentThread();
	    final String threadName = currentThread.getName();
	    //keep executing the tasks as long as you are not asked to stop
	    while(true){
	        if(currentThread.isInterrupted()){
		    System.out.printf("%s is asked to stop.%n" , threadName);
		    System.out.printf("%s is stopping .%n", threadName);
		    break;
		}
	        final Task task = queueOfTasks.poll();
		if(task != null) task.execute();
	    }
	}
    }

    private class Task {
	private final int taskID;

	public Task(final int taskID){ this.taskID = taskID; }

        public void execute(){
	    System.out.printf("The task number %d has executed %n", this.taskID);
	}
    }

    private void start(){
        poolOfThreads.stream().forEach(Thread::start);
    }

    private void submit(final Task task) throws InterruptedException{
        queueOfTasks.put(task);
    }

    private void shutdown(){
        poolOfThreads.stream().forEach(Thread::interrupt);
    }

    public static void main(final String... args) throws InterruptedException{
        final ThreadPoolTest threadPool = new ThreadPoolTest();
	final Runnable testRun = threadPool.new TestRunnable();

	//Create number of threads which is equal to thread pool size
	IntStream.range(0, threadPool.sizeOfThreadPool).forEach(threadID -> threadPool.poolOfThreads.add(new Thread(testRun, "Thread " + threadID)));

	//Start all the threads
        threadPool.start();

	int loopCount = 0;
	final Thread mainThread = Thread.currentThread();

	//Add task to the task queue
	while(true){
	    if(loopCount % 10 == 0) mainThread.sleep(1000);

	    loopCount++;
	    threadPool.submit(threadPool.new Task(loopCount));

	    if(loopCount == 100) { break; }
	}

	threadPool.shutdown();
    }
}
