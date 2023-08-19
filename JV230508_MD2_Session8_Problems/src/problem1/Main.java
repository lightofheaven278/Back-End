package problem1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int a = (int) (Math.random()*100);
            intList.add(a);
        }
        System.out.print("intList: ");
        for (Integer element:intList) {
            System.out.print(element + "\t");
        }
        System.out.println();
        int max = Collections.max(intList);
        System.out.printf("Max value is: %d", max);
    }
}
