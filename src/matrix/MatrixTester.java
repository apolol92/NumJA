package matrix;

/**
 * Created by apolol92 on 07.08.2015.
 * This class tests the matrix-package
 */
public class MatrixTester {
    /**
     * This method tests the basic functions of the package.. (Matrix creation, Matrix addtion/subtraction..)
     */
    public static void basic_test() {
        Matrix m1 = new Matrix(2,2);
        m1.values[0][0] = 3;
        m1.values[1][0] = 1;
        m1.values[0][1] = 2;
        m1.values[1][1] = 5;
        Matrix m2 = new Matrix(2,2);
        m2.values[0][0] = 2;
        m2.values[1][0] = 6;
        m2.values[0][1] = 3;
        m2.values[1][1] = 1;
        System.out.print("m1-values:\n" + m1+"\n");
        System.out.print("m2-values:\n" + m2+"\n");
        System.out.print("addition m1+m2:\n" + m1.addition(m2) +"\n");
        System.out.print("subtraction m1-m2:\n" + m1.subtraction(m2) +"\n");
        System.out.print("addition m1+m2:\n" + m1.self_addition(m2) +"\n");
        System.out.print("subtraction m1-m2:\n" + m1.self_subtraction(m2) +"\n");
        Matrix A = new Matrix(3,3);
        A.values[0][0] = 3;
        A.values[0][1] = 6;
        A.values[0][2] = 0;
        A.values[1][0] = 1;
        A.values[1][1] = 7;
        A.values[1][2] = 5;
        A.values[2][0] = 2;
        A.values[2][1] = 4;
        A.values[2][2] = -8;
        Matrix b = new Matrix(3,1);
        b.values[0][0] = 6;
        b.values[1][0] = 17;
        b.values[2][0] = -12;
        System.out.println(A);
        System.out.println(b);
        System.out.println(JacobiIterator.iterate(A, b,100));
    }
}
