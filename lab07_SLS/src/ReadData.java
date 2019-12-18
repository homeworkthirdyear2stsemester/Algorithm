import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadData {
    public static double[] readDataFromText(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            stringBuilder.append(bufferedReader.readLine());
        } catch (IOException e) {
            return null;
        }
        String resultStringData = stringBuilder.toString();

        String[] splitedData = resultStringData.split(",");
        double[] result = new double[splitedData.length];

        for (int index = 0; index < result.length; index++) {
            result[index] = Double.parseDouble(splitedData[index]);
        }

        return result;
    }

    public static Point[] convertDoubleArrayToPointArray(double[] doubleArray) {
        if (doubleArray == null || doubleArray.length % 2 != 0) {
            return null;
        }
        int length = (int) doubleArray[0];
        Point[] points = new Point[length];

        for (int index = 0; index < points.length; index++) {
            int doubleArrayIndex = (index + 1) * 2;
            points[index] = new Point(doubleArray[doubleArrayIndex - 1], doubleArray[doubleArrayIndex]);
        }

        return points;
    }
}
