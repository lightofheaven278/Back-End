package problem2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(0);
        intList.add(1);
        intList.add(3);
        System.out.print("Here is intList before reversing: ");
        for (Integer i:intList) {
            System.out.print(i + "\t");
        }
        System.out.println();
        System.out.print("Here is intList after reversing: ");
        for (int i = intList.size()-1; i >=0 ; i--) {
            System.out.print(intList.get(i) + "\t");
        }
    }
}
