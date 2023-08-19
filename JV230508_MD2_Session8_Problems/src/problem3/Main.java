package problem3;

import problem1.Int;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int a = (int) (Math.random() * 100);
            intList.add(a);
        }
        System.out.println("Here is intList before sorting:");
        for (Integer i : intList) {
            System.out.print(i + "\t");
        }
        System.out.println();
        Collections.sort(intList, Collections.reverseOrder());
        System.out.println("Here is intList after sorting:");
        for (Integer i : intList) {
            System.out.print(i + "\t");
        }
    }
}
