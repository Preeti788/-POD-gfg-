/*
class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}
*/
class Solution {
    public Node mergeSort(Node head) {
        // code here
        if (head == null || head.next == null) return head;

        Node mid = getMiddle(head);
        Node nextHalf = mid.next;
        mid.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(nextHalf);

        return merge(left, right);
    }

    private Node getMiddle(Node head) {
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Node merge(Node a, Node b) {
        Node dummy = new Node(0);
        Node tail = dummy;

        while (a != null && b != null) {
            if (a.data <= b.data) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }

        if (a != null) tail.next = a;
        if (b != null) tail.next = b;

        return dummy.next;
        
        
        
    }
}