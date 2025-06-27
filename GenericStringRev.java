public class GenericStringRev {

    public static <T> void reverseArray(T[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            T temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static Character[] toCharacterArray(String input) {
        Character[] res = new Character[input.length()];
        for (int i = 0; i < input.length(); i++) {
            res[i] = input.charAt(i);
        }
        return res;
    }

    public static <T> String arrayToString(T[] array) {
        StringBuilder builder = new StringBuilder();
        for (T element : array) {
            builder.append(element);
        }
        return builder.toString();
    }

    public static void exe() {
        String in = "Generics are cool";

        Character[] ca = toCharacterArray(in);
        reverseArray(ca);
        String rev = arrayToString(ca);

        System.out.println("Original String: " + in);
        System.out.println("Reversed String: " + rev);
    }

    public static void main(String[] args) {
        exe(); 
    }
}
