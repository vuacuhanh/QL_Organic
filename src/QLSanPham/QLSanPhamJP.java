/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package QLSanPham;
import QLDanhMuc.DanhMuc;
import QLDanhMuc.TTDanhMuc;
import QLSanPham.SanPham;
import QLSanPham.TTSanPham;
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
public class QLSanPhamJP extends javax.swing.JPanel {
    private SanPham sanPham; // Đối tượng để lấy danh sách sản phẩm
    private DefaultTableModel tableModel; // Model cho JTable
    /**
     * Creates new form QLSanPhamJP
     */
    public QLSanPhamJP() {
        initComponents();
        sanPham = new SanPham(); // Khởi tạo đối tượng SanPham
        tableModel = (DefaultTableModel) tblSanPham.getModel(); // Lấy model từ JTable
        loadProducts(); // Gọi hàm để load sản phẩm vào bảng
        loadDanhMuc();     
        loadSanPham(); 
        
         // Thêm listener cho tblSanPham
        tblSanPham.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) { // Chỉ xử lý khi sự kiện không đang điều chỉnh
                    int selectedRow = tblSanPham.getSelectedRow(); // Lấy chỉ số hàng được chọn
                    if (selectedRow != -1) { // Kiểm tra xem có hàng nào được chọn không
                        // Lấy thông tin sản phẩm từ hàng được chọn
                        updateFieldsFromSelectedRow(selectedRow);
                    }
                }
            }
        });
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnTimKiemActionPerformed(evt);
    }
    });
    }
    private void loadProducts() {
        // Lấy danh sách sản phẩm
        List<TTSanPham> danhSach = sanPham.getDanhSachSanPham();

        // Xóa tất cả dữ liệu hiện có trong bảng
        tableModel.setRowCount(0);

        // Thêm dữ liệu sản phẩm vào bảng
        for (TTSanPham sp : danhSach) {
            Object[] row = {
                sp.getMaSP(),
                sp.getTenSP(),
                sp.getGiaTien(),
                sp.getMoTa(),
                sp.getDonViTinh(),
                sp.getXuatXu(),
                sp.getSoLuongTonKho()
            };
            tableModel.addRow(row); // Thêm hàng vào bảng
        }
    }
    private void updateFieldsFromSelectedRow(int selectedRow) {
        // Lấy giá trị từ bảng
        String maSP = (String) tableModel.getValueAt(selectedRow, 0);
        String tenSP = (String) tableModel.getValueAt(selectedRow, 1);
        double gia = (Double) tableModel.getValueAt(selectedRow, 2);
        String moTa = (String) tableModel.getValueAt(selectedRow, 3);
        String dvt = (String) tableModel.getValueAt(selectedRow, 4);
        String xuatXu = (String) tableModel.getValueAt(selectedRow, 5);
        int soLuongTonKho = (Integer) tableModel.getValueAt(selectedRow, 6);

        // Cập nhật các JTextField
        txtMaSP.setText(maSP);
        txtTenSP.setText(tenSP);
        txtGia.setText(String.valueOf(gia));
        txtMoTa.setText(moTa);
        txtDVT.setText(dvt);
        txtXuatXu.setText(xuatXu);
        txtSoLuongTonKho.setText(String.valueOf(soLuongTonKho));
    }
    // Hàm load danh mục lên combobox1
    private void loadDanhMuc() {
    DanhMuc danhMuc = new DanhMuc();  // Tạo đối tượng DanhMuc để truy cập hàm lấy danh mục
    List<TTDanhMuc> danhMucList = danhMuc.getDanhSachDanhMuc();  // Lấy danh sách danh mục

    jComboBox1.removeAllItems();  // Xóa các item cũ trong combobox

    // Thay đổi ở đây: thêm mã danh mục vào combobox1
    for (TTDanhMuc dm : danhMucList) {
        jComboBox1.addItem(dm.getMaDM() + " - " + dm.getTenDM());  // Thêm mã và tên danh mục vào combobox1
    }

    danhMuc.closeConnection();  // Đóng kết nối sau khi lấy danh mục xong
    }
    // Hàm load tên sản phẩm lên combobox2
    private void loadSanPham() {
        SanPham sanPham = new SanPham();  // Tạo đối tượng SanPham để truy cập hàm lấy sản phẩm
        List<TTSanPham> sanPhamList = sanPham.getDanhSachSanPham();  // Lấy danh sách sản phẩm bao gồm cả mã và tên
        jComboBox2.removeAllItems();  // Xóa các item cũ trong combobox2
    // Thêm mã và tên sản phẩm vào combobox2
        for (TTSanPham sp : sanPhamList) {
            jComboBox2.addItem(sp.getMaSP() + " - " + sp.getTenSP());  // Thêm mã và tên sản phẩm vào combobox2
        }

        sanPham.closeConnection();  // Đóng kết nối sau khi lấy sản phẩm xong
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
        tblSanPham = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        panelBoderCircle1 = new PanelBoder.PanelBoderCircle();
        panelBoderCircle2 = new PanelBoder.PanelBoderCircle();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        panelBoderFrm1 = new PanelBoder.PanelBoderFrm();
        jLabel1 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMoTa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDVT = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        panelBoderFrm2 = new PanelBoder.PanelBoderFrm();
        btnThemSanPham = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        txtGia = new javax.swing.JTextField();
        txtSoLuongTonKho = new javax.swing.JTextField();
        txtXuatXu = new javax.swing.JTextField();
        panelBoderFrm3 = new PanelBoder.PanelBoderFrm();
        btnTimKiem = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        panelBoderFrm4 = new PanelBoder.PanelBoderFrm();
        btnThemDM = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();

        jpnKhachHang.setBackground(new java.awt.Color(0, 51, 102));

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Giá tiền", "Mô tả", "Đơn vị tính", "Xuất xứ", "Số lượng tồn kho"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblSanPham.setSelectionBackground(new java.awt.Color(0, 153, 153));
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        tblSanPham.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblSanPhamKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tblSanPham);

        jPanel1.setLayout(new java.awt.GridLayout(1, 4, 2, 2));

        jPanel3.setBackground(new java.awt.Color(253, 240, 205));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 102));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Thông tin sản phẩm");

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
        jLabel13.setText("Danh sách sản phẩm");

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
        jLabel1.setText("Mã sản phẩm:");

        txtMaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSPActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Tên sản phẩm");

        txtTenSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenSPActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Giá tiền");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Mô tả");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Đơn vị tính");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Xuất xứ");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Số lượng tồn kho");

        panelBoderFrm2.setBackground(new java.awt.Color(0, 51, 102));

        btnThemSanPham.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemSanPham.setText("Thêm");
        btnThemSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSanPhamActionPerformed(evt);
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
        btnReset.setText("Refresh");
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
                .addComponent(btnThemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBoderFrm2Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(panelBoderFrm2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBoderFrm2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );

        panelBoderFrm3.setBackground(new java.awt.Color(0, 51, 102));

        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btnTimKiem.setText("Tìm kiếm sản phẩm");
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
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnTimKiem)
                .addContainerGap())
        );
        panelBoderFrm3Layout.setVerticalGroup(
            panelBoderFrm3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBoderFrm3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelBoderFrm3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(24, 24, 24))
        );

        panelBoderFrm4.setBackground(new java.awt.Color(0, 51, 102));

        btnThemDM.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btnThemDM.setText("Thêm");
        btnThemDM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDMActionPerformed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Chọn danh mục :");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Chọn sản phẩm :");

        javax.swing.GroupLayout panelBoderFrm4Layout = new javax.swing.GroupLayout(panelBoderFrm4);
        panelBoderFrm4.setLayout(panelBoderFrm4Layout);
        panelBoderFrm4Layout.setHorizontalGroup(
            panelBoderFrm4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelBoderFrm4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBoderFrm4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(8, 8, 8))
                    .addGroup(panelBoderFrm4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(btnThemDM)
                .addGap(19, 19, 19))
        );
        panelBoderFrm4Layout.setVerticalGroup(
            panelBoderFrm4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelBoderFrm4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThemDM, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBoderFrm4Layout.createSequentialGroup()
                        .addGroup(panelBoderFrm4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBoderFrm4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDVT, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBoderFrm1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBoderFrm1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSoLuongTonKho, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBoderFrm1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBoderFrm1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBoderFrm1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBoderFrm1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelBoderFrm3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBoderFrm4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelBoderFrm1Layout.setVerticalGroup(
            panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoderFrm1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDVT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBoderFrm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoLuongTonKho, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBoderFrm2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBoderFrm3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBoderFrm4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("QUẢN LÝ SẢN PHẨM");

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
            .addGap(0, 60, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 6, Short.MAX_VALUE)
                    .addComponent(jLabel11)
                    .addGap(0, 6, Short.MAX_VALUE)))
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
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(jpnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpnKhachHangLayout.createSequentialGroup()
                    .addGap(429, 429, 429)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(680, Short.MAX_VALUE)))
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
                .addGroup(jpnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelBoderFrm1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap(57, Short.MAX_VALUE))
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

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked

    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void tblSanPhamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblSanPhamKeyReleased

    }//GEN-LAST:event_tblSanPhamKeyReleased

    private void txtMaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaSPActionPerformed

    private void txtTenSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenSPActionPerformed

    private void btnThemSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSanPhamActionPerformed
        // Khi nhấn nút thêm sản phẩm
        // Lấy thông tin từ các JTextField
        String maSP = txtMaSP.getText();
        String tenSP = txtTenSP.getText();
        double giaTien = Double.parseDouble(txtGia.getText());
        String moTa = txtMoTa.getText();
        String donViTinh = txtDVT.getText();
        String xuatXu = txtXuatXu.getText();
        int soLuongTonKho = Integer.parseInt(txtSoLuongTonKho.getText());

        // Tạo đối tượng sản phẩm
        TTSanPham sp = new TTSanPham(maSP, tenSP, giaTien, moTa, donViTinh, xuatXu, soLuongTonKho);

        // Thêm sản phẩm vào cơ sở dữ liệu
        SanPham sanPham = new SanPham();
        boolean success = sanPham.themSanPhamMoi(sp);

        if (success) {
            JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công!");

            // Thêm sản phẩm mới vào bảng
            DefaultTableModel model = (DefaultTableModel) tblSanPham.getModel();
            model.addRow(new Object[]{maSP, tenSP, giaTien, moTa, donViTinh, xuatXu, soLuongTonKho});

            // Sắp xếp bảng theo mã sản phẩm
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(tblSanPham.getModel());
            tblSanPham.setRowSorter(sorter);
            List<RowSorter.SortKey> sortKeys = new ArrayList<>();

            // Sắp xếp theo cột Mã sản phẩm (giả sử cột đầu tiên là Mã sản phẩm)
            sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING)); // Cột 0 là cột Mã sản phẩm
            sorter.setSortKeys(sortKeys);
            sorter.sort();

            // Chọn dòng cuối cùng trong bảng sau khi sắp xếp
            int rowCount = tblSanPham.getRowCount();
            if (rowCount > 0) {
                tblSanPham.setRowSelectionInterval(rowCount - 1, rowCount - 1); // Chọn dòng cuối
                tblSanPham.scrollRectToVisible(tblSanPham.getCellRect(rowCount - 1, 0, true)); // Cuộn đến dòng cuối
            }
        } else {
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi thêm sản phẩm.");
        }
    }//GEN-LAST:event_btnThemSanPhamActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // Kiểm tra xem có dòng nào được chọn trong bảng không
        int selectedRow = tblSanPham.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần xóa.");
            return;
        }

        // Lấy mã sản phẩm của dòng được chọn
        String maSP = tblSanPham.getValueAt(selectedRow, 0).toString();  // Cột 0 là cột MaSP

        // Xác nhận việc xóa sản phẩm
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa sản phẩm này không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Xóa sản phẩm từ cơ sở dữ liệu Neo4j
            SanPham sanPham = new SanPham();
            boolean success = sanPham.xoaSanPham(maSP);

            if (success) {
                // Xóa dòng khỏi bảng
                DefaultTableModel model = (DefaultTableModel) tblSanPham.getModel();
                model.removeRow(selectedRow);

                JOptionPane.showMessageDialog(this, "Sản phẩm đã được xóa thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi xóa sản phẩm.");
            }

            sanPham.closeConnection();  // Đóng kết nối Neo4j
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        // Kiểm tra xem có dòng nào được chọn trong bảng không
        int selectedRow = tblSanPham.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần sửa.");
            return;
        }

        // Lấy thông tin từ các trường nhập liệu
        String maSP = txtMaSP.getText();
        String tenSP = txtTenSP.getText();
        double giaTien = Double.parseDouble(txtGia.getText());
        String moTa = txtMoTa.getText();
        String donViTinh = txtDVT.getText();
        String xuatXu = txtXuatXu.getText();
        int soLuongTonKho = Integer.parseInt(txtSoLuongTonKho.getText());

        // Tạo đối tượng sản phẩm với thông tin mới
        TTSanPham sp = new TTSanPham(maSP, tenSP, giaTien, moTa, donViTinh, xuatXu, soLuongTonKho);

        // Sửa sản phẩm trong cơ sở dữ liệu
        SanPham sanPham = new SanPham();
        boolean success = sanPham.suaSanPham(sp);

        if (success) {
            // Cập nhật bảng hiển thị
            DefaultTableModel model = (DefaultTableModel) tblSanPham.getModel();
            model.setValueAt(sp.getMaSP(), selectedRow, 0);  // Cập nhật MaSP tại dòng được chọn
            model.setValueAt(sp.getTenSP(), selectedRow, 1); // Cập nhật TenSP tại dòng được chọn
            model.setValueAt(sp.getGiaTien(), selectedRow, 2); // Cập nhật GiaTien tại dòng được chọn
            model.setValueAt(sp.getMoTa(), selectedRow, 3); // Cập nhật MoTa tại dòng được chọn
            model.setValueAt(sp.getDonViTinh(), selectedRow, 4); // Cập nhật DonViTinh tại dòng được chọn
            model.setValueAt(sp.getXuatXu(), selectedRow, 5); // Cập nhật XuatXu tại dòng được chọn
            model.setValueAt(sp.getSoLuongTonKho(), selectedRow, 6); // Cập nhật SoLuongTonKho tại dòng được chọn

            JOptionPane.showMessageDialog(this, "Sản phẩm đã được sửa thành công!");
        } else {
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi sửa sản phẩm.");
        }

        sanPham.closeConnection();  // Đóng kết nối Neo4j
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // Đặt lại tất cả các JTextField về trống
        txtMaSP.setText("");         // Reset mã sản phẩm
        txtTenSP.setText("");        // Reset tên sản phẩm
        txtGia.setText("");          // Reset giá tiền
        txtMoTa.setText("");         // Reset mô tả
        txtDVT.setText("");          // Reset đơn vị tính
        txtXuatXu.setText("");       // Reset xuất xứ
        txtSoLuongTonKho.setText(""); // Reset số lượng tồn kho

        loadProducts();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        String tuKhoa = txtTimKiem.getText().trim(); // Lấy từ khóa từ text field
        if (!tuKhoa.isEmpty()) {
            SanPham sanPham = new SanPham(); // Tạo đối tượng SanPham để truy cập hàm tìm kiếm
            List<TTSanPham> danhSachTimKiem = sanPham.timKiemSanPham(tuKhoa);

            // Cập nhật dữ liệu vào bảng
            DefaultTableModel model = (DefaultTableModel) tblSanPham.getModel();
            model.setRowCount(0); // Xóa dữ liệu cũ trên bảng

            for (TTSanPham sp : danhSachTimKiem) {
                model.addRow(new Object[]{
                    sp.getMaSP(),
                    sp.getTenSP(),
                    sp.getGiaTien(),
                    sp.getMoTa(),
                    sp.getDonViTinh(),
                    sp.getXuatXu(),
                    sp.getSoLuongTonKho()
                });
            }

            sanPham.closeConnection(); // Đóng kết nối sau khi tìm kiếm xong
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập từ khóa để tìm kiếm!", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnThemDMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDMActionPerformed
        // Lấy mã sản phẩm từ ComboBox2 (phân tách mã và tên)
        String selectedSP = jComboBox2.getSelectedItem().toString();
        String maSP = selectedSP.split(" - ")[0];  // Tách mã sản phẩm từ chuỗi (VD: "SP001 - Tên sản phẩm")

        // Lấy mã danh mục từ ComboBox1 (phân tách mã và tên)
        String selectedDM = jComboBox1.getSelectedItem().toString();
        String maDM = selectedDM.split(" - ")[0];  // Tách mã danh mục từ chuỗi (VD: "DM001 - Tên danh mục")

        // Kiểm tra log xem các giá trị có chính xác không
        System.out.println("Mã sản phẩm: " + maSP);
        System.out.println("Mã danh mục: " + maDM);

        // Gọi hàm thêm sản phẩm vào danh mục
        SanPham sanPham = new SanPham();
        boolean success = sanPham.themSanPhamVaoDanhMuc(maSP, maDM);

        // Kiểm tra kết quả của việc thêm
        if (success) {
            System.out.println("Thêm thành công sản phẩm vào danh mục!");
            JOptionPane.showMessageDialog(this, "Thêm sản phẩm vào danh mục thành công!");
        } else {
            System.out.println("Có lỗi xảy ra khi thêm sản phẩm vào danh mục.");
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi thêm sản phẩm vào danh mục.");
        }

        sanPham.closeConnection();  // Đóng kết nối Neo4j sau khi hoàn thành
    }//GEN-LAST:event_btnThemDMActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnThemDM;
    private javax.swing.JButton btnThemSanPham;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
    private PanelBoder.PanelBoderFrm panelBoderFrm4;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtDVT;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtMoTa;
    private javax.swing.JTextField txtSoLuongTonKho;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtXuatXu;
    // End of variables declaration//GEN-END:variables
}
