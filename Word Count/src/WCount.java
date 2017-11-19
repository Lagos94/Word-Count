/*By Juan Lagos
* CSC 201
* Professor Tanes Kanchanawanchai
* Assignment 12 Chapter 12
* Word Count
* Due Date: 11/12/17*/

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class WCount {

    public static void main(String[] args) {

        System.out.println("Source: http://cs.armstrong.edu/liang/data/Lincoln.txt");
        URL url = null;
        try {
            url = new URL("http://cs.armstrong.edu/liang/data/Lincoln.txt");
        } catch (MalformedURLException ex) {
            System.out.println("Invalid url: " + ex.getMessage());
            ex.printStackTrace();
            System.exit(1);
        }

        String s = "";
        try (Scanner input = new Scanner(url.openStream())) {

            while (input.hasNext()) {
                s += input.nextLine();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        String[] words = s.split("[. ,]", 0);
        words = removeEmptySpaces(words);
        System.out.println("Word count from the given site is: " + words.length);
    }

    private static String[] removeEmptySpaces(String[] words) {

        ArrayList<String> fixedWords = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() != 0) {
                fixedWords.add(words[i]);
            }
        }
        return fixedWords.toArray(new String[fixedWords.size()]);
    }
}