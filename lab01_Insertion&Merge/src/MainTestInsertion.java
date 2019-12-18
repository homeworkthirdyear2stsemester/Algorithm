public class MainTestInsertion {
    public static void main(String[] args) {
        Integer[] ascendingArray = ReadData.getArrayFromFile("data02.txt");
        if (ascendingArray == null) {
            System.out.println("오류");
            return;
        }
        for (int data : ascendingArray) {
            System.out.print(data + " ");
        }
        System.out.println();

        Sort<Integer> ascendingSort = new InsertionSort<>(Sort.ASCENDING_ORDER);

        ascendingSort.sort(ascendingArray);

        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < ascendingArray.length; index++) {
            int data = ascendingArray[index];
            System.out.print(data + " ");
            if (index == ascendingArray.length - 1) {
                sb.append(data);
            } else {
                sb.append(data).append(",");
            }
        }
        System.out.println();

        System.out.println("file write result : " + ReadData.fileWriteData(sb.toString(), "hw01_05_201502020_insertion.txt"));

    }
}
