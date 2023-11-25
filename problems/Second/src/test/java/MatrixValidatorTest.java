import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MatrixValidatorTest {
    private static final MatrixValidator validator = new MatrixValidator();

    @Test
    public void isThreeDiagonal() {
        List<Double> validA = new ArrayList<>(Arrays.asList(1.0, 3.0, 1.0, 1.0));
        List<Double> validC = new ArrayList<>(Arrays.asList(2.0, 2.0, 4.0, 2.0, 3.0));
        List<Double> validB = new ArrayList<>(Arrays.asList(1.0, 1.0, 1.0, 1.0));
        List<Double> validF = new ArrayList<>(Arrays.asList(1.0, 2.0, 1.0, 1.0, 1.0));

        ThreeDiagonalMatrix validMatrix = new ThreeDiagonalMatrix(validA, validC, validB, validF);

        assertTrue(validator.isThreeDiagonal(validMatrix));

        List<Double> notValidB = new ArrayList<>(Arrays.asList(10.0, 10.0, 10.0, 10.0));

        ThreeDiagonalMatrix notValidMatrix = new ThreeDiagonalMatrix(validA, validC, notValidB, validF);

        assertFalse(validator.isThreeDiagonal(notValidMatrix));
    }
}