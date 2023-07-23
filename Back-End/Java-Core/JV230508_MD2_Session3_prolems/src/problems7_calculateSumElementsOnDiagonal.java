import java.util.Scanner;

public class problems7_calculateSumElementsOnDiagonal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please input number of rows:");
        int row = input.nextInt();
        System.out.println("Please input number of columns:");
        int column = input.nextInt();
        int[][] arrInt = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.printf("Please input arrInt[%d][%d]: ", i, j);
                arrInt[i][j] = input.nextInt();
            }
        }
        System.out.println("Here is arrInt: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.printf("%d\t", arrInt[i][j]);
            }
            System.out.println();
        }
        int sum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == j) {
                    sum += arrInt[i][j];
                }
            }
        }
        System.out.printf("Here is sum of elements on the main diagonal: %d", sum);
    }
}
