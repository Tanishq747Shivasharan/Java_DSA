import java.util.*;

public class SecondLargestSmallest {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 5, 8, 45, 30};

        NumberProcessor p = new NumberProcessor() {
            @Override
            public void findSecondLargestAndSmallest(int[] arr) {
                Arrays.sort(arr);

                int secSmall = arr[1];
                int secLarge = arr[arr.length - 2];

                System.out.println("Second Smallest: " + secSmall);
                System.out.println("Second largest: " + secLarge);
            }
        };
        p.findSecondLargestAndSmallest(numbers);
     }
}

interface NumberProcessor {
    void findSecondLargestAndSmallest(int[] arr);
}