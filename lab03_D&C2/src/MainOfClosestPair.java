public class MainOfClosestPair {
    public static void main(String[] args) {
        Pair[] arrayOfPair = FileReader.readAllPairs("data03_closest.txt");

        System.out.println(ClosestPair.cloesetPair(arrayOfPair, 0, arrayOfPair.length - 1));
    }
}
