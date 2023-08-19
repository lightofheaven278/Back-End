package problem5;

public class Main {
    public static void main(String[] args) {
        String originStr = "I am Iron man";
        String[] arrStr = originStr.split(" ");
        for (String i:arrStr) {
            System.out.print(i + "\t\t");
        }
        System.out.println();
        String min = arrStr[0];
        for (int i = 0; i < arrStr.length; i++) {
            if(arrStr[i].length()==min.length()){
                min = arrStr[i];
            }
        }
        System.out.printf("Here is shortest string: %s", min);
    }
}
