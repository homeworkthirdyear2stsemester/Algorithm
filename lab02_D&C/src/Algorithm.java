import java.math.BigInteger;

public class Algorithm {

    public static final int poweringNumber(int number, int powNumber) {
        if (powNumber == 0) {
            return 1;
        } else if (powNumber == 1) {
            return number;
        } else if (powNumber % 2 == 0) {
            int getData = Algorithm.poweringNumber(number, powNumber / 2);

            return getData * getData;
        }
        int getData = Algorithm.poweringNumber(number, (powNumber - 1) / 2);

        return getData * getData * number;
    }

    public static final BigInteger fiboRecursive(int number) {
        if (number == 0) {
            return new BigInteger("0");
        } else if (number == 1) {
            return new BigInteger("1");
        } else if (number == 2) {
            return new BigInteger("1");
        }

        return Algorithm.fiboRecursive(number - 1).add(Algorithm.fiboRecursive(number - 2));
    }

    public static final BigInteger fiboBottomUp(int number) {
        if (number == 0) {
            return new BigInteger("0");
        } else if (number == 1) {
            return new BigInteger("1");
        } else if (number == 2) {
            return new BigInteger("1");
        }

        BigInteger[] dp = new BigInteger[number + 1];
        dp[0] = new BigInteger("0");
        dp[1] = new BigInteger("1");
        dp[2] = dp[1];

        for (int index = 3; index <= number; index++) {
            dp[index] = dp[index - 1].add(dp[index - 2]);
        }

        return dp[number];
    }

    public static final BigInteger fiboRecursiveSquaring(int number) {
        if (number == 0) {
            return new BigInteger("0");
        } else if (number == 1) {
            return new BigInteger("1");
        } else if (number == 2) {
            return new BigInteger("1");
        }
        BigInteger fn = new BigInteger("1");
        BigInteger[][] arrayOfSquare = {{new BigInteger("1"), fn}, {fn, new BigInteger("0")}};

        return Algorithm.pow(arrayOfSquare, number - 1)[0][0];
    }

    private static BigInteger[][] pow(BigInteger[][] arrayOfSquare, int number) {
        if (number == 1) {
            return arrayOfSquare;
        } else if (number % 2 == 0) {
            BigInteger[][] result = Algorithm.pow(arrayOfSquare, number / 2);
            return Algorithm.mul(result, result);
        }
        BigInteger[][] result = Algorithm.pow(arrayOfSquare, (number - 1) / 2);

        return Algorithm.mul(Algorithm.mul(result, result), arrayOfSquare);
    }

    private static BigInteger[][] mul(BigInteger[][] firstArray, BigInteger[][] secondArray) {
        BigInteger[][] result = new BigInteger[2][2];
        result[0][0] = firstArray[0][0].multiply(secondArray[0][0]).add(firstArray[0][1].multiply(secondArray[1][0]));
        result[0][1] = firstArray[0][0].multiply(secondArray[0][1]).add(firstArray[0][1].multiply(secondArray[1][1]));
        result[1][0] = firstArray[1][0].multiply(secondArray[0][0]).add(firstArray[1][1].multiply(secondArray[1][0]));
        result[1][1] = firstArray[1][0].multiply(secondArray[0][1]).add(firstArray[1][1].multiply(secondArray[1][1]));

        return result;
    }
}
