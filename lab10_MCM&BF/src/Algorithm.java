import java.awt.Point;
import java.util.List;

public class Algorithm {
    static int matrixChainMultiplication(Point[] points) {
        int numberOfMultiple = points.length;
        int[][] amountOfMultiple = new int[numberOfMultiple][numberOfMultiple];

        for (int indexOfCross = 1; indexOfCross < numberOfMultiple; indexOfCross++) {
            int maxIndexForRow = numberOfMultiple - indexOfCross;
            int endIndex = indexOfCross;

            for (int startIndex = 0; startIndex < maxIndexForRow; startIndex++) {
                amountOfMultiple[startIndex][endIndex] = Integer.MAX_VALUE;

                for (int indexOfPivot = startIndex; indexOfPivot < endIndex; indexOfPivot++) {
                    int min = amountOfMultiple[startIndex][indexOfPivot] + amountOfMultiple[indexOfPivot + 1][endIndex] +
                            points[startIndex].x * points[indexOfPivot].y * points[endIndex].y;
                    if (amountOfMultiple[startIndex][endIndex] > min) {
                        amountOfMultiple[startIndex][endIndex] = min;
                    }
                }
                endIndex += 1;
            }
        }

        for (int[] array : amountOfMultiple) {
            for (int data : array) {
                System.out.printf("%7d", data);
            }
            System.out.println();
        }
        System.out.println();

        return amountOfMultiple[0][points.length - 1];
    }

    public static boolean bellmanFord(Graph graph, int startIndex) {
        List<Integer> vertices = graph.vertices;
        List<Edge> edges = graph.edges;
        double[] weightVertex = new double[vertices.size()];
        for (int index = 0; index < weightVertex.length; index++) { // 모두 무한대로
            if (index != startIndex) {
                weightVertex[index] = Double.POSITIVE_INFINITY;
            }
        }

        for (int indexOfVertex = 0; indexOfVertex < vertices.size(); indexOfVertex++) {
            System.out.println("\n----------iteration " + indexOfVertex + " ------------");
            for (Edge edge : edges) {
                double relax = weightVertex[edge.startVertex] + edge.weight;
                if (relax < weightVertex[edge.endVertex]) {
                    System.out.println("Update distance of " + edge.endVertex + " from " + weightVertex[edge.endVertex] + " to " + relax);
                    weightVertex[edge.endVertex] = relax;
                }
            }
            Algorithm.printall(indexOfVertex, weightVertex);
        }

        for (Edge edge : edges) {
            if (weightVertex[edge.endVertex] > weightVertex[edge.startVertex] + edge.weight) {
                System.out.println("The graph has negative cycle");
                return false;
            }
        }
        System.out.print("\nFinal distance [");
        for (int index = 0; index < weightVertex.length; index++) {
            if (index == weightVertex.length - 1) {
                System.out.print((int) weightVertex[index]);
            } else {
                System.out.print((int) weightVertex[index] + ", ");
            }
        }
        System.out.println("]");

        return true;
    }

    private static void printall(int iteration, double[] distance) {
        System.out.print("iteration " + iteration + " distance : [");
        for (int index = 0; index < distance.length; index++) {
            if (index == distance.length - 1) {
                System.out.print((int) distance[index]);
            } else {
                System.out.print((int) distance[index] + ", ");
            }
        }
        System.out.println("]");
    }
}