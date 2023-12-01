import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomReentrantLock implements CustomLock {
    private static final Logger log = Logger.getLogger(CustomReentrantLock.class.getName());
    private int lockHoldCount;
    private long currentHoldingThreadID;

    public CustomReentrantLock() {
        this.lockHoldCount = 0;
    }

    public synchronized void lock() {
        if(lockHoldCount == 0){
            lockHoldCount++;
            currentHoldingThreadID = Thread.currentThread().getId();
        } else if(lockHoldCount > 0 &&
                currentHoldingThreadID == Thread.currentThread().getId()){
            lockHoldCount++;
        } else {
            while (currentHoldingThreadID!= Thread.currentThread().getId()){
                try {
                    this.wait();
                    lockHoldCount++;
                    currentHoldingThreadID = Thread.currentThread().getId();
                } catch (InterruptedException e) {
                    log.log(Level.SEVERE, "Exception: ", e);
                }
            }
        }
    }

    public synchronized void unlock() {
        if(lockHoldCount == 0){
            throw new IllegalMonitorStateException();
        }
        lockHoldCount--;
        if(lockHoldCount == 0){
            notify();
        }
    }

    public boolean tryLock() {
        if(lockHoldCount == 0){
            lock();
            return true;
        }
        return false;
    }
}