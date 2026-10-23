import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    private static final Map<Character, String> numsToChars = new HashMap<>();
    static {
        numsToChars.put('2', "abc");
        numsToChars.put('3', "def");
        numsToChars.put('4', "ghi");
        numsToChars.put('5', "jkl");
        numsToChars.put('6', "mno");
        numsToChars.put('7', "pqrs");
        numsToChars.put('8', "tuv");
        numsToChars.put('9', "wxyz");
    }

    private static List<String> letterCombinations;

    public void letterCombinations(String digits, int i, String cur) {
        int n = digits.length();
        if (i == n) {
            letterCombinations.add(cur);
            return;
        }

        StringBuilder sb = new StringBuilder(cur);
        for (Character c : numsToChars.get(digits.charAt(i)).toCharArray()) {
            sb.append(c);
            letterCombinations(digits, i + 1, sb.toString());
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        letterCombinations = new ArrayList<>();
        letterCombinations(digits, 0, "");
        return letterCombinations;
    }

}
