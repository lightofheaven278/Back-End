package subclass;

import java.util.List;
import java.util.Scanner;

public class Fresher extends Staff<Fresher> {
    private int graduatedYear;
    private String graduatedRank;
    private String education;

    public Fresher() {
    }

    public Fresher(int graduatedYear, String graduatedRank, String education) {
        this.graduatedYear = graduatedYear;
        this.graduatedRank = graduatedRank;
        this.education = education;
    }

    public int getGraduatedYear() {
        return graduatedYear;
    }

    public String getGraduatedRank() {
        return graduatedRank;
    }

    public String getEducation() {
        return education;
    }

    public void setGraduatedYear(int graduatedYear) {
        this.graduatedYear = graduatedYear;
    }

    public void setGraduatedRank(String graduatedRank) {
        this.graduatedRank = graduatedRank;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public void inputData(Scanner input, List<Fresher> arr) {
        super.inputData(input, arr);
        System.out.println("Please input graduated year:");
        this.graduatedYear = Integer.parseInt(input.nextLine());
        System.out.println("Please input graduated rank:");
        this.graduatedRank = input.nextLine();
        System.out.println("Please input education of fresher");
    }

    @Override
    public void showInfo() {
        System.out.printf("%-15s%-20s%-15s%-15d%-20s%-15s%-20d%-20s%-20s\n", super.getStaffId(), super.getFullName(), super.getBirthDay(), super.getPhone(), super.getEmail(), super.getStaffType(), graduatedYear, graduatedRank, education);
    }
}
