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
    public static void main(String[] args) {
        linkedlist list = new linkedlist();
        list.addfront(30);
        list.addfront(20);
        list.addfront(10);
        list.addlast(40);
        list.addlast(50);
        list.display();   
    }
}