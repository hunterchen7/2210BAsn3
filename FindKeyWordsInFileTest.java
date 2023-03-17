public class FindKeyWordsInFileTest {
    public static void main(String[] args) {
      FindKeyWordsInFile f = new FindKeyWordsInFile(3, "file_test.txt", "MostFrequentEnglishWords.txt");


      // test case 1: check if the program reads the input file and creates the word frequency correctly
      System.out.println("++++++++++++++++++++++++++");
      int apple = f.wordFrequencies.get("apple");
      int banana = f.wordFrequencies.get("banana");
      int orange = f.wordFrequencies.get("orange");
      int pear = f.wordFrequencies.get("pear");
      if (apple == 5 && banana == 2 && orange == 3 && pear == 1) {
        System.out.println("Test case 1 passed");
      } else {
        System.out.println("Test case 1 failed");
      }

      // test case 2: check if the program finds the k most frequent words correctly
      // apple is in most frequent words
      System.out.println("++++++++++++++++++++++++++");
      banana = f.keywordFrequencies.get("banana");
      orange = f.keywordFrequencies.get("orange");
      pear = f.keywordFrequencies.get("pear");
      if (banana == 2 && orange == 3 && pear == 1) {
        System.out.println("Test case 2 passed");
      } else {
        System.out.println("Test case 2 failed");
      }

      // test case 3: check if the program filters common English words correctly
      System.out.println("++++++++++++++++++++++++++");
      if (f.keywordFrequencies.get("apple") == null) {
        System.out.println("Test case 3 passed");
      } else {
        System.out.println("Test case 3 failed");
      }

      // test case 4: check if the program generates the correct output for file3.txt
      System.out.println("++++++++++++++++++++++++++");
      FindKeyWordsInFile f2 = new FindKeyWordsInFile(4, "file3.txt", "MostFrequentEnglishWords.txt");
      int elephant = f2.keywordFrequencies.get("elephant");
      int lily = f2.keywordFrequencies.get("lily");
      int umbrella = f2.keywordFrequencies.get("umbrella");
      int violet = f2.keywordFrequencies.get("violet");
      if (elephant == 8 && lily == 8 && umbrella == 8 && violet == 8) {
        System.out.println("Test case 4 passed");
      } else {
        System.out.println("Test case 4 failed");
      }

      // test case 5: check if the program handles empty input files
      System.out.println("++++++++++++++++++++++++++");
      FindKeyWordsInFile f3 = new FindKeyWordsInFile(4, "file_empty.txt", "MostFrequentEnglishWords.txt");
      System.out.println("Test case 5 passed (no output is expected for this test case.");

      // test case 6: check if the program handles non-existing input files
      System.out.println("++++++++++++++++++++++++++");
      FindKeyWordsInFile f4 = new FindKeyWordsInFile(4, "file_non_existing.txt", "MostFrequentEnglishWords.txt");
      System.out.println("Test case 6 passed (no output is expected for this test case.");
    }
}
