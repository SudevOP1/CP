import java.util.*;

public class CF_2050_A_LineBreaks {

    public static int solveLineBreaks(int n, int m, String[] words) {
        int x = 0;
        for (String word : words) {
            if (word.length() <= m) {
                m -= word.length();
                x += 1;
            } else {
                break;
            }
        }
        return x;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            String[] words = new String[n];
            for (int j = 0; j < n; j++) {
                words[j] = sc.nextLine();
            }
            System.out.println(solveLineBreaks(n, m, words));
        }

        sc.close();
    }
}
