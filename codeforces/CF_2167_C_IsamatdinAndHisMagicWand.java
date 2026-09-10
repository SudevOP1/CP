import java.util.*;

public class CF_2167_C_IsamatdinAndHisMagicWand {

    public static int getDigitFromLeft(int num, int pos) {
        String numStr = String.valueOf(num);
        if (numStr.length() <= pos) {
            return 10;
        }
        return Character.getNumericValue(numStr.charAt(pos));
    }

    public static boolean isLexicographicallySmaller(int a, int b) {
        if (a == b) {
            return true;
        }
        int maxLen = Math.max(String.valueOf(a).length(), String.valueOf(b).length());
        for (int i = 0; i < maxLen; i++) {
            int aDig = getDigitFromLeft(a, i);
            int bDig = getDigitFromLeft(b, i);
            if (aDig < bDig) {
                return true;
            }
            if (aDig > bDig) {
                return false;
            }
        }
        return true; // will never reach here
    }

    public static int[] get_lexicograhically_sorted(int[] arr) {
        boolean hasEven = false;
        boolean hasOdd = false;

        for (int num : arr) {
            if (num % 2 == 0) {
                hasEven = true;
            } else {
                hasOdd = true;
            }
            if (hasEven && hasOdd) {
                break;
            }
        }

        if (hasEven && hasOdd) {
            int[] new_arr = arr.clone();
            Arrays.sort(new_arr);
            return new_arr;
        }

        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }

            int[] new_arr = get_lexicograhically_sorted(arr);

            for (int j = 0; j < n; j++) {
                System.out.printf("%d ", new_arr[j]);
            }
            System.out.printf("\n");
        }

        sc.close();
    }
}