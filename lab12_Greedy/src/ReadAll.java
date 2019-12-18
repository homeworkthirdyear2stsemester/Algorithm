import java.io.*;
import java.util.*;

public class ReadAll {
    public static Graph readPrimData(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            List<Vertex> vertices = new ArrayList<>();
            String vertexNamesStr = bufferedReader.readLine();
            StringTokenizer vertexNameTokens = new StringTokenizer(vertexNamesStr, ",");
            while (vertexNameTokens.hasMoreTokens()) {
                int vertexNumber = Integer.parseInt(vertexNameTokens.nextToken());
                vertices.add(new Vertex(vertexNumber, (char) (vertexNumber + 65)));
            }
            double[][] edges = new double[vertices.size()][vertices.size()];
            List<StringTokenizer> edgeStringData = new ArrayList<>();
            String edgeReadData;
            while ((edgeReadData = bufferedReader.readLine()) != null) {
                edgeStringData.add(new StringTokenizer(edgeReadData, ","));
            }

            for (StringTokenizer splitData : edgeStringData) {
                int startVertexNumber = Integer.parseInt(splitData.nextToken());
                int endVertexNumber = Integer.parseInt(splitData.nextToken());
                double weight = Double.parseDouble(splitData.nextToken());
                edges[startVertexNumber][endVertexNumber] = weight;
                edges[endVertexNumber][startVertexNumber] = weight;
            }

            return new Graph(vertices, edges);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public static List<Node> readDataForHuffman(String fileName) {
        List<Node> resultList = new ArrayList<>();
        String data = ReadAll.readDataForEncoding(fileName);
        char[] arrayChar = data.toCharArray();
        int[] frequencyOfdata = new int[27];
        for (char charData : arrayChar) {
            if (charData == ' ') {
                frequencyOfdata[0]++;
            } else {
                frequencyOfdata[(int) charData - 96]++;
            }
        }
        resultList.add(new Node(frequencyOfdata[0], ' '));
        for (int index = 1; index < frequencyOfdata.length; index++) {
            if (frequencyOfdata[index] != 0) {
                resultList.add(new Node(frequencyOfdata[index], (char) (index + 96)));
            }
        }

        return resultList;
    }

    public static Map<Character, String> recordHuffmantable(List<Node> nodeList, String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        Map<Character, String> table = new HashMap<>();
        for (Node node : nodeList) {
            if (node.huffmanCode == null) {
                continue;
            }
            stringBuilder.append(node.data).append(",").append(node.huffmanCode).append("\n");
            table.put(node.data, node.huffmanCode);
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            bufferedWriter.write(stringBuilder.toString());
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return table;
    }

    public static String readDataForEncoding(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            return bufferedReader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void recordEncodingData(String fileName, String resultData) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            bufferedWriter.write(resultData);
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, Character> readTable(String fileName) {
        Map<String, Character> table = new HashMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String oneLine;
            List<StringTokenizer> strList = new ArrayList<>();
            while ((oneLine = bufferedReader.readLine()) != null) {
                strList.add(new StringTokenizer(oneLine, ","));
            }

            for (StringTokenizer oneLineSplitData : strList) {
                char digit = oneLineSplitData.nextToken().charAt(0);
                String huffmanCode = oneLineSplitData.nextToken();
                table.put(huffmanCode, digit);
            }
        } catch (Exception e) {
            return null;
        }
        return table;
    }

    public static void storeDecodeData(String fileName, String result) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            bufferedWriter.write(result);
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}