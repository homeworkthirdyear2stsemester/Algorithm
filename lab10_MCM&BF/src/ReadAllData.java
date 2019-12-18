import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ReadAllData {
    static Point[] readAllDataForMatrixChain(String fileName) {
        Point[] points;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String oneLineData;
            List<StringTokenizer> stringTokenizerList = new ArrayList<>();
            while ((oneLineData = bufferedReader.readLine()) != null) {
                StringTokenizer stringTokenizer = new StringTokenizer(oneLineData, ",");
                stringTokenizerList.add(stringTokenizer);
            }

            points = new Point[stringTokenizerList.size()];
            for (int index = 0; index < stringTokenizerList.size(); index++) {
                StringTokenizer stringTokenizer = stringTokenizerList.get(index);
                points[index] = new Point(Integer.parseInt(stringTokenizer.nextToken()),
                        Integer.parseInt(stringTokenizer.nextToken()));
            }
        } catch (IOException exception) {
            return null;
        }

        return points;
    }

    static Graph readGraphData(String fileName) {
        List<Integer> vertices = new ArrayList<>();
        List<Edge> edges = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String readVertices = bufferedReader.readLine();
            StringTokenizer stringTokenizer = new StringTokenizer(readVertices, ",");
            while (stringTokenizer.hasMoreTokens()) {
                vertices.add(Integer.parseInt(stringTokenizer.nextToken()));
            }

            String edgeLine;
            List<StringTokenizer> stringTokenizerList = new ArrayList<>();
            while ((edgeLine = bufferedReader.readLine()) != null) {
                stringTokenizer = new StringTokenizer(edgeLine, ", ");
                stringTokenizerList.add(stringTokenizer);
            }

            for (StringTokenizer tokenizer : stringTokenizerList) {
                stringTokenizer = tokenizer;
                edges.add(new Edge(Integer.parseInt(stringTokenizer.nextToken()),
                        Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken())));
            }
        } catch (IOException e) {
            return null;
        }

        return new Graph(vertices, edges);
    }
}
