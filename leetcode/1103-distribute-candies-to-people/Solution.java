import java.util.Arrays;

class Solution {

    public int[] distributeCandies(int candies, int num_people) {

        int[] numCandies = new int[num_people];
        Arrays.fill(numCandies, 0);

        int i = 1;
        while (candies != 0) {
            numCandies[(i - 1 + num_people) % num_people] += i;
            candies -= i;
            if (candies <= 0) {
                numCandies[(i - 1 + num_people) % num_people] += candies;
                candies = 0;
            }
            i += 1;
        }

        return numCandies;
    }

}
