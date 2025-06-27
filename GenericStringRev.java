import java.util.*;

public class GenericStringRev {
    public static <T> void reverseList(List<T> l){
        int left = 0;
        int right = l.size()-1;

        while(left<right) {
            T temp =l.get(left);
            l.set(left, l.get(right));
            l.set(right, temp);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {

        String in = "Generics are cool";

        Character[] charArray = new Character[in.length()];
        for (int i = 0; i < in.length(); i++) {
            charArray[i] = in.charAt(i);
        }


        reverseList(charList);
        StringBuilder reversed = new StringBuilder();
        for (char c : charList) {
            reversed.append(c);
        }
        System.out.println("Original String: " + in);
        System.out.println("Reversed String: " + reversed.toString());
    }
}
