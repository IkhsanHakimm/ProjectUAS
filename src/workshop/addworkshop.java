/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package workshop;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;

/**
 *
 * @author LENOVO
 */
public class addworkshop extends javax.swing.JFrame {

    /**
     * Creates new form addworkshop
     */
    public Statement st;
    public ResultSet rs;
    public Connection kon = konekdb.bukaKon();
    public addworkshop() {
        initComponents();
        setLocationRelativeTo(null);
        ShowData();
    }
    private void clearFields() {
    txtID.setText("");
    txtNama.setText("");
    txtTanggal.setText("");
    txtLokasi.setText("");
    txtKap.setText("");
    txtDeskripsi.setText("");

    txtID.setEditable(true);
}

    private void findWorkshop() {
    try {
        st = kon.createStatement();
        String searchQuery = "SELECT * FROM tabel_workshop WHERE workshop_id LIKE '%" + jTextField1.getText()
                + "%' OR nama_workshop LIKE '%" + jTextField1.getText()
                + "%' OR tanggal_workshop LIKE '%" + jTextField1.getText()
                + "%' OR lokasi_workshop LIKE '%" + jTextField1.getText()
                + "%' OR kapasitas LIKE '%" + jTextField1.getText() + "%'";

        rs = st.executeQuery(searchQuery);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Workshop ID");
        model.addColumn("Nama Workshop");
        model.addColumn("Tanggal Workshop");
        model.addColumn("Lokasi Workshop");
        model.addColumn("Kapasitas");
        model.addColumn("Deskripsi Workshop");

        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        model.setRowCount(0);

        while (rs.next()) {
            Object[] data = {
                rs.getString("workshop_id"),
                rs.getString("nama_workshop"),
                rs.getString("tanggal_workshop"),
                rs.getString("lokasi_workshop"),
                rs.getString("kapasitas"),
                rs.getString("deskripsi_workshop")
            };
            model.addRow(data);
            tableWorkshop.setModel(model);
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,e);
    }
}

    public void ShowData(){
        try {
            st = kon.createStatement();
            rs = st.executeQuery("SELECT * FROM tabel_workshop");
            
            DefaultTableModel model = new DefaultTableModel();
            
            model.addColumn("Id Workshop");
            model.addColumn("Nama");
            model.addColumn("Tanggal");
            model.addColumn("Lokasi");
            model.addColumn("Kapasitas");
            model.addColumn("Deskripsi");
            
            model.getDataVector().removeAllElements();
            model.setRowCount(0);
            model.fireTableDataChanged();
            
            while (rs.next()){
                Object[] data = {
                    rs.getInt("workshop_id"),
                    rs.getString("nama_workshop"),
                    rs.getDate("tanggal_workshop"),
                    rs.getString("lokasi_workshop"),
                    rs.getInt("kapasitas"),
                    rs.getString("deskripsi_workshop")
                };
                model.addRow(data);
                tableWorkshop.setModel(model);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
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
        jTextField1 = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableWorkshop = new javax.swing.JTable();
        txtNama = new javax.swing.JTextField();
        txtTanggal = new javax.swing.JTextField();
        txtLokasi = new javax.swing.JTextField();
        txtDeskripsi = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtKap = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("addworkshop");

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        tableWorkshop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id Workshop", "Nama ", "Tanggal ", "Lokasi ", "Kapasitas", "Deskripsi"
            }
        ));
        jScrollPane1.setViewportView(tableWorkshop);

        txtNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaActionPerformed(evt);
            }
        });

        txtTanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTanggalActionPerformed(evt);
            }
        });

        txtLokasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLokasiActionPerformed(evt);
            }
        });

        txtDeskripsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDeskripsiActionPerformed(evt);
            }
        });

        jLabel2.setText("Tanggal");

        jLabel3.setText("Nama");

        jLabel4.setText("Lokasi");

        jLabel5.setText("Deskripsi");

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel6.setText("ID");

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        jLabel7.setText("Kapasitas");

        txtKap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKapActionPerformed(evt);
            }
        });

        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(btnCari)))
                        .addGap(29, 29, 29))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(73, 73, 73)
                                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2))
                                        .addGap(43, 43, 43)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(btnSimpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnHapus)
                                .addGap(14, 14, 14)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(21, 21, 21)
                                .addComponent(txtKap, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(136, 136, 136))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(36, 36, 36)
                                        .addComponent(txtLokasi, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnUpdate)
                                            .addComponent(txtDeskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(69, 69, 69))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLokasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtKap))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtDeskripsi)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnHapus)
                    .addComponent(btnUpdate)
                    .addComponent(jButton1))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("");
        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCariActionPerformed

    private void txtNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaActionPerformed

    private void txtTanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTanggalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTanggalActionPerformed

    private void txtLokasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLokasiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLokasiActionPerformed

    private void txtDeskripsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDeskripsiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDeskripsiActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        try {
            st = kon.createStatement();

            if (txtID.getText().equals("") || txtNama.getText().equals("") || txtTanggal.getText().equals("") ||
            txtLokasi.getText().equals("") || txtKap.getText().equals("") || txtDeskripsi.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf, data harus diisi.");
            return;
            }

            String cekQuery = "SELECT * FROM tabel_workshop WHERE workshop_id = '" + txtID.getText() + "' AND nama_workshop = '" + txtNama.getText() +
                          "' AND tanggal_workshop = '" + txtTanggal.getText() + "' AND lokasi_workshop = '" + txtLokasi.getText() +
                          "' AND kapasitas = '" + txtKap.getText() + "' AND deskripsi_workshop = '" + txtDeskripsi.getText() + "'";

            rs = st.executeQuery(cekQuery);

            if (rs.next()) {
            JOptionPane.showMessageDialog(null, "Data sudah ada.");
            } else {
            String addData = "INSERT INTO tabel_workshop(workshop_id, nama_workshop, tanggal_workshop, lokasi_workshop, kapasitas, deskripsi_workshop) VALUES ('"
                             + txtID.getText() + "','" + txtNama.getText() + "','" + txtTanggal.getText() + "','" + txtLokasi.getText() +
                             "','" + txtKap.getText() + "','" + txtDeskripsi.getText() + "')";

            st.executeUpdate(addData);
            
            ShowData();
            
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menyimpan data.");
            }

     
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
               if (txtID.getText().isEmpty()) {
    JOptionPane.showMessageDialog(this, "Silakan pilih data yang akan dihapus");
        } else {
        int jawab = JOptionPane.showConfirmDialog(null, "Data ini akan dihapus, lanjutkan?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (jawab == JOptionPane.YES_OPTION) {
        try {
            st = kon.createStatement();
            String deleteQuery = "DELETE FROM tabel_workshop WHERE workshop_id = '" + txtID.getText() + "'";
            int rowsAffected = st.executeUpdate(deleteQuery);

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus"); 
                
                DefaultTableModel model = (DefaultTableModel) tableWorkshop.getModel();
                int rowCount = model.getRowCount();
                for (int i = 0; i < rowCount; i++) {
                    if (model.getValueAt(i, 0).toString().equals(txtID.getText())) {
                        model.removeRow(i);
                        break; 
                    }
                }
                ShowData();
                clearFields();
            } else {
                JOptionPane.showMessageDialog(null, "Tidak ada data yang dihapus");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menghapus data: " + e.getMessage());
        }
    }
}

    }//GEN-LAST:event_btnHapusActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void txtKapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKapActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        try {
    String update = "UPDATE tabel_workshop SET nama_workshop = '" + txtNama.getText()
            + "', tanggal_workshop = '" + txtTanggal.getText() + "', lokasi_workshop = '" + txtLokasi.getText()
            + "', kapasitas = '" + txtKap.getText() + "', deskripsi_workshop = '" + txtDeskripsi.getText()
            + "' WHERE workshop_id = '" + txtID.getText() + "'";

    st.executeUpdate(update);
    JOptionPane.showMessageDialog(null, "Data berhasil diupdate");

    clearFields(); // Fungsi clearFields() untuk membersihkan nilai input setelah pembaruan data
    ShowData(); // Fungsi ShowData() untuk menampilkan data yang sudah diperbarui
    } catch (SQLException e) {
        Logger.getLogger(addworkshop.class.getName()).log(Level.SEVERE, null, e);
    }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new Home().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    
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
            java.util.logging.Logger.getLogger(addworkshop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addworkshop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addworkshop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addworkshop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addworkshop().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tableWorkshop;
    private javax.swing.JTextField txtDeskripsi;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtKap;
    private javax.swing.JTextField txtLokasi;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtTanggal;
    // End of variables declaration//GEN-END:variables
}
