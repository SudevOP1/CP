import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

    private static final int MOD = 1_000_000_007;

    public int countRestrictedPaths(int n, int[][] edges) {

        // adjacency list: adj[u] = [v, weight]
        List<int[]>[] adj = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            adj[e[0]].add(new int[] { e[1], e[2] });
            adj[e[1]].add(new int[] { e[0], e[2] });
        }

        // dijkstra from node n
        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[n] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.add(new long[] { n, 0 });

        while (!pq.isEmpty()) {
            long[] top = pq.poll();
            int u = (int) top[0];
            long d = top[1];
            if (d > dist[u]) {
                continue;
            }
            for (int[] next : adj[u]) {
                int v = next[0];
                long nd = d + next[1];
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.add(new long[] { v, nd });
                }
            }
        }

        // process nodes in increasing dist order
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) {
            order[i] = i + 1;
        }
        Arrays.sort(order, (a, b) -> Long.compare(dist[a], dist[b]));

        long[] ways = new long[n + 1];
        ways[n] = 1;

        for (int idx = 0; idx < n; idx++) {
            int u = order[idx];
            if (u == n) {
                continue;
            }
            long total = 0;
            for (int[] next : adj[u]) {
                int v = next[0];
                if (dist[v] < dist[u]) {
                    total += ways[v];
                }
            }
            ways[u] = total % MOD;
        }

        return (int) ways[1];
    }

}
