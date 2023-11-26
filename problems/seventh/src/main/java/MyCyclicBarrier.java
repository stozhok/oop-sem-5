import java.util.concurrent.atomic.AtomicInteger;

public class MyCyclicBarrier {
    private final int amountOfThreads;
    private final Runnable cyclicBarrierEvent;
    private final AtomicInteger waiting;

    public MyCyclicBarrier(int amounrOfThreads, Runnable cyclicBarrierEvent){
        this.amountOfThreads = amounrOfThreads;
        this.cyclicBarrierEvent = cyclicBarrierEvent;
        this.waiting = new AtomicInteger(amounrOfThreads);
    }
    public void await() throws InterruptedException{
        if (waiting.decrementAndGet() != 0){
            synchronized (this){
                while (waiting.get() != 0){
                    wait();
                }
            }
        }
        else {
            waiting.set(amountOfThreads);
            synchronized (this){
                notifyAll();
            }
            cyclicBarrierEvent.run();
        }
    }
    public int getAmountOfThreads(){
        return amountOfThreads;
    }

    public AtomicInteger getWaiting() {
        return waiting;
    }

}
