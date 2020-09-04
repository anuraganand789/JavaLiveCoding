public class ProdConsUsingWaitNotifyAll{
    private final int   MAX  = 6;
    private final int[] data = new int[MAX];
    
    private int dataIndex = -1;
    private int dataValue = 0;

    private void consume() {
        try{
	    while(true){
                synchronized(this){
	            while(dataIndex == -1) wait(2000);
	            final int consumedValue = data[dataIndex--];
	            System.out.println(Thread.currentThread().getName() + " Consumed " + consumedValue);
	            notifyAll();
	        }
	    }
	}catch(InterruptedException ex){
	    ex.printStackTrace();
	}
    }

    private void produce(){
        try{
            while(true){
	        synchronized(this){
	            while(dataIndex == MAX - 1) wait(2000);
	            data[++dataIndex]  =  ++dataValue;
		    System.out.println(Thread.currentThread().getName() + " Produced " + dataValue);
	            notifyAll();
	        }
	    }
	}catch(InterruptedException ex){
	    ex.printStackTrace();
	}
    }
    
    public static void main(String[] args) {
        final ProdConsUsingWaitNotifyAll pc = new ProdConsUsingWaitNotifyAll();

	final Runnable consumer = () -> pc.consume();
	final Runnable producer  = () -> pc.produce();
	
	//Consumer Threads
	final Thread consumer1 = new Thread(consumer);
	final Thread consumer2 = new Thread(consumer);
	final Thread consumer3 = new Thread(consumer);
	final Thread consumer4 = new Thread(consumer);
	final Thread consumer5 = new Thread(consumer);
	final Thread consumer6 = new Thread(consumer);


	//Producer Threads
	final Thread producer1  = new Thread(producer);
	final Thread producer2 = new Thread(consumer);
	final Thread producer3 = new Thread(consumer);
	final Thread producer4 = new Thread(consumer);
	final Thread producer5 = new Thread(consumer);
	final Thread producer6 = new Thread(consumer);

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
