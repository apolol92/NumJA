package matrix;

/**
 * Created by apolol92 on 08.08.2015.
 * This class invertes matrices.
 */
public class Inverter {

    /**
     * This method do the main job.. it invertes matrices
     * @param A is the matrix
     * @return the inverted matrix
     */
    public static Matrix inverte(Matrix A) {
        Matrix identityMatrix = A.getIdentityMatrix();
        Matrix inverse = new Matrix(1,1);
        for(int identityColumn = 0; identityColumn < identityMatrix.COLS; identityColumn++) {
            Matrix eVec = identityMatrix.getColumnVector(identityColumn);
            if(A.diagonallyDominant()!=2) {
                //Till now, we have got only the JacobiIterator to calculate a linear system of equations
                return null;
            }
            Matrix xn = JacobiIterator.iterate(A,eVec,100); //A*xn = eVec
            System.out.println(A);
            System.out.println(eVec);
            System.out.println(xn);
            switch (identityColumn) {
                case 0:
                    inverse = xn;
                    break;
                default:
                    inverse = inverse.concatHorizontal(xn);
                    break;
            }
        }
        return inverse;
    }
}
