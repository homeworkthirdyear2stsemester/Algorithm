import java.util.List;

public class Graph {
    List<Vertex> vertices;
    double[][] edges;

    public Graph(List<Vertex> vertices, double[][] edges) {
        this.vertices = vertices;
        this.edges = edges;
    }
}

class Vertex implements Comparable<Vertex> {
    public int vertexNumber;
    public char vertexName;
    public double weight;

    public Vertex(int vertexNumber, char vertexName) {
        this.vertexNumber = vertexNumber;
        this.vertexName = vertexName;
    }

    @Override
    public int compareTo(Vertex o) {
        return (int) (this.weight - o.weight);
    }
}