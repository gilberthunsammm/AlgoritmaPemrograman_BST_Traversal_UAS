package org.example;

public class BinarySearchTree {
    public Node root;

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    public void preOrder(Node root, StringBuilder sb) {
        if (root != null) {
            sb.append(root.data).append(" ");
            preOrder(root.left, sb);
            preOrder(root.right, sb);
        }
    }

    public void inOrder(Node root, StringBuilder sb) {
        if (root != null) {
            inOrder(root.left, sb);
            sb.append(root.data).append(" ");
            inOrder(root.right, sb);
        }
    }

    public void postOrder(Node root, StringBuilder sb) {
        if (root != null) {
            postOrder(root.left, sb);
            postOrder(root.right, sb);
            sb.append(root.data).append(" ");
        }
    }
}
