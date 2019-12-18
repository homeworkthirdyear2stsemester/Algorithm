import java.util.Random;

public class QuickSort {
    private static Random random = new Random();

    public static void quickSort(int[] array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int middle = QuickSort.partition(array, leftIndex, rightIndex);
            QuickSort.quickSort(array, leftIndex, middle - 1);
            QuickSort.quickSort(array, middle + 1, rightIndex);
        }
    }

    public static void quickSortWithRandom(int[] array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int middle = QuickSort.randomizedPartition(array, leftIndex, rightIndex);
            QuickSort.quickSortWithRandom(array, leftIndex, middle - 1);
            QuickSort.quickSortWithRandom(array, middle + 1, rightIndex);
        }
    }

    private static int partition(int[] array, int leftIndex, int rightIndex) {
        int pivotData = array[rightIndex];
        int pivotIndex = leftIndex - 1;
        for (int indexOfNowData = leftIndex; indexOfNowData < rightIndex; indexOfNowData++) {
            if (array[indexOfNowData] <= pivotData) {
                pivotIndex = pivotIndex + 1;
                QuickSort.swap(array, pivotIndex, indexOfNowData);
            }
        }
        pivotIndex += 1;
        QuickSort.swap(array, pivotIndex, rightIndex);

        return pivotIndex;
    }

    private static void swap(int[] array, int indexFirst, int indexSecond) {
        int temp = array[indexFirst];
        array[indexFirst] = array[indexSecond];
        array[indexSecond] = temp;
    }

    private static int randomizedPartition(int[] array, int leftIndex, int rightIndex) {
        int pivotA = random.nextInt(rightIndex - leftIndex) + leftIndex;
        int pivotB = random.nextInt(rightIndex - leftIndex) + leftIndex;
        int pivotC = random.nextInt(rightIndex - leftIndex) + leftIndex;

        int pivot;
        if (pivotA > pivotB) {
            if (pivotC > pivotA) {
                pivot = pivotA;
            } else if (pivotB > pivotC) {
                pivot = pivotB;
            } else {
                pivot = pivotB;
            }
        } else if (pivotA < pivotC) {
            pivot = Math.min(pivotC, pivotB);
        } else {
            pivot = pivotA;
        }

        QuickSort.swap(array, rightIndex, pivot);
        return QuickSort.partition(array, leftIndex, rightIndex);
    }
}
