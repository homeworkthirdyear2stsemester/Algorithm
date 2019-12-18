import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ReadDataFromFile {
    public static PackObject[] readAllData(String fileName) {
        PackObject[] packObjects;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String oneLineData;
            List<StringTokenizer> tokenizersList = new ArrayList<>();
            while ((oneLineData = bufferedReader.readLine()) != null) {
                StringTokenizer stringTokenizer = new StringTokenizer(oneLineData, ",");
                tokenizersList.add(stringTokenizer);
            }

            packObjects = new PackObject[tokenizersList.size()];
            for (int index = 0; index < tokenizersList.size(); index++) {
                StringTokenizer stringTokenizer = tokenizersList.get(index);
                packObjects[index] = new PackObject(Integer.parseInt(stringTokenizer.nextToken()),
                        Integer.parseInt(stringTokenizer.nextToken()),
                        Integer.parseInt(stringTokenizer.nextToken()));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return packObjects;
    }
}

