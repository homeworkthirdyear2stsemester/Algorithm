import java.io.*;

public class ReadData {

    public static int[] getArrayFromFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
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
    }

    public static boolean writeAllStr(String data, String filename) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename))) {
            bufferedWriter.write(data);
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
