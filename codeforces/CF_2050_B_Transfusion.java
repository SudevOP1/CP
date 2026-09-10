import java.util.*;

public class CF_2050_B_Transfusion {

    public static boolean solveTransfusion(int[] nums) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % nums.length != 0) {
            return false;
        }
        long avg = sum / nums.length;
        int i;
        for (i = 0; i < nums.length - 2; i++) {
            nums[i + 2] += (nums[i] - avg);
        }
        if (nums[i] == avg && nums[i + 1] == avg) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = sc.nextInt();
            }
            if (solveTransfusion(nums)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}
