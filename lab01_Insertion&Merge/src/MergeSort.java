public class MergeSort<E extends Comparable<E>> extends AbstractSort<E> {
    private int numberOfMergeNumber;

    public int getNumberOfMergeNumber() {
        return this.numberOfMergeNumber;
    }

    public MergeSort(boolean inOrderOrPreOrder) {
        super(inOrderOrPreOrder);
    }

    @Override
    public void sort(E[] array) {
        this.numberOfMergeNumber = 0;
        Object[] result = new Object[array.length];
        this.mergeSort(array, result, 0, array.length - 1);
    }

    private void mergeSort(E[] array, Object[] result, int startIndex, int lastIndex) {
        if (startIndex < lastIndex) {
            int middle = (startIndex + lastIndex) / 2;
            this.mergeSort(array, result, startIndex, middle);
            this.mergeSort(array, result, middle + 1, lastIndex);
            this.merge(array, result, startIndex, middle, lastIndex);
        }
    }

    private void merge(E[] array, Object[] result, int startIndex, int middleIndex, int lastIndex) {
        this.numberOfMergeNumber += 1;
        int indexOfStartToMiddle = startIndex;
        int indexOfMiddleToLast = middleIndex + 1;
        int indexOfResult = startIndex;

        while (indexOfStartToMiddle <= middleIndex && indexOfMiddleToLast <= lastIndex) {
            if (compare(array[indexOfStartToMiddle], array[indexOfMiddleToLast]) <= 0) {
                result[indexOfResult] = array[indexOfStartToMiddle];
                indexOfStartToMiddle += 1;
            } else {
                result[indexOfResult] = array[indexOfMiddleToLast];
                indexOfMiddleToLast += 1;
            }
            indexOfResult += 1;
        }

        if (indexOfStartToMiddle > middleIndex) {
            for (int indexOfRestData = indexOfMiddleToLast; indexOfRestData <= lastIndex; indexOfRestData++) {
                result[indexOfResult] = array[indexOfRestData];
                indexOfResult += 1;
            }
        } else {
            for (int indexOfRestData = indexOfStartToMiddle; indexOfRestData <= middleIndex; indexOfRestData++) {
                result[indexOfResult] = array[indexOfRestData];
                indexOfResult += 1;
            }
        }

        for (int indexOfStartInResult = startIndex; indexOfStartInResult <= lastIndex; indexOfStartInResult++) {
            array[indexOfStartInResult] = (E) result[indexOfStartInResult];
        }
    }
}
