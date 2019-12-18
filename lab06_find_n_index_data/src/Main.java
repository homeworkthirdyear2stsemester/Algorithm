public class Main {
    public static void main(String[] args) {
        int[] arrayA = ReadAndMakeArray.makeArray("data06_a.txt");
        int[] arrayB = ReadAndMakeArray.makeArray("data06_b.txt");

        if (arrayA != null) {
            System.out.println(BinarySearchOfTwoArray.binarySearch(arrayA, 5650));
        }

        System.out.println(BinarySearchOfTwoArray.binarySearchOfTwoArray(arrayA, arrayB));

    }
}
