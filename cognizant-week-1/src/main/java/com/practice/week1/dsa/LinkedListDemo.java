package com.practice.week1.dsa;

/**
 * DATA STRUCTURE: Singly Linked List
 * Implements insertAtEnd, delete, and iterative reverse from scratch.
 */
public class LinkedListDemo {

    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    private Node head;

    void insertAtEnd(int value) {
        Node node = new Node(value);
        if (head == null) { head = node; return; }
        Node curr = head;
        while (curr.next != null) curr = curr.next;
        curr.next = node;
    }

    void delete(int value) {
        if (head == null) return;
        if (head.data == value) { head = head.next; return; }
        Node curr = head;
        while (curr.next != null && curr.next.data != value) curr = curr.next;
        if (curr.next != null) curr.next = curr.next.next;
    }

    void reverse() {
        Node prev = null, curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    void print() {
        Node curr = head;
        StringBuilder sb = new StringBuilder();
        while (curr != null) { sb.append(curr.data).append(" -> "); curr = curr.next; }
        sb.append("null");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        LinkedListDemo list = new LinkedListDemo();
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.print();          // 10 -> 20 -> 30 -> null

        list.delete(20);
        list.print();          // 10 -> 30 -> null

        list.reverse();
        list.print();          // 30 -> 10 -> null
    }
}
