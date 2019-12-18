public class CountingInversions {
    public static final Point sortAndCount(int[] array) {
        if (array.length == 1) {
            return new Point(0, array);
        }
        int[] leftArray = new int[array.length / 2];
        int[] rightArray = new int[array.length - leftArray.length];
        System.arraycopy(array, 0, leftArray, 0, leftArray.length);
        System.arraycopy(array, leftArray.length, rightArray, 0, rightArray.length);
        Point leftResult = CountingInversions.sortAndCount(leftArray);
        Point rightResult = CountingInversions.sortAndCount(rightArray);
        Point mergedResult = CountingInversions.mergeAndCount(leftResult.array, rightResult.array);

        return new Point(leftResult.count + rightResult.count + mergedResult.count, mergedResult.array);
    }

    private static final Point mergeAndCount(int[] left, int[] right) {
        int inversionCount = 0;
        int indexOfA = 0;
        int indexOfB = 0;
        int[] resultArray = new int[left.length + right.length];
        int indexOfResult = 0;
        int countOfLeft = left.length;
        int countOfRight = right.length;
        while (countOfLeft != 0 && countOfRight != 0) {
            if (left[indexOfA] > right[indexOfB]) {
                inversionCount += countOfLeft;
                resultArray[indexOfResult] = right[indexOfB];
                indexOfB += 1;
                countOfRight--;
            } else {
                resultArray[indexOfResult] = left[indexOfA];
                indexOfA += 1;
                countOfLeft--;
            }
            indexOfResult += 1;
        }
        while (indexOfA < left.length) {
            resultArray[indexOfResult] = left[indexOfA];
            indexOfA += 1;
            indexOfResult += 1;
        }
        while (indexOfB < right.length) {
            resultArray[indexOfResult] = right[indexOfB];
            indexOfB += 1;
            indexOfResult += 1;
        }

        return new Point(inversionCount, resultArray);
    }
}

class Point {
    public int count;
    public int[] array;

    public Point(int count, int[] array) {
        this.count = count;
        this.array = array;
    }
}