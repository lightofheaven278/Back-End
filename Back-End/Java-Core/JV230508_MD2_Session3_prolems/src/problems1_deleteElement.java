public class problems1_deleteElement {
    public static void main(String[] args) {
        int[] arrInt = {10, 4, 6, 7, 8, 6, 0, 0, 0, 0};
        System.out.print("Here is the original array elements: ");
        for (int element :
                arrInt) {
            System.out.printf("%d\t", element);
        }
        System.out.println();
        int[] newArrInt = new int[10];
        newArrInt[0] = arrInt[0];
        newArrInt[1] = arrInt[1];
        newArrInt[2] = arrInt[2];
        newArrInt[3] = arrInt[4];
        newArrInt[4] = arrInt[5];
        newArrInt[5] = arrInt[6];
        newArrInt[6] = arrInt[7];
        newArrInt[7] = arrInt[8];
        newArrInt[8] = arrInt[9];
        newArrInt[9] = 0;
        System.out.print("Here is the new array elements: ");
        for (int element :
                newArrInt) {
            System.out.printf("%d\t", element);
        }
        System.out.println();
    }
}
