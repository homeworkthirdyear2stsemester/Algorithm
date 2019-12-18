import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("data04.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append(",");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String resultData = stringBuilder.toString();
        String[] spliteData = resultData.split(",");
        PriorityQueue.arrayOfData = new Point[spliteData.length / 2 + 1];
        PriorityQueue.size = PriorityQueue.arrayOfData.length - 1;

        for (int index = 0; index < spliteData.length / 2; index++) {
            PriorityQueue.arrayOfData[index + 1] = new Point(Integer.parseInt(spliteData[2 * index]), spliteData[2 * index + 1].substring(1));
        }

        PriorityQueue.makeMaxHeap(PriorityQueue.arrayOfData);

        while (true) {
            PriorityQueue.printAll(PriorityQueue.arrayOfData);
            System.out.println("--------------------------------------------");
            System.out.println("1. 작업추가 2. 최대값 3. 최대 우선순위 작업 처리");
            System.out.println("4. 원소 키값 증가,    5. 작업 제거     6. 종료");
            System.out.println("--------------------------------------------");
            int number = scanner.nextInt();
            if (number == 6) {
                break;
            }
            int key;
            String value;
            int newKey;
            switch (number) {
                case 1:
                    System.out.print("key : ");
                    key = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("value : ");
                    value = scanner.nextLine();
                    PriorityQueue.insert(PriorityQueue.arrayOfData, new Point(key, value));
                    break;
                case 2:
                    System.out.println("최대값 : " + PriorityQueue.max(PriorityQueue.arrayOfData));
                    break;
                case 3:
                    System.out.println("최대 우선 순위 작업 처리 : " + PriorityQueue.extractMax(PriorityQueue.arrayOfData));
                    break;
                case 4:
                    System.out.print("변경을 원하는 key : ");
                    key = scanner.nextInt();
                    System.out.print("변경할 key : ");
                    newKey = scanner.nextInt();
                    PriorityQueue.increaseKey(PriorityQueue.arrayOfData, key, newKey);
                    break;
                case 5:
                    System.out.print("제거 하고싶은 key 값 : ");
                    key = scanner.nextInt();
                    PriorityQueue.delete(PriorityQueue.arrayOfData, key);
                    break;
            }
        }
    }
}
