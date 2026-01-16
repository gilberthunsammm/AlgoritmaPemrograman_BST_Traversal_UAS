package org.example;

import javax.swing.*;
import java.awt.*;

public class BSTFrame extends JFrame {

    private JTextField inputField;
    private JTextArea outputArea;
    private BinarySearchTree bst;

    public BSTFrame() {
        bst = new BinarySearchTree();

        setTitle("BST & Traversal - Java Swing");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel input
        JPanel inputPanel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Masukkan angka (pisahkan spasi):");
        inputField = new JTextField();

        inputPanel.add(label, BorderLayout.NORTH);
        inputPanel.add(inputField, BorderLayout.CENTER);

        // Tombol
        JButton btnProcess = new JButton("Proses BST");

        // Output
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // Layout utama
        setLayout(new BorderLayout(10, 10));
        add(inputPanel, BorderLayout.NORTH);
        add(btnProcess, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        // Event
        btnProcess.addActionListener(e -> processBST());
    }

    private void processBST() {
        bst = new BinarySearchTree();
        outputArea.setText("");

        try {
            String[] data = inputField.getText().trim().split("\\s+");
            for (String d : data) {
                bst.insert(Integer.parseInt(d));
            }

            StringBuilder pre = new StringBuilder();
            StringBuilder in = new StringBuilder();
            StringBuilder post = new StringBuilder();

            bst.preOrder(bst.root, pre);
            bst.inOrder(bst.root, in);
            bst.postOrder(bst.root, post);

            outputArea.append("PreOrder  : " + pre + "\n");
            outputArea.append("InOrder   : " + in + "\n");
            outputArea.append("PostOrder : " + post + "\n");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Input tidak valid! Masukkan angka saja.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
