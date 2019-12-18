public class MainTestMerge {
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

        Sort<Integer> ascendingSort = new MergeSort<>(Sort.ASCENDING_ORDER);

        ascendingSort.sort(ascendingArray);

        StringBuilder sb = new StringBuilder();
        for (int data : ascendingArray) {
            System.out.print(data + " ");
            sb.append(data).append(",");
        }
        System.out.println();
        System.out.println("merge number : " + ((MergeSort) ascendingSort).getNumberOfMergeNumber());
        sb.append(((MergeSort) ascendingSort).getNumberOfMergeNumber());
        System.out.println("file write result : " + ReadData.fileWriteData(sb.toString(), "hw01_05_201502020_merge.txt"));
    }
}
