package com.fmatrix;

public class MatrixTest {
    
    private static void fatorarCholeskyTest() throws MatrixOperationException{
        double[][] A = {
            {4,-2,4,2}, 
            {-2,10,-2,-7}, 
            {4,-2,8,4},
            {2,-7,4,7}
        };
        double[] b = {8,2,16,6};
        
        System.out.println("Fatoração de Cholesky:");
        System.out.println("Seja A = ");
        for(int i = 0; i < A.length; i++){
            System.out.print("| ");
            for(int j = 0; j < A[i].length; j++){
                System.out.print(A[i][j] + "  ");
            }
            System.out.println("|");
        }
        System.out.print("Seja b = [");
        for(int i = 0; i < b.length; i++)
            System.out.print(b[i] + "  ");
        System.out.println("]");
        
        MatrixOperation.fatorarCholesky(A, MatrixOperationCholeskyForm.OUTER_PRODUCT);
        
        System.out.println("Então R = ");
        for(int i = 0; i < A.length; i++){
            System.out.print("| ");
            for(int j = 0; j < A[i].length; j++){
                if(j < i)
                    System.out.print("0.0  ");
                else    
                    System.out.print(A[i][j] + "  ");
            }
            System.out.println("|");
        }
        
        double[][] Rt = MatrixOperation.transposta(A);
        
        MatrixOperation.resolverSistemaTriangularInferior(Rt, b, MatrixOperationTriangularSystemForm.ROW_ORIENTED);
        
        System.out.println("R(t)y = b:");
        System.out.print("y = [ ");
        for(int i = 0; i < b.length; i++)
            System.out.print(b[i] + "  ");
        System.out.println("]");
        
        MatrixOperation.resolverSistemaTriangularSuperior(A, b, MatrixOperationTriangularSystemForm.ROW_ORIENTED);
        
        System.out.println("Rx = y:");
        System.out.print("x = [ ");
        for(int i = 0; i < b.length; i++)
            System.out.print(b[i] + "  ");
        System.out.println("]");
        
    }
    
    private static void resolverSistemaGaussSemPivoTest() throws MatrixOperationException{
        double[][] A = {
            {2,1,-1,3}, 
            {-2,0,0,0}, 
            {4,1,-2,6},
            {-6,-1,2,-3}
        };
        double[] b = {13,-2,24,-14};
        
        System.out.println("Resolvendo sistema com eliminação Gaussiana sem pivô:");
        System.out.println("Seja A = ");
        for(int i = 0; i < A.length; i++){
            System.out.print("| ");
            for(int j = 0; j < A[i].length; j++){
                System.out.print(A[i][j] + "  ");
            }
            System.out.println("|");
        }
        System.out.print("Seja b = [");
        for(int i = 0; i < b.length; i++)
            System.out.print(b[i] + "  ");
        System.out.println("]");
        
        MatrixOperation.resolverSistemaGaussLU(A, b);
        
        System.out.println("Então Â = ");
        for(int i = 0; i < A.length; i++){
            System.out.print("| ");
            for(int j = 0; j < A[i].length; j++){
                System.out.print(A[i][j] + "  ");
            }
            System.out.println("|");
        }
        
        System.out.println("Ax = b:");
        System.out.print("x = [ ");
        for(int i = 0; i < b.length; i++)
            System.out.print(b[i] + "  ");
        System.out.println("]");
        
    }
    
    public static void main(String[] args) throws MatrixOperationException {
        resolverSistemaGaussSemPivoTest();
    }
}
