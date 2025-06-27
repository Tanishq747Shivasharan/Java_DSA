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
        int[] nums = {10, 20, 30, 40, 50};
        int aim = 30;

        boolean got = linearSearch(nums, aim);

        String message = found
            ? "Element " + searchValue + " found in the array."
            : "Element " + searchValue + " not found in the array.";
        
        System.out.println(message);
    }

    public static void main(String[] args) {
        exe(); 
    }
}
