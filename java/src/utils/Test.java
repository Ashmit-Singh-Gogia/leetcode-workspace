package utils;

import java.util.Arrays;
import java.util.Objects;

public class Test {
    private static int caseNum = 1;

    public static void reset() {
        caseNum = 1;
    }

    public static void expect(Object actual, Object expected) {
        printResult(Objects.equals(actual, expected), actual, expected);
    }

    public static void expect(int[] actual, int[] expected) {
        printResult(Arrays.equals(actual, expected), Arrays.toString(actual), Arrays.toString(expected));
    }

    public static void expect(int[][] actual, int[][] expected) {
        printResult(Arrays.deepEquals(actual, expected), Arrays.deepToString(actual), Arrays.deepToString(expected));
    }

    private static void printResult(boolean passed, Object actual, Object expected) {
        if (passed) {
            System.out.printf("✅ Test Case %d: PASSED\n", caseNum++);
        } else {
            System.out.printf("❌ Test Case %d: FAILED\n   Expected: %s\n   Got:      %s\n", caseNum++, expected, actual);
        }
    }
}
