package ra.entity;

import java.util.List;
import java.util.Scanner;

public interface IEntity {
    void inputData(Scanner input, List<Student> studentList);

    void displayData();

    void calAge(Scanner input);

    void calAvgMark_Rank(List<Student> studentList);
}
