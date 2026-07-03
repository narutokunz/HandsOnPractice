package com.practice.week1.dsa;

/**
 * DATA STRUCTURE: Binary Search Tree
 * Implements insert, search, and inorder traversal (gives sorted output).
 */
public class BSTDemo {

    static class Node {
        int value;
        Node left, right;
        Node(int value) { this.value = value; }
    }

    private Node root;

    void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node node, int value) {
        if (node == null) return new Node(value);
        if (value < node.value) node.left = insertRec(node.left, value);
        else if (value > node.value) node.right = insertRec(node.right, value);
        return node;
    }

    boolean search(int value) {
        return searchRec(root, value);
    }

    private boolean searchRec(Node node, int value) {
        if (node == null) return false;
        if (node.value == value) return true;
        return value < node.value ? searchRec(node.left, value) : searchRec(node.right, value);
    }

    void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(Node node) {
        if (node == null) return;
        inorderRec(node.left);
        System.out.print(node.value + " ");
        inorderRec(node.right);
    }

    public static void main(String[] args) {
        BSTDemo bst = new BSTDemo();
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int v : values) bst.insert(v);

        bst.inorder();                          // 20 30 40 50 60 70 80
        System.out.println("Search 40: " + bst.search(40));
        System.out.println("Search 99: " + bst.search(99));
    }
}
