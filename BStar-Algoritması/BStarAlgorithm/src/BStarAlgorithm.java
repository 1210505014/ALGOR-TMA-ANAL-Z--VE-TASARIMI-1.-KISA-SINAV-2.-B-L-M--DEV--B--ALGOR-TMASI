import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BStarAlgorithm {

    private int[] patternTable;

    public Map<String, Integer> countPatternOccurrences(String text, String[] patterns) {

        Map<String, Integer> patternOccurrences = new HashMap<>();
        int n = text.length();
        int m = patterns[0].length();
        patternTable = createPatternTable(patterns[0]);

        for (String pattern : patterns) {

            patternOccurrences.put(pattern, 0);
        }

        int i = m - 1;
        while (i < n) {

            int j = m - 1;
            String substring = text.substring(i - m + 1, i + 1);

            if (Arrays.asList(patterns).contains(substring)) {

                patternOccurrences.put(substring, patternOccurrences.get(substring) + 1);
            }

            i += Math.max(m - j, patternTable[text.charAt(i)]);
        }
        return patternOccurrences;
    }

    private int[] createPatternTable(String pattern) {

        int[] table = new int[256];
        int m = pattern.length();

        for (int i = 0; i < 256; i++) {

            table[i] = m;
        }

        for (int i = 0; i < m - 1; i++) {

            table[pattern.charAt(i)] = m - i - 1;
        }
        return table;
    }

}


