import java.util.*;

public class CF_2155_A_ElFucho {

    public static int calcElFucho(int n) {
        int numW = n;
        int numL = 0;
        int numMatches = 0;

        while (!(numW == 1 && numL == 1)) {
            int lMatches = numL / 2;
            int wMatches = numW / 2;

            numW -= wMatches;
            numL -= lMatches;
            numL += wMatches;

            numMatches += wMatches + lMatches;
        }

        // +1 for final match
        return numMatches + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            System.out.printf("%d\n", calcElFucho(sc.nextInt()));
        }

        sc.close();
    }
}
