/*
 * Created by Alexey Babkin
 * April 2020
 */

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Program {
    /*
    * n - upper border of sequence [0..n]
    */
    public static List<Long> palindromesFactory(long n) throws ArithmeticException, NumberFormatException {
        if (n < 0) throw new ArithmeticException("Number must not be negative!");
        List<Long> palindromes = new ArrayList<Long>();
        for (int i = 0; i < 10; i++) {
            palindromes.add((long) i);
            if (i == n) return palindromes;
        }
        int p_size = 1;
        while (true) {
            long min = (long) Math.pow(10, p_size - 1);
            long max = (long) Math.pow(10, p_size) - 1;
                for (long i = min; i <= max; i++) {
                    long result = Long.parseLong(Long.toString(i) + new StringBuilder(Long.toString(i)).reverse());
                    try {
                    if (result > n) return palindromes;
                    else palindromes.add(result);
                    }
                    catch (NumberFormatException ex) {
                        throw new NumberFormatException("String can`t be converted to long type");
                    }

                }
                for (long i = min; i <= max; i++) {
                    for (int j = 0; j < 10; j++) {
                        long result = Long.parseLong(Long.toString(i) + Integer.toString(j)
                                + new StringBuilder(Long.toString(i)).reverse());
                        try {
                            if (result > n) return palindromes;
                            else palindromes.add(result);
                        }
                        catch (NumberFormatException ex) {
                            throw new NumberFormatException("String can`t be converted to long type");
                        }
                    }
                }
            p_size++;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter N (upper border of sequence integer numbers from 0 to N).");
        System.out.println("It must not be more than 100");
        long n = 0;
        try {
            n = input.nextLong();
            // This line can be deleted but the Task requires this condition (N < 100).
            if (n < 0 || n > 100) throw new InputMismatchException();
        }
        catch (InputMismatchException ex){
            System.out.print("Input error!!! Check that you entered correct values, relaunch program and try again, please!\n");
            return;
        }
        try {
            List<Long> lst = palindromesFactory(n);
            System.out.println("Palindromes from the sequence: ");
            for (long num : lst) {
                System.out.println(num);
            }
        }
        catch (ArithmeticException ex) {
            System.out.println(ex.getMessage());
        }
        catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            return;
        }
    }
}

