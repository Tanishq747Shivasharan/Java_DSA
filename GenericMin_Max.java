public class GenericMin_Max {

    static {
        int[] nums = {5, 2, 9, 1, 7};

        int min = MinMax.findMin(nums);
        int max = MinMax.findMax(nums);

        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
    }

    public class MinMax {

    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int num : arr) {
            if (num < min) min = num;
        }
        return min;
    }

    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
        }
        return max;
    }
}

    public static void main(String[] args) {
        // Sir just returned the value so no object creation needed...
    }
}

