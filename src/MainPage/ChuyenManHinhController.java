package MainPage;

import QLDanhMuc.QLDanhMuc;
import QLHoaDon.QLHoaDon;
import QLKhachHang.frmKhachHangJP;
import QLSanPham.QLSanPhamJP;
import QLThongKe.QLThongKe;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChuyenManHinhController {
    private JPanel root;
    private String KindSelect = "";
    private List<DanhMucBean> ListItem;

    public ChuyenManHinhController(JPanel root) {
        this.root = root;
    }

    public void setView(JPanel jpanelItem, JLabel jlbItem) {
        KindSelect = "TrangChu";
        jpanelItem.setBackground(new Color(255, 228, 196));
        jlbItem.setBackground(new Color(255, 228, 196));
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new FrmHome());
        root.validate();
        root.repaint();
    }

    public void setEvent(List<DanhMucBean> ListItem) {
        this.ListItem = ListItem;
        for (DanhMucBean item : ListItem) {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
            item.getJpn().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb())); // Thêm sự kiện cho JPanel
        }
    }

    class LabelEvent implements MouseListener {
        private JPanel node;
        private String kind;
        private JPanel jpnItem;
        private JLabel jlnItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlnItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlnItem = jlnItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "TrangChu":
                    node = new FrmHome();
                    break;
                case "KhachHang":
                    node = new frmKhachHangJP();
                    break;
                case "SanPham":
                    node = new QLSanPhamJP();
                    break;
                case "DanhMuc":
                    node = new QLDanhMuc();
                    break;
                case "HoaDon":
                    node = new QLHoaDon();
                    break;
                case "ThongKe":
                    node = new QLThongKe();
                    break;
                default:
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackGround(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            KindSelect = kind;
            jpnItem.setBackground(new Color(255, 228, 196));
            jlnItem.setBackground(new Color(255, 228, 196));
        }

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(255, 228, 196));
            jlnItem.setBackground(new Color(255, 228, 196));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!KindSelect.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(242, 242, 242));
                jlnItem.setBackground(new Color(242, 242, 242));
            }
        }
    }

    private void setChangeBackGround(String kind) {
        for (DanhMucBean item : ListItem) {
            if (item.getKind().equalsIgnoreCase(kind)) {
                item.getJpn().setBackground(new Color(255, 228, 196));
                item.getJlb().setBackground(new Color(255, 228, 196));
            } else {
                item.getJpn().setBackground(new Color(242, 242, 242));
                item.getJlb().setBackground(new Color(242, 242, 242));
            }
            item.getJpn().repaint(); // Vẽ lại JPanel
            item.getJlb().repaint(); // Vẽ lại JLabel
        }
    }
}
