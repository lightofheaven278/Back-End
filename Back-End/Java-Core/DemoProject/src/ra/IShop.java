package ra;

import java.util.List;
import java.util.Scanner;

public interface IShop <E>{
    void inputData(Scanner input, List<E> arr);

    void displayData();
}
