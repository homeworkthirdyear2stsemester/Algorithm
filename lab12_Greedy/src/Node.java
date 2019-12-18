public class Node implements Comparable<Node> {
    public char data;
    public int frequency;
    public String huffmanCode;
    public boolean isLeaf;
    public Node left;
    public Node right;

    public Node(int frequency, char data) {
        this.frequency = frequency;
        this.data = data;
        this.isLeaf = true;
    }

    public Node(int frequency, Node left, Node right) {
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.frequency, o.frequency);
    }
}