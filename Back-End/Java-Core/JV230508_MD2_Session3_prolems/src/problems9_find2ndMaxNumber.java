import java.util.Scanner;

public class problems9_find2ndMaxNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arrInt = new int[6];
        int max = arrInt[0];
        int[] newArrayInt = new int[arrInt.length - 1];
        int max2 = newArrayInt[0];
        int index = 0;
        // input element into arrayInt
        for (int i = 0; i < arrInt.length; i++) {
            System.out.printf("Please input element number %d: ", i);
            arrInt[i] = input.nextInt();
        }
        // print arrInt
        System.out.print("Here is arrInt: ");
        for (int element : arrInt) {
            System.out.printf("%d\t", element);
        }
        System.out.println();
        // find max in arrayInt
        for (int i = 0; i < arrInt.length; i++) {
            if (max < arrInt[i]) {
                max = arrInt[i];
            }
        }
//        System.out.printf("max is: %d", max);
        System.out.println();
        // find index of max element
        for (int i = 0; i < arrInt.length; i++) {
            if (max == arrInt[i]) {
                index = i;
                break;
            }
        }
        // delete max element from arrayInt
        for (int i = index + 1; i < arrInt.length; i++) {
            newArrayInt[i - 1] = arrInt[i];
        }
        for (int i = 0; i < index; i++) {
            newArrayInt[i] = arrInt[i];
        }
//        System.out.print("Here is newArrInt: ");
//        for (int element : newArrayInt) {
//            System.out.printf("%d\t", element);
//        }
        for (int i = 0; i < newArrayInt.length; i++) {
            if (max2 < newArrayInt[i]) {
                max2 = newArrayInt[i];
            }
        }
        System.out.println();
        System.out.printf("The element has 2nd max value in arrInt is: %d", max2);
    }
}
