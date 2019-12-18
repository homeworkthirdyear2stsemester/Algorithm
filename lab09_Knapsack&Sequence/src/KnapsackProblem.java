import java.util.ArrayList;

public class KnapsackProblem {
    public static int knapsack(PackObject[] packObjects, int weightData) {
        int weigthNumber = weightData + 1;
        int[][] sumMinWeigth = new int[packObjects.length + 1][weigthNumber];
        ArrayList[] nowRowList = new ArrayList[weigthNumber];
        for (int index = 0; index < weigthNumber; index++) {
            nowRowList[index] = new ArrayList<Integer>();
        }

        for (int indexOfRow = 1; indexOfRow <= packObjects.length; indexOfRow++) {
            ArrayList[] nextRowList = new ArrayList[weigthNumber];
            nextRowList[0] = new ArrayList<Integer>();
            for (int indexOfCol = 1; indexOfCol < weigthNumber; indexOfCol++) {
                if (packObjects[indexOfRow - 1].weight > indexOfCol) {
                    sumMinWeigth[indexOfRow][indexOfCol] = sumMinWeigth[indexOfRow - 1][indexOfCol];
                    nextRowList[indexOfCol] = (ArrayList) nowRowList[indexOfCol].clone();
                } else {
                    int beforeDataResult = sumMinWeigth[indexOfRow - 1][indexOfCol];
                    int nextDataResult = sumMinWeigth[indexOfRow - 1][indexOfCol - packObjects[indexOfRow - 1].weight] + packObjects[indexOfRow - 1].value;
                    if (beforeDataResult >= nextDataResult) {
                        sumMinWeigth[indexOfRow][indexOfCol] = beforeDataResult;
                        nextRowList[indexOfCol] = (ArrayList) nowRowList[indexOfCol].clone();
                    } else {
                        sumMinWeigth[indexOfRow][indexOfCol] = nextDataResult;
                        nextRowList[indexOfCol] = (ArrayList) nowRowList[indexOfCol - packObjects[indexOfRow - 1].weight].clone();
                        nextRowList[indexOfCol].add(packObjects[indexOfRow - 1].itenNum);
                    }
                }
            }
            nowRowList = nextRowList;
        }

        for (int indexOfRow = 0; indexOfRow <= packObjects.length; indexOfRow++) {
            for (int indexOfCol = 0; indexOfCol < weigthNumber; indexOfCol++) {
                System.out.printf("%4d", sumMinWeigth[indexOfRow][indexOfCol]);
            }
            System.out.println();
        }
        System.out.println("item : " + nowRowList[weightData]);

        return sumMinWeigth[packObjects.length][weigthNumber - 1];
    }
}
