package com.fmatrix;

import java.math.BigDecimal;

public class MultiMatrix {
    
    public static void main(String[] args) throws MatrixOperationException {
        double[][] A = {
            {1, 2, 3, 4}, 
            {5, 6, 7, 8,}, 
            {9, 10, 11, 12}
        };
        double[] X = {13, 14, 15, 16};
        
        long ti = System.nanoTime();
        double[] B = MatrixOperation.multiplicar(A, X);
        long tf = System.nanoTime();
        long ratio = tf-ti;
        
        System.out.println("Multiplicação de Matriz por Vetor orientada pela linha (A x X = B):");
        System.out.println("|1,  2,  3,  4|   |13|   |" + B[0] + "|");
        System.out.println("|5,  6,  7,  8| * |14| = |" + B[1] + "|");
        System.out.println("|9, 10, 11, 12|   |15|   |" + B[2] + "|");
        System.out.println("                  |16|                 ");
        System.out.println("");
        System.out.println("Número de flops: " + 2*4*3);
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
        
        /*B = new int[A.length];
        
        ti = System.nanoTime();
        for(int j = 0; j < 4; j++){
            for(int i = 0; i < 3; i++){
                B[i] += A[i][j]*X[i];
            }
        }
        tf = System.nanoTime();
        ratio = tf-ti;
        
        System.out.println("Multiplicação de Matriz por Vetor orientada pela coluna (A x X = B):");
        System.out.println("|1,  2,  3,  4|   |13|   |" + B[0] + "|");
        System.out.println("|5,  6,  7,  8| * |14| = |" + B[1] + "|");
        System.out.println("|9, 10, 11, 12|   |15|   |" + B[2] + "|");
        System.out.println("                  |16|                 ");
        System.out.println("");
        System.out.println("Número de flops: " + 2*4*3);
        System.out.println("");
        System.out.println("Tempo inicial: " + ti);
        System.out.println("Tempo final: " + tf);
        System.out.println("Intervalo de tempo: " + ratio + " nanosegundos!");
        
        bdRatio = new BigDecimal(ratio);
        bdRatSec = bdRatio.divide(bd10e9);
        System.out.println("                 ou " + bdRatSec.toString() + " segundos!");
        System.out.println("");
        System.out.println("");*/
        
        double[][] Y = {
            {-6, -5, -4},
            {-2, -1, 0},
            {2, 3, 4},
            {2, 3, 5}
        };
        ti = System.nanoTime();
        double[][] C = MatrixOperation.multiplicar(A, Y);
        tf = System.nanoTime();
        ratio = tf-ti;
        
        System.out.println("Multiplicação de Matrizes (A x Y = C):");
        System.out.println("|1,  2,  3,  4|   |-6, -5, -4|   |" + C[0][0] + ", " + C[0][1] + ", " + C[0][2] + "|");
        System.out.println("|5,  6,  7,  8| * |-2, -1,  0| = |" + C[1][0] + ", " + C[1][1] + ", " + C[1][2] + "|");
        System.out.println("|9, 10, 11, 12|   | 2,  3,  4|   |" + C[2][0] + ", " + C[2][1] + ", " + C[2][2] + "|");
        System.out.println("                  | 2,  3,  5|                 ");
        System.out.println("");
        System.out.println("Número de flops: " + 2*3*3*4);
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
