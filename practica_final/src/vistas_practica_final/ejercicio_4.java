/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vistas_practica_final;

import java.util.List;
import javax.swing.JOptionPane;
import modelos_tabla.tabla_ejercicio4;
import practica.practica_ejercicio4;
import practica.utilidades_practica;

/**
 *
 * @author USER
 */
public class ejercicio_4 extends javax.swing.JDialog {

    private practica_ejercicio4 p_ejercicio4 = new practica_ejercicio4();
    private tabla_ejercicio4 tablaejecicio4 = new tabla_ejercicio4();
    private Integer fila = -1;

    /**
     * Creates new form ejercicio_4
     */
    public ejercicio_4(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void cargarTabla() {
        tablaejecicio4.setP_ejercicio4(p_ejercicio4);
        tbltabla.setModel(tablaejecicio4);
        tbltabla.updateUI();
    }

    private Boolean verificar() {
        return (txtaltura.getText().trim().isEmpty() || txtancho.getText().trim().isEmpty() || txtlargo.getText().trim().isEmpty() || txtpisos.getText().trim().isEmpty());
    }

    private void limpiar() {
        txtaltura.setText("");
        txtancho.setText("");
        txtlargo.setText("");
        txtpisos.setText("");
        txtAhomonimas.setText("");
        cargarTabla();
        fila = -1;
        tbltabla.clearSelection();
    }

    private void registrar() {
        if (verificar()) {
            JOptionPane.showMessageDialog(null, "llene todos los campos");
        } else {
            if (utilidades_practica.validar(txtaltura.getText().trim()) && utilidades_practica.validar(txtancho.getText().trim()) && utilidades_practica.validar(txtlargo.getText().trim()) && utilidades_practica.validar(txtpisos.getText().trim())) {
                Float altura = utilidades_practica.transformStringFloat(txtaltura.getText().trim());
                Float ancho = utilidades_practica.transformStringFloat(txtancho.getText().trim());
                Float largo = utilidades_practica.transformStringFloat(txtlargo.getText().trim());
                Float pisos = utilidades_practica.transformStringFloat(txtpisos.getText().trim());
                if (fila == -1) {
                    if (p_ejercicio4.guardar(altura, ancho, largo, pisos)) {
                        JOptionPane.showMessageDialog(null, "se guardo correctamente", "OK", JOptionPane.INFORMATION_MESSAGE);
                        limpiar();
                        txtAhomonimas.setText(p_ejercicio4.casashomonimas().toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "error al guardar o ya se guardaron todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    if (p_ejercicio4.Modificar(altura, ancho, largo, pisos, fila)) {
                        JOptionPane.showMessageDialog(null, "se a modificado correctamente", "OK", JOptionPane.INFORMATION_MESSAGE);
                        limpiar();
                        txtAhomonimas.setText(p_ejercicio4.casashomonimas().toString());
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
        Integer nro = 10;
        p_ejercicio4.crear(nro);
        btnagregar.setEnabled(true);
        btnguardararchivo.setEnabled(true);
        cargarTabla();
    }

    private void cargarDatos() {
        fila = tbltabla.getSelectedRow();
        System.out.println("****" + fila);
        if (fila >= 0) {
            if (p_ejercicio4.getAltura()[fila] != null && p_ejercicio4.getAncho()[fila] != null && p_ejercicio4.getLargo()[fila] != null && p_ejercicio4.getPisos()[fila] != null) {
                txtaltura.setText(p_ejercicio4.getAltura()[fila].toString());
                txtancho.setText(p_ejercicio4.getAncho()[fila].toString());
                txtlargo.setText(p_ejercicio4.getLargo()[fila].toString());
                txtpisos.setText(p_ejercicio4.getPisos()[fila].toString());
            } else {
                fila = -1;
                txtaltura.setText("");
                txtancho.setText("");
                txtlargo.setText("");
                txtpisos.setText("");
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbltabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnagregar = new javax.swing.JButton();
        txtaltura = new javax.swing.JTextField();
        txtancho = new javax.swing.JTextField();
        txtlargo = new javax.swing.JTextField();
        txtpisos = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnguardararchivo = new javax.swing.JButton();
        btncargarchivo = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAhomonimas = new javax.swing.JTextArea();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane6.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tbltabla.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbltabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbltabla);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("CASAS/HOMONIMAS");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("ALTURA");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("ANCHO");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("LARGO");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("PISOS");

        btnagregar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnagregar.setText("AGREGAR");
        btnagregar.setEnabled(false);
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });

        txtaltura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtalturaActionPerformed(evt);
            }
        });

        txtancho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtanchoActionPerformed(evt);
            }
        });

        txtlargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtlargoActionPerformed(evt);
            }
        });

        txtpisos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpisosActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("CASAS HOMONIMAS");

        btnguardararchivo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnguardararchivo.setText("GUARDAR ARCHIVO");
        btnguardararchivo.setEnabled(false);
        btnguardararchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardararchivoActionPerformed(evt);
            }
        });

        btncargarchivo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btncargarchivo.setText("CARGAR ARCHIVO");
        btncargarchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncargarchivoActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jButton1.setText("10 CASAS NUEVAS");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtAhomonimas.setColumns(20);
        txtAhomonimas.setRows(5);
        jScrollPane2.setViewportView(txtAhomonimas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnagregar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(220, 220, 220)
                            .addComponent(jLabel1))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtaltura, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtancho, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtpisos, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                                    .addComponent(txtlargo)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btncargarchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnguardararchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(13, 13, 13)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(txtaltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtlargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(txtancho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtpisos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnagregar)))
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(40, 40, 40)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncargarchivo)
                    .addComponent(btnguardararchivo))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        // TODO add your handling code here:
        registrar();
    }//GEN-LAST:event_btnagregarActionPerformed

    private void btncargarchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncargarchivoActionPerformed
        // TODO add your handling code here:
        if (p_ejercicio4.cargarArchivo()) {
            cargarTabla();
            txtAhomonimas.setText(p_ejercicio4.casashomonimas().toString());
            btnagregar.setEnabled(true);
            btncargarchivo.setEnabled(true);
        }
    }//GEN-LAST:event_btncargarchivoActionPerformed

    private void btnguardararchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardararchivoActionPerformed
        // TODO add your handling code here:
        if (p_ejercicio4.generar_files()) {
            JOptionPane.showMessageDialog(null, "se ha generado correctamente", "OK!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Hubo un error intentelo mas tarde", "ERROR!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnguardararchivoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        crearArreglos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtalturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtalturaActionPerformed
        // TODO add your handling code here:
        registrar();
    }//GEN-LAST:event_txtalturaActionPerformed

    private void txtlargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlargoActionPerformed
        // TODO add your handling code here:
        registrar();
    }//GEN-LAST:event_txtlargoActionPerformed

    private void txtanchoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtanchoActionPerformed
        // TODO add your handling code here:
        registrar();
    }//GEN-LAST:event_txtanchoActionPerformed

    private void txtpisosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpisosActionPerformed
        // TODO add your handling code here:
        registrar();
    }//GEN-LAST:event_txtpisosActionPerformed

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
            java.util.logging.Logger.getLogger(ejercicio_4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ejercicio_4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ejercicio_4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ejercicio_4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ejercicio_4 dialog = new ejercicio_4(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btncargarchivo;
    private javax.swing.JButton btnguardararchivo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTable tbltabla;
    private javax.swing.JTextArea txtAhomonimas;
    private javax.swing.JTextField txtaltura;
    private javax.swing.JTextField txtancho;
    private javax.swing.JTextField txtlargo;
    private javax.swing.JTextField txtpisos;
    // End of variables declaration//GEN-END:variables
}
