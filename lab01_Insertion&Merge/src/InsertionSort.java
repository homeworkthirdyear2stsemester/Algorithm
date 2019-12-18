

public class InsertionSort<E extends Comparable<E>> extends AbstractSort<E> {

    public InsertionSort(boolean inOrderOrPreOrder) {
        super(inOrderOrPreOrder);
    }

    @Override
    public void sort(E[] array) {
        for (int indexOfArray = array.length - 2; indexOfArray >= 0; indexOfArray--) {
            int beforeIndex = indexOfArray;
            for (int indexOfInsert = indexOfArray + 1; indexOfInsert < array.length; indexOfInsert++) {
                if (this.compare(array[beforeIndex], array[indexOfInsert]) > 0) {
                    this.swap(array, beforeIndex, indexOfInsert);
                    beforeIndex = indexOfInsert;
                } else {
                    break;
                }
            }
        }
    }
}
