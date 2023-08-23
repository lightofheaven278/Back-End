package ra.entity;

import java.util.List;
import java.util.Scanner;

public interface IEntity {
    void inputData(Scanner input, List<Student> studentList);

    void displayData();

    void calAge();

    void calAvgMark_Rank();
}
