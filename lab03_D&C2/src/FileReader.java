import java.io.BufferedReader;
import java.io.IOException;

public class FileReader {
    public static int[] getIntArrayFromFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                line = line.replaceAll("\n", " ");
                line = line.replaceAll(",", " ");
                sb.append(line).append(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        String resultStringData = sb.toString();
        String[] splitData = resultStringData.split(" ");
        int[] resultData = new int[splitData.length];
        for (int index = 0; index < splitData.length; index++) {
            resultData[index] = Integer.parseInt(splitData[index]);
        }

        return resultData;
    } // int 형으로 배열 반환

    public static Pair[] readAllPairs(String fileName) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                line = line.replaceAll("\n", " ");
                line = line.replaceAll(",", " ");
                sb.append(line).append(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        String resultStringData = sb.toString();
        String[] splitData = resultStringData.split(" ");
        Pair[] resultData = new Pair[splitData.length / 2];
        for (int index = 0; index < splitData.length; index++) {
            double nowData = Double.parseDouble(splitData[index]);
            if (index % 2 == 0) {
                resultData[index / 2] = new Pair();
                resultData[index / 2].x = nowData;
            } else {
                resultData[index / 2].y = nowData;
            }
        }

        return resultData;
    }
}
