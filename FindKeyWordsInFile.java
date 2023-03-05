import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKeyWordsInFile {
        
    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Usage: java FindKeyWordsInFile k file.txt MostFrequentEnglishWords.txt");
            System.exit(1);
        }

        int k = Integer.parseInt(args[0]);
        String inputFileName = args[1];
        String englishWordsFileName = args[2];
        
        AVLTree<String, Integer> wordFrequencies = new AVLTree<>();
        AVLTree<String, Void> englishWords = new AVLTree<>();
        AVLTree<String, Integer> keywordFrequencies = new AVLTree<>();
        
        try {
            //Part 1
            // function name => computeWordFrequencies
            
            //Part 2
            // function name => findKMostFrequentWords
            
            //Part 3
            // function name => filterCommonEnglishWords
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}