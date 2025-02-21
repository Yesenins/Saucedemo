package tasks;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter you're number: " );
        int number = scanner.nextInt();
        int a = 1;
        int b = 0;
        int counter = 0;
        do {
            System.out.print(a +" ");
            int c = a;
            a += b;
            b = c;
            counter++;
        }
        while(counter < number);
    }
}
