/*
 * Created by Alexey Babkin
 * April 2020
 */

import java.util.Scanner;
 class Program {
    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);
        System.out.println("Please, type English text!");
        String text = input.nextLine();
        Sentense txt = new Sentense(text);
        System.out.println("Amount of words: " + txt.getCount());
        try {
            for (String s : txt.getWords()) {
                System.out.println(s);
            }
        }
        catch (NullPointerException ex){
            System.out.println(ex.getMessage());
            return;
        }
    }
}
