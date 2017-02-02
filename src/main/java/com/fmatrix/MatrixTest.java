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
    
    private static void fatorarGaussLUTest() throws MatrixOperationException{
        double[][] A = {
            {2,1,1}, 
            {2,2,-1}, 
            {4,-1,6}
        };
        
        System.out.println("Resolvendo sistema com eliminação Gaussiana sem pivô (fatoração em LU):");
        System.out.println("Seja A = ");
        for(int i = 0; i < A.length; i++){
            System.out.print("| ");
            for(int j = 0; j < A[i].length; j++){
                System.out.print(A[i][j] + "  ");
            }
            System.out.println("|");
        }
        
        MatrixOperation.fatorarGaussLU(A, MatrixOperationGaussLUForm.ROW_ORIENTED);
        
        System.out.println("Então LU = ");
        for(int i = 0; i < A.length; i++){
            System.out.print("| ");
            for(int j = 0; j < A[i].length; j++){
                System.out.print(A[i][j] + "  ");
            }
            System.out.println("|");
        }
        
        double[] b = {9,9,16};
        
        System.out.print("Seja b = [");
        for(int i = 0; i < b.length; i++)
            System.out.print(b[i] + "  ");
        System.out.println("]");
        
        MatrixOperation.obterGaussLy(A, b);
        
        System.out.println("Ly = b:");
        System.out.print("y = [ ");
        for(int i = 0; i < b.length; i++)
            System.out.print(b[i] + "  ");
        System.out.println("]");
        
        MatrixOperation.resolverSistemaTriangularSuperior(A, b, MatrixOperationTriangularSystemForm.ROW_ORIENTED);
        
        System.out.println("Ux = y:");
        System.out.print("x = [ ");
        for(int i = 0; i < b.length; i++)
            System.out.print(b[i] + "  ");
        System.out.println("]");
        
        double[] c = {3,0,11};
        
        System.out.print("Seja c = [");
        for(int i = 0; i < c.length; i++)
            System.out.print(c[i] + "  ");
        System.out.println("]");
        
        MatrixOperation.obterGaussLy(A, c);
        
        System.out.println("Ly = c:");
        System.out.print("y = [ ");
        for(int i = 0; i < c.length; i++)
            System.out.print(c[i] + "  ");
        System.out.println("]");
        
        MatrixOperation.resolverSistemaTriangularSuperior(A, c, MatrixOperationTriangularSystemForm.ROW_ORIENTED);
        
        System.out.println("Ux = y:");
        System.out.print("x = [ ");
        for(int i = 0; i < c.length; i++)
            System.out.print(c[i] + "  ");
        System.out.println("]");
        
    }
    
    private static void fatorarGaussPivoTest() throws MatrixOperationException{
        double[][] A = {
            {2,10,8,8,6}, 
            {1,4,-2,4,-1}, 
            {0,2,3,2,1},
            {3,8,3,10,9},
            {1,4,1,2,1}
        };
        
        System.out.println("Resolvendo sistema com eliminação Gaussiana com pivô:");
        System.out.println("Seja A = ");
        for(int i = 0; i < A.length; i++){
            System.out.print("| ");
            for(int j = 0; j < A[i].length; j++){
                System.out.print(A[i][j] + "  ");
            }
            System.out.println("|");
        }
        
        int[] p = MatrixOperation.fatorarGaussPivo(A);
        
        System.out.println("Então LU = ");
        for(int i = 0; i < A.length; i++){
            System.out.print("| ");
            for(int j = 0; j < A[i].length; j++){
                System.out.print(A[i][j] + "  ");
            }
            System.out.println("|");
        }
        
        System.out.print("p = [");
        for(int i = 0; i < p.length; i++)
            System.out.print(p[i] + "  ");
        System.out.println("]");
        
        double[] b = {52,14,12,51,15};
        
        System.out.print("Seja b = [");
        for(int i = 0; i < b.length; i++)
            System.out.print(b[i] + "  ");
        System.out.println("]");
        
        MatrixOperation.reordenarGaussb(p, b);
        
        System.out.print("b (reordenado) = [");
        for(int i = 0; i < b.length; i++)
            System.out.print(b[i] + "  ");
        System.out.println("]");
        
        MatrixOperation.obterGaussLy(A, b);
        
        System.out.println("Ly = b:");
        System.out.print("y = [ ");
        for(int i = 0; i < b.length; i++)
            System.out.print(b[i] + "  ");
        System.out.println("]");
        
        MatrixOperation.resolverSistemaTriangularSuperior(A, b, MatrixOperationTriangularSystemForm.ROW_ORIENTED);
        
        System.out.println("Ux = y:");
        System.out.print("x = [ ");
        for(int i = 0; i < b.length; i++)
            System.out.print(b[i] + "  ");
        System.out.println("]");
        
        double[] c = {50,4,12,48,12};
        
        System.out.print("Seja c = [");
        for(int i = 0; i < c.length; i++)
            System.out.print(c[i] + "  ");
        System.out.println("]");
        
        MatrixOperation.reordenarGaussb(p, c);
        
        System.out.print("c (reordenado) = [");
        for(int i = 0; i < c.length; i++)
            System.out.print(c[i] + "  ");
        System.out.println("]");
        
        MatrixOperation.obterGaussLy(A, c);
        
        System.out.println("Ly = c:");
        System.out.print("y = [ ");
        for(int i = 0; i < c.length; i++)
            System.out.print(c[i] + "  ");
        System.out.println("]");
        
        MatrixOperation.resolverSistemaTriangularSuperior(A, c, MatrixOperationTriangularSystemForm.ROW_ORIENTED);
        
        System.out.println("Ux = y:");
        System.out.print("x = [ ");
        for(int i = 0; i < c.length; i++)
            System.out.print(c[i] + "  ");
        System.out.println("]");
        
    }
    
    public static void main(String[] args) throws MatrixOperationException {
        //fatorarCholeskyTest();
        //System.out.println("----------------------------------------------------");
        //System.out.println();
        fatorarGaussLUTest();
        System.out.println("----------------------------------------------------");
        System.out.println();
        //fatorarGaussPivoTest();
        //System.out.println("----------------------------------------------------");
        //System.out.println();
        
        /*for(int n = 1; n < 100; n++){
            int q = 0;
            for(int i = 0; i < n; i++){
                for(int k = 0; k < i; k++)
                    q += 2;
                q += 1;
                for(int j = i+1; j < n; j++){
                    for(int k = 0; k < i; k++)
                        q += 2;
                    q += 1;
                }
            }
            //System.out.println(n + " = " + q + " aprox. " + (((3*n*n)-n)/2));
            System.out.println(n + " = " + q + " aprox. " + (((2*n*n*n) + (3*n*n) + n)/6));
        }*/
    }
}
