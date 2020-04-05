/*
 * Created by Alexey Babkin
 * April 2020
 */

import java.util.Scanner;

class Program {

    public static void main(String[] args) {
        int count = 0;
        System.out.println("Print a keyword, please!");
        // Input a keyword
        Scanner scanner = new Scanner(System.in);
        String keyWord = scanner.next();

        System.out.println("Print text, please!");
        // Input a text
        Scanner console = new Scanner(System.in);
        String inputLine = console.nextLine();
        // All words which consist letters and symbol '`' (can`t, won`t and so on).
        Scanner in = new Scanner(inputLine.replaceAll("[^a-zA-Z\\`]", " "));
        while (in.hasNext()) {
            if (in.next().equalsIgnoreCase(keyWord)) count++;
        }
        System.out.println("The keyword was used " + count + " times in this text.");
        // Destroy the streams!
        scanner.close();
        console.close();
        in.close();
    }
}

