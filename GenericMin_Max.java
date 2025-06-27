public class GenericMin_Max {

    static {
        int[] numbers = {5, 2, 9, 1, 7};

        int min = MinMax.findMin(numbers);
        int max = MinMax.findMax(numbers);

        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
    }

    public class MinMax {

    public static int findMin(int[] array) {
        int min = array[0];
        for (int num : array) {
            if (num < min) min = num;
        }
        return min;
    }

    public static int findMax(int[] array) {
        int max = array[0];
        for (int num : array) {
            if (num > max) max = num;
        }
        return max;
    }
}

    public static void main(String[] args) {
        // Sir just returned the value so no object creation needed...
    }
}

