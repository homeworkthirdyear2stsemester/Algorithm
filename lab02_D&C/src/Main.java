import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 : Recursion");
        System.out.println("2 : Array");
        System.out.println("3 : Recursion squaring");
        int whatKind = scanner.nextInt();
        long startTime;
        BigInteger resultBig;
        long endTime;
        long result;
        for (int index = 0; index < 90; index++) {
            if(index % 10 == 0){
                System.out.println("-----------------------------------------------------------------------------");
            }
            if (whatKind == 1) {
                startTime = System.nanoTime();
                resultBig = Algorithm.fiboRecursive(index);
                endTime = System.nanoTime();
                result = endTime - startTime;
                System.out.printf("f<%2d> = %s %20.9f\n", index, resultBig.toString(), result/1000000000.0);
            } else if (whatKind == 2) {
                startTime = System.nanoTime();
                resultBig = Algorithm.fiboBottomUp(index);
                endTime = System.nanoTime();
                result = endTime - startTime;
                System.out.printf("f<%2d> = %s %20.9f\n", index, resultBig.toString(), result/1000000000.0);
            } else {
                startTime = System.nanoTime();
                resultBig = Algorithm.fiboRecursiveSquaring(index);
                endTime = System.nanoTime();
                result = endTime - startTime;
                System.out.printf("f<%2d> = %s %20.9f\n", index, resultBig.toString(), result/1000000000.0);
            }
        }
    }
}
