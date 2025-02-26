package tasks;

import java.util.List;

public class FindString {
    public boolean isFindString(List<String> list, String text){
        for(String element : list){
            if(element.equals(text)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        FindString find = new FindString();
        List<String> list = List.of("In this world",
                "Is the destiny of mankind",
                "Controlled by some transcendental entity or law?",
                "Entity or law?");
        System.out.println(list.contains("Entity or law?"));

        boolean result = find.isFindString(List.of("In this world",
                "Is the destiny of mankind",
                "Controlled by some transcendental entity or law?",
                "Entity or law?"), "Entity or law?");
        System.out.println(result);
    }
}
