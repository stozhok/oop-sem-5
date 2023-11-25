import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MatrixValidator matrixValidator = new MatrixValidator();
        ThreeDiagonalMatrix threeDiagonalMatrix = new ThreeDiagonalMatrix(new File("/Users/sashastozhok/Desktop/java/oop-sem-5/problems/Second/src/main/resources/matrix.txt"));
        Solver solver = new Solver(matrixValidator);
        List<Double> res = solver.solve(threeDiagonalMatrix);
        if (res != null) {
            System.out.println(res);
        }
    }
}