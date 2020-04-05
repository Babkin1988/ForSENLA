/*
 * Created by Alexey Babkin
 * April 2020
 */

import java.util.Scanner;
import java.util.NoSuchElementException;
import java.util.InputMismatchException;

public class Program {
    // For computing the greatest common divisor is using Euclidean algorithm!
    private static int Nod(int a, int b) throws ArithmeticException {
        if (a == 0 || b == 0) throw new ArithmeticException("Argument can`t be a zero!!!");
        a = Math.abs(a);
        b = Math.abs(b);
        while (a > 0 && b > 0) {
            if (a > b) {
                a %= b;
            } else {
                b %= a;
            }
        }
        return a + b;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter two integer numbers, please:");
        int nod = 0;
        int nok = 0;
        int a = 0;
        int b = 0;
        try {
            a = input.nextInt();
            b = input.nextInt();
            nod = Nod(a, b);
        }
        catch (ArithmeticException ex) {
            System.out.print(ex.getMessage());
            return;
        }
        catch (InputMismatchException ex){
            System.out.print("Input error!!! Check that you entered correct values, relaunch program and try again, please!");
            return;
        }
        catch (NoSuchElementException ex){
            System.out.print(ex.getMessage());
            return;
        }
        catch (IllegalStateException ex) {
            System.out.print("Internal error! Scanner is closed.");
            return;
        }
        try {
            //Danger! nod could be zero!
            nok = Math.abs(a * b) / nod;
        }
        catch (ArithmeticException ex) {
            System.out.print("Division by zero\n");
            return;
        }
        // Output
        System.out.println("NOD = " + nod);
        System.out.println("NOK = " + nok);
    }
}