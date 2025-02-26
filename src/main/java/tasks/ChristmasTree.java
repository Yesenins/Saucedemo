package tasks;

import java.util.Scanner;

public class ChristmasTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter you're number: " );
        int number = scanner.nextInt();
        for (int i = 1; i <= number; i++){
            for (int k = number-i; k >= 0; k--){
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++){
                System.out.print("$");
            }
            for (int m = 1; m < i; m++){
                System.out.print("$");
            }
            for (int l = number-i; l >= 0; l--){
                System.out.print(" ");
            }
            System.out.println("");
        }

        for (int i = 1; i <= number; i++) {

            for (int j = number - i; j > 0; j--) {
                System.out.print(" ");
            }

            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
