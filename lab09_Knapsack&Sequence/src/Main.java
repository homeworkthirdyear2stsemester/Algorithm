import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PackObject[] array = ReadDataFromFile.readAllData("data09_knapsack.txt");
        System.out.print("배낭 사이즈를 입력하세요(0~50) : ");
        int maxWeigth = scanner.nextInt();
        if (array != null) {
            System.out.println("max : " + KnapsackProblem.knapsack(array, maxWeigth));
        }
    }
}
