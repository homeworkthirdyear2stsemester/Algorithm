import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Graph graph = ReadAll.readPrimData("data12_prim.txt"); // 다시 짜야함
        Algorithm.prim(Objects.requireNonNull(graph), 0);
        List<Node> nodeList = ReadAll.readDataForHuffman("data12.txt");
        Algorithm.recordHuffmanCode(nodeList);
        Map<Character, String> table = ReadAll.recordHuffmantable(nodeList, "hw12_05_201502020_table.txt");

        String encodingData = Algorithm.encoding(ReadAll.readDataForEncoding("data12.txt"), table);
        ReadAll.recordEncodingData("hw12_05_201502020_encoded.txt", encodingData);

        String dataForDecoding = ReadAll.readDataForEncoding("data12_encoded.txt"); // encoded 된 값 읽어오기
        Map<String, Character> decodingTable = ReadAll.readTable("data12_table.txt");// table읽어오기

        String decodedData = Algorithm.decoding(dataForDecoding, decodingTable); // decode된 결과값

        ReadAll.storeDecodeData("hw12_05_201502020_decoded.txt", decodedData); // 파일에 작성하는 코드 작성하기
    }
}
