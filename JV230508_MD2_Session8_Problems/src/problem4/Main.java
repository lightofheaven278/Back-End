package problem4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String originString = "Rikkei Academy de nong dan biet code";
        String[] arrString = originString.split(" ");
        for (String i : arrString) {
            System.out.print(i + "\t\t");
        }
        List<String> listStr = new ArrayList<>();
        for (int i = 0; i < arrString.length; i++) {
            if (arrString[i].length() >= 3) {
                listStr.add(arrString[i]);
            }
        }
        System.out.println();
        System.out.print("Here is string(s) have(has) more than 3 char: ");
        for (String i : listStr) {
            System.out.printf("%s\t\t", i);
        }

    }
}
