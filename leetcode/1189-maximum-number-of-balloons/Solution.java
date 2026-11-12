import java.util.HashMap;
import java.util.Map;

class Solution {

    private static String target = "balloon";

    private static Map<Character, Integer> countCharsFrom(String text, String target) {
        Map<Character, Integer> counts = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (target.indexOf(c) >= 0) {
                counts.put(c, counts.getOrDefault(c, 0) + 1);
            }
        }

        return counts;
    }

    public int maxNumberOfBalloons(String text) {

        Map<Character, Integer> textCounts = countCharsFrom(text, target);
        Map<Character, Integer> targetCounts = countCharsFrom(target, target);

        int min = Integer.MAX_VALUE;
        for (char c : targetCounts.keySet()) {
            min = Math.min(min, textCounts.getOrDefault(c, 0) / targetCounts.get(c));
        }

        return min;
    }

}
