package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BSTFrame extends JFrame {

    private JTextField inputField;
    private JTextArea outputArea;
    private TreePanel treePanel;
    private BinarySearchTree bst;
    private BufferedImage backgroundImage;

    public BSTFrame() {
        bst = new BinarySearchTree();

        setTitle("BST Simulator Pro - Insert, Delete, Search & Reset");
        setSize(1100, 750); // Ukuran sedikit diperlebar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Load Gambar (Pastikan file 'background3.jpg' ada di folder project)
        try {
            backgroundImage = ImageIO.read(new File("background3.jpg"));
        } catch (IOException e) {
            System.err.println("Gagal load gambar: " + e.getMessage());
        }

        // --- 1. BACKGROUND PANEL ---
        JPanel mainContainer = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                    g2d.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
                } else {
                    g.setColor(Color.DARK_GRAY);
                    g.fillRect(0, 0, getWidth(), getHeight());
                }
                g.setColor(new Color(0, 0, 0, 90)); // Overlay gelap
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        setContentPane(mainContainer);

        // --- 2. HEADER PANEL (TOMBOL-TOMBOL) ---
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 15));
        headerPanel.setOpaque(false);
        headerPanel.setBorder(new EmptyBorder(20, 0, 20, 0));

        JLabel lblInput = new JLabel("Data:");
        lblInput.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblInput.setForeground(Color.WHITE);

        inputField = new ModernTextField(12);

        // --- DAFTAR TOMBOL ---
        // 1. Insert (Biru)
        JButton btnInsert = new ModernButton("Insert", new Color(0, 120, 215), new Color(0, 80, 160));
        // 2. Delete (Merah)
        JButton btnDelete = new ModernButton("Hapus", new Color(220, 50, 50), new Color(160, 30, 30));
        // 3. Search (Ungu) - FITUR BARU
        JButton btnSearch = new ModernButton("Cari", new Color(138, 43, 226), new Color(75, 0, 130));
        // 4. Reset (Oranye)
        JButton btnReset = new ModernButton("Reset", new Color(255, 140, 0), new Color(200, 80, 0));

        headerPanel.add(lblInput);
        headerPanel.add(inputField);
        headerPanel.add(btnInsert);
        headerPanel.add(btnDelete);
        headerPanel.add(btnSearch);
        headerPanel.add(btnReset);

        add(headerPanel, BorderLayout.NORTH);

        // --- 3. TREE AREA (CENTER) ---
        treePanel = new TreePanel();
        JScrollPane treeScroll = new JScrollPane(treePanel);
        treeScroll.setBorder(null);
        treeScroll.setOpaque(false);
        treeScroll.getViewport().setOpaque(false);
        treeScroll.getVerticalScrollBar().setPreferredSize(new Dimension(0,0));
        treeScroll.getHorizontalScrollBar().setPreferredSize(new Dimension(0,0));

        add(treeScroll, BorderLayout.CENTER);

        // --- 4. FOOTER (HASIL TRAVERSAL) ---
        JPanel footerPanel = new JPanel(new BorderLayout());
        footerPanel.setOpaque(false);
        footerPanel.setBorder(new EmptyBorder(10, 20, 20, 20));

        outputArea = new JTextArea(4, 1);
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Consolas", Font.PLAIN, 14));
        outputArea.setForeground(new Color(100, 255, 218)); // Cyan Neon
        outputArea.setOpaque(false);
        outputArea.setText(" Selamat datang! Masukkan angka untuk memulai...");

        JPanel glassConsole = new RoundedPanel(15, new Color(0, 0, 0, 180));
        glassConsole.setLayout(new BorderLayout());
        glassConsole.setBorder(new EmptyBorder(10, 15, 10, 15));
        glassConsole.add(outputArea, BorderLayout.CENTER);

        footerPanel.add(glassConsole, BorderLayout.CENTER);
        add(footerPanel, BorderLayout.SOUTH);

        // --- EVENTS ---

        // Event Insert
        btnInsert.addActionListener(e -> {
            treePanel.setSearchTarget(null); // Reset highlight
            processInput(true);
        });
        inputField.addActionListener(e -> { // Enter = Insert
            treePanel.setSearchTarget(null);
            processInput(true);
        });

        // Event Delete
        btnDelete.addActionListener(e -> {
            treePanel.setSearchTarget(null);
            processInput(false);
        });

        // Event Search (Pencarian)
        btnSearch.addActionListener(e -> {
            String text = inputField.getText().trim();
            if (text.isEmpty()) return;
            try {
                int key = Integer.parseInt(text);
                boolean found = bst.search(key);

                if (found) {
                    treePanel.setSearchTarget(key); // Highlight Node
                    outputArea.setText(" HASIL PENCARIAN:\n Angka " + key + " DITEMUKAN di dalam pohon (Lihat warna Emas).");
                } else {
                    treePanel.setSearchTarget(null);
                    outputArea.setText(" HASIL PENCARIAN:\n Angka " + key + " TIDAK ADA di dalam pohon.");
                    JOptionPane.showMessageDialog(this, "Angka " + key + " tidak ditemukan!", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
                inputField.setText("");
                inputField.requestFocus();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Input harus angka!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Event Reset
        btnReset.addActionListener(e -> {
            bst = new BinarySearchTree();
            treePanel.setRoot(null);
            treePanel.setSearchTarget(null);
            outputArea.setText(" System Reset: Semua data telah dihapus.");
            inputField.setText("");
        });
    }

    private void processInput(boolean isInsert) {
        String rawText = inputField.getText().trim();
        if (rawText.isEmpty()) return;

        try {
            String[] data = rawText.split("\\s+");
            for (String d : data) {
                int val = Integer.parseInt(d);
                if (isInsert) bst.insert(val);
                else bst.delete(val);
            }
            treePanel.setRoot(bst.root);
            updateTraversalText();
            inputField.setText("");
            inputField.requestFocus();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Input harus angka!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateTraversalText() {
        if (bst.root == null) {
            outputArea.setText(" Tree kosong.");
            return;
        }
        StringBuilder pre = new StringBuilder();
        StringBuilder in = new StringBuilder();
        StringBuilder post = new StringBuilder();

        bst.preOrder(bst.root, pre);
        bst.inOrder(bst.root, in);
        bst.postOrder(bst.root, post);

        outputArea.setText("");
        outputArea.append(" PreOrder  : " + pre + "\n");
        outputArea.append(" InOrder   : " + in + "\n");
        outputArea.append(" PostOrder : " + post);
    }

    // --- CUSTOM COMPONENTS ---
    class ModernButton extends JButton {
        private Color cNormal, cHover;
        public ModernButton(String t, Color n, Color h) {
            super(t); cNormal = n; cHover = h;
            setContentAreaFilled(false); setFocusPainted(false); setBorderPainted(false);
            setFont(new Font("Segoe UI", Font.BOLD, 13)); setForeground(Color.WHITE);
            setCursor(new Cursor(Cursor.HAND_CURSOR));
            addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e) { setForeground(new Color(220, 255, 255)); }
                public void mouseExited(MouseEvent e) { setForeground(Color.WHITE); }
            });
        }
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if (getModel().isPressed()) g2.setColor(cHover.darker());
            else g2.setPaint(new GradientPaint(0, 0, cNormal, 0, getHeight(), cHover));
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
            g2.dispose(); super.paintComponent(g);
        }
    }

    class ModernTextField extends JTextField {
        public ModernTextField(int c) {
            super(c); setOpaque(false); setBorder(new EmptyBorder(5, 8, 5, 8));
            setFont(new Font("Segoe UI", Font.PLAIN, 14)); setForeground(Color.WHITE); setCaretColor(Color.WHITE);
        }
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(new Color(255, 255, 255, 50)); g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
            g2.setColor(new Color(255, 255, 255, 100)); g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
            g2.dispose(); super.paintComponent(g);
        }
    }

    class RoundedPanel extends JPanel {
        private int r; private Color c;
        public RoundedPanel(int radius, Color bg) { r = radius; c = bg; setOpaque(false); }
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(c); g2.fillRoundRect(0, 0, getWidth(), getHeight(), r, r);
            super.paintComponent(g);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BSTFrame().setVisible(true));
    }
}