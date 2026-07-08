public class LL {
    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    Node head;
    public void addFront(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }
    public void addLast(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }
    public void removeNthFromEnd(int n) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node fast = dummy;
        Node slow = dummy;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        head = dummy.next;
    }
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        LL list = new LL();
        list.addFront(30);
        list.addFront(20);
        list.addFront(10);
        list.addLast(40);
        list.addLast(50);
        list.display();
        list.removeNthFromEnd(2);
        list.display();
    }
}