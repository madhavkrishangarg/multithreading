import java.util.ArrayList;

public class Tree {
    Node root;
    ArrayList<Long> inorder = new ArrayList<>();

    public Long height(Node N) {
        if (N == null)
            return (long) 0;
        return N.getHeight();
    }

    public long max(long a, long b) {
        return Math.max(a, b);
    }

    public Node rightRotate(Node y) {
        Node x = y.left;
        Node x2 = x.right;
        x.right = y;
        y.left = x2;
        y.setHeight(max(height(y.left), height(y.right)) + 1);
        x.setHeight(max(height(x.left), height(x.right)) + 1);
        return x;
    }

    public Node leftRotate(Node x) {
        Node y = x.right;
        Node x2 = y.left;
        y.left = x;
        x.right = x2;
        x.setHeight(max(height(x.left), height(x.right)) + 1);
        y.setHeight(max(height(y.left), height(y.right)) + 1);
        return y;
    }

    public long getBalanceFactor(Node N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    public Node insertNode(Node node, long item) {

        if (node == null)
            return (new Node(item));
        if (item < node.getItem())
            node.left = insertNode(node.left, item);
        else if (item > node.getItem())
            node.right = insertNode(node.right, item);
        else
            return node;

        node.setHeight(1 + max(height(node.left), height(node.right)));
        long balanceFactor = getBalanceFactor(node);

        if (balanceFactor < -1) {
            if (item > node.right.getItem()) {
                return leftRotate(node);
            } else if (item < node.right.getItem()) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        if (balanceFactor > 1) {
            if (item < node.left.getItem()) {
                return rightRotate(node);
            } else if (item > node.left.getItem()) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        return node;
    }

    public Node nodeMin(Node node) {
        Node current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }

    public Node deleteNode(Node root, long item) {
        if (item < root.getItem()) {
            root.left = deleteNode(root.left, item);
        } else if (item > root.getItem()) {
            root.right = deleteNode(root.right, item);
        } else {
            if ((root.left == null) || (root.right == null)) {
                Node temp = null;
                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;
                if (temp == null) {
                    temp = root;
                    root = null;
                } else
                    root = temp;
            } else {
                Node temp = nodeMin(root.right);
                root.setItem(temp.getItem());
                root.right = deleteNode(root.right, temp.getItem());
            }
        }
        if (root == null)
            return null;
        root.setHeight(max(height(root.left), height(root.right)) + 1);
        long balanceFactor = getBalanceFactor(root);
        if (balanceFactor > 1) {
            if (getBalanceFactor(root.left) < 0) {
                root.left = leftRotate(root.left);
            }
            return rightRotate(root);
        }
        if (balanceFactor < -1) {
            if (getBalanceFactor(root.right) > 0) {
                root.right = rightRotate(root.right);
            }
            return leftRotate(root);
        }
        return root;
    }

    void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            inorder.add(node.getItem());
            inOrder(node.right);
        }
    }
}
