import java.util.Scanner;

public class problems8_countNumberOfElement {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arrInt = new int[5];
        for (int i = 0; i < arrInt.length; i++) {
            System.out.printf("Please input element number %d: ", i);
            arrInt[i] = input.nextInt();
        }
        System.out.print("Here is arrInt: ");
        for (int i = 0; i < arrInt.length; i++) {
            System.out.printf("%d\t", arrInt[i]);
        }
        System.out.println();
        System.out.print("Please input a number: ");
        int a = input.nextInt();
        int count = 0;
        for (int i = 0; i < arrInt.length; i++) {
            if (a == arrInt[i]) {
                count++;
            }
        }
        System.out.printf("Number of elements in arrInt have the same value as number %d is: ", a);
        System.out.println(count);
    }
}
