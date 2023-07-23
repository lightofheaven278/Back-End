public class problems6_calculateColumnSum {
    public static void main(String[] args) {
        int[][] arrayInt = {{1, 2, 3, 4}, {5, 6, 9, 8}};
        int column = 0;
        while (column <= 3) {
            int sumColumn = 0;
            for (int i = 0; i < arrayInt.length; i++) {
                sumColumn += arrayInt[i][column];
            }
            System.out.printf("The sum of the column number " + (column + 1) + " is: %d\n", sumColumn);
            column++;
        }
    }
}
