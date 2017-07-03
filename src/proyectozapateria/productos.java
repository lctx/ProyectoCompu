package proyectozapateria;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class productos extends javax.swing.JInternalFrame {

    public productos() {
        initComponents();
        bloquearBotonesInicio();
        BloquearTexto();
    }

    public void limpiarTexto() {
        jTexID.setText("");
        jTextFieldMarca.setText("");

        jTextFieldColor.setText("");
        jTextFieldTalla.setText("");
        jTextFieldModelo.setText("");
        jTextFieldTipo.setText("");
        jTextFieldStock.setText("");
    }

    public void BloquearTexto() {
        jTexID.setEnabled(false);
        jTextFieldMarca.setEnabled(false);
        jTextFieldColor.setEnabled(false);
        jTextFieldTalla.setEnabled(false);
        jTextFieldModelo.setEnabled(false);
        jTextFieldTipo.setEnabled(false);
        jTextFieldStock.setEnabled(false);
    }

    public void Texto() {
        jTexID.setEnabled(true);
        jTextFieldMarca.setEnabled(true);
        jTextFieldColor.setEnabled(true);
        jTextFieldTalla.setEnabled(true);
        jTextFieldModelo.setEnabled(true);
        jTextFieldTipo.setEnabled(true);
        jTextFieldStock.setEnabled(true);
    }

    public void bloquearBotonesInicio() {
        btnNuevo.setEnabled(true);
        btnGuardar.setEnabled(false);
    }

    public void GuardarProducto() {

        if (jTexID.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Ingrese la ID");
            jTexID.requestFocus(true);
        } else if (jTextFieldMarca.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese la Marca");
            jTextFieldMarca.requestFocus(true);

        } else if (jTextFieldColor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese la Color");
            jTextFieldColor.requestFocus(true);
        } else if (jTextFieldTalla.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese la Taller");
            jTextFieldTalla.requestFocus(true);
        } else if (jTextFieldModelo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese la Modelo");
            jTextFieldModelo.requestFocus(true);
        } else if (jTextFieldTipo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese la Tipo");
            jTextFieldTipo.requestFocus(true);
        } else if (jTextFieldStock.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese la Stock");
            jTextFieldStock.requestFocus(true);
        } else {
            String PRO_ID, PRO_MARCA, PRO_COLOR, PRO_TALLA, PRO_MODELO, PRO_TIPO, Stock;

            PRO_ID = jTexID.getText();
            PRO_MARCA = jTextFieldMarca.getText();
            PRO_COLOR = jTextFieldColor.getText();
            PRO_TALLA = jTextFieldTalla.getText();
            PRO_MODELO = jTextFieldModelo.getText();
            PRO_TIPO = jTextFieldTipo.getText();
            Stock = jTextFieldStock.getText();
            Conexion cc = new Conexion();
            Connection cn = (Connection) cc.conectar();
            String sql = "";
            sql = "insert into productos (PRO_ID,PRO_MARCA,PRO_COLOR,PRO_TALLA,PRO_MODELO,PRO_TIPO,Stock) values (?,?,?,?,?,?,?) ";
            try {
                java.sql.PreparedStatement psd = cn.prepareStatement(sql);
                psd.setString(1, PRO_ID);
                psd.setString(2, PRO_MARCA);
                psd.setString(3, PRO_COLOR);
                psd.setString(4, PRO_TALLA);
                psd.setString(5, PRO_MODELO);
                psd.setString(6, PRO_TIPO);
                psd.setString(7, Stock);

                int n = psd.executeUpdate();

                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Se Inserto el dato correctamente");
                    limpiarTexto();
                    BloquearTexto();
                    bloquearBotonesInicio();

                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Se Inserto el dato correctamente");
            }

        }

    }

    public void controlSoloLetras(KeyEvent evt) {
        if (evt.getKeyChar() < 65 || evt.getKeyChar() > 90 && evt.getKeyChar() < 97 || evt.getKeyChar() > 122 && evt.getKeyChar() == 32) {
            evt.consume();
        }
    }

    public void solonumeros(KeyEvent evt) {
        char c = evt.getKeyChar();

        if (Character.isLetter(c)) {

            evt.consume();
        }

    }

    public void bloquearBotonesNuevo() {
        btnNuevo.setEnabled(false);
        btnGuardar.setEnabled(true);
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
        jLabel1 = new javax.swing.JLabel();
        jTexID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldMarca = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldColor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldTalla = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldTipo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldStock = new javax.swing.JTextField();
        jTextFieldModelo = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ID:");

        jLabel2.setText("Marca:");

        jTextFieldMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldMarcaKeyTyped(evt);
            }
        });

        jLabel3.setText("Color:");

        jTextFieldColor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldColorKeyTyped(evt);
            }
        });

        jLabel4.setText("Talla:");

        jTextFieldTalla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTallaActionPerformed(evt);
            }
        });
        jTextFieldTalla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTallaKeyTyped(evt);
            }
        });

        jLabel5.setText("Modelo:");

        jLabel6.setText("Tipo:");

        jTextFieldTipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTipoKeyTyped(evt);
            }
        });

        jLabel7.setText("Stock:");

        jTextFieldStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldStockKeyTyped(evt);
            }
        });

        jTextFieldModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldModeloActionPerformed(evt);
            }
        });
        jTextFieldModelo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldModeloKeyTyped(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldTipo, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                            .addComponent(jTextFieldStock, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldModelo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                            .addComponent(jTextFieldTalla)
                            .addComponent(jTexID, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                            .addComponent(jTextFieldMarca)
                            .addComponent(jTextFieldColor))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnGuardar)))
                        .addGap(63, 63, 63))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addContainerGap(350, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTexID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNuevo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldTalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jTextFieldTallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTallaActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jTextFieldTallaActionPerformed

private void jTextFieldModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldModeloActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jTextFieldModeloActionPerformed

private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
// TODO add your handling code here:
    bloquearBotonesNuevo();
    Texto();

}//GEN-LAST:event_btnNuevoActionPerformed

private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
// TODO add your handling code here:
    GuardarProducto();

}//GEN-LAST:event_btnGuardarActionPerformed

private void jTextFieldMarcaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldMarcaKeyTyped
// TODO add your handling code here:
    controlSoloLetras(evt);
}//GEN-LAST:event_jTextFieldMarcaKeyTyped

private void jTextFieldColorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldColorKeyTyped
// TODO add your handling code here:
    controlSoloLetras(evt);
}//GEN-LAST:event_jTextFieldColorKeyTyped

private void jTextFieldModeloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldModeloKeyTyped
// TODO add your handling code here:
    controlSoloLetras(evt);
}//GEN-LAST:event_jTextFieldModeloKeyTyped

private void jTextFieldTipoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTipoKeyTyped
// TODO add your handling code here:
    controlSoloLetras(evt);
}//GEN-LAST:event_jTextFieldTipoKeyTyped

private void jTextFieldTallaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTallaKeyTyped
// TODO add your handling code here:
    solonumeros(evt);
}//GEN-LAST:event_jTextFieldTallaKeyTyped

    private void jTextFieldStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldStockKeyTyped
        // TODO add your handling code here:
        solonumeros(evt);
    }//GEN-LAST:event_jTextFieldStockKeyTyped

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
            java.util.logging.Logger.getLogger(productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new productos().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTexID;
    private javax.swing.JTextField jTextFieldColor;
    private javax.swing.JTextField jTextFieldMarca;
    private javax.swing.JTextField jTextFieldModelo;
    private javax.swing.JTextField jTextFieldStock;
    private javax.swing.JTextField jTextFieldTalla;
    private javax.swing.JTextField jTextFieldTipo;
    // End of variables declaration//GEN-END:variables
}
