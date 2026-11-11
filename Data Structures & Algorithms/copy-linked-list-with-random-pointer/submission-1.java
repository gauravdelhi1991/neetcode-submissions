/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node temp = head;

        while (temp != null) {
            Node next = temp.next;
            temp.next = new Node(temp.val);
            temp.next.next = next;
            temp = next;
        }

        temp = head;

        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        temp = head.next;

        while (temp.next != null) {
            Node next = temp.next.next;
            temp.next = next;
            temp = next;
        }

        return head.next;
    }
}
