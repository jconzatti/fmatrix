package com.fmatrix;

import java.math.BigDecimal;

public class MatrixTest {
    
    public static void main(String[] args) throws MatrixOperationException {
        double[][] A = {
            {3, -1,  0, 2}, 
            {0,  4, -1, 9}, 
            {0,  0,  4, 5}, 
            {0,  0,  0, 9}
        };
        double[] x = {1, 2, 3, 4};
        
        System.out.println("Multiplicação da Matriz A por Vetor x (Ax = b):");
        System.out.println("Seja A = ");
        for(int i = 0; i < A.length; i++){
            System.out.print("| ");
            for(int j = 0; j < A[i].length; j++){
                System.out.print(A[i][j] + "  ");
            }
            System.out.println("|");
        }
        System.out.print("Seja x = [");
        for(int i = 0; i < x.length; i++)
            System.out.print(x[i] + "  ");
        System.out.println("]");
        
        long ti = System.nanoTime();
        double[] b = MatrixOperation.multiplicar(A, x);
        long tf = System.nanoTime();
        long ratio = tf-ti;
        
        System.out.print("Então b = [ ");
        for(int i = 0; i < b.length; i++)
            System.out.print(b[i] + "  ");
        System.out.println("]");
        
        System.out.println("");
        System.out.println("Número de flops: " + 2*A.length*x.length);
        System.out.println("");
        System.out.println("Tempo inicial: " + ti);
        System.out.println("Tempo final: " + tf);
        System.out.println("Intervalo de tempo: " + ratio + " nanosegundos!");
        
        BigDecimal bdRatio = new BigDecimal(ratio);
        BigDecimal bd10e9 = new BigDecimal("1000000000");
        BigDecimal bdRatSec = bdRatio.divide(bd10e9);
        System.out.println("                 ou " + bdRatSec.toString() + " segundos!");
        System.out.println("");
        System.out.println("");
        
        ti = System.nanoTime();
        double[] y = MatrixOperation.resolverSistemaTriangularSuperior(A, b, MatrixOperationTriangularSystemForm.COLUMN_ORIENTED);
        tf = System.nanoTime();
        ratio = tf-ti;
        
        System.out.println("Ay = b:");
        System.out.print("y = [ ");
        for(int i = 0; i < y.length; i++)
            System.out.print(y[i] + "  ");
        System.out.println("]");
        System.out.println("");
        System.out.println("Tempo inicial: " + ti);
        System.out.println("Tempo final: " + tf);
        System.out.println("Intervalo de tempo: " + ratio + " nanosegundos!");
        
        bdRatio = new BigDecimal(ratio);
        bd10e9 = new BigDecimal("1000000000");
        bdRatSec = bdRatio.divide(bd10e9);
        System.out.println("                 ou " + bdRatSec.toString() + " segundos!");
        System.out.println("");
        System.out.println("");
        
        double[][] B = {
            {-6, -5, -4},
            {-2, -1, 0},
            {2, 3, 4},
            {2, 3, 5}
        };
        ti = System.nanoTime();
        double[][] C = MatrixOperation.multiplicar(A, B);
        tf = System.nanoTime();
        ratio = tf-ti;
        
        System.out.println("Multiplicação de Matrizes:");
        System.out.println("Seja A = ");
        for(int i = 0; i < A.length; i++){
            System.out.print("| ");
            for(int j = 0; j < A[i].length; j++){
                System.out.print(A[i][j] + "  ");
            }
            System.out.println("|");
        }
        System.out.println("Seja B = ");
        for(int i = 0; i < B.length; i++){
            System.out.print("| ");
            for(int j = 0; j < B[i].length; j++){
                System.out.print(B[i][j] + "  ");
            }
            System.out.println("|");
        }
        System.out.println("Então AB = ");
        for(int i = 0; i < C.length; i++){
            System.out.print("| ");
            for(int j = 0; j < C[i].length; j++){
                System.out.print(C[i][j] + "  ");
            }
            System.out.println("|");
        }
        System.out.println("");
        System.out.println("Número de flops: " + 2*A.length*B.length*C.length);
        System.out.println("");
        System.out.println("Tempo inicial: " + ti);
        System.out.println("Tempo final: " + tf);
        System.out.println("Intervalo de tempo: " + ratio + " nanosegundos!");
        
        bdRatio = new BigDecimal(ratio);
        bdRatSec = bdRatio.divide(bd10e9);
        System.out.println("                 ou " + bdRatSec.toString() + " segundos!");
        System.out.println("");
        System.out.println("");
    }
}
