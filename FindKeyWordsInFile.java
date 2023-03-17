import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;
public class FindKeyWordsInFile {
    static AVLTree<String, Integer> wordFrequencies = new AVLTree<>();
    static AVLTree<String, Boolean> englishWords = new AVLTree<>();
    static AVLTree<String, Integer> keywordFrequencies = new AVLTree<>();    

    FindKeyWordsInFile(int k, String inputFileName, String englishWordsFileName) {
        try {
            
            try {
                BufferedReader englishWordsReader = new BufferedReader(new FileReader(englishWordsFileName));
                String word = "";
                while ((word = englishWordsReader.readLine()) != null) {
                    englishWords.put(word.toLowerCase(), true);
                }
                englishWordsReader.close();                
            } catch (Exception e) {
                System.out.println("Error reading " + englishWordsFileName);
            }

            //Part 1
            // function name => computeWordFrequencies
            try {
                BufferedReader targetReader = new BufferedReader(new FileReader(inputFileName));
                String line = "";
                while ((line = targetReader.readLine()) != null) {
                    String[] words = line.split(" ");
                    for (String w : words) {
                        // strip punctuation, accomplishments. is the same as accomplishments, numbers remain readable without commas
                        w = w.replaceAll("\\p{Punct}", ""); 
                        // convert to lower case if it's not the word "I"
                        w = w.toLowerCase();
                        if (w.length() > 0) {
                            if (wordFrequencies.get(w) == null) {
                                wordFrequencies.put(w, 1);
                            } else {
                                wordFrequencies.put(w, wordFrequencies.get(w) + 1);
                            }
                        }
                    }
                }
                targetReader.close();
            } catch (Exception e) {
                System.out.println("Error reading " + inputFileName);
            }

                        //Part 2
            // function name => findKMostFrequentWords

            PriorityQueue<KeyFreqPair> pq = new PriorityQueue<>(new WordComparator());
            
            ArrayList<String> keys = wordFrequencies.getKeys(); // get keys is in order, so this array list is also in order
            // keys are returned as a string in the form of "frequency word"
            // this way it's inserted into the priority queue in order

            for (String key : keys) {
                pq.add(
                    new KeyFreqPair(
                        key, 
                        wordFrequencies.get(key)
                    )
                );
            }

            // print out the priority queue
            /*while (!pq.isEmpty()) {
                KeyFreqPair item = pq.poll();
                System.out.println("word: " + item.freq + " " + item.key);
            }*/

            //Part 3
            // function name => filterCommonEnglishWords
            int inserted = 0;
            while (!pq.isEmpty() && inserted < k) {
                KeyFreqPair item = pq.poll();
                String key = item.key;
                int freq = item.freq;
                if (englishWords.get(key) == null) { // if it's in frequent words this will give true
                    keywordFrequencies.put(key, freq); // insert if not in frequent words
                    inserted++;
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Usage: java FindKeyWordsInFile k file.txt MostFrequentEnglishWords.txt");
            System.exit(1);
        }

        int k = Integer.parseInt(args[0]);
        new FindKeyWordsInFile(k, args[1], args[2]);

        keywordFrequencies.inOrderTraversal();

    }

    public static void printWordFrequencies() {
        wordFrequencies.inOrderTraversal();
    }

    public static void printKeywordFrequencies() {
        keywordFrequencies.inOrderTraversal();
    }

}

class WordComparator implements Comparator<KeyFreqPair> {
    public int compare(KeyFreqPair a, KeyFreqPair b) {
        return a.freq > b.freq ? -1 : a.freq < b.freq ? 1 : 0; // compare frequencies, return for insertion as max heap
    }
}

class KeyFreqPair {
    String key;
    int freq;
    public KeyFreqPair(String key, int freq) {
        this.key = key;
        this.freq = freq;
    }
}


