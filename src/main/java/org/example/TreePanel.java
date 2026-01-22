package org.example;

import javax.swing.*;
import java.awt.*;

public class TreePanel extends JPanel {
    private Node root;
    private Integer searchTarget = null; // Menyimpan angka yang sedang dicari

    private final int RADIUS = 25;
    private final int V_GAP = 60;

    public TreePanel() {
        setOpaque(false); // Transparan
    }

    public void setRoot(Node root) {
        this.root = root;
        repaint();
    }

    // Method baru untuk menandai node yang dicari
    public void setSearchTarget(Integer target) {
        this.searchTarget = target;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (root != null) {
            Graphics2D g2d = (Graphics2D) g;

            // Kualitas Rendering Maksimal
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

            drawTree(g2d, root, getWidth() / 2, 40, getWidth() / 4);
        }
    }

    private void drawTree(Graphics2D g, Node node, int x, int y, int xOffset) {
        // 1. GAMBAR GARIS
        g.setStroke(new BasicStroke(2.0f));
        g.setColor(new Color(200, 200, 200, 150)); // Garis Putih Transparan

        if (node.left != null) {
            int childX = x - xOffset;
            int childY = y + V_GAP;
            g.drawLine(x, y, childX, childY);
            drawTree(g, node.left, childX, childY, xOffset / 2);
        }

        if (node.right != null) {
            int childX = x + xOffset;
            int childY = y + V_GAP;
            g.drawLine(x, y, childX, childY);
            drawTree(g, node.right, childX, childY, xOffset / 2);
        }

        // 2. LOGIKA WARNA NODE (SEARCH HIGHLIGHT)
        if (searchTarget != null && node.data == searchTarget) {
            // JIKA KETEMU -> WARNA EMAS (GOLD) + GLOW
            g.setColor(new Color(255, 215, 0, 150)); // Glow luar
            g.fillOval(x - RADIUS - 4, y - RADIUS - 4, (2 * RADIUS) + 8, (2 * RADIUS) + 8);

            GradientPaint gp = new GradientPaint(x, y-RADIUS, new Color(255, 223, 0), x, y+RADIUS, new Color(218, 165, 32));
            g.setPaint(gp);
        } else {
            // NORMAL -> WARNA BIRU
            g.setColor(new Color(0, 150, 255, 100)); // Bayangan luar
            g.fillOval(x - RADIUS - 2, y - RADIUS - 2, (2 * RADIUS) + 4, (2 * RADIUS) + 4);

            GradientPaint gp = new GradientPaint(x, y-RADIUS, new Color(0, 200, 255), x, y+RADIUS, new Color(0, 100, 200));
            g.setPaint(gp);
        }

        // Gambar lingkaran utama
        g.fillOval(x - RADIUS, y - RADIUS, 2 * RADIUS, 2 * RADIUS);

        // Outline Putih
        g.setColor(Color.WHITE);
        g.setStroke(new BasicStroke(1.5f));
        g.drawOval(x - RADIUS, y - RADIUS, 2 * RADIUS, 2 * RADIUS);

        // 3. TULIS ANGKA
        g.setColor(Color.WHITE);
        g.setFont(new Font("Segoe UI", Font.BOLD, 14));

        String value = String.valueOf(node.data);
        FontMetrics fm = g.getFontMetrics();
        int textWidth = fm.stringWidth(value);
        int textHeight = fm.getAscent();

        g.drawString(value, x - (textWidth / 2), y + (textHeight / 4));
    }
}