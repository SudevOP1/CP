import java.util.HashMap;
import java.util.Map;

class Solution {
    public int romanToInt(String s) {

        Map<Character, Integer> romanToIntMap = new HashMap<>();
        romanToIntMap.put('I', 1);
        romanToIntMap.put('V', 5);
        romanToIntMap.put('X', 10);
        romanToIntMap.put('L', 50);
        romanToIntMap.put('C', 100);
        romanToIntMap.put('D', 500);
        romanToIntMap.put('M', 1000);

        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            int current = romanToIntMap.get(s.charAt(i));

            if (i + 1 < s.length() && current < romanToIntMap.get(s.charAt(i + 1))) {
                answer -= current;
            } else {
                answer += current;
            }
        }

        return answer;
    }
}
