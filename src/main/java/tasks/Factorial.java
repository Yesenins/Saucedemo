package tasks;


import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        System.out.println("Enter you're number: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int factorial = 1;
        if(number == 0){
            System.out.println("Factorial: 1");
        } else {
            while (number != 1) {
                factorial *= number;
                number--;
            }
            System.out.println("Factorial: " + factorial);
        }
    }
}
