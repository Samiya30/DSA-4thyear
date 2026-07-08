public class linkedlist{
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    Node head=null;

    //add in front
    public void addfront(int data){
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    //add in last
    public void addlast(int data){
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

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "=");
            temp = temp.next;
        }
        System.out.println("null");
    }

    //remove nth node from end
    public Node removeNthFromEnd(Node head, int n) {
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
        return dummy.next;
    }

    public static void main(String[] args) {
        linkedlist list = new linkedlist();
        list.addfront(30);
        list.addfront(20);
        list.addfront(10);
        list.addlast(40);
        list.addlast(50);
        list.addlast(30);
        list.display();   
    }
}