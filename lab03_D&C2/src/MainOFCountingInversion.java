public class MainOFCountingInversion {
    public static void main(String[] args) {
        int[] arrayOfIntData = FileReader.getIntArrayFromFile("data03_inversion.txt");

        System.out.println("Output Data : ");
        Point result = CountingInversions.sortAndCount(arrayOfIntData);
        for (int index = 0; index < result.array.length; index++) {
            System.out.print(result.array[index] + " ");
        }
        System.out.println();
        System.out.println(result.count);
    }
}
