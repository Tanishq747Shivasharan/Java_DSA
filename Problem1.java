
import java.util.*;

public class Problem1 {
        int arr[] = new int[10];
        public void acceptElement() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter array elements: ");
            for(int i=0; i<arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            sc.close();
        }

        public void UsingFor() {
            System.out.println("Length of the array using for loop ");
            for(int j=0; j<arr.length; j++) {
                System.out.println("index: "+j+" element: "+arr[j]);
            }    
        }
        
        public void UsingWhile() {
            System.out.println("Length of the array using while loop ");
            int t=0;
            while(t<arr.length) {
                System.out.println("index: "+t+" element: "+arr[t]);
                t++;
            }
        }
        
        public void UsingDoWhile() {
            System.out.println("Length of the array using do-while loop ");
            int t=0;
            do {
                System.out.println("index: "+t+" element: "+arr[t]);
                t++;
            }
            while(t<arr.length);
        }

        public void UsingForEach(int[] arr) {
    System.out.println("Length of the array using for-each loop");

    int index = 0;
    for (int element : arr) {
        System.out.println("index: " + index + " element: " + element);
        index++;
    }
}

    public static void main(String []args) {
        Problem1 obj = new Problem1();
        obj.acceptElement();
        obj.UsingFor();
        obj.UsingWhile();
        obj.UsingDoWhile();
        obj.UsingForEach(null);
    }
}