import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public static void sortByValue(List<Integer> idx, int[] nums) {
        if (idx == null || idx.size() <= 1) {
            return;
        }
        sortByValue(idx, nums, 0, idx.size() - 1);
    }

    public static void sortByValue(List<Integer> idx, int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            sortByValue(idx, nums, left, mid);
            sortByValue(idx, nums, mid + 1, right);
            mergeByValue(idx, nums, left, mid, right);
        }
    }

    public static void mergeByValue(List<Integer> idx, int[] nums, int left, int mid, int right) {
        List<Integer> leftSubList = new ArrayList<>(idx.subList(left, mid + 1));
        List<Integer> rightSubList = new ArrayList<>(idx.subList(mid + 1, right + 1));

        int i = 0, j = 0;
        int k = left;

        while (i < leftSubList.size() && j < rightSubList.size()) {
            if (nums[leftSubList.get(i)] <= nums[rightSubList.get(j)]) {
                idx.set(k, leftSubList.get(i));
                i++;
            } else {
                idx.set(k, rightSubList.get(j));
                j++;
            }
            k++;
        }

        while (i < leftSubList.size()) {
            idx.set(k, leftSubList.get(i));
            i++;
            k++;
        }

        while (j < rightSubList.size()) {
            idx.set(k, rightSubList.get(j));
            j++;
            k++;
        }
    }

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {

        int n = nums.length;

        List<Integer> order = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            order.add(i);
        }
        sortByValue(order, nums);

        int[] result = new int[n];
        int groupStart = 0;
        for (int end = 1; end <= n; end++) {
            if (end == n || nums[order.get(end)] - nums[order.get(end - 1)] > limit) {
                List<Integer> positions = new ArrayList<>(order.subList(groupStart, end));
                positions.sort(null);
                for (int i = 0; i < positions.size(); i++) {
                    result[positions.get(i)] = nums[order.get(groupStart + i)];
                }
                groupStart = end;
            }
        }

        return result;
    }

    // public static void main(String[] args) {
    // Solution s = new Solution();
    // System.out.println(Arrays.toString(s.lexicographicallySmallestArray(new int[]
    // { 1, 7, 6, 18, 2, 1 }, 3)));
    // }

}
