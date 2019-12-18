public abstract class AbstractSort<E extends Comparable<E>> implements Sort<E> {

    private boolean inOrderOrPreOrder; // true : 오름차순, false : 내림차순

    boolean getInOrderOrPreOrder() {
        return this.inOrderOrPreOrder;
    }

    public AbstractSort(boolean inOrderOrPreOrder) { // 생서자
        this.inOrderOrPreOrder = inOrderOrPreOrder;
    }

    boolean swap(E[] array, int indexA, int indexB) {
        if (indexA >= 0 && indexA < array.length && indexB >= 0 && indexB < array.length) {
            E tempData = array[indexA];
            array[indexA] = array[indexB];
            array[indexB] = tempData;

            return true;
        }

        return false;
    }

    int compare(E firstData, E secondData) {
        if (this.inOrderOrPreOrder) {
            return firstData.compareTo(secondData);
        }

        return -firstData.compareTo(secondData);
    }
}
