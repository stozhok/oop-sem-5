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

        // Simulate waiting for a while (adjust this time if needed)
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Replace this with the expected output
        String expectedOutput = "Root\n main"; // Адаптированный ожидаемый вывод

        // Trim the actual and expected output for comparison
        String actualOutput = outputStream.toString().trim();

        // Check if the actual output equals the expected output
        assertEquals(expectedOutput, actualOutput);
    }
}