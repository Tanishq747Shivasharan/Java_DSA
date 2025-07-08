public class GenericLinearSearch {

    public static <T> boolean linearSearch(T[] arr, T aim) {
        for (T element : arr) {
            if (element.equals(aim)) {
                return true;
            }
        }
        return false;
    }

    public static void exe() {
        Integer[] nums = {10, 20, 30, 40, 50}; 
        Integer aim = 30;

        boolean got = linearSearch(nums, aim);

        String message = got
            ? "Element " + aim + " found in the array."
            : "Element " + aim + " not found in the array.";

        System.out.println(message);
    }

    public static void main(String[] args) {
        exe(); 
    }
}