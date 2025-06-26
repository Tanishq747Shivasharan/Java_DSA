import java.util.*;

public class GenericStringRev {
    public static <T> void reverseList(List<T> l){
        int left = 0;
        int right = list.size()-1;

        while(left<right) {
            T temp =list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {

        String in = "Generics are cool";

        List<Character> charList = new ArrayList<>();
        for (char c : input.toCharArray()) {
            charList.add(c);
        }
        reverseList(charList);
        StringBuilder reversed = new StringBuilder();
        for (char c : charList) {
            reversed.append(c);
        }
        System.out.println("Original String: " + input);
        System.out.println("Reversed String: " + reversed.toString());
    }
}
