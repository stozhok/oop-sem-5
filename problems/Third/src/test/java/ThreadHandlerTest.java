import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ThreadHandlerTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testPrintThreadsInfo() {
        ThreadGroup rootGroup = Thread.currentThread().getThreadGroup();

        ThreadHandler threadHandler = new ThreadHandler();
        threadHandler.printThreadsInfo(rootGroup);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String expectedOutput = "Root\n main";

        String actualOutput = outputStream.toString().trim();

        assertEquals(expectedOutput, actualOutput);
    }
}