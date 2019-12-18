import java.io.*;

public final class ReadData {

    public static Integer[] getArrayFromFile(String fileName) {
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
        Integer[] resultData = new Integer[splitData.length];
        for (int index = 0; index < splitData.length; index++) {
            resultData[index] = Integer.parseInt(splitData[index]);
        }

        return resultData;
    }

    public static boolean fileWriteData(String data, String fileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
