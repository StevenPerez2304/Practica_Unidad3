/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class practica_ejercicio4 {

    private Float[] altura;
    private Float[] ancho;
    private Float[] largo;
    private Float[] pisos;

    public Float[] getAltura() {
        return altura;
    }

    public Float[] getAncho() {
        return ancho;
    }

    public Float[] getLargo() {
        return largo;
    }

    public Float[] getPisos() {
        return pisos;
    }

    public void crear(Integer nro) {
        this.altura = new Float[nro];
        this.ancho = new Float[nro];
        this.largo = new Float[nro];
        this.pisos = new Float[nro];
    }

    public List<String> casashomonimas() {
        List<String> homonimas = new ArrayList<>();
        for (int i = 0; i < altura.length; i++) {
            if (altura[i] != null) {
                for (int j = i + 1; j < altura.length; j++) {
                    if (altura[j] != null && altura[i].equals(altura[j]) && ancho[i].equals(ancho[j]) && largo[i].equals(largo[j]) && pisos[i].equals(pisos[j])) {
                        homonimas.add("Casa " + (i + 1) + " es homónima de " + (j + 1+"\n"));
                    }
                }
            }
        }
        return homonimas;
    }

    public Integer verficar_altura() {
        Integer pos = -1;
        for (int i = 0; i < altura.length; i++) {
            if (altura[i] == null) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    public Integer verficar_ancho() {
        Integer pos = -1;
        for (int i = 0; i < ancho.length; i++) {
            if (ancho[i] == null) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    public Integer verficar_largo() {
        Integer pos = -1;
        for (int i = 0; i < largo.length; i++) {
            if (largo[i] == null) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    public Integer verficar_pisos() {
        Integer pos = -1;
        for (int i = 0; i < pisos.length; i++) {
            if (pisos[i] == null) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    public Boolean guardar(Float alto, Float larg, Float anch, Float piso) {
        Integer pos = verficar_altura();
        Integer pos2 = verficar_ancho();
        Integer pos3 = verficar_largo();
        Integer pos4 = verficar_pisos();
        if (pos >= 0 && pos2 >= 0 && pos3 >= 0 && pos4 >= 0) {
            altura[pos] = alto;
            ancho[pos2] = anch;
            largo[pos3] = larg;
            pisos[pos4] = piso;
            return true;
        }
        return false;
    }

    public Boolean Modificar(Float alto, Float larg, Float anch, Float piso, Integer pos) {
        if (pos >= 0) {
            altura[pos] = alto;
            ancho[pos] = anch;
            largo[pos] = larg;
            pisos[pos] = piso;
            return true;
        }
        return false;
    }

    public Boolean generar_files() {
        if (altura != null && ancho != null && largo != null && pisos != null) {
            String pathCasas = "data_primero" + File.separatorChar + "casahomonimas.txt";
            try {
                FileWriter file_casas = new FileWriter(pathCasas);
                for (int i = 0; i < altura.length; i++) {
                    if (altura[i] != null) {
                        file_casas.write("altura:" + altura[i].toString() + "\n");
                    }
                }
                for (int i = 0; i < ancho.length; i++) {
                    if (ancho[i] != null) {
                        file_casas.write("ancho:" + ancho[i].toString() + "\n");
                    }
                }
                for (int i = 0; i < largo.length; i++) {
                    if (largo[i] != null) {
                        file_casas.write("largo:" + largo[i].toString() + "\n");
                    }
                }
                for (int i = 0; i < pisos.length; i++) {
                    if (pisos[i] != null) {
                        file_casas.write("pisos:" + pisos[i].toString() + "\n");
                    }
                }
                file_casas.flush();
                file_casas.close();
                return true;
            } catch (Exception e) {
                System.out.println("error en archivo" + e);
                return false;
            }
        }
        return false;
    }

    public Boolean cargarArchivo() {
        String pathCasas = "data_primero" + File.separatorChar + "casahomonimas.txt";
        try {
            FileReader fr = new FileReader(pathCasas);
            BufferedReader file_casas = new BufferedReader(fr);
            int nlineas = 0;
            while (file_casas.readLine() != null) {
                nlineas++;
            }
            file_casas.close();
            crear(nlineas / 4);
            fr = new FileReader(pathCasas);
            file_casas = new BufferedReader(fr);
            String Linea;
            int alturaCont = 0;
            int anchoCont = 0;
            int largoCont = 0;
            int pisosCont = 0;
            while ((Linea = file_casas.readLine()) != null) {
                if (Linea.startsWith("altura:")) {
                    altura[alturaCont] = Float.parseFloat(Linea.substring(7).trim());
                    alturaCont++;
                } else if (Linea.startsWith("ancho:")) {
                    ancho[anchoCont] = Float.parseFloat(Linea.substring(6).trim());
                    anchoCont++;
                } else if (Linea.startsWith("largo:")) {
                    largo[largoCont] = Float.parseFloat(Linea.substring(6).trim());
                    largoCont++;
                } else if (Linea.startsWith("pisos:")) {
                    pisos[pisosCont] = Float.parseFloat(Linea.substring(6).trim());
                    pisosCont++;
                }
            }
            file_casas.close();
            fr.close();
            return true;
        } catch (Exception e) {
            System.out.println("error en archivo" + e);
            return false;
        }
    }
}
