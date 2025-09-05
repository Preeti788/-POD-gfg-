/*
class Node {
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/

class Solution {
    public Node segregate(Node head) {
        // code here
        if (head == null || head.next == null) return head;
        
        int[] count = new int[3];
        Node curr = head;
        
        while (curr != null){
            count[curr.data]++;
            curr = curr.next;
        }
        
        curr = head;
        int i = 0;
        
        while(curr != null){
            if(count[i] == 0){
                i++;
            }else{
                curr.data = i;
                count[i]--;
                curr = curr.next;
            }
        }
        
        return head;
    }
}