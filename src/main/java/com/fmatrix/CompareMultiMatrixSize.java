package com.fmatrix;

import java.math.BigDecimal;

public class CompareMultiMatrixSize {
    
    public static void main(String[] args) {
        int n = 200;
        for(int k = 0; k < 4; k++){
            long[][] A = new long[n][n];
            long[] X = new long[n];
            long[] B = new long[n];
            
            for(int i = 0; i < n; i++){
                X[i] = Math.round(Math.random());
                for(int j = 0; j < n; j++){
                    A[i][j] = Math.round(Math.random());
                }
            }
            
            long ti = System.nanoTime();
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    B[i] += A[i][j]*X[i];
                }
            }
            long tf = System.nanoTime();
            long ratio = tf-ti;
        
            System.out.println("Multiplicação de Matrizes orientada pela linha (A x X = B):");
            System.out.println("n = " + n);
            System.out.print("B = {");
            for(int i = 0; i < n; i++)
                System.out.print(B[i] + ", ");
            System.out.print("}");
            System.out.println("");
            System.out.println("Número de flops: " + 2*n*n);
            System.out.println("Tempo inicial: " + ti);
            System.out.println("Tempo final: " + tf);
            System.out.println("Intervalo de tempo: " + ratio + " nanosegundos!");

            BigDecimal bdRatio = new BigDecimal(ratio);
            BigDecimal bd10e9 = new BigDecimal("1000000000");
            BigDecimal bdRatSec = bdRatio.divide(bd10e9);
            System.out.println("                 ou " + bdRatSec.toString() + " segundos!");
            System.out.println("--------------------------------------------------------");
            System.out.println("");
            
            n *= 2;
        }
    }
}
