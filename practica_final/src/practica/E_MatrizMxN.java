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
        // 1. Solicitar el tamaño de la matriz
        int filas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de filas (M):"));
        int columnas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de columnas (N):"));

        // 2. Crear la matriz y solicitar los valores al usuario
        matriz = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor para [" + i + "][" + j + "]:"));
            }
        }

        // 3. Mostrar la matriz original
        mostrarMatriz("Matriz Original", matriz);

        // 4. Preguntar qué operación realizar
        String[] opciones = {"Eliminar múltiplos", "Eliminar primos"};
        int eleccion = JOptionPane.showOptionDialog(null, "Seleccione la operación a realizar:",
                "Opciones", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        // Crear una copia de la matriz para modificar
        int[][] matrizModificada = copiarMatriz(matriz);

        if (eleccion == 0) {
            // Opción: eliminar múltiplos de un número ingresado
            int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número para eliminar sus múltiplos:"));
            eliminarMultiplos(matrizModificada, numero);
        } else if (eleccion == 1) {
            // Opción: eliminar números primos
            eliminarPrimos(matrizModificada);
        }

        // 5. Mostrar la matriz modificada
        mostrarMatriz("Matriz Modificada", matrizModificada);
    }

    // Método para mostrar una matriz en un cuadro de diálogo
    private static void mostrarMatriz(String titulo, int[][] matriz) {
        StringBuilder sb = new StringBuilder(titulo + ":\n");
        for (int[] fila : matriz) {
            for (int num : fila) {
                sb.append(num == -1 ? "X" : num).append("\t"); // Reemplaza números eliminados con 'X'
            }
            sb.append("\n");
        }
        JOptionPane.showMessageDialog(null, new JTextArea(sb.toString()));
    }

    // Método para eliminar los múltiplos de un número dado
    private static void eliminarMultiplos(int[][] matriz, int num) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] % num == 0) {
                    matriz[i][j] = -1; // Marcamos los eliminados con -1
                }
            }
        }
    }

    // Método para eliminar los números primos de la matriz
    private static void eliminarPrimos(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (esPrimo(matriz[i][j])) {
                    matriz[i][j] = -1; // Marcamos los eliminados con -1
                }
            }
        }
    }

    // Método para verificar si un número es primo
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

    // Copia una matriz sin modificar la original
    private static int[][] copiarMatriz(int[][] original) {
        int[][] copia = new int[original.length][original[0].length];
        for (int i = 0; i < original.length; i++) {
            System.arraycopy(original[i], 0, copia[i], 0, original[i].length);
        }
        return copia;
    }
}
