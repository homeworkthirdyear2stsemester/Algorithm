import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Algorithm {
    public static void dijkstra(Graph graph, int startIndex) {
        List<Vertex> vertices = graph.vertices;
        double[][] edges = graph.edges;
        Queue<Vertex> nowVerticesQueue = new PriorityQueue<>();

        for (Vertex vertex : vertices) {
            if (vertex.vertexNumber != startIndex) {
                vertex.weight = Double.POSITIVE_INFINITY;
            }
            nowVerticesQueue.add(vertex);
        }

        int count = 0;
        while (!nowVerticesQueue.isEmpty()) {
            Queue<Vertex> nextVerticesQueue = new PriorityQueue<>();
            Vertex minWeightVertex = nowVerticesQueue.poll();
            System.out.printf("S[%d] : d[%c] = %.1f\n", count++, (char) (minWeightVertex.vertexNumber + 65), minWeightVertex.weight);
            System.out.println("---------------------------------------------------------------");
            int innerCount = 0;
            Iterator<Vertex> edgeIterator = nowVerticesQueue.iterator();
            while (edgeIterator.hasNext()) {
                Vertex endVertex = edgeIterator.next();
                double edgeWeight = edges[minWeightVertex.vertexNumber][endVertex.vertexNumber];

                double nowWeight = endVertex.weight;
                double nextWeight;
                if (edgeWeight != 0) {
                    nextWeight = minWeightVertex.weight + edgeWeight;
                } else {
                    nextWeight = endVertex.weight;
                }
                char changeVertexNumber = (char) (endVertex.vertexNumber + 65);
                System.out.printf("Q[%d] : d[%c] = %.1f", innerCount++, changeVertexNumber, nowWeight);
                if (nowWeight > nextWeight) {
                    endVertex.weight = nextWeight;
                    System.out.printf(" -> d[%c] = %.1f\n", changeVertexNumber, nextWeight);
                } else {
                    System.out.println();
                }
                nextVerticesQueue.add(endVertex);
            }
            System.out.println();
            nowVerticesQueue = nextVerticesQueue;
        }
    }
}
