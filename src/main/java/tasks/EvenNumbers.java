package tasks;

public class EvenNumbers {
    public static void main(String[] args) {
        int number = 2;
        while(number <= 20){
            if (number % 2 == 0){
                System.out.print(number + " ");
            }
            number++;
        }
    }
}
