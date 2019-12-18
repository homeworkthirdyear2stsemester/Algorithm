import java.util.LinkedList;
import java.util.List;

public class Algorithm {
    public static List<AllData> pointList = new LinkedList<>();

    public static double segmentedLeastSquares(int length, Point[] points, double cost) {
        double[][] inclination = new double[length][length]; // 기울기 저장
        double[][] intercept = new double[length][length]; // 절편 저장
        double[][] sse = new double[length][length]; // 오차 error 저장

        for (int indexOfY = 0; indexOfY < points.length; indexOfY++) {
            for (int indexOfX = 0; indexOfX <= indexOfY; indexOfX++) { // 시그마 값으 가짐
                int size = indexOfY - indexOfX + 1;
                if (size == 1) {
                    inclination[indexOfX][indexOfY] = 0;
                    intercept[indexOfX][indexOfY] = points[indexOfX].y;
                    sse[indexOfX][indexOfY] = 0;
                    break;
                } // 0을 나눠서 NaN을 없애기 위한 부분

                double sumXY = 0;
                double sumX = 0;
                double sumY = 0;
                double sumPowXTwo = 0;

                for (int indexOfSum = indexOfX; indexOfSum <= indexOfY; indexOfSum++) {// 시그마값
                    double nowX = points[indexOfSum].x;
                    double nowY = points[indexOfSum].y;
                    sumX += nowX;
                    sumY += nowY;
                    sumXY += nowX * nowY;
                    sumPowXTwo += nowX * nowX;
                }

                double nowInclination = (size * sumXY - sumX * sumY) / (size * sumPowXTwo - sumX * sumX); // 기울기
                double nowIntercept = (sumY - nowInclination * sumX) / size; // 절편
                inclination[indexOfX][indexOfY] = nowInclination;
                intercept[indexOfX][indexOfY] = nowIntercept;

                double sumErrorXToY = 0;
                for (int indexForSumOfError = indexOfX; indexForSumOfError <= indexOfY; indexForSumOfError++) {
                    sumErrorXToY += Math.pow((points[indexForSumOfError].y - nowInclination * points[indexForSumOfError].x - nowIntercept), 2);
                } // error 결과를 총합을 저장

                sse[indexOfX][indexOfY] = sumErrorXToY; // 결과저장
            }
        }

        double[] dpForSegmentedLeastSquares = new double[length]; // cost값 저장 하는 dp
        int[] optimalIndex = new int[length];// 최소 직전 index를 저장하는 배열 아무것도 없으면 자동으로 0을 저장

        for (int indexOfY = 0; indexOfY < length; indexOfY++) { // dp로 저장
            dpForSegmentedLeastSquares[indexOfY] = sse[0][indexOfY] + cost; // 처음부터 cost더하고 시작
            int minIndex = 0; // 최소 index 저장하는 곳
            for (int indexOfX = 1; indexOfX <= indexOfY; indexOfX++) {
                double dataOfCutting = dpForSegmentedLeastSquares[indexOfX - 1] + sse[indexOfX][indexOfY] + cost;
                if (dataOfCutting < dpForSegmentedLeastSquares[indexOfY]) {
                    dpForSegmentedLeastSquares[indexOfY] = dataOfCutting;
                    minIndex = indexOfX;
                }
            }
            optimalIndex[indexOfY] = minIndex;
        }

        int beforeIndex = optimalIndex[length - 1];
        int afterIndex = length - 1;
        while (afterIndex >= 0) { // 예외 경우
            pointList.add(new AllData(beforeIndex + 1, afterIndex + 1, inclination[beforeIndex][afterIndex], intercept[beforeIndex][afterIndex], sse[beforeIndex][afterIndex]));
            afterIndex = beforeIndex - 1;
            if (afterIndex < 0) {
                break; // 예외 경우 0 미만일경우 바운더리 문제 해결
            }
            beforeIndex = optimalIndex[afterIndex];
        }

        return dpForSegmentedLeastSquares[length - 1]; // 최종 값 출력
    }
}

class AllData {
    public int startIndex;
    public int lastIndex;
    public double inclination;
    public double intercept;
    public double squareError;

    public AllData(int startIndex, int lastIndex, double inclination, double intercept, double squareError) {
        this.startIndex = startIndex;
        this.inclination = inclination;
        this.intercept = intercept;
        this.squareError = squareError;
        this.lastIndex = lastIndex;
    }
}