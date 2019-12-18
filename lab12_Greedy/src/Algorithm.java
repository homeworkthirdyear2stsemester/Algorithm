import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Algorithm {
    public static void prim(Graph graph, int startIndex) { // graph 입력
        double result = 0;
        Queue<Vertex> vertices = new PriorityQueue<>();
        boolean[] isVisited = new boolean[graph.vertices.size()];
        for (Vertex vertex : graph.vertices) {
            if (vertex.vertexNumber != startIndex) { // start index재외하고 모든 vertex의 weight를 infinity 설정
                vertex.weight = Double.POSITIVE_INFINITY;
            }
            vertices.add(vertex); // pq에 추가
        }

        System.out.println("w<" + " ," + graph.vertices.get(startIndex).vertexName + "> = 0"); // start vertex 출력
        while (!vertices.isEmpty()) {
            Vertex leafVertex = vertices.poll();
            isVisited[leafVertex.vertexNumber] = true;
            for (Vertex leftVertices : vertices) {
                double edgeWeight = graph.edges[leafVertex.vertexNumber][leftVertices.vertexNumber];
                if (!isVisited[leftVertices.vertexNumber] && edgeWeight != 0 && edgeWeight < leftVertices.weight) {
                    leftVertices.weight = edgeWeight;
                }
            }
            Queue<Vertex> nextVertices = new PriorityQueue<>();
            for (Vertex vertex : vertices) {
                nextVertices.add(vertex);
            } // heapify
            vertices = nextVertices;

            if (vertices.size() > 0) {
                double weigthOfPeek = vertices.peek().weight;
                result += weigthOfPeek;
                System.out.println("w<" + leafVertex.vertexName + "," + vertices.peek().vertexName + ">" + " = " + weigthOfPeek);
            } // 출력
        }

        System.out.println("\nW(MST) = " + result);
    }

    private static Node huffmanTree(List<Node> huffmanLeaves) {
        Queue<Node> huffmanNodes = new PriorityQueue<>(huffmanLeaves);
        while (huffmanNodes.size() > 1) {
            Node leftData = huffmanNodes.poll();
            Node rightData = huffmanNodes.poll();
            huffmanNodes.add(new Node(leftData.frequency + rightData.frequency, leftData, rightData));
        }

        return huffmanNodes.poll();
    }

    public static void recordHuffmanCode(List<Node> huffmanLeaves) {
        Node huffmanTree = Algorithm.huffmanTree(huffmanLeaves);
        Algorithm.dfsHuffman("", huffmanTree);
    }

    private static void dfsHuffman(String huffmanCode, Node nowPosition) {
        if (nowPosition.isLeaf) {
            nowPosition.huffmanCode = huffmanCode;
            return;
        }
        if (nowPosition.left != null && nowPosition.left.frequency != 0) {
            Algorithm.dfsHuffman(huffmanCode + "0", nowPosition.left);
        }
        if (nowPosition.right != null && nowPosition.right.frequency != 0) {
            Algorithm.dfsHuffman(huffmanCode + "1", nowPosition.right);
        }
    }

    public static String encoding(String data, Map<Character, String> table) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] dataCharArray = data.toCharArray();
        for (char digit : dataCharArray) {
            stringBuilder.append(table.get(digit));
        }

        return stringBuilder.toString();
    }

    public static String decoding(String data, Map<String, Character> table) {
        StringBuilder subData = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for (int index = 0; index < data.length(); index++) {
            subData.append(data.charAt(index));
            Character getDigit = table.get(subData.toString());
            if (getDigit != null) {
                result.append(getDigit);
                subData = new StringBuilder();
            }
        }

        return result.toString();
    }
}
