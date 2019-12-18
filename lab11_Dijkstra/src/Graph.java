import java.util.List;

public class Graph {
    public int numberOfVertices;
    public double[][] edges;
    public List<Vertex> vertices;

    public Graph(int numberOfVertices, double[][] edges, List<Vertex> vertices) {
        this.numberOfVertices = numberOfVertices;
        this.edges = edges;
        this.vertices = vertices;
    }
}

class Vertex implements Comparable<Vertex> {
    public int vertexNumber;
    public double weight;

    public Vertex(int vertexNumber) {
        this.vertexNumber = vertexNumber;
    }

    @Override
    public int compareTo(Vertex o) {
        if (this.weight < o.weight) {
            return -1;
        } else if (this.weight == o.weight) {
            return 0;
        }
        return 1;
    }
}