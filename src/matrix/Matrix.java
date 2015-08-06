package matrix;

import java.util.Arrays;

/**
 * Created by apolol92 on 07.08.2015.
 * This class is the basic structure of the library.
 * It is a mathematical matrix.
 * It should contain all matrix operations..
 */
public class Matrix {
    /**
     * This 2d-array contains all matrix-elements
     */
    public double[][] values;
    /**
     * This to constants show us the dimension of the matrix
     */
    public final int ROWS, COLS;

    /**
     * This constructor creates a matrix
     * @param rows, amount of rows
     * @param cols, amount of cols
     */
    public Matrix(int rows, int cols) {
        this.ROWS = rows;
        this.COLS = cols;
        this.values = new double[this.ROWS][this.COLS];
    }

    /**
     * This method returns a print of the matrix
     * @return nice matrix print
     */
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("");
        for(int r = 0; r < this.ROWS; r++) {
            for(int c = 0; c < this.COLS; c++) {
                if(c==this.COLS-1) {
                    output.append(this.values[r][c]+"\n");
                }
                else {
                    output.append(this.values[r][c]+" ");
                }
            }
        }
        return output.toString();
    }

    /**
     * This method creates a copy of the current matrix
     * @return the copy
     */
    public Matrix copy() {
        Matrix copy = new Matrix(this.ROWS,this.COLS);
        for(int r = 0; r < this.ROWS; r++) {
            copy.values[r] = this.values[r].clone();
        }
        return copy;
    }

    /**
     * This method add the matrix elements on the own matrix elements.
     * In other words, this method make an addition and same the result in its own values.
     * @param matrix
     * @return a reference on itself
     */
    public Matrix self_addition(Matrix matrix) {
        try {
            checkSameMatrixDimension(this,matrix);
            for(int r = 0; r < this.ROWS; r++) {
                for(int c = 0; c < this.COLS; c++) {
                    this.values[r][c] += matrix.values[r][c];
                }
            }
        }
        catch(Exception ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        return this;
    }

    /**
     * This method make an addition and save the result in a extra matrix.
     * @param matrix, summand
     * @return result
     */
    public Matrix addition(Matrix matrix) {
        Matrix result = null;
        try {
            checkSameMatrixDimension(this,matrix);
            result = new Matrix(this.ROWS,this.COLS);
            for(int r = 0; r < this.ROWS; r++) {
                for(int c = 0; c < this.COLS; c++) {
                    result.values[r][c] = this.values[r][c] + matrix.values[r][c];
                }
            }
        }
        catch(Exception ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        return result;
    }

    /**
     * This method make a subtraction and save the result in its own values.
     * @param matrix, operand
     * @return result
     */
    public Matrix self_subtraction(Matrix matrix) {
        try {
            checkSameMatrixDimension(this,matrix);
            for(int r = 0; r < this.ROWS; r++) {
                for(int c = 0; c < this.COLS; c++) {
                    this.values[r][c] -= matrix.values[r][c];
                }
            }
        }
        catch(Exception ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        return this;
    }
    /**
     * This method make a subtraction and save the result in a extra matrix.
     * @param matrix, operand
     * @return result
     */
    public Matrix subtraction(Matrix matrix) {
        Matrix result = null;
        try {
            checkSameMatrixDimension(this,matrix);
            result = new Matrix(this.ROWS,this.COLS);
            for(int r = 0; r < this.ROWS; r++) {
                for(int c = 0; c < this.COLS; c++) {
                    result.values[r][c] = this.values[r][c] - matrix.values[r][c];
                }
            }
        }
        catch(Exception ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        return result;
    }

    /**
     * This method checks the dimension of m1 and m2.
     * It throws a Exception, if their dimension(m1 and m2) aren't equal.
     * @param m1, Matrix1
     * @param m2, Matrix2
     * @throws Exception dimensions aren't equal..
     */
    private void checkSameMatrixDimension(Matrix m1, Matrix m2) throws Exception{
        if(m1.ROWS != m2.ROWS || m1.COLS != m2.COLS) {
            throw new Exception("matrices haven't got the same dimension..");
        }
    }
}
