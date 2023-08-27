package subclass;

import java.util.List;
import java.util.Scanner;

public class Intern extends Staff<Intern> {
    private String major;
    private String semester;
    private String universityName;

    public Intern() {
    }

    public Intern(String major, String semester, String universityName) {
        this.major = major;
        this.semester = semester;
        this.universityName = universityName;
    }

    public String getMajor() {
        return major;
    }

    public String getSemester() {
        return semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public void inputData(Scanner input, List<Intern> arr) {
        super.inputData(input, arr);
        System.out.println("Please input staff major:");
        this.major = input.nextLine();
        System.out.println("Please input semester:");
        this.semester = input.nextLine();
        System.out.println("Please input name of university");
        this.universityName = input.nextLine();
    }

    @Override
    public void showInfo() {
        System.out.printf("%-15s%-20s%-15s%-15d%-20s%-15s%-20s%-20s%-20s", super.getStaffId(), super.getFullName(), super.getBirthDay(), super.getPhone(), super.getEmail(), super.getStaffType(), major, semester, universityName);
    }
}
