package Matrix;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by pearlterminal on 2/3/16.
 */
public class GruntWork {

    /*
        Takes in a list of numbers and converts it into a m x n matrix
     */
    public static double[][] convertToMatrix(ArrayDeque queue, int m, int n) {
        double[][] matrix = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (double) queue.remove();
            }
        }
        return matrix;
    }

    /*
        Written by Robert Sedgewick and Kevin Wayne of Princeton
        Dei Sub Numine Viget
     */
    // return C = A * B
    public static double[][] multiply(double[][] A, double[][] B) {
        int mA = A.length;
        int nA = A[0].length;
        int mB = B.length;
        int nB = B[0].length;
        if (nA != mB) throw new RuntimeException("Illegal matrix dimensions.");
        double[][] C = new double[mA][nB];
        for (int i = 0; i < mA; i++)
            for (int j = 0; j < nB; j++)
                for (int k = 0; k < nA; k++)
                    C[i][j] += A[i][k] * B[k][j];
        return C;
    }
}
