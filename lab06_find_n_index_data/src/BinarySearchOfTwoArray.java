public class BinarySearchOfTwoArray {

    public static int binarySearchOfTwoArray(int[] firstArray, int[] secondArray) {
        int indexOfWantToSearch = firstArray.length; // 원하는 index - 1의 값을 넣는다

        int firstArrayIndex = indexOfWantToSearch / 2;
        int secondArrayIndex = indexOfWantToSearch - firstArrayIndex;

        int step = indexOfWantToSearch / 4;

        while (step > 0) {
            if (firstArrayIndex < 0) {
                if (secondArray.length < indexOfWantToSearch) {
                    return firstArray[indexOfWantToSearch - secondArray.length - 1];
                } else {
                    return secondArray[indexOfWantToSearch - 1];
                }
            }

            if (firstArray[firstArrayIndex - 1] > secondArray[secondArrayIndex - 1]) {
                firstArrayIndex -= step;
                secondArrayIndex += step;
            } else {
                firstArrayIndex += step;
                secondArrayIndex -= step;
                step /= 2;
            }
        }

        return Math.max(firstArray[firstArrayIndex - 1], secondArray[secondArrayIndex - 1]);
        // 해당 index에서 큰값이 indexOfWanToSearch의 값이다.
    }

    public static int binarySearch(int[] array, int findData) {
        int searchLength = (array.length - 1) / 2;
        int leftIndex = 0;
        int rightIndex = array.length - 1;
        int mid;

        while (leftIndex < rightIndex) {
            mid = leftIndex + searchLength;

            if (array[mid] > findData) {
                rightIndex = mid;
            } else if (array[mid] < findData) {
                leftIndex = mid;
            } else {
                return mid;
            }

            searchLength = (rightIndex - leftIndex) / 2;
        }

        return -1;
    }
}
