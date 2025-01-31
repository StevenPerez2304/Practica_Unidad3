/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos_tabla;

import practica.practica_ejercicio1;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author USER
 */
public class tabla_ejercicio1 extends AbstractTableModel {

    private practica_ejercicio1 p_ejercicio1;

    private String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septimebre", "Octubre", "Noviembre", "Diciembre"};

    public practica_ejercicio1 getP_ejercicio1() {
        return p_ejercicio1;
    }

    public void setP_ejercicio1(practica_ejercicio1 p_ejercicio1) {
        this.p_ejercicio1 = p_ejercicio1;
    }

    /**
     * metodo que devuelve el numero de filas
     *
     * @return int numero de filas
     */
    @Override
    public int getRowCount() {
        return p_ejercicio1 != null ? p_ejercicio1.getVentas().length : 0;
    }

    /**
     * metodo que devuelve el numero de columnas
     *
     * @return int numero de columnas
     */
    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        switch (i1) {
            case 0:
                return meses[i];
            case 1:
                return p_ejercicio1.getVentas()[i];
            case 2:
                return p_ejercicio1.getGastos()[i];
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int i) {
        switch (i) {
            case 0:
                return "Meses";
            case 1:
                return "Ventas";
            case 2:
                return "Gastos";
            default:
                return null;
        }
    }
}
