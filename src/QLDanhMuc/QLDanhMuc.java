/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package QLDanhMUc;
import QLDanhMuc.DanhMuc;
import QLDanhMuc.TTDanhMuc;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author User
 */
public class QLDanhMuc extends javax.swing.JPanel {

    /**
     * Creates new form QLDanhMuc
     */
    public QLDanhMuc() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnKhachHang = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDanhMuc = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        panelBoderCircle1 = new PanelBoder.PanelBoderCircle();
        panelBoderCircle2 = new PanelBoder.PanelBoderCircle();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        panelBoderFrm1 = new PanelBoder.PanelBoderFrm();
        jLabel1 = new javax.swing.JLabel();
        txtMaDM = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTenDM = new javax.swing.JTextField();
        panelBoderFrm2 = new PanelBoder.PanelBoderFrm();
        btnThemDanhMuc = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        panelBoderFrm3 = new PanelBoder.PanelBoderFrm();
        btnTimKiem = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();

        jpnKhachHang.setBackground(new java.awt.Color(0, 51, 102));

        tblDanhMuc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã danh mục", "Tên danh mục"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblDanhMuc.setSelectionBackground(new java.awt.Color(0, 153, 153));
        tblDanhMuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhMucMouseClicked(evt);
            }
        });
        tblDanhMuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblDanhMucKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tblDanhMuc);

        jPanel1.setLayout(new java.awt.GridLayout(1, 4, 2, 2));

        jPanel3.setBackground(new java.awt.Color(253, 240, 205));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 102));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Thông tin danh mục");

        panelBoderCircle1.setBackground(new java.awt.Color(0, 51, 102));
        panelBoderCircle1.setForeground(new java.awt.Color(0, 51, 102));

        javax.swing.GroupLayout panelBoderCircle1Layout = new javax.swing.GroupLayout(panelBoderCircle1);
        panelBoderCircle1.setLayout(panelBoderCircle1Layout);
        panelBoderCircle1Layout.setHorizontalGroup(
            panelBoderCircle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );
        panelBoderCircle1Layout.setVerticalGroup(
            panelBoderCircle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        panelBoderCircle2.setBackground(new java.awt.Color(0, 51, 102));
        panelBoderCircle2.setForeground(new java.awt.Color(0, 51, 102));

        javax.swing.GroupLayout panelBoderCircle2Layout = new javax.swing.GroupLayout(panelBoderCircle2);
        panelBoderCircle2.setLayout(panelBoderCircle2Layout);
        panelBoderCircle2Layout.setHorizontalGroup(
            panelBoderCircle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );
        panelBoderCircle2Layout.setVerticalGroup(
            panelBoderCircle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBoderCircle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBoderCircle2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelBoderCircle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(panelBoderCircle2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(253, 240, 205));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 102));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Danh sách danh mục");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(15, 15, 15))
        );

        panelBoderFrm1.setBackground(new java.awt.Color(253, 240, 205));

        jLabel1.setBackground(new java.awt.Color(0, 204, 204));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Mã danh mục:");

        txtMaDM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaDMActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Tên danh mục");

        txtTenDM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenDMActionPerformed(evt);
            }
        });

        panelBoderFrm2.setBackground(new java.awt.Color(0, 51, 102));

        btnThemDanhMuc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemDanhMuc.setText("Thêm");
        btnThemDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDanhMucActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnCapNhat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCapNhat.setText("Sửa");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBoderFrm2Layout = new javax.swing.GroupLayout(panelBoderFrm2);
        panelBoderFrm2.setLayout(panelBoderFrm2Layout);
        panelBoderFrm2Layout.setHorizontalGroup(
            panelBoderFrm2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThemDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBoderFrm2Layout.setVerticalGroup(
            panelBoderFrm2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelBoderFrm2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBoderFrm2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThemDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        panelBoderFrm3.setBackground(new java.awt.Color(0, 51, 102));

        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btnTimKiem.setText("Tìm kiếm danh mục");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nhập thông tin :");

        javax.swing.GroupLayout panelBoderFrm3Layout = new javax.swing.GroupLayout(panelBoderFrm3);
        panelBoderFrm3.setLayout(panelBoderFrm3Layout);
        panelBoderFrm3Layout.setHorizontalGroup(
            panelBoderFrm3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBoderFrm3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnTimKiem)
                .addContainerGap())
        );
        panelBoderFrm3Layout.setVerticalGroup(
            panelBoderFrm3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBoderFrm3Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(panelBoderFrm3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout panelBoderFrm1Layout = new javax.swing.GroupLayout(panelBoderFrm1);
        panelBoderFrm1.setLayout(panelBoderFrm1Layout);
        panelBoderFrm1Layout.setHorizontalGroup(
            panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBoderFrm2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelBoderFrm1Layout.createSequentialGroup()
                        .addGroup(panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBoderFrm1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaDM, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBoderFrm1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTenDM, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelBoderFrm3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelBoderFrm1Layout.setVerticalGroup(
            panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaDM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenDM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(271, 271, 271)
                .addComponent(panelBoderFrm2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(panelBoderFrm3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("QUẢN LÝ DANH MỤC");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel11)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 83, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 17, Short.MAX_VALUE)
                    .addComponent(jLabel11)
                    .addGap(0, 18, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jpnKhachHangLayout = new javax.swing.GroupLayout(jpnKhachHang);
        jpnKhachHang.setLayout(jpnKhachHangLayout);
        jpnKhachHangLayout.setHorizontalGroup(
            jpnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpnKhachHangLayout.createSequentialGroup()
                        .addGroup(jpnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelBoderFrm1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpnKhachHangLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(jpnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpnKhachHangLayout.createSequentialGroup()
                    .addGap(429, 429, 429)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(640, Short.MAX_VALUE)))
        );
        jpnKhachHangLayout.setVerticalGroup(
            jpnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBoderFrm1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap())
            .addGroup(jpnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpnKhachHangLayout.createSequentialGroup()
                    .addContainerGap(814, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblDanhMucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhMucMouseClicked

    }//GEN-LAST:event_tblDanhMucMouseClicked

    private void tblDanhMucKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblDanhMucKeyReleased

    }//GEN-LAST:event_tblDanhMucKeyReleased

    private void txtMaDMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaDMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaDMActionPerformed

    private void txtTenDMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenDMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenDMActionPerformed

    private void btnThemDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDanhMucActionPerformed
        //        // Khi nhấn nút thêm sản phẩm
        //        // Lấy thông tin từ các JTextField
        String maDM = txtMaDM.getText();
        String tenDM = txtTenDM.getText();
        //        double giaTien = Double.parseDouble(txtGia.getText());
        //        String moTa = txtMoTa.getText();
        //        String donViTinh = txtDVT.getText();
        //        String xuatXu = txtXuatXu.getText();
        //        int soLuongTonKho = Integer.parseInt(txtSoLuongTonKho.getText());
        //
        //        // Tạo đối tượng sản phẩm
        TTDanhMuc dm = new TTDanhMuc(maDM, tenDM);
        //
        //        // Thêm sản phẩm vào cơ sở dữ liệu
        DanhMuc danhMuc = new DanhMuc();
        boolean success = danhMuc.themDanhMucMoi(dm);
        //
        if (success) {
            JOptionPane.showMessageDialog(this, "Thêm danh mục thành công!");

            // Thêm sản phẩm mới vào bảng
            DefaultTableModel model = (DefaultTableModel) tblDanhMuc.getModel();
            model.addRow(new Object[]{maDM, tenDM});

            // Sắp xếp bảng theo mã sản phẩm
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(tblDanhMuc.getModel());
            tblDanhMuc.setRowSorter(sorter);
            List<RowSorter.SortKey> sortKeys = new ArrayList<>();

            // Sắp xếp theo cột Mã sản phẩm (giả sử cột đầu tiên là Mã sản phẩm)
            sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING)); // Cột 0 là cột Mã sản phẩm
            sorter.setSortKeys(sortKeys);
            sorter.sort();

            // Chọn dòng cuối cùng trong bảng sau khi sắp xếp
            int rowCount = tblDanhMuc.getRowCount();
            if (rowCount > 0) {
                tblDanhMuc.setRowSelectionInterval(rowCount - 1, rowCount - 1); // Chọn dòng cuối
                tblDanhMuc.scrollRectToVisible(tblDanhMuc.getCellRect(rowCount - 1, 0, true)); // Cuộn đến dòng cuối
            }
        } else {
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi thêm sản phẩm.");
        }
    }//GEN-LAST:event_btnThemDanhMucActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        //        // Kiểm tra xem có dòng nào được chọn trong bảng không
        int selectedRow = tblDanhMuc.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần xóa.");
            return;
        }
        //
        // Lấy mã sản phẩm của dòng được chọn
        String maDM = tblDanhMuc.getValueAt(selectedRow, 0).toString();  // Cột 0 là cột MaSP

        // Xác nhận việc xóa sản phẩm
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa danh mục này không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Xóa sản phẩm từ cơ sở dữ liệu Neo4j
            DanhMuc danhMuc = new DanhMuc();
            boolean success = danhMuc.xoaDanhMuc(maDM);

            if (success) {
                // Xóa dòng khỏi bảng
                DefaultTableModel model = (DefaultTableModel) tblDanhMuc.getModel();
                model.removeRow(selectedRow);

                JOptionPane.showMessageDialog(this, "Danh mục đã được xóa thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi xóa danh mục.");
            }

            danhMuc.closeConnection();  // Đóng kết nối Neo4j
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        // Kiểm tra xem có dòng nào được chọn trong bảng không
        int selectedRow = tblDanhMuc.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn danh mục cần sửa.");
            return;
        }

        // Lấy thông tin từ các trường nhập liệu
        String maDM = txtMaDM.getText();
        String tenDM = txtTenDM.getText();

        // Tạo đối tượng sản phẩm với thông tin mới
        TTDanhMuc sp = new TTDanhMuc(maDM, tenDM);

        // Sửa sản phẩm trong cơ sở dữ liệu
        DanhMuc danhMuc = new DanhMuc();
        boolean success = danhMuc.suaDanhMuc(sp);

        if (success) {
            // Cập nhật bảng hiển thị
            DefaultTableModel model = (DefaultTableModel) tblDanhMuc.getModel();
            model.setValueAt(sp.getMaDM(), selectedRow, 0);  // Cập nhật MaSP tại dòng được chọn
            model.setValueAt(sp.getTenDM(), selectedRow, 1); // Cập nhật TenSP tại dòng được chọn

            JOptionPane.showMessageDialog(this, "Danh mục đã được sửa thành công!");
        } else {
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi sửa danh mục.");
        }

        danhMuc.closeConnection();  // Đóng kết nối Neo4j
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // Đặt lại tất cả các JTextField về trống
        txtMaDM.setText("");         // Reset mã sản phẩm
        txtTenDM.setText("");        // Reset tên sản phẩm
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        String tuKhoa = txtTimKiem.getText().trim(); // Lấy từ khóa từ text field
        if (!tuKhoa.isEmpty()) {
            DanhMuc danhMuc = new DanhMuc(); // Tạo đối tượng SanPham để truy cập hàm tìm kiếm
            List<TTDanhMuc> danhSachTimKiem = danhMuc.timKiemDanhMuc(tuKhoa);

            // Cập nhật dữ liệu vào bảng
            DefaultTableModel model = (DefaultTableModel) tblDanhMuc.getModel();
            model.setRowCount(0); // Xóa dữ liệu cũ trên bảng

            for (TTDanhMuc sp : danhSachTimKiem) {
                model.addRow(new Object[]{
                    sp.getMaDM(),
                    sp.getTenDM(),
                });
            }

            danhMuc.closeConnection(); // Đóng kết nối sau khi tìm kiếm xong
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập từ khóa để tìm kiếm!", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnThemDanhMuc;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel jpnKhachHang;
    private PanelBoder.PanelBoderCircle panelBoderCircle1;
    private PanelBoder.PanelBoderCircle panelBoderCircle2;
    private PanelBoder.PanelBoderFrm panelBoderFrm1;
    private PanelBoder.PanelBoderFrm panelBoderFrm2;
    private PanelBoder.PanelBoderFrm panelBoderFrm3;
    private javax.swing.JTable tblDanhMuc;
    private javax.swing.JTextField txtMaDM;
    private javax.swing.JTextField txtTenDM;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
