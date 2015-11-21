package test_code.matrix_tests;

import main_code.matrix.Matrix;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by apolol92 on 21.11.2015.
 */
public class MatrixOperationsTest {

    @Test
    public void testAdditionGivenAnotherMatrixExpectSumMatrix() {
        Matrix A = new Matrix(1, 2);
        A.values[0][0] = 1;
        A.values[0][1] = 1;
        Matrix B = new Matrix(1, 2);
        B.values[0][0] = 1;
        B.values[0][1] = 1;
        Matrix SumMatrix = new Matrix(1, 2);
        SumMatrix.values[0][0] = 2;
        SumMatrix.values[0][1] = 2;
        Matrix SumAB = new Matrix(1, 2);
        SumAB = A.addition(B);
        Assert.assertArrayEquals(SumMatrix.copyValues(), SumAB.copyValues());
    }

    @Test
    public void testSelfAdditionGivenAnotherMatrixExpectSumMatrix() {
        Matrix A = new Matrix(1, 2);
        A.values[0][0] = 1;
        A.values[0][1] = 1;
        Matrix B = new Matrix(1, 2);
        B.values[0][0] = 1;
        B.values[0][1] = 1;
        Matrix SumMatrix = new Matrix(1, 2);
        SumMatrix.values[0][0] = 2;
        SumMatrix.values[0][1] = 2;
        A.self_addition(B);
        Assert.assertArrayEquals(SumMatrix.copyValues(),A.copyValues());
    }

    @Test
    public void testSubtractionGivenAnotherMatrixExpectDifferenceMatrix() {
        Matrix A = new Matrix(1, 2);
        A.values[0][0] = 1;
        A.values[0][1] = 1;
        Matrix B = new Matrix(1, 2);
        B.values[0][0] = 1;
        B.values[0][1] = 1;
        Matrix DifferenceMatrix = new Matrix(1, 2);
        DifferenceMatrix.values[0][0] = 0;
        DifferenceMatrix.values[0][1] = 0;
        Matrix DifferenceAB = new Matrix(1, 2);
        DifferenceAB = A.subtraction(B);
        Assert.assertArrayEquals(DifferenceMatrix.copyValues(), DifferenceAB.copyValues());
    }

    @Test
    public void testSelfSubtractionGivenAnotherMatrixExpectDifferenceMatrix() {
        Matrix A = new Matrix(1, 2);
        A.values[0][0] = 1;
        A.values[0][1] = 1;
        Matrix B = new Matrix(1, 2);
        B.values[0][0] = 1;
        B.values[0][1] = 1;
        Matrix DifferenceMatrix = new Matrix(1, 2);
        DifferenceMatrix.values[0][0] = 0;
        DifferenceMatrix.values[0][1] = 0;
        A.self_subtraction(B);
        Assert.assertArrayEquals(DifferenceMatrix.copyValues(), A.copyValues());
    }

    @Test
    public void test2x1Multiply1x2ExpectProductMatrix() {
        Matrix A = new Matrix("1,2;");
        Matrix B = new Matrix("3;4;");
        Matrix Result = new Matrix("11;");
        Assert.assertArrayEquals(Result.copyValues(),A.multiply(B).copyValues());
    }

    @Test
    public void test2x2Multiply2x2ExpectProductMatrix() {
        Matrix A = new Matrix("1,2;2,5;");
        Matrix B = new Matrix("3,4;2,1;");
        Matrix Result = new Matrix("7,6;16,13;");
        Assert.assertArrayEquals(Result.copyValues(),A.multiply(B).copyValues());
    }

    @Test(expected = Exception.class)
    public void test2x2Multiply3x2ExpectErrorWrongDimension() {
        Matrix A = new Matrix("1,2;2,5;");
        Matrix B = new Matrix("3,4;2,1;4,6;");
        Matrix Result = new Matrix("7,6;16,13;");
        Assert.assertArrayEquals(Result.copyValues(),A.multiply(B).copyValues());
    }

}
