import java.util.Map;
import java.util.HashMap;

class Solution {

    private static final int[] keys = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    private static final Map<Integer, String> intToRomanMap = new HashMap<>();
    static {
        intToRomanMap.put(1000, "M");
        intToRomanMap.put(900, "CM");
        intToRomanMap.put(500, "D");
        intToRomanMap.put(400, "CD");
        intToRomanMap.put(100, "C");
        intToRomanMap.put(90, "XC");
        intToRomanMap.put(50, "L");
        intToRomanMap.put(40, "XL");
        intToRomanMap.put(10, "X");
        intToRomanMap.put(9, "IX");
        intToRomanMap.put(5, "V");
        intToRomanMap.put(4, "IV");
        intToRomanMap.put(1, "I");
    }

    public String intToRoman(int num) {

        StringBuilder sb = new StringBuilder();

        for (int key : keys) {
            while (num >= key) {
                sb.append(intToRomanMap.get(key));
                num -= key;
            }
        }

        return sb.toString();
    }

}
