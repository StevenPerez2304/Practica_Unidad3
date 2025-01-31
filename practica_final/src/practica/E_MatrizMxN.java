/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica;

import javax.swing.*;

/**
 *
 * @author steve
 */
public class E_MatrizMxN {

    private static int[][] matriz;

    public static void main(String[] args) {
  
        int filas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de filas (M):"));
        int columnas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de columnas (N):"));

        
        matriz = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor para [" + i + "][" + j + "]:"));
            }
        }

    
        mostrarMatriz("Matriz Original", matriz);

    
        String[] opciones = {"Eliminar múltiplos", "Eliminar primos"};
        int eleccion = JOptionPane.showOptionDialog(null, "Seleccione la operación a realizar:",
                "Opciones", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        int[][] matrizModificada = copiarMatriz(matriz);

        if (eleccion == 0) {
            int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número para eliminar sus múltiplos:"));
            eliminarMultiplos(matrizModificada, numero);
        } else if (eleccion == 1) {
            eliminarPrimos(matrizModificada);
        }


        mostrarMatriz("Matriz Modificada", matrizModificada);
    }

    private static void mostrarMatriz(String titulo, int[][] matriz) {
        StringBuilder sb = new StringBuilder(titulo + ":\n");
        for (int[] fila : matriz) {
            for (int num : fila) {
                sb.append(num == -1 ? "X" : num).append("\t"); 
            }
            sb.append("\n");
        }
        JOptionPane.showMessageDialog(null, new JTextArea(sb.toString()));
    }


    private static void eliminarMultiplos(int[][] matriz, int num) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] % num == 0) {
                    matriz[i][j] = -1; 
                }
            }
        }
    }


    private static void eliminarPrimos(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (esPrimo(matriz[i][j])) {
                    matriz[i][j] = -1; 
                }
            }
        }
    }

  
    private static boolean esPrimo(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int[][] copiarMatriz(int[][] original) {
        int[][] copia = new int[original.length][original[0].length];
        for (int i = 0; i < original.length; i++) {
            System.arraycopy(original[i], 0, copia[i], 0, original[i].length);
        }
        return copia;
    }
}
