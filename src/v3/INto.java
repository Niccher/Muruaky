/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v3;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.awt.Dimension;
import java.io.File;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author nicch
 */
public class INto extends javax.swing.JFrame {
    ResultSet rs=null;
    Connection Conn=null;
    PreparedStatement pst=null;
    Statement smt;
    
    String lst,lst2,Patt;

    /**
     * Creates new form INto
     */
    public INto() {
        initComponents();
        Conn=(Connection) Dbsv2.InitDb();
        Dimension dim=getToolkit().getScreenSize();
        int jframWidth=this.getSize().width;
        int jframHeight=this.getSize().height;
        int locationX=(dim.width-jframWidth)/2;
        int locationY=(dim.height-jframHeight)/2;
        this.setLocation(locationX, locationY);
    }
    
    private void Nm(){
        try {
                String sql="SELECT `Test` FROM `tbl_Tests` ORDER BY `Count` DESC LIMIT 1";
                pst= (PreparedStatement) Conn.prepareStatement(sql);
                rs=pst.executeQuery();
                if (rs.next()) {
                    lst=rs.getString("Test");
                }
                
                String sql2="SELECT `Test` FROM `tbl_Tests` WHERE Count=(SELECT MAX(Count)-1 FROM `tbl_Tests`) ";
                pst= (PreparedStatement) Conn.prepareStatement(sql2);
                rs=pst.executeQuery();
                if (rs.next()) {
                    lst2=rs.getString("Test");
                }

                //Toolkit.getDefaultToolkit().beep();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\nCurrent Exam Table Error");
            //Toolkit.getDefaultToolkit().beep();
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

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Dsp = new javax.swing.JTable();
        CsvGt = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Dsp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(Dsp);

        CsvGt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CsvGtMouseClicked(evt);
            }
        });
        CsvGt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CsvGtActionPerformed(evt);
            }
        });

        jRadioButton1.setText("jRadioButton1");
        jRadioButton1.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jButton1)
                        .addGap(146, 146, 146)
                        .addComponent(CsvGt, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioButton1))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(CsvGt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jRadioButton1)))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Nm();
        try {
            //String sql="SELECT `Reg_No` FROM `tbl_Placer` WHERE `Class`='Form4' AND `Geography`=1 ";
            String sql="SELECT Reg_No INTO "+lst+" FROM `tbl_Placer` WHERE `Class`='Form4' AND `Geography`=1 ";
            pst=(PreparedStatement) Conn.prepareStatement(sql);
            rs=pst.executeQuery();
            Dsp.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e+"\nNo Such Table");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void CsvGtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CsvGtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CsvGtActionPerformed

    private void CsvGtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CsvGtMouseClicked
        // TODO add your handling code here:
        try {
            JFileChooser prip=new JFileChooser();
            FileFilter flft=new FileNameExtensionFilter("2 Only", new String []{"csv","png","jpeg","jpg"});

            prip.setFileFilter(flft);
            prip.addChoosableFileFilter(flft);
            int rtn=prip.showOpenDialog(null);
            
            if (rtn==JFileChooser.APPROVE_OPTION) {
                File f= new File(prip.getSelectedFile().getAbsolutePath());//prip.getSelectedFile();
                Patt=f.getAbsolutePath();
                CsvGt.setText(Patt);
            }
            
            String Parr=Patt;
            String cv=".png";
            Pattern r = Pattern.compile(cv);

            Matcher m = r.matcher(Parr);

            
            if (m.find( )) {
               jRadioButton1.setEnabled(Boolean.TRUE);
            } 

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Null or Invalid 'Image' File");
        }
    }//GEN-LAST:event_CsvGtMouseClicked

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
            java.util.logging.Logger.getLogger(INto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(INto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(INto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(INto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new INto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CsvGt;
    private javax.swing.JTable Dsp;
    private javax.swing.JButton jButton1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}