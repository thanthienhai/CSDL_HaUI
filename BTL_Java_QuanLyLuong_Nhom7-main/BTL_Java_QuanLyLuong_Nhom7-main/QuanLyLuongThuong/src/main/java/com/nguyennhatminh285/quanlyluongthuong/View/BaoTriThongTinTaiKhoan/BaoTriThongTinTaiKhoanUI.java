/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.nguyennhatminh285.quanlyluongthuong.View.BaoTriThongTinTaiKhoan;

import com.nguyennhatminh285.quanlyluongthuong.Controller.BaoTriThongTinTaiKhoanController;
import com.nguyennhatminh285.quanlyluongthuong.Model.TaiKhoan;
import com.nguyennhatminh285.quanlyluongthuong.View.TuyChonUI;
import com.nguyennhatminh285.quanlyluongthuong.util.IOptionEvent;
import com.nguyennhatminh285.quanlyluongthuong.util.IUpdateTableEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class BaoTriThongTinTaiKhoanUI extends javax.swing.JFrame {
    private BaoTriThongTinTaiKhoanController controller;
    private HashMap<String, Object> data;
    
    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }
    
    /**
     * Creates new form BaoTriThongTinTaiKhoanUI
     */
    public BaoTriThongTinTaiKhoanUI() throws SQLException {
        initComponents();
        setLocationRelativeTo(null);
        txtTenTaiKhoan.requestFocus();
        cboQuyen.setSelectedIndex(0);
        
        controller = new BaoTriThongTinTaiKhoanController();
        UpdateData();
        
        controller.setUpdateTableEvent(new IUpdateTableEvent() {
            @Override
            public void onUpdateDataOnTableEvent() {
                try {
                    UpdateData();
                } catch (SQLException ex) {
                    Logger.getLogger(BaoTriThongTinTaiKhoanUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    public void UpdateData() throws SQLException
    {
        ArrayList<TaiKhoan> taiKhoans = controller.onQueryAllTaiKhoan();
        
        DefaultTableModel defaultTableModel = (DefaultTableModel)tblTaiKhoan.getModel();
        
        while(defaultTableModel.getRowCount() > 0){
            defaultTableModel.removeRow(0);
        }
        
        for (TaiKhoan taiKhoan : taiKhoans) {
            defaultTableModel.addRow(taiKhoan.toObjectArrayData());
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaTaiKhoan = new javax.swing.JTextField();
        txtTenTaiKhoan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cboQuyen = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTaiKhoan = new javax.swing.JTable();
        txtMatKhau = new javax.swing.JTextField();
        btnXoaThongTin = new javax.swing.JButton();
        btnThemTaiKhoan = new javax.swing.JButton();
        btnSuaTaiKhoan = new javax.swing.JButton();
        btnXoaTaiKhoan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bảo Trì Thông Tin Tài Khoản");

        jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getStyle() | java.awt.Font.BOLD, jLabel1.getFont().getSize()+11));
        jLabel1.setText("Bảo Trì Thông Tin Tài Khoản");

        jLabel2.setFont(jLabel2.getFont().deriveFont(jLabel2.getFont().getSize()+3f));
        jLabel2.setText("Mã Tài Khoản");

        txtMaTaiKhoan.setEditable(false);
        txtMaTaiKhoan.setFont(txtMaTaiKhoan.getFont().deriveFont(txtMaTaiKhoan.getFont().getSize()+3f));

        txtTenTaiKhoan.setFont(txtTenTaiKhoan.getFont().deriveFont(txtTenTaiKhoan.getFont().getSize()+3f));

        jLabel3.setFont(jLabel3.getFont().deriveFont(jLabel3.getFont().getSize()+3f));
        jLabel3.setText("Tên Tài Khoản");

        jLabel4.setFont(jLabel4.getFont().deriveFont(jLabel4.getFont().getSize()+3f));
        jLabel4.setText("Mật Khẩu");

        jLabel5.setFont(jLabel5.getFont().deriveFont(jLabel5.getFont().getSize()+3f));
        jLabel5.setText("Quyền");

        cboQuyen.setFont(cboQuyen.getFont().deriveFont(cboQuyen.getFont().getSize()+3f));
        cboQuyen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản Trị Viên", "Giảng Viên", "Kế Toán", "Nhân Sự", "Giám Đốc" }));

        tblTaiKhoan.setFont(tblTaiKhoan.getFont().deriveFont(tblTaiKhoan.getFont().getSize()+3f));
        tblTaiKhoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Tài Khoản", "Tên Tài Khoản", "Mật Khẩu", "Quyền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTaiKhoanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTaiKhoan);

        txtMatKhau.setFont(txtMatKhau.getFont().deriveFont(txtMatKhau.getFont().getSize()+3f));

        btnXoaThongTin.setFont(btnXoaThongTin.getFont().deriveFont(btnXoaThongTin.getFont().getSize()+3f));
        btnXoaThongTin.setText("Xóa Thông Tin");
        btnXoaThongTin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaThongTinActionPerformed(evt);
            }
        });

        btnThemTaiKhoan.setFont(btnThemTaiKhoan.getFont().deriveFont(btnThemTaiKhoan.getFont().getSize()+3f));
        btnThemTaiKhoan.setText("Thêm Tài Khoản");
        btnThemTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemTaiKhoanActionPerformed(evt);
            }
        });

        btnSuaTaiKhoan.setFont(btnSuaTaiKhoan.getFont().deriveFont(btnSuaTaiKhoan.getFont().getSize()+3f));
        btnSuaTaiKhoan.setText("Sửa Tài Khoản");
        btnSuaTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaTaiKhoanActionPerformed(evt);
            }
        });

        btnXoaTaiKhoan.setFont(btnXoaTaiKhoan.getFont().deriveFont(btnXoaTaiKhoan.getFont().getSize()+3f));
        btnXoaTaiKhoan.setText("Xóa Tài Khoản");
        btnXoaTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTaiKhoanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtMaTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addGap(49, 49, 49)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTenTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                                    .addComponent(cboQuyen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(230, 230, 230))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnThemTaiKhoan)
                        .addGap(18, 18, 18)
                        .addComponent(btnSuaTaiKhoan)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoaTaiKhoan)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoaThongTin)
                        .addGap(103, 103, 103))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoaThongTin)
                    .addComponent(btnThemTaiKhoan)
                    .addComponent(btnSuaTaiKhoan)
                    .addComponent(btnXoaTaiKhoan))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblTaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTaiKhoanMouseClicked
        int rowIndex = tblTaiKhoan.getSelectedRow();
        
        String maTaiKhoan = tblTaiKhoan.getValueAt(rowIndex, 0).toString();
        String tenTaiKhoan = tblTaiKhoan.getValueAt(rowIndex, 1).toString();
        String matKhau = tblTaiKhoan.getValueAt(rowIndex, 2).toString();
        String quyen = tblTaiKhoan.getValueAt(rowIndex, 3).toString();
        
        txtMaTaiKhoan.setText(maTaiKhoan);
        txtTenTaiKhoan.setText(tenTaiKhoan);
        txtMatKhau.setText(matKhau);
        
        for(int i = 0 ; i < cboQuyen.getItemCount() ; i++){
            if(cboQuyen.getItemAt(i).equalsIgnoreCase(quyen)){
                cboQuyen.setSelectedIndex(i);
            }
        }
    }//GEN-LAST:event_tblTaiKhoanMouseClicked

    private void btnThemTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemTaiKhoanActionPerformed
        TuyChonUI tuyChonUI = new TuyChonUI();
        tuyChonUI.setOnHandleOptionEvent(new IOptionEvent() {
            @Override
            public void onAcceptEvent() {
                if(validateData()) {
                    TaiKhoan taiKhoan = new TaiKhoan();
                    taiKhoan.setTaiKhoan(txtTenTaiKhoan.getText());
                    taiKhoan.setMatKhau(txtMatKhau.getText());
                    taiKhoan.setQuyen(cboQuyen.getSelectedIndex());
                    
                    clearAllInfo();
                    JOptionPane.showMessageDialog(getContentPane(), "Thêm Tài Khoản thành công!!");
                }
            }

            @Override
            public void onCancelEvent() {
                clearAllInfo();
            } 
        });
        
       tuyChonUI.onCallGUI(getContentPane(), "Bạn có chắc chắn muốn thêm Tài Khoản này không ?", "Thông Báo");
    }//GEN-LAST:event_btnThemTaiKhoanActionPerformed
    private boolean validateData() {
        String message = "";
        int numErr = 0;
        try {
            if(txtTenTaiKhoan.getText().trim().equalsIgnoreCase("")){
                message += "Tên tài khoản không được để trống!!\n";
                numErr += 1;
            }
            
            if(txtMatKhau.getText().trim().equalsIgnoreCase("")){
                message += "Mật khẩu không được để trống\n";
                numErr += 1;
            }
            
            if(numErr > 0){
                throw new Exception(message);
            }
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(getContentPane(), message);
        } 
        return false; 
    }
    private void clearAllInfo() {
        txtMaTaiKhoan.setText("");
        txtTenTaiKhoan.setText("");
        txtMatKhau.setText("");
        cboQuyen.setSelectedIndex(0);
    }

    private void btnSuaTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaTaiKhoanActionPerformed
        TuyChonUI tuyChonUI = new TuyChonUI();
        tuyChonUI.setOnHandleOptionEvent(new IOptionEvent() {
            @Override
            public void onAcceptEvent() {
                if(validateData()) {
                    if(txtMaTaiKhoan.getText().equals("")){
                        JOptionPane.showMessageDialog(getContentPane(), "Bạn chưa chọn Tài Khoản cần sửa!!");
                        return;
                    }
                    
                    TaiKhoan taiKhoan = new TaiKhoan();
                    taiKhoan.setMaTaiKhoan(Long.parseLong(txtMaTaiKhoan.getText().trim()));
                    taiKhoan.setTaiKhoan(txtTenTaiKhoan.getText().trim());
                    taiKhoan.setMatKhau(txtMatKhau.getText().trim());
                    taiKhoan.setQuyen(cboQuyen.getSelectedIndex());
                    
                    try {
                        controller.updateTaiKhoanByID(taiKhoan);
                    } catch (SQLException ex) {
                        Logger.getLogger(BaoTriThongTinTaiKhoanUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    clearAllInfo();
                    JOptionPane.showMessageDialog(getContentPane(), "Sửa Tài Khoản thành công!!");
                }
            }

            @Override
            public void onCancelEvent() {
                clearAllInfo();
            }
        });
        
        tuyChonUI.onCallGUI(getContentPane(), "Bạn có chắc chắn muốn sửa Tài Khoản này không ?", "Thông Báo");
    }//GEN-LAST:event_btnSuaTaiKhoanActionPerformed

    private void btnXoaTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaTaiKhoanActionPerformed
        TuyChonUI tuyChonUI = new TuyChonUI();
        tuyChonUI.setOnHandleOptionEvent(new IOptionEvent() {
            @Override
            public void onAcceptEvent() {
                if(validateData()) {
                    if(txtMaTaiKhoan.getText().equals("")){
                        JOptionPane.showMessageDialog(getContentPane(), "Bạn chưa chọn Tài Khoản cần xóa!!");
                        return;
                    }

                    try {
                        controller.deleteTaiKhoanByID(Long.parseLong(txtMaTaiKhoan.getText().trim()));
                    } catch (SQLException ex) {
                        Logger.getLogger(BaoTriThongTinTaiKhoanUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    clearAllInfo();
                    JOptionPane.showMessageDialog(getContentPane(), "Xóa Tài Khoản thành công!!");
                }
            }

            @Override
            public void onCancelEvent() {
                clearAllInfo();
            }
        });
        
        tuyChonUI.onCallGUI(getContentPane(), "Bạn có chắc chắn muốn xóa Tài Khoản này không ?", "Thông Báo");
    }//GEN-LAST:event_btnXoaTaiKhoanActionPerformed

    private void btnXoaThongTinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaThongTinActionPerformed
        TuyChonUI tuyChonUI = new TuyChonUI();
        tuyChonUI.setOnHandleOptionEvent(new IOptionEvent() {
            @Override
            public void onAcceptEvent() {
                if(validateData()){
                    clearAllInfo();
                    JOptionPane.showMessageDialog(getContentPane(), "Xóa thông tin thành công!!");
                }  
            }

            @Override
            public void onCancelEvent() {
                clearAllInfo();
            }
        });
        
        tuyChonUI.onCallGUI(getContentPane(), "Bạn có chắc chắn muốn xóa thông tin này không ?", "Thông Báo");
    }//GEN-LAST:event_btnXoaThongTinActionPerformed

    public void onStartGUI() {
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
            java.util.logging.Logger.getLogger(BaoTriThongTinTaiKhoanUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BaoTriThongTinTaiKhoanUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BaoTriThongTinTaiKhoanUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BaoTriThongTinTaiKhoanUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new BaoTriThongTinTaiKhoanUI().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(BaoTriThongTinTaiKhoanUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSuaTaiKhoan;
    private javax.swing.JButton btnThemTaiKhoan;
    private javax.swing.JButton btnXoaTaiKhoan;
    private javax.swing.JButton btnXoaThongTin;
    private javax.swing.JComboBox<String> cboQuyen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTaiKhoan;
    private javax.swing.JTextField txtMaTaiKhoan;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtTenTaiKhoan;
    // End of variables declaration//GEN-END:variables
}
