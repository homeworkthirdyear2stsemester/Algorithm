import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ReadAll {

    static Graph readGraphData(String fileName) {
        List<Vertex> vertices = new ArrayList<>();
        double[][] edges;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String readVertices = bufferedReader.readLine();
            StringTokenizer stringTokenizer = new StringTokenizer(readVertices, ",");
            while (stringTokenizer.hasMoreTokens()) {
                vertices.add(new Vertex(Integer.parseInt(stringTokenizer.nextToken())));
            }// vertex 초기화

            String edgeLine;
            List<StringTokenizer> stringTokenizerList = new ArrayList<>();
            while ((edgeLine = bufferedReader.readLine()) != null) {
                stringTokenizer = new StringTokenizer(edgeLine, ", ");
                stringTokenizerList.add(stringTokenizer);
            } // edge 데이터 입력

            edges = new double[vertices.size()][vertices.size()];

            for (StringTokenizer tokenizer : stringTokenizerList) {
                stringTokenizer = tokenizer;
                int startIndex = Integer.parseInt(stringTokenizer.nextToken());
                int endIndex = Integer.parseInt(stringTokenizer.nextToken());
                edges[startIndex][endIndex] = Double.parseDouble(stringTokenizer.nextToken());
            }
        } catch (IOException e) {
            return null;
        }

        return new Graph(vertices.size(), edges, vertices);
    }
}
