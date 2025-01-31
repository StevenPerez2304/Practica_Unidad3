/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import modelos_tabla.tabla_ejercicio1;

/**
 *
 * @author USER
 */
public class practica_ejercicio1 {

    private Float[] gastos;
    private Float[] ventas;
    private String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septimebre", "Octubre", "Noviembre", "Diciembre"};

    public Float[] getGastos() {
        return gastos;
    }

    public Float[] getVentas() {
        return ventas;
    }

    public void crear(Integer nro) {
        this.ventas = new Float[nro];
        this.gastos = new Float[nro];
    }

    public Float promedio() {
        Float promedio = 0.0f;
        Float cont = 0.0f;
        for (int i = 0; i < ventas.length; i++) {
            if (ventas[i] != null) {
                cont++;
                promedio += ventas[i];
            }
        }
        return utilidades_practica.redondear(promedio / cont);
    }

    public Float suma_ventas() {
        Float sumaventas = 0.0f;
        for (int i = 0; i < ventas.length; i++) {
            if (ventas[i] != null) {
                sumaventas += ventas[i];
            }
        }
        return utilidades_practica.redondear(sumaventas);
    }

    public Float suma_gastos() {
        Float sumagastos = 0.0f;
        for (int i = 0; i < gastos.length; i++) {
            if (gastos[i] != null) {
                sumagastos += gastos[i];
            }
        }
        return utilidades_practica.redondear(sumagastos);
    }

    public Float venta_alta() {
        Float ventaalta = Float.MIN_VALUE;
        for (int i = 0; i < ventas.length; i++) {
            if (ventas[i] != null && ventas[i] > ventaalta) {
                ventaalta = ventas[i];
            }
        }
        return utilidades_practica.redondear(ventaalta);
    }

    public String mesv_alta() {
        Float ventaalta = Float.MIN_VALUE;
        int mesalto = -1;
        for (int i = 0; i < ventas.length; i++) {
            if (ventas[i] != null && ventas[i] > ventaalta) {
                ventaalta = ventas[i];
                mesalto = i;
            }
        }
        return meses[mesalto];
    }

    public Float venta_baja() {
        Float ventabaja = Float.MAX_VALUE;
        for (int i = 0; i < ventas.length; i++) {
            if (ventas[i] != null && ventas[i] < ventabaja) {
                ventabaja = ventas[i];
            }
        }
        return utilidades_practica.redondear(ventabaja);
    }

    public String mesv_baja() {
        Float ventabaja = Float.MAX_VALUE;
        int mesbaja = -1;
        for (int i = 0; i < ventas.length; i++) {
            if (ventas[i] != null && ventas[i] < ventabaja) {
                ventabaja = ventas[i];
                mesbaja = i;
            }
        }
        return meses[mesbaja];
    }

    public Integer verficar_ventas() {
        Integer pos = -1;
        for (int i = 0; i < ventas.length; i++) {
            if (ventas[i] == null) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    public Integer verficar_gastos() {
        Integer pos = -1;
        for (int i = 0; i < gastos.length; i++) {
            if (gastos[i] == null) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    public Boolean guardar(Float venta, Float gasto) {
        Integer pos = verficar_ventas();
        Integer posg = verficar_gastos();
        if (pos >= 0 && posg >= 0) {
            ventas[pos] = venta;
            gastos[pos] = gasto;
            return true;
        }
        return false;
    }

    public Boolean Modificar(Float venta, Float gasto, Integer pos) {
        if (pos >= 0) {
            ventas[pos] = venta;
            gastos[pos] = gasto;
            return true;
        }
        return false;
    }

    public Boolean generar_files() {
        if (ventas != null && gastos != null) {
            String pathVentaanual = "data_primero" + File.separatorChar + "registroanual.txt";
            try {
                FileWriter file_ventaanual = new FileWriter(pathVentaanual);
                for (int i = 0; i < ventas.length; i++) {
                    if (ventas[i] != null) {
                        file_ventaanual.write("venta:" + ventas[i].toString() + "\n");
                    }
                }
                for (int i = 0; i < gastos.length; i++) {
                    if (gastos[i] != null) {
                        file_ventaanual.write("gasto:" + gastos[i].toString() + "\n");
                    }
                }
                file_ventaanual.flush();
                file_ventaanual.close();
                return true;
            } catch (Exception e) {
                System.out.println("error en archivo" + e);
                return false;
            }
        }
        return false;
    }

    public Boolean cargarArchivo() {
        String pathVentaanual = "data_primero" + File.separatorChar + "registroanual.txt";
        try {
            FileReader fr = new FileReader(pathVentaanual);
            BufferedReader file_ventaanual = new BufferedReader(fr);
            int nlineas = 0;
            while (file_ventaanual.readLine() != null) {
                nlineas++;
            }
            file_ventaanual.close();
            crear(nlineas = (12 - nlineas) + nlineas);
            fr = new FileReader(pathVentaanual);
            file_ventaanual = new BufferedReader(fr);
            String Linea;
            int ventaCont = 0;
            int gastoCont = 0;
            while ((Linea = file_ventaanual.readLine()) != null) {
                if (Linea.startsWith("venta:")) {
                    ventas[ventaCont] = Float.parseFloat(Linea.substring(6));
                    ventaCont++;
                } else if (Linea.startsWith("gasto:")) {
                    gastos[gastoCont] = Float.parseFloat(Linea.substring(6));
                    gastoCont++;
                }
            }
            file_ventaanual.close();
            fr.close();
            return true;
        } catch (Exception e) {
            System.out.println("error en archivo" + e);
            return false;
        }
    }
}
