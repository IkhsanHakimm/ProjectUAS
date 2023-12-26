/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package workshop;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class daftar extends javax.swing.JFrame {

    
     
    
    public Statement st;
    public ResultSet rs;
    public Connection kon = konekdb.bukaKon();
    public daftar() {
        
        initComponents();
        ShowData();
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
                tabledaftar.setModel(model);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabledaftar = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabledaftar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabledaftar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabledaftarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabledaftar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabledaftarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabledaftarMouseClicked
        // TODO add your handling code here:
        int index = tabledaftar.getSelectedRow();
        TableModel model = tabledaftar.getModel();

        String id = model.getValueAt(index, 0).toString();
        String work = model.getValueAt(index, 1).toString();
        String lok= model.getValueAt(index, 3).toString();
        String jumlah = model.getValueAt(index, 4).toString();

        homeuser.setID(id);
        homeuser.setWorkshop(work);
        homeuser.setlokasi(lok);
        homeuser.setKuota(jumlah);

        homeuser.txtWorkshop.setText(homeuser.getWorkshop());
        homeuser.txtlokasi.setText(homeuser.getlokasi());
        homeuser.txtJumlah.setText(homeuser.getKuota());

        String TicketCode = homeuser.txtWorkshop.getText();
        homeuser.generateDaftarCode(TicketCode.substring(TicketCode.length() - 1));
        dispose();
    }//GEN-LAST:event_tabledaftarMouseClicked

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
            java.util.logging.Logger.getLogger(daftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(daftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(daftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(daftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new daftar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabledaftar;
    // End of variables declaration//GEN-END:variables
}
