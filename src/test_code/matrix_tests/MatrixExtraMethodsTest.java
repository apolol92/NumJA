package test_code.matrix_tests;

import main_code.matrix.Matrix;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by apolol92 on 21.11.2015.
 */
public class MatrixExtraMethodsTest {
    Matrix M1_2x2 = new Matrix("1,2;3,4;");
    Matrix M1_3x3 = new Matrix("1,2,3;4,5,6;7,8,9;");

    @Test
    public void test2x2MatrixConstructorGivenCsvString() {
        Matrix A = new Matrix(2,2);
        A.values[0][0] = 1;
        A.values[0][1] = 2;
        A.values[1][0] = 3;
        A.values[1][1] = 4;
        Matrix B = new Matrix("1,2;3,4;");
        Assert.assertArrayEquals(A.copyValues(),B.copyValues());
    }

    @Test
    public void test3x3MatrixConstructorGivenCsvString() {
        Matrix A = new Matrix(3,3);
        A.values[0][0] = 1;
        A.values[0][1] = 2;
        A.values[0][2] = 3;
        A.values[1][0] = 4;
        A.values[1][1] = 5;
        A.values[1][2] = 6;
        A.values[2][0] = 7;
        A.values[2][1] = 8;
        A.values[2][2] = 9;

        Matrix B = new Matrix("1,2,3;4,5,6;7,8,9;");
        Assert.assertArrayEquals(A.copyValues(), B.copyValues());
    }

    @Test
    public void testMatrixToString() {
        System.out.print(M1_2x2.toString());
        String matrix_str = "1.0 2.0\n3.0 4.0\n";
        Assert.assertEquals(matrix_str, M1_2x2.toString());
    }

    @Test
    public void testCopyValues() {
        Matrix A = new Matrix(1,2);
        A.values[0][0]=23;
        A.values[0][1]=20;
        Assert.assertArrayEquals(A.values, A.copyValues());
    }
}
