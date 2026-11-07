import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

    public int[] assignTasks(int[] servers, int[] tasks) {

        int n = servers.length;
        int m = tasks.length;

        int[] ans = new int[m];
        long seconds = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(tasks[0]);

        int arrived = 1;
        int assigned = 0;

        // free servers (weight, index)
        PriorityQueue<Integer> free = new PriorityQueue<>(
                (a, b) -> servers[a] != servers[b] ? servers[a] - servers[b] : a - b);

        // busy servers {freeAt, index}, ordered by freeAt
        PriorityQueue<long[]> busy = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

        for (int i = 0; i < n; i++) {
            free.offer(i);
        }

        while (true) {

            while (!busy.isEmpty() && busy.peek()[0] <= seconds) {
                free.offer((int) busy.poll()[1]);
            }

            while (!queue.isEmpty() && !free.isEmpty()) {
                int best = free.poll();
                ans[assigned++] = best;
                busy.offer(new long[] { seconds + queue.poll(), best });
            }

            if (assigned == m) {
                break;
            }

            if (queue.isEmpty()) {
                seconds = arrived;
            } else {
                seconds = busy.peek()[0];
            }

            while (arrived < m && arrived <= seconds) {
                queue.offer(tasks[arrived++]);
            }
        }

        return ans;
    }

}
