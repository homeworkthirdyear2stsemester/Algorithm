import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClosestPair {

    private static double distance(Pair a, Pair b) {
        double lengthOfX = a.x - b.x;
        double lengthOfY = a.y - b.y;

        return Math.sqrt(lengthOfX * lengthOfX + lengthOfY * lengthOfY);
    }

    public static double cloesetPair(Pair[] arrayOfPari, int startIndex, int endIndex) {
        if (endIndex - startIndex < 3) {
            double min = Double.MAX_VALUE;
            for (int index = startIndex; index < endIndex; index++) {
                for (int indexOfInner = startIndex + 1; indexOfInner <= endIndex; indexOfInner++) {
                    if (index != indexOfInner) {
                        min = Math.min(min, distance(arrayOfPari[index], arrayOfPari[indexOfInner]));
                    }
                }
            }
            return min;
        }

        Arrays.sort(arrayOfPari, (first, secnod) -> {
            if (first.x > secnod.x) {
                return 1;
            } else if (first.x == secnod.x) {
                return 0;
            }
            return -1;
        });

        int middle = (endIndex + startIndex) / 2;
        double middlePointX = (arrayOfPari[middle].x + arrayOfPari[middle + 1].x) / 2;

        double leftShortestLength = cloesetPair(arrayOfPari, startIndex, middle);
        double rightShortestLength = cloesetPair(arrayOfPari, middle + 1, endIndex);

        double middleTermLenght = Math.min(leftShortestLength, rightShortestLength);

        List<Pair> termPairData = new ArrayList<>();
        double lastLeftPointX = middlePointX - middleTermLenght;
        double lastRightPointX = middlePointX + middleTermLenght;
        for (Pair data : arrayOfPari) {
            if (lastLeftPointX <= data.x && data.x <= lastRightPointX) {
                termPairData.add(data);
            }
        }

        Collections.sort(termPairData, (first, second) -> {
            if (first.y < second.y) {
                return -1;
            } else if (first.y == second.y) {
                return 0;
            }
            return 1;
        });

        for (int indexOfX = 0; indexOfX < termPairData.size() - 1; indexOfX++) {
            int maxIndexOfY = Math.min(termPairData.size(), indexOfX + 4);
            for (int indexOfY = indexOfX + 1; indexOfY < maxIndexOfY; indexOfY++) {
                double distanceOfEach = distance(termPairData.get(indexOfX), termPairData.get(indexOfY));
                middleTermLenght = Math.min(middleTermLenght, distanceOfEach);
            }
        }

        return middleTermLenght;
    }
}

class Pair {
    double x;
    double y;
}
