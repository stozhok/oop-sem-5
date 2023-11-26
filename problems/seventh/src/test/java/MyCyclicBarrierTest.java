import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MyCyclicBarrierTest {
    private MyCyclicBarrier myCyclicBarrier;
    private boolean reached = false;

    @BeforeEach
    public void setUp() {
        myCyclicBarrier = new MyCyclicBarrier(3, () -> reached = true);
    }

    private void createThread() {
        Thread thread = new Thread(() -> {
            try {
                myCyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }

    @Test
    public void shouldAllThreadsReachBarrier() throws InterruptedException {
        createThread();
        createThread();
        createThread();
        Thread.sleep(2000); // Замінено використання wait на Thread.sleep
        assertTrue(reached);
    }

    @Test
    public void shouldRemainOneThreadWaiting() throws InterruptedException {
        createThread();
        createThread();
        Thread.sleep(2000);
        assertEquals(1, myCyclicBarrier.getWaiting().get());
    }

    @Test
    public void shouldRemainThreeThreadsAfterReleasingBarrier() throws InterruptedException {
        createThread();
        createThread();
        createThread();
        Thread.sleep(3000);
        assertTrue(reached);
        assertEquals(3, myCyclicBarrier.getWaiting().get());
    }

    @Test
    public void shouldRemainThreeThreadsThatNotReachedBarrier() throws InterruptedException {
        createThread();
        createThread();
        createThread();
        Thread.sleep(2000);
        assertEquals(3, myCyclicBarrier.getAmountOfThreads());
    }
}
