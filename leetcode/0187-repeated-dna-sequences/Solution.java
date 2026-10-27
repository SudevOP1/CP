import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    public List<String> findRepeatedDnaSequences(String s) {

        int n = s.length();
        List<String> repeatedDnaSequencesList = new ArrayList<>();

        if (n < 10) {
            return repeatedDnaSequencesList;
        }

        Set<String> repeatedDnaSequences = new HashSet<>();
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < n - 9; i++) {

            String subString = s.substring(i, i + 10);

            if (seen.contains(subString)) {
                repeatedDnaSequences.add(subString);
            } else {
                seen.add(subString);
            }
        }

        for (String repeatedDnaSequence : repeatedDnaSequences) {
            repeatedDnaSequencesList.add(repeatedDnaSequence);
        }
        return repeatedDnaSequencesList;
    }

}
