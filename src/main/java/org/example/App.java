package org.example;

import org.example.BSTFrame;

import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BSTFrame().setVisible(true);
        });
    }
}