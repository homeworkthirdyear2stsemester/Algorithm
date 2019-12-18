public class Main {
    public static void main(String[] args) {
        double[] doubleData = ReadData.readDataFromText("data07.txt");
        if (doubleData == null) {
            return;
        }

        int lenghtOfArray = (int) doubleData[0];
        int cost = (int) doubleData[doubleData.length - 1];

        Point[] points = ReadData.convertDoubleArrayToPointArray(doubleData);

        System.out.println("Cost of the optional solution : " +
                Algorithm.segmentedLeastSquares(lenghtOfArray, points, cost));
        System.out.println();
        System.out.println("An optional Soulution : ");
        for (int index = Algorithm.pointList.size() - 1; index >= 0; index--) { // 출력부
            AllData allData = Algorithm.pointList.get(index);
            System.out.println("[Segment " + allData.startIndex + " - " +
                    allData.lastIndex + "] : y = " + allData.inclination + " * x + " +
                    allData.intercept + "  //  square error : " + allData.squareError);
        }
    }
}
