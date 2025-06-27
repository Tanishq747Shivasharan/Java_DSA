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

        if (got) {
            System.out.println("Element " + aim + " found in the array.");
        } else {
            System.out.println("Element " + aim + " not found in the array.");
        }
    }

    public static void main(String[] args) {
        exe(); 
    }
}