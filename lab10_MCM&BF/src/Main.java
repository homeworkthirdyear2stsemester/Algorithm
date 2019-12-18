import java.awt.Point;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        String fileName = "data11_matrix_chain.txt";
        Point[] points = Objects.requireNonNull(ReadAllData.readAllDataForMatrixChain(fileName));
        System.out.println(Algorithm.matrixChainMultiplication(points));


        fileName = "data11_bellman_ford_1.txt";
        Graph graph = Objects.requireNonNull(ReadAllData.readGraphData(fileName));
        System.out.println(Algorithm.bellmanFord(graph, 0));
    }
}
