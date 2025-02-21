package tasks;

import java.util.Random;

public class DisplayElements {

    public static void main(String[] args) {
        Random random = new Random();
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++){
            numbers[i] = random.nextInt(100);
        }
        for(int element : numbers){
            System.out.print(element + " ");
        }
    }
}
