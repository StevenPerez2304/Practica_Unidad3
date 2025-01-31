/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica;

import java.util.Random;
import javax.swing.JComboBox;

/**
 *
 * @author USER
 */
public class utilidades_practica {

    public static boolean validar(String num) {
        boolean band = true;
        if (num.charAt(0) == '-') {
            num = num.substring(1);
        }

        int cont_p = 0;
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            if (!Character.isDigit(c) && c != '.') {
                band = false;
                break;
            }
            if (c == '.') {
                cont_p++;
            }
        }

        if (cont_p > 1) {
            band = false;
        }

        return band;
    }

    public static int transformStringInt(String num) {
        int resp = 0;
        if (validar(num)) {
            resp = Integer.parseInt(num);
        }
        return resp;
    }

    public static float transformStringFloat(String num) {
        float resp = 0.0f;
        if (validar(num)) {
            resp = Float.parseFloat(num);
        }
        return resp;
    }

    public static int genearaNumeroRango(int minimo, int maximo) {
        Random random = new Random();
        //2 - 10
        //   2 + 11 -2 
        return minimo + random.nextInt((maximo + 1) - minimo);
    }

    public static float genearaNumeroRangoFloat(float minimo, float maximo) {
        Random random = new Random();
        //2 - 10
        //2 + 11 - 2 ------2 + (9)
        return minimo + random.nextFloat() * (maximo - minimo);
    }

    public static float redondear(float num) {
        float aux = num * 100.00f;
        float aux1 = (float) ((int) aux);
        return (aux1 / 100.00f);
        //return (float)Math.round(num*100)/100;
    }

    public static double redondearDouble(double num) {
        double aux = num * 100.00f;
        double aux1 = (double) ((int) aux);
        return (aux1 / 100.00f);
        //return (float)Math.round(num*100)/100;
    }

    public static void print_matriz(Object[][] m) {
        System.out.println("Print Matriz");
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] != null) {
                    System.out.print(m[i][j] + "\t");
                } else {
                    System.out.print("..." + "\t");
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static void años(JComboBox cbx) {
        cbx.removeAllItems();
        for (int i = 2000; i <= 2024; i++) {
            cbx.addItem(i);
        }
    }
}
