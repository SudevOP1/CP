import java.util.*;

public class CF_2167_D_YetAnotherArrayProblem {

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static long getMaxNum(long[] arr) {
        long maxNum = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxNum) {
                maxNum = arr[i];
            }
        }
        return maxNum;
    }

    public static long getX(long[] arr) {
        for (int x = 2; x <= getMaxNum(arr) + 1; x++) {
            boolean flag = false;
            for (int j = 0; j < arr.length; j++) {
                if (gcd(arr[j], x) == 1) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                return x;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            long[] arr = new long[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextLong();
            }
            System.out.println(getX(arr));
        }

        sc.close();
    }
}