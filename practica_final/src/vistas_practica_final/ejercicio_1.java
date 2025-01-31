/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vistas_practica_final;

import javax.swing.JOptionPane;
import modelos_tabla.tabla_ejercicio1;
import practica.practica_ejercicio1;
import practica.utilidades_practica;

/**
 *
 * @author USER
 */
public class ejercicio_1 extends javax.swing.JDialog {

    private practica_ejercicio1 p_ejercicio1 = new practica_ejercicio1();
    private tabla_ejercicio1 tablaejecicio1 = new tabla_ejercicio1();
    private Integer fila = -1;

    /**
     * Creates new form ejercicio_1
     */
    public ejercicio_1(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        utilidades_practica.años(comboboxaño);
    }

    private void cargarTabla() {
        tablaejecicio1.setP_ejercicio1(p_ejercicio1);
        tbltabla.setModel(tablaejecicio1);
        tbltabla.updateUI();
    }

    private Boolean verificar() {
        return (txtventa.getText().trim().isEmpty() || txtgasto.getText().trim().isEmpty());
    }

    private void limpiar() {
        txtventa.setText("");
        txtgasto.setText("");
        lblpromedio.setText("0.0");
        lblventanual.setText("0.0");
        lblgastoanual.setText("0.0");
        lblventaalta.setText("0.0");
        lblmesalto.setText("...");
        lblventabaja.setText("0.0");
        lblmesbaja.setText("...");
        cargarTabla();
        fila = -1;
        tbltabla.clearSelection();
    }

    private void registrar() {
        if (verificar()) {
            JOptionPane.showMessageDialog(null, "llene todos los campos");
        } else {
            if (utilidades_practica.validar(txtventa.getText().trim()) && utilidades_practica.validar(txtgasto.getText().trim())) {
                Float venta = utilidades_practica.transformStringFloat(txtventa.getText().trim());
                Float gasto = utilidades_practica.transformStringFloat(txtgasto.getText().trim());
                if (fila == -1) {
                    if (p_ejercicio1.guardar(venta, gasto)) {
                        JOptionPane.showMessageDialog(null, "se guardo correctamente", "OK", JOptionPane.INFORMATION_MESSAGE);
                        limpiar();
                        lblpromedio.setText(p_ejercicio1.promedio().toString());
                        lblventanual.setText(p_ejercicio1.suma_ventas().toString());
                        lblgastoanual.setText(p_ejercicio1.suma_gastos().toString());
                        lblventaalta.setText(p_ejercicio1.venta_alta().toString());
                        lblmesalto.setText(p_ejercicio1.mesv_alta().toString());
                        lblventabaja.setText(p_ejercicio1.venta_baja().toString());
                        lblmesbaja.setText(p_ejercicio1.mesv_baja().toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "error al guardar o ya se guardaron todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    if (p_ejercicio1.Modificar(venta, gasto, fila)) {
                        JOptionPane.showMessageDialog(null, "se a modificado correctamente", "OK", JOptionPane.INFORMATION_MESSAGE);
                        limpiar();
                        lblpromedio.setText(p_ejercicio1.promedio().toString());
                        lblventanual.setText(p_ejercicio1.suma_ventas().toString());
                        lblgastoanual.setText(p_ejercicio1.suma_gastos().toString());
                        lblventaalta.setText(p_ejercicio1.venta_alta().toString());
                        lblmesalto.setText(p_ejercicio1.mesv_alta().toString());
                        lblventabaja.setText(p_ejercicio1.venta_baja().toString());
                        lblmesbaja.setText(p_ejercicio1.mesv_baja().toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "error al modificar", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "ingresa un numero valido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void crearArreglos() {
        Integer nro = 12;
        p_ejercicio1.crear(nro);
        btnregistrar.setEnabled(true);
        btnguardararchivo.setEnabled(true);
        cargarTabla();
    }

    private void cargarDatos() {
        fila = tbltabla.getSelectedRow();
        System.out.println("****" + fila);
        if (fila >= 0) {
            if (p_ejercicio1.getVentas()[fila] != null && p_ejercicio1.getGastos()[fila] != null) {
                txtventa.setText(p_ejercicio1.getVentas()[fila].toString());
                txtgasto.setText(p_ejercicio1.getGastos()[fila].toString());
            } else {
                fila = -1;
                txtventa.setText("");
                txtgasto.setText("");
                JOptionPane.showMessageDialog(null, "seleccione un registro valido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            fila = -1;
            JOptionPane.showMessageDialog(null, "seleccione un registro de la tabla", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comboboxaño = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnregistrar = new javax.swing.JButton();
        txtventa = new javax.swing.JTextField();
        txtgasto = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbltabla = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblventanual = new javax.swing.JLabel();
        lblgastoanual = new javax.swing.JLabel();
        lblpromedio = new javax.swing.JLabel();
        lblventaalta = new javax.swing.JLabel();
        lblventabaja = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lblmesalto = new javax.swing.JLabel();
        lblmesbaja = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnguardararchivo = new javax.swing.JButton();
        btncargararchivo = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        jLabel6.setText("jLabel6");

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel1.setText("Seleccione el año");

        comboboxaño.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jButton1.setText("SELECCIONE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel2.setText("Gastos en el mes");

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel3.setText("INFORME");

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel4.setText("Ingreso de datos");

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel5.setText("Ventas en el mes");

        btnregistrar.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnregistrar.setText("REGISTRAR");
        btnregistrar.setEnabled(false);
        btnregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarActionPerformed(evt);
            }
        });

        txtventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtventaActionPerformed(evt);
            }
        });

        txtgasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtgastoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(comboboxaño, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnregistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtventa)
                                    .addComponent(txtgasto))
                                .addGap(104, 104, 104))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(comboboxaño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addComponent(txtventa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(btnregistrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtgasto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tbltabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tbltabla);

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("SELECIONAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel7.setText("Venta anual");

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel8.setText("Gasto anual");

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel9.setText("Promedio de ventas");

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel10.setText("Venta mas alta");

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel11.setText("Venta mas baja");

        lblventanual.setText("0.0");

        lblgastoanual.setText("0.0");

        lblpromedio.setText("0.0");

        lblventaalta.setText("0.0");

        lblventabaja.setText("0.0");

        jLabel18.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel18.setText("Mes");

        jLabel19.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel19.setText("Mes");

        lblmesalto.setText("...");

        lblmesbaja.setText("...");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblventanual, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(lblgastoanual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblpromedio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblventabaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblventaalta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblmesbaja, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(lblmesalto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblventanual)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblgastoanual))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblpromedio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblventaalta)
                    .addComponent(jLabel18)
                    .addComponent(lblmesalto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblventabaja)
                    .addComponent(jLabel19)
                    .addComponent(lblmesbaja))
                .addGap(15, 15, 15))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnguardararchivo.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnguardararchivo.setText("GUARDAR ARCHIVO");
        btnguardararchivo.setEnabled(false);
        btnguardararchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardararchivoActionPerformed(evt);
            }
        });

        btncargararchivo.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btncargararchivo.setText("CARGAR ARCHIVO");
        btncargararchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncargararchivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnguardararchivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btncargararchivo)
                .addGap(96, 96, 96))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnguardararchivo)
                    .addComponent(btncargararchivo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        crearArreglos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarActionPerformed
        // TODO add your handling code here:
        registrar();
    }//GEN-LAST:event_btnregistrarActionPerformed

    private void btnguardararchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardararchivoActionPerformed
        // TODO add your handling code here:
        if (p_ejercicio1.generar_files()) {
            JOptionPane.showMessageDialog(null, "se ha generado correctamente", "OK!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Hubo un error intentelo mas tarde", "ERROR!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnguardararchivoActionPerformed

    private void btncargararchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncargararchivoActionPerformed
        // TODO add your handling code here:
        if (p_ejercicio1.cargarArchivo()) {
            cargarTabla();
            lblpromedio.setText(p_ejercicio1.promedio().toString());
            lblventanual.setText(p_ejercicio1.suma_ventas().toString());
            lblgastoanual.setText(p_ejercicio1.suma_gastos().toString());
            lblventaalta.setText(p_ejercicio1.venta_alta().toString());
            lblmesalto.setText(p_ejercicio1.mesv_alta().toString());
            lblventabaja.setText(p_ejercicio1.venta_baja().toString());
            lblmesbaja.setText(p_ejercicio1.mesv_baja().toString());
            btnregistrar.setEnabled(true);
            btnguardararchivo.setEnabled(true);
        }
    }//GEN-LAST:event_btncargararchivoActionPerformed

    private void txtventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtventaActionPerformed
        // TODO add your handling code here:
        registrar();
    }//GEN-LAST:event_txtventaActionPerformed

    private void txtgastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtgastoActionPerformed
        // TODO add your handling code here:
        registrar();
    }//GEN-LAST:event_txtgastoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        cargarDatos();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ejercicio_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ejercicio_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ejercicio_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ejercicio_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ejercicio_1 dialog = new ejercicio_1(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncargararchivo;
    private javax.swing.JButton btnguardararchivo;
    private javax.swing.JButton btnregistrar;
    private javax.swing.JComboBox<String> comboboxaño;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JLabel lblgastoanual;
    private javax.swing.JLabel lblmesalto;
    private javax.swing.JLabel lblmesbaja;
    private javax.swing.JLabel lblpromedio;
    private javax.swing.JLabel lblventaalta;
    private javax.swing.JLabel lblventabaja;
    private javax.swing.JLabel lblventanual;
    private javax.swing.JTable tbltabla;
    private javax.swing.JTextField txtgasto;
    private javax.swing.JTextField txtventa;
    // End of variables declaration//GEN-END:variables
}
