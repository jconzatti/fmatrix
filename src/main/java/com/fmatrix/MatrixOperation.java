package com.fmatrix;

public class MatrixOperation {
    
    public static double determinante(double[][] A){
        return 0;
    }
    
    public static double[][] transposta(double[][] A){
        double[][] B = new double[A[0].length][A.length];
        for(int i = 0; i < A.length; i++)
            for(int j = 0; j < A[i].length; j++)
                B[i][j] = A[j][i];
        return B;
    }
    
    public static boolean comparar(double[][] A, double[][] B){
        if(A.length != B.length){
            return false;
        }else{
            for(int i = 0; i < A.length; i++){
                if(A[i].length != B[i].length){
                    return false;
                }else{
                    for(int j = 0; j < A[i].length; j++)
                        if(A[i][j] != B[i][j])
                            return false;
                }
            }
        }
        return true;
    }
    
    public static boolean isSimetrica(double[][] A){
        double[][] At = transposta(A);
        return comparar(A, At);
    }
    
    public static double[][] somar(double[][] A, double[][] B) throws MatrixOperationException{
        if((A.length != B.length)
                ||(A[0].length != B[0].length))
            throw new MatrixOperationException("Soma de matrizes impossível! A ordem da matriz A deve ser igual a ordem da matriz B!");
        
        double[][] C = new double[A.length][A[0].length];
        for(int i = 0; i < C.length; i++){
            for(int j = 0; j < C[i].length; j++)
                    C[i][j] = A[i][j] + B[i][j];
        }
        return C;
    }
    
    public static double[][] multiplicar(double a, double[][] A){
        for(int i = 0; i < A.length; i++)
            for(int j = 0; j < A[i].length; j++)
                A[i][j] = a*A[i][j];
        return A;
    }
    
    public static double[] multiplicar(double[][] A, double[] B) throws MatrixOperationException{
        if(A[0].length != B.length)
            throw new MatrixOperationException("Multiplicação de matriz por vetor impossível! O número de colunas da matriz A deve ser igual ao número de elementos do vetor B!");
        
        double[] C = new double[B.length];
        for(int i = 0; i < A.length; i++)
            for(int j = 0; j < B.length; j++)
                C[i] = C[i] + (A[i][j] * B[j]);
        return C;
    }
    
    public static double[][] multiplicar(double[][] A, double[][] B) throws MatrixOperationException{
        if(A[0].length != B.length)
            throw new MatrixOperationException("Multiplicação de matrizes impossível! O número de colunas da matriz A deve ser igual ao número de linhas da matriz B!");
        
        double[][] C = new double[A.length][];
        for(int i = 0; i < A.length; i++){
            C[i] = new double[B[i].length];
            for(int j = 0; j < B[i].length; j++)
                for(int k = 0; k < B.length; k++)
                    C[i][j] = C[i][j] + (A[i][k] * B[k][j]);
        }
        return C;
    }
    
    public static double[] resolverSistemaTriangularInferior(double[][]A, double[]b, MatrixOperationTriangularSystemForm form) throws MatrixOperationException{
        int k = 0;
        for(; k < b.length; k++){
            if(A[k][k] == 0)
                throw new MatrixOperationException("A matriz não é inversível!");
            
            if(b[k] != 0)
                break;
        }
        
        switch(form){
            case ROW_ORIENTED:
                for(int i = k; i < b.length; i++){
                    if(A[i][i] == 0)
                        throw new MatrixOperationException("A matriz não é inversível!");
                    
                    for(int j = k; j < i; j++)
                        b[i] = b[i] - (A[i][j] * b[j]);
                    b[i] = b[i]/A[i][i];
                }
                break;
            case COLUMN_ORIENTED:
                for(int j = k; j < b.length; j++){
                    if(A[j][j] == 0)
                        throw new MatrixOperationException("A matriz não é inversível!");
                    
                    b[j] = b[j]/A[j][j];
                    for(int i = j+1; i < b.length; i++)
                        b[i] = b[i] - (A[i][j] * b[j]);
                }
                break;
        }
        return b;
    }
    
    public static double[] resolverSistemaTriangularSuperior(double[][]A, double[]b, MatrixOperationTriangularSystemForm form) throws MatrixOperationException{
        int k = 0;
        for(; k < b.length; k++){
            if(A[k][k] == 0)
                throw new MatrixOperationException("A matriz não é inversível!");
            
            if(b[k] != 0)
                break;
        }
        
        switch(form){
            case ROW_ORIENTED:
                for(int i = b.length - 1; i >= k; i--){
                    if(A[i][i] == 0)
                        throw new MatrixOperationException("A matriz não é inversível!");
                    
                    for(int j = b.length - 1; j > i; j--)
                        b[i] = b[i] - (A[i][j] * b[j]);
                    b[i] = b[i]/A[i][i];
                }
                break;
            case COLUMN_ORIENTED:
                for(int j = b.length - 1; j >= k; j--){
                    if(A[j][j] == 0)
                        throw new MatrixOperationException("A matriz não é inversível!");
                    
                    b[j] = b[j]/A[j][j];
                    for(int i = j-1; i >= 0; i--)
                        b[i] = b[i] - (A[i][j] * b[j]);
                }
                break;
        }
        return b;
    }
    
    public static double[][] fatorarCholesky(double[][] A){
        for(int i = 0; i < A.length; i++){
            for(int k = 0; k < 1; k++)
                A[i][i] = A[i][i] - (A[k][i]*A[k][i]);
        }
        return A;
    }
    
    public static double[][] fatorarGaussLU(double[][] A){
        return A;
    }
    
    public static double[][] fatorarGaussPivo(double[][] A){
        return A;
    }
    
}
