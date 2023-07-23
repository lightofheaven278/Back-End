public class problems5_findMin {
    public static void main(String[] args) {
        int[][] arrayInt = {{1, 2, 3, 4}, {5, 6, 9, 8}};
        int min = arrayInt[0][0];
        for (int i = 0; i < arrayInt.length; i++) {
            for (int j = 0; j < arrayInt[i].length; j++) {
                if (min > arrayInt[i][j]) {
                    min = arrayInt[i][j];
                }
            }
        }
        System.out.printf("the element which has minimum value is: %d", min);
    }
}
