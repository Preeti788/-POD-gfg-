/*
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
*/
class Solution {
    public Node reverse(Node head) {
        // code here
        if (head == null) return null;
        
        Node curr = head;
        Node newHead = null;
        
        while (curr != null){
            Node temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            
            newHead = curr;
            curr = curr.prev;
        }
        
        return newHead;
    }
}