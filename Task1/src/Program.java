/*
 * Created by Alexey Babkin
 * April 2020
 */
/*
even numbers: -100,..., -2, 0, 2, 4,...
odd numbers: -101,..., -3, -1, 1, 3, 5,...
prime numbers: 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97...
composite numbers: 4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 22, 24, 25, 26, 27...
*/

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter integer number, please:");
        int number = input.nextInt();
        // Check even or odd
        if (number % 2 == 0) System.out.print("Even");
        else System.out.print("Odd");
        // Check prime, composite or other (negative, 0 and 1)
        // because prime and composite numbers are positive integers which are strong more than 1
        if (number <= 1) return;
        if (number == 2
                || number == 3
                || Math.pow(number, 2) % 24 == 1) {
            System.out.print(" and prime");
        } else System.out.print(" and composite");
    }
}
