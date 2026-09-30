
class Solution {

    public int[] maxDepthAfterSplit(String seq) {

        int n = seq.length();
        int[] answer = new int[n];
        int depth = 0;

        for (int i = 0; i < n; i++) {
            char curr = seq.charAt(i);
            char prev = i == 0 ? ' ' : seq.charAt(i - 1);

            if (i == 0) {
                depth += 1;
            }

            else if (prev == '(' && curr == '(') {
                depth += 1;
            }

            else if (prev == ')' && curr == ')') {
                depth -= 1;
            }

            // System.out.print(depth + " ");
            answer[i] = (depth + 1) % 2;
        }

        return answer;
    }

}
