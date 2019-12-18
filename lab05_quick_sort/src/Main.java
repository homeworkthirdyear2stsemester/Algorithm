public class Main {
    public static void main(String[] args) {
        int[] data = ReadData.getArrayFromFile("data05.txt");
        int[] randomData = ReadData.getArrayFromFile("data05.txt");

        QuickSort.quickSort(data, 0, data.length - 1);
        QuickSort.quickSortWithRandom(randomData, 0, randomData.length - 1);

        int[] resultData = ReadData.getArrayFromFile("data05_sorted.txt");
        StringBuilder resultForStoreAtData = new StringBuilder();

        if (data.length == resultData.length) {
            for (int index = 0; index < data.length; index++) {
                if (index == data.length - 1) {
                    resultForStoreAtData.append(data[index]);
                } else {
                    resultForStoreAtData.append(data[index]).append(",");
                }
                if (data[index] != resultData[index]) {
                    System.out.println("error");
                    break;
                }
            }
        }

        StringBuilder resultForRandomStoreAtData = new StringBuilder();

        if (randomData.length == resultData.length) {
            for (int index = 0; index < randomData.length; index++) {
                if (index == data.length - 1) {
                    resultForRandomStoreAtData.append(randomData[index]);
                } else {
                    resultForRandomStoreAtData.append(randomData[index]).append(",");
                }

                if (randomData[index] != resultData[index]) {
                    System.out.println("error");
                    break;
                }
            }
        }

        System.out.println(ReadData.writeAllStr(resultForStoreAtData.toString(), "hw03_05_201502020_quick.txt"));
        System.out.println(ReadData.writeAllStr(resultForRandomStoreAtData.toString(), "hw03_05_201502020_quickRandom.txt"));
    }
}
