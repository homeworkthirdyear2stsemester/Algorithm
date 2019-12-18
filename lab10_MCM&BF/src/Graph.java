import java.util.List;

public class Graph {
    List<Integer> vertices;
    List<Edge> edges;

    public Graph(List<Integer> vertices, List<Edge> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "vertices=" + vertices +
                ",\nedges=" + edges +
                '}';
    }
}

class Edge {
    int startVertex;
    int endVertex;
    int weight;

    public Edge(int startVertex, int endVertex, int weight) {
        this.startVertex = startVertex;
        this.endVertex = endVertex;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "startVertex=" + startVertex +
                ", endVertex=" + endVertex +
                ", weight=" + weight +
                "}\n";
    }
}

