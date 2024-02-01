import java.util.Scanner;

public class SAT_JAVA {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display an introduction and explanation of the program
        System.out.println("Welcome to the Text Processing Program!");
        System.out.println("This program provides various text processing options.");
        System.out.println("Please choose an option from the menu:");

        while (true) {
            displayOptions();  // Display the menu options
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    searchWordInText(scanner);  // Call function to search a word in text
                    break;
                case 2:
                    findLongestWord(scanner);  // Call function to find the longest word
                    break;
                case 3:
                    findFiveLongestWords(scanner);  // Call function to find five longest words
                    break;
                case 4:
                    findMinMaxInSequence(scanner);  // Call function to find min and max in a sequence
                    break;
                case 0:
                    System.out.println("Exiting program. Goodbye!\n");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please choose again.\n");
                    break;
            }
        }
    }

    // Function to display menu options
    private static void displayOptions() {
        System.out.println("Choose an option:");
        System.out.println("1 - Search for a word in a given text.");
        System.out.println("2 - Find the longest word within a given text.");
        System.out.println("3 - Find the five longest words within a given text.");
        System.out.println("4 - Find the largest and smallest number in a sequence of 10 integers.");
        System.out.println("0 - Exit\n");
    }

    // Function to search a word in text
    private static void searchWordInText(Scanner scanner) {
        System.out.print("Enter the text: ");
        String text = scanner.nextLine();
        System.out.print("Enter the word to search: ");
        String word = scanner.nextLine();
        boolean isWordPresent = isWordPresentInText(word, text);
        System.out.println("The word '" + word + "' is " + (isWordPresent ? "" : "not ") + "present in the text.\n");
    }

    // Function to find the longest word in text
    private static void findLongestWord(Scanner scanner) {
        System.out.print("Enter the text: ");
        String text = scanner.nextLine();
        String longestWord = findLongestWordInText(text);
        System.out.println("The longest word in the text is: " + longestWord + "\n");
    }

    // Function to find five longest words in text
    private static void findFiveLongestWords(Scanner scanner) {
        System.out.print("Enter the text: ");
        String text = scanner.nextLine();
        String[] fiveLongestWords = findFiveLongestWordsInText(text);
        System.out.println("The five longest words in the text are:");
        for (String word : fiveLongestWords) {
            System.out.println("- " + word);
        }
        System.out.println();
    }

    // Function to find min and max in a sequence
    private static void findMinMaxInSequence(Scanner scanner) {
        int[] sequence = new int[10];
        System.out.println("Enter 10 integers:");

        for (int i = 0; i < 10; i++) {
            sequence[i] = scanner.nextInt();
        }

        findMinMaxInSequence(sequence);
        System.out.println();
    }

    // Function to check if a word is present in text
    private static boolean isWordPresentInText(String word, String text) {
        return text.contains(word);
    }

    // Function to find the longest word in text
    private static String findLongestWordInText(String text) {
        String[] words = text.split("\\s+");
        String longestWord = "";

        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        return longestWord;
    }

    // Function to find five longest words in text
    private static String[] findFiveLongestWordsInText(String text) {
        String[] words = text.split("\\s+");
        String[] fiveLongestWords = new String[Math.min(words.length, 5)];

        for (int i = 0; i < fiveLongestWords.length; i++) {
            String longestWord = "";
            for (String word : words) {
                if (word.length() > longestWord.length() && !arrayContains(fiveLongestWords, word)) {
                    longestWord = word;
                }
            }
            fiveLongestWords[i] = longestWord;
        }

        return fiveLongestWords;
    }

    // Function to find min and max in a sequence
    private static void findMinMaxInSequence(int[] sequence) {
        int min = sequence[0];
        int max = sequence[0];

        for (int num : sequence) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }

        System.out.println("The smallest number is: " + min);
        System.out.println("The largest number is: " + max);
    }

    // Function to check if an array contains a value
    private static boolean arrayContains(String[] array, String value) {
        for (String element : array) {
            if (element != null && element.equals(value)) {
                return true;
            }
        }
        return false;
    }
}
