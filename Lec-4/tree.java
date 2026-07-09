import java.util.Stack;

public class tree {

    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    Node root;

    public void postOrderIterative() {
        if (root == null)
            return;

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(root);

        while (!s1.isEmpty()) {
            Node curr = s1.pop();
            s2.push(curr);

            if (curr.left != null)
                s1.push(curr.left);

            if (curr.right != null)
                s1.push(curr.right);
        }

        while (!s2.isEmpty()) {
            System.out.print(s2.pop().data + " ");
        }
    }

    public static void main(String[] args) {
        tree t = new tree();

        t.root = t.new Node(1);
        t.root.left = t.new Node(2);
        t.root.right = t.new Node(3);
        t.root.left.left = t.new Node(4);
        t.root.left.right = t.new Node(5);
        t.root.right.left = t.new Node(6);
        t.root.right.right = t.new Node(7);

        t.postOrderIterative();
    }
}