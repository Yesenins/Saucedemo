package tasks;

public class ArrayEquality {
    public boolean isArraysEquals(int[] list1, int[] list2){
        for (int i = 0; i < list1.length; i++){
            if(list1[i] != list2[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayEquality arrayEquality = new ArrayEquality();
        int[] list1 = {1,2,4,4,5,6,7,9};
        int[] list2 = {1,2,3,3,5,6,7,8};
        System.out.println(arrayEquality.isArraysEquals(list1,list2));
    }
}
