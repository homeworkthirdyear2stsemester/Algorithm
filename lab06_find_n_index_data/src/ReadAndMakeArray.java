import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndMakeArray {

    public static int[] makeArray(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)))) {
            stringBuilder.append(bufferedReader.readLine());
        } catch (IOException e) {
            return null;
        }
        String result = stringBuilder.toString().replaceAll(",", "");

        String[] array = result.split(" ");

        int[] resultOfArray = new int[array.length];

        for (int index = 0; index < array.length; index++) {
            resultOfArray[index] = Integer.parseInt(array[index]);
        }

        return resultOfArray;
    }
}
