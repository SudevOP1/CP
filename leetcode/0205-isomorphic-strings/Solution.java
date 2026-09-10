
class Solution {

    public boolean isIsomorphic(String s, String t) {

        int n = s.length();

        int[] sSeen = new int[128];
        int[] tSeen = new int[128];

        for (int i = 0; i < n; i++) {

            char a = s.charAt(i);
            char b = t.charAt(i);

            if (sSeen[a] != tSeen[b]) {
                return false;
            }

            sSeen[a] = i + 1;
            tSeen[b] = i + 1;
        }

        return true;
    }

}
