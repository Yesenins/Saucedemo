package tasks;

public class WordSearch {
    public static void main(String[] args) {
        String[] words = {"apple", "orange", "banana", "cherry"};
        String targetWord ="banana";
        boolean found = false;
        for(String word : words){
            if(word.equals(targetWord)){
                found = true;
                System.out.println("Word "+ word + " found!");
                break;
            }
        }
        if(!found){
            System.out.println("Not found");
        }
    }
}
