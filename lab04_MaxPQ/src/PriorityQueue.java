public class PriorityQueue {
    public static Point[] arrayOfData;
    public static int size;

    private static void maxHeapify(Point[] points, int index) {
        int leftChild = 2 * index;
        int rightChild = 2 * index + 1;

        int largestIndex = index;
        if (leftChild <= size && points[leftChild].compareTo(points[index]) > 0) {
            largestIndex = leftChild;
        }
        if (rightChild <= size && points[rightChild].compareTo(points[largestIndex]) > 0) {
            largestIndex = rightChild;
        }
        if (largestIndex != index) {
            swap(points, index, largestIndex);
            maxHeapify(points, largestIndex);
        }
    }// 수도

    private static void swap(Point[] points, int indexOne, int indexTwo) {
        Point temp = points[indexOne];
        points[indexOne] = points[indexTwo];
        points[indexTwo] = temp;
    }

    public static void makeMaxHeap(Point[] array) {
        for (int rootIndex = size; rootIndex > 0; rootIndex--) {
            maxHeapify(array, rootIndex);
        }
    }

    public static void insert(Point[] points, Point x) {
        Point[] tempArray = points;
        if (points.length <= size + 1) {
            tempArray = new Point[2 * points.length];
            System.arraycopy(points, 1, tempArray, 1, size);
        }
        size++;
        tempArray[size] = x;

        makeMaxHeap(tempArray);

        arrayOfData = tempArray;
    }

    public static Point max(Point[] points) {
        return points[1];
    }

    public static Point extractMax(Point[] points) {
        Point maxResult = max(points);

        points[1] = points[size];
        points[size] = null;
        maxHeapify(points, 1);
        size--;

        return maxResult;
    }

    public static void increaseKey(Point[] points, int x, int k) {
        for (int index = 1; index <= size; index++) {
            if (points[index].number == x) {
                points[index].number = k;
                makeMaxHeap(points);

                return;
            }
        }
        System.out.println("해당 key 값은 존재 하지 않습니다.");
    }

    public static Point delete(Point[] points, int x) {
        for (int index = 1; index <= size; index++) {
            if (x == points[index].number) {
                Point temp = points[index];
                points[index] = points[size];
                points[size] = null;
                size--;

                makeMaxHeap(points);

                return temp;
            }
        }

        System.out.println("해당 key 값은 존재 하지 않습니다.");
        return null;
    }

    public static void printAll(Point[] datas) {
        for (Point data : datas) {
            if (data == null) {
                continue;
            }
            System.out.printf("%3d, %s\n", data.number, data.data);
        }
    }
}
