import java.util.Scanner;

public class problems2_printShape {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("please input number of rows");
        int numberOfRow = input.nextInt();
        System.out.println("please input number of columns");
        int numberOfColumn = input.nextInt();
        // print rectangular
        for (int i = 0; i < numberOfRow; i++) {
            for (int j = 0; j < numberOfColumn; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println("--------------------------------");
        // print right triangle bottom-left
        for (int i = 1; i <= numberOfRow; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println("--------------------------------");
        // print right triangle  top-left
        for (int i = numberOfColumn; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println("--------------------------------");
        // print isosceles triangle
        for (int i = 1; i <= numberOfRow; i++) {
            for (int k = numberOfRow; k >= i; k--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
