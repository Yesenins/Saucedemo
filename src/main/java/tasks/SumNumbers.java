package tasks;

public class SumNumbers {

    public static void main(String[] args) {
        int sum = 0;
        for(int i = 1; i <=100; i++){
            sum+=i;
        }
        System.out.println("Sum of numbers: " + sum);
    }

}
