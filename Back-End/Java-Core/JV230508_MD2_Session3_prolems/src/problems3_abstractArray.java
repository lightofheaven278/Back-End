import java.util.Scanner;

public class problems3_abstractArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr1 = new int[3];
        int[] arr2 = new int[2];
        int[] arr3 = new int[5];
        for (int i = 0; i < arr1.length; i++) {
            System.out.printf("Please input the elements number %d for arr1: ", i);
            arr1[i] = input.nextInt();
        }
        System.out.print("Here is arr1: ");
        for (int i = 0; i < arr1.length; i++) {
            System.out.printf("%d\t", arr1[i]);
        }
        System.out.println();
        for (int i = 0; i < arr2.length; i++) {
            System.out.printf("Please input the elements number %d for arr2: ", i);
            arr2[i] = input.nextInt();
        }
        System.out.print("Here is arr2: ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.printf("%d\t", arr2[i]);
        }
        System.out.println();
        for (int i = 0; i < arr1.length; i++) {
            arr3[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            arr3[i + arr2.length] = arr2[i];
        }

        System.out.print("Here is arr3's elements: ");
        for (int i = 0; i < arr3.length; i++) {
            System.out.printf("%d\t", arr3[i]);
        }
    }
}
