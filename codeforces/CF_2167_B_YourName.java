import java.util.*;

public class CF_2167_B_YourName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < t; i++) {
            char[] name1 = sc.next().toCharArray();
            char[] name2 = sc.next().toCharArray();
            Arrays.sort(name1);
            Arrays.sort(name2);
            if (Arrays.equals(name1, name2)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}