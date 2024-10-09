package QL_CuaHang;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class CuaHangGUI extends JFrame {
    private CuaHang cuaHang;
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField maCHField, tenCHField, diaChiField, emailField, sdtField, searchField;

    // Màu chủ đạo
    private Color navyBlue = new Color(36, 54, 101);
    private Color creamColor = new Color(255, 247, 230);

    public CuaHangGUI() {
        cuaHang = new CuaHang();
        setVisible(true);
        setTitle("Quản Lý Cửa Hàng");
        setFont(new Font("Arial", Font.BOLD, 30));
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(creamColor);

        // Tạo bảng
        String[] columns = {"Mã CH", "Tên CH", "Địa Chỉ", "Email", "SĐT", "Mã Khu Vực"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 450, 1100, 300);
        add(scrollPane);

        // Thêm sự kiện lắng nghe khi người dùng chọn một hàng trong bảng
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    maCHField.setText(tableModel.getValueAt(selectedRow, 0).toString());
                    tenCHField.setText(tableModel.getValueAt(selectedRow, 1).toString());
                    diaChiField.setText(tableModel.getValueAt(selectedRow, 2).toString());
                    emailField.setText(tableModel.getValueAt(selectedRow, 3).toString());
                    sdtField.setText(tableModel.getValueAt(selectedRow, 4).toString());
                }
            }
        });
        
        

        // Thiết lập font chữ và kích thước
        Font titleFont = new Font("Arial", Font.BOLD, 20);
        Font labelFont = new Font("Arial", Font.BOLD, 16);
        Font inputFont = new Font("Arial", Font.PLAIN, 14);
        Font buttonFont = new Font("Arial", Font.BOLD, 16);

        // Tiêu đề chính
        JLabel mainTitle = new JLabel("QUẢN LÝ CỬA HÀNG");
        mainTitle.setBounds(450, 10, 400, 40);
        mainTitle.setFont(new Font("Arial", Font.BOLD, 32));
        mainTitle.setForeground(navyBlue);
        add(mainTitle);

        // Panel bao quanh các trường nhập liệu
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(null);
        inputPanel.setBounds(50, 70, 500, 300);
        inputPanel.setBorder(BorderFactory.createTitledBorder(new LineBorder(navyBlue, 5), "Thông Tin Cửa Hàng", TitledBorder.LEFT, TitledBorder.TOP, labelFont, navyBlue));
        inputPanel.setBackground(creamColor);

        maCHField = createTextField(200, 40, inputFont);
        tenCHField = createTextField(200, 80, inputFont);
        diaChiField = createTextField(200, 120, inputFont);
        emailField = createTextField(200, 160, inputFont);
        sdtField = createTextField(200, 200, inputFont);

        inputPanel.add(createLabel("Mã CH:", 50, 40, labelFont));
        inputPanel.add(maCHField);
        inputPanel.add(createLabel("Tên CH:", 50, 80, labelFont));
        inputPanel.add(tenCHField);
        inputPanel.add(createLabel("Địa Chỉ:", 50, 120, labelFont));
        inputPanel.add(diaChiField);
        inputPanel.add(createLabel("Email:", 50, 160, labelFont));
        inputPanel.add(emailField);
        inputPanel.add(createLabel("SĐT:", 50, 200, labelFont));
        inputPanel.add(sdtField);

        add(inputPanel);

        // Panel bao quanh chức năng tìm kiếm
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(null);
        searchPanel.setBounds(600, 70, 500, 150);
        searchPanel.setBorder(BorderFactory.createTitledBorder(new LineBorder(navyBlue, 5), "Tìm Kiếm", TitledBorder.LEFT, TitledBorder.TOP, labelFont, navyBlue));
        searchPanel.setBackground(creamColor);

        // Tìm kiếm theo tên cửa hàng
        JLabel searchLabel = createLabel("Tìm kiếm:", 20, 40, labelFont);
        searchField = createTextField(140, 40, inputFont);
        JButton searchButton = createButton("Tìm", buttonFont);
        searchButton.setBounds(390, 40, 100, 30);
        searchButton.addActionListener(e -> searchStoreByName());

        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        
        add(searchPanel);

        // Bố trí nút chức năng
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBounds(50, 380, 1100, 50);

        JButton addButton = createButton("Thêm", buttonFont);
        addButton.addActionListener(e -> addStore());
        buttonPanel.add(addButton);

        JButton editButton = createButton("Sửa", buttonFont);
        editButton.addActionListener(e -> editStore());
        buttonPanel.add(editButton);

        JButton deleteButton = createButton("Xóa", buttonFont);
        deleteButton.addActionListener(e -> deleteStore());
        buttonPanel.add(deleteButton);

        JButton resetButton = createButton("Reset", buttonFont);
        resetButton.addActionListener(e -> resetFields());
        buttonPanel.add(resetButton);

        add(buttonPanel);

        loadData(); // Tải dữ liệu khi khởi động

        // Thêm viền cho trường nhập liệu
        addBorder(maCHField);
        addBorder(tenCHField);
        addBorder(diaChiField);
        addBorder(emailField);
        addBorder(sdtField);
    }

    // Tạo JLabel với các thuộc tính tùy chỉnh
    private JLabel createLabel(String text, int x, int y, Font font) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 150, 30);
        label.setFont(font);
        label.setForeground(navyBlue);
        return label;
    }

    // Tạo JTextField với các thuộc tính tùy chỉnh
    private JTextField createTextField(int x, int y, Font font) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, 250, 30);
        textField.setFont(font);
        return textField;
    }

    // Tạo JButton với các thuộc tính tùy chỉnh
    private JButton createButton(String text, Font font) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setForeground(Color.WHITE);
        button.setBackground(navyBlue);
        button.setFocusPainted(false);
        return button;
    }

    // Thêm viền cho JTextField
    private void addBorder(JTextField textField) {
        textField.setBorder(new LineBorder(navyBlue, 2));
    }

    private void loadData() {
        tableModel.setRowCount(0);

        List<TTCuaHang> danhSachCuaHang = cuaHang.getDanhSachCuaHang();
        Set<String> maCuaHangSet = new HashSet<>();

        for (TTCuaHang cuaHang : danhSachCuaHang) {
            if (cuaHang.getMaCH() != null && !cuaHang.getMaCH().isEmpty() &&
                maCuaHangSet.add(cuaHang.getMaCH())) {
                
                Object[] rowData = {
                    cuaHang.getMaCH(),
                    cuaHang.getTenCH(),
                    cuaHang.getDiaChi(),
                    cuaHang.getEmail(),
                    cuaHang.getSDT(),
                    cuaHang.getMaKhuVuc()
                };
                tableModel.addRow(rowData);
            }
        }
    }

    // Tìm kiếm cửa hàng theo tên
    private void searchStoreByName() {
        String searchTerm = searchField.getText().toLowerCase();
        tableModel.setRowCount(0);

        for (TTCuaHang cuaHang : cuaHang.getDanhSachCuaHang()) {
            if (cuaHang.getTenCH().toLowerCase().contains(searchTerm)) {
                Object[] rowData = {
                    cuaHang.getMaCH(),
                    cuaHang.getTenCH(),
                    cuaHang.getDiaChi(),
                    cuaHang.getEmail(),
                    cuaHang.getSDT(),
                    cuaHang.getMaKhuVuc()
                };
                tableModel.addRow(rowData);
            }
        }
    }

    // Thêm cửa hàng mới
 // Thêm cửa hàng mới
    private void addStore() {
        String maCH = maCHField.getText();
        String tenCH = tenCHField.getText();
        String diaChi = diaChiField.getText();
        String email = emailField.getText();
        String sdt = sdtField.getText();

        // Kiểm tra các trường không được để trống
        if (maCH.isEmpty() || tenCH.isEmpty() || diaChi.isEmpty() || email.isEmpty() || sdt.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        TTCuaHang newCuaHang = new TTCuaHang(maCH, tenCH, diaChi, email, sdt, "");
        cuaHang.themCuaHangMoi(newCuaHang);
        
        // Load dữ liệu cập nhật
        loadData();
        
        // Reset các trường nhập liệu
        resetFields();
        
        // Thông báo
        JOptionPane.showMessageDialog(null, "Cửa hàng mới đã được thêm thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }

    
    // Sửa thông tin cửa hàng
 // Sửa thông tin cửa hàng
    private void editStore() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            // Lấy mã cửa hàng của dòng được chọn
            String maCH = tableModel.getValueAt(selectedRow, 0).toString();
            
            // Lấy dữ liệu mới từ các trường nhập liệu
            String tenCH = tenCHField.getText();
            String diaChi = diaChiField.getText();
            String email = emailField.getText();
            String sdt = sdtField.getText();
            
            // Cập nhật thông tin cửa hàng trong danh sách
            TTCuaHang updatedCuaHang = new TTCuaHang(maCH, tenCH, diaChi, email, sdt, "");
            cuaHang.suaCuaHang(maCH, updatedCuaHang);

            // Tải lại dữ liệu lên bảng
            loadData();
            
            // Đặt lại các trường nhập liệu về rỗng
            resetFields();
            
            // Thông báo cho người dùng
            JOptionPane.showMessageDialog(null, "Thông tin cửa hàng đã được cập nhật!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một cửa hàng để sửa!", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }



    // Xóa cửa hàng
 // Xóa cửa hàng
    private void deleteStore() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            String maCH = tableModel.getValueAt(selectedRow, 0).toString();

            // Xác nhận trước khi xóa
            int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa cửa hàng này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                cuaHang.xoaCuaHang(maCH);
                
                // Load dữ liệu cập nhật
                loadData();
                
                // Reset các trường nhập liệu
                resetFields();
                
                // Thông báo
                JOptionPane.showMessageDialog(null, "Cửa hàng đã được xóa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một cửa hàng để xóa!", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Reset các trường nhập liệu
    private void resetFields() {
        maCHField.setText("");
        tenCHField.setText("");
        diaChiField.setText("");
        emailField.setText("");
        sdtField.setText("");
        searchField.setText("");
        loadData(); // Reload data to refresh the table
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CuaHangGUI();
        });
    }

}
