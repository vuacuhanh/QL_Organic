/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package PanelBoder;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 *
 * @author anhng
 */
public class PanelBordertamgiactrai extends javax.swing.JPanel {

    /**
     * Creates new form PanelBordertamgiactrai
     */
    private boolean isLeft;
    public PanelBordertamgiactrai() {
        initComponents();
        this.isLeft = isLeft;
        setOpaque(false);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());

        int[] xPoints = new int[3];
        int[] yPoints = new int[3];

        if (isLeft) { // Vẽ tam giác vuông quay trái
            xPoints[0] = 0;
            xPoints[1] = getWidth();
            xPoints[2] = 0;
            yPoints[0] = getHeight();
            yPoints[1] = getHeight();
            yPoints[2] = 0;
        } else { // Vẽ tam giác vuông quay phải
            xPoints[0] = getWidth();
            xPoints[1] = getWidth();
            xPoints[2] = 0;
            yPoints[0] = 0;
            yPoints[1] = getHeight();
            yPoints[2] = getHeight();
        }

        g2.fillPolygon(xPoints, yPoints, 3);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
