import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class Searching {

    public void search() {

        System.out.println("B* Algoritması ile 'Alice in Wonderland' hikayesinde kelime arama algoritmaları");
        System.out.println("Aranan kelimeler: ");
        System.out.println("1- upon");
        System.out.println("2- sigh");
        System.out.println("3- Dormouse");
        System.out.println("4- jury-box");
        System.out.println("5- swim");

        String[] wordsArray = {"upon", "sigh", "Dormouse", "jury-box", "swim"};

        String txtPath = "C:\\Users\\bahar\\OneDrive\\Masaüstü\\ks1\\codes\\ks-1.2\\BStar-Algoritması\\BStarAlgorithm\\alice_in_wonderland.txt";

        Path filePath = Path.of(txtPath);

        String story = null;

        try {

            story = Files.readString(filePath);

        } catch (IOException e) {

            throw new RuntimeException(e);
        }

        BStarAlgorithm bStarAlgorithm = new BStarAlgorithm();

        Map<String, Integer> patternOccurrences = bStarAlgorithm.countPatternOccurrences(story, wordsArray);
        for (String pattern : wordsArray) {
            System.out.println("Kelime: " + pattern + " - Geçiş sayısı: " + patternOccurrences.get(pattern));

        }

    }


}
