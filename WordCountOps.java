import java.io.*;
import java.util.*;

public class WordCountOps{

    public static void main(String[] args)throws Exception
    {

        Scanner scanner = new Scanner(System.in);
        System.out.println(".........................................................");
        System.out.println("|| Enter '1' to input text :  || \n || '2' to provide a file : ||");
        System.out.println(".........................................................");
        int choice = scanner.nextInt();
        scanner.nextLine();
//Choice For user Input Or File Input
        String inputText;
        if (choice == 1) 
        {
            System.out.println(".........................................................");
            System.out.println("Enter the text:");
            System.out.println(".........................................................");
            inputText = scanner.nextLine();
        } 
        else if (choice == 2) 
        {
            System.out.println(".........................................................");
            System.out.println("Enter the path to the file:");
            System.out.println(".........................................................");
            String filePath = scanner.nextLine();
            inputText = readFile(filePath);

//Input Validation
            if (inputText == null) 
            {
                System.out.println(".........................................................");
                System.out.println("Error reading the file.");
                System.out.println(".........................................................");
                scanner.close();
                return;
            }
        } 
        else
        {
            System.out.println(".........................................................");
            System.out.println("Invalid choice.");
            System.out.println(".........................................................");
            scanner.close();
            return;
        }

        String[] words = splitIntoWords(inputText);
        int totalWords = words.length;
//Total Words
        System.out.println(".........................................................");
        System.out.println("Total words: " + totalWords);
        System.out.println(".........................................................");

        Map<String, Integer> wordFreq = getWordFrequency(words);
        System.out.println("Frequency of each word:");
        for (Map.Entry<String, Integer> entry : wordFreq.entrySet()) {
            System.out.println(".........................................................");
            System.out.println(entry.getKey() + ": " + entry.getValue());
            System.out.println(".........................................................");
        }

//WordFrequency
        int uniqueWords = wordFreq.size();
        System.out.println(".........................................................");
        System.out.println("Number of unique words: " + uniqueWords);
        System.out.println(".........................................................");


        scanner.close();
    }

    private static String[] splitIntoWords(String inputText) {
        return inputText.split("[\\s\\p{Punct}]+");
    }

    private static Map<String, Integer> getWordFrequency(String[] words) {
        Map<String, Integer> wordFreq = new HashMap<>();
        for (String word : words) {
// Convert the word to lowercase to ignore case differences
            word = word.toLowerCase();
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }
        return wordFreq;
    }

    private static String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return content.toString();
    }
}
