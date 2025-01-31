/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos_tabla;

import practica.practica_ejercicio4;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author USER
 */
public class tabla_ejercicio4 extends AbstractTableModel {

    private practica_ejercicio4 p_ejercicio4;

    public practica_ejercicio4 getP_ejercicio4() {
        return p_ejercicio4;
    }

    public void setP_ejercicio4(practica_ejercicio4 p_ejercicio4) {
        this.p_ejercicio4 = p_ejercicio4;
    }

    /**
     * metodo que devuelve el numero de filas
     *
     * @return int numero de filas
     */
    @Override
    public int getRowCount() {
        return p_ejercicio4 != null ? p_ejercicio4.getAltura().length : 0;
    }

    /**
     * metodo que devuelve el numero de columnas
     *
     * @return int numero de columnas
     */
    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        switch (i1) {
            case 0:
                return (i + 1);
            case 1:
                return p_ejercicio4.getAltura()[i];
            case 2:
                return p_ejercicio4.getLargo()[i];
            case 3:
                return p_ejercicio4.getAncho()[i];
            case 4:
                return p_ejercicio4.getPisos()[i];
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int i) {
        switch (i) {
            case 0:
                return "Casas";
            case 1:
                return "Altura";
            case 2:
                return "Ancho";
            case 3:
                return "Largo";
            case 4:
                return "Pisos";
            default:
                return null;
        }
    }
}
