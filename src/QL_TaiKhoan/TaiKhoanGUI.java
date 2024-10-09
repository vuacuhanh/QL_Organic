package QL_TaiKhoan;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TaiKhoanGUI {
    private TaiKhoan taiKhoan; // Đối tượng quản lý tài khoản
    private JFrame frame;
    private JTextField maTKField, tenTKField, quyenHanField;
    private JPasswordField matKhauField; // Sử dụng JPasswordField cho mật khẩu
    private JTable taiKhoanTable;
    private DefaultTableModel tableModel;

    // Constructor
    public TaiKhoanGUI() {
        taiKhoan = new TaiKhoan(); // Khởi tạo danh sách tài khoản

        // Tạo giao diện
        frame = new JFrame("Quản lý tài khoản");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 650);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(240, 228, 198)); // Màu nền kem

        // Thiết lập font chữ
        Font font = new Font("Arial", Font.PLAIN, 16);
        UIManager.put("TextField.font", font);
        UIManager.put("TextArea.font", font);
        UIManager.put("Button.font", font);
        UIManager.put("Label.font", font);

        // Tiêu đề
        JLabel titleLabel = new JLabel("Quản lý tài khoản", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(new Color(0, 0, 128)); // Màu navy
        frame.add(titleLabel, BorderLayout.NORTH);

        // Tạo Panel cho nhập liệu
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        inputPanel.setBackground(new Color(240, 228, 198)); // Màu nền kem
        inputPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLACK),
                "Thông tin tài khoản",
                TitledBorder.CENTER,
                TitledBorder.TOP
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Các trường nhập liệu
        gbc.gridx = 0; gbc.gridy = 0; inputPanel.add(new JLabel("Mã Tài Khoản:"), gbc);
        gbc.gridx = 1; gbc.gridy = 0; maTKField = new JTextField(15); inputPanel.add(maTKField, gbc);

        gbc.gridx = 0; gbc.gridy = 1; inputPanel.add(new JLabel("Tên Đăng Nhập:"), gbc);
        gbc.gridx = 1; gbc.gridy = 1; tenTKField = new JTextField(15); inputPanel.add(tenTKField, gbc);

        gbc.gridx = 0; gbc.gridy = 2; inputPanel.add(new JLabel("Mật Khẩu:"), gbc);
        gbc.gridx = 1; gbc.gridy = 2; matKhauField = new JPasswordField(15); inputPanel.add(matKhauField, gbc);

        gbc.gridx = 0; gbc.gridy = 3; inputPanel.add(new JLabel("Quyền Hạn:"), gbc);
        gbc.gridx = 1; gbc.gridy = 3; quyenHanField = new JTextField(15); inputPanel.add(quyenHanField, gbc);

        // Thêm inputPanel vào phần bên trái của frame
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.add(inputPanel, BorderLayout.NORTH);
        frame.add(leftPanel, BorderLayout.WEST);

        // Tạo Panel cho các nút
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 10));
        buttonPanel.setBackground(new Color(240, 228, 198)); // Màu nền kem
        buttonPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLACK),
                "Chức năng",
                TitledBorder.CENTER,
                TitledBorder.TOP
        ));

        // Nút Thêm
        JButton addButton = new JButton("Thêm Tài Khoản");
        styleButton(addButton, new Color(0, 0, 128)); // Màu navy
        addButton.addActionListener(e -> addAccount());
        buttonPanel.add(addButton);

        // Nút Sửa
        JButton editButton = new JButton("Sửa Tài Khoản");
        styleButton(editButton, new Color(0, 0, 128)); // Màu navy
        editButton.addActionListener(e -> editAccount());
        buttonPanel.add(editButton);

        // Nút Xóa
        JButton deleteButton = new JButton("Xóa Tài Khoản");
        styleButton(deleteButton, new Color(0, 0, 128)); // Màu navy
        deleteButton.addActionListener(e -> deleteAccount());
        buttonPanel.add(deleteButton);

        // Thêm buttonPanel vào phần bên phải của frame
        frame.add(buttonPanel, BorderLayout.EAST);

        // Tạo bảng để hiển thị danh sách tài khoản
        String[] columnNames = {"Mã Tài Khoản", "Tên Đăng Nhập", "Quyền Hạn"};
        tableModel = new DefaultTableModel(columnNames, 0);
        taiKhoanTable = new JTable(tableModel);
        taiKhoanTable.setFillsViewportHeight(true);
        taiKhoanTable.setBackground(new Color(255, 255, 255));
        taiKhoanTable.setForeground(new Color(0, 0, 0));
        taiKhoanTable.setSelectionBackground(new Color(173, 216, 230)); // Màu nền khi chọn hàng
        taiKhoanTable.setSelectionForeground(new Color(0, 0, 0)); // Màu chữ khi chọn hàng
        JScrollPane scrollPane = new JScrollPane(taiKhoanTable);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 128), 1)); // Đường viền cho bảng

        // Đặt bảng hiển thị ở nửa dưới của frame
        frame.add(scrollPane, BorderLayout.SOUTH);
        scrollPane.setPreferredSize(new Dimension(frame.getWidth(), 300));

        // Lắng nghe sự kiện khi chọn hàng trong bảng
        taiKhoanTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = taiKhoanTable.getSelectedRow();
                if (row >= 0) {
                    loadAccountData(row);
                }
            }
        });

        // Hiển thị giao diện
        updateTable(); // Cập nhật hiển thị ban đầu
        frame.setVisible(true);
    }

    // Phương thức để thiết lập kiểu nút
    private void styleButton(JButton button, Color backgroundColor) {
        button.setBackground(backgroundColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Thêm khoảng cách bên trong
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(button.getBackground().brighter()); // Làm sáng màu nút khi di chuột vào
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(backgroundColor); // Đặt lại màu khi rời chuột
            }
        });
    }

	// Phương thức kiểm tra các trường nhập liệu
    private boolean validateFields() {
        if (maTKField.getText().isEmpty() || tenTKField.getText().isEmpty() || String.valueOf(matKhauField.getPassword()).isEmpty() || quyenHanField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Vui lòng điền đầy đủ thông tin!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    // Phương thức cập nhật vùng hiển thị danh sách tài khoản
    private void updateTable() {
        // Xóa tất cả dữ liệu hiện có trong bảng
        tableModel.setRowCount(0);
        for (TTTaiKhoan tk : taiKhoan.getList()) {
            tableModel.addRow(new Object[]{tk.getMaTK(), tk.getTenDangNhap(), tk.getQuyenHan()});
        }
    }

    // Phương thức xóa các trường nhập liệu
    private void clearFields() {
        maTKField.setText("");
        tenTKField.setText("");
        matKhauField.setText("");
        quyenHanField.setText("");
    }

    // Tải dữ liệu từ bảng vào các trường nhập liệu
    private void loadAccountData(int row) {
        maTKField.setText(tableModel.getValueAt(row, 0).toString());
        tenTKField.setText(tableModel.getValueAt(row, 1).toString());
        matKhauField.setText(tableModel.getValueAt(row, 2).toString());
        quyenHanField.setText(tableModel.getValueAt(row, 3).toString());
        // Không hiển thị mật khẩu vì lý do bảo mật
    }

    // Thêm tài khoản
    private void addAccount() {
        if (validateFields()) {
            String maTK = maTKField.getText();
            String tenTK = tenTKField.getText();
            String matKhau = String.valueOf(matKhauField.getPassword()); // Lấy mật khẩu từ JPasswordField
            String quyenHan = quyenHanField.getText();

            // Kiểm tra xem mã tài khoản đã tồn tại chưa
            if (taiKhoan.kiemTraMaTK(maTK)) {
                JOptionPane.showMessageDialog(frame, "Mã tài khoản đã tồn tại!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                return;
            }

            TTTaiKhoan newTaiKhoan = new TTTaiKhoan(maTK, tenTK, matKhau, quyenHan);
            taiKhoan.themTaiKhoan(newTaiKhoan);
            updateTable(); // Cập nhật bảng
            clearFields(); // Xóa các trường nhập liệu
            JOptionPane.showMessageDialog(frame, "Thêm tài khoản thành công!");
        }
    }

    // Sửa tài khoản
    private void editAccount() {
        if (validateFields()) {
            String maTK = maTKField.getText();
            String tenTK = tenTKField.getText();
            String matKhau = String.valueOf(matKhauField.getPassword());
            String quyenHan = quyenHanField.getText();

            // Kiểm tra mã tài khoản có tồn tại không
            if (!taiKhoan.kiemTraMaTK(maTK)) {
                JOptionPane.showMessageDialog(frame, "Mã tài khoản không tồn tại!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Cập nhật thông tin tài khoản
            taiKhoan.suaTaiKhoan(maTK, tenTK, matKhau, quyenHan);
            updateTable(); // Cập nhật bảng
            clearFields(); // Xóa các trường nhập liệu
            JOptionPane.showMessageDialog(frame, "Sửa tài khoản thành công!");
        }
    }

    // Xóa tài khoản
    private void deleteAccount() {
        int selectedRow = taiKhoanTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(frame, "Vui lòng chọn tài khoản để xóa!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String maTK = tableModel.getValueAt(selectedRow, 0).toString();
        taiKhoan.xoaTaiKhoan(maTK);
        updateTable(); // Cập nhật bảng
        clearFields(); // Xóa các trường nhập liệu
        JOptionPane.showMessageDialog(frame, "Xóa tài khoản thành công!");
    }

    // Phương thức main
    public static void main(String[] args) {
        SwingUtilities.invokeLater(TaiKhoanGUI::new); // Khởi động GUI
    }
}
