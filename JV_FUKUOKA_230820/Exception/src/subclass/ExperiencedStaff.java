package subclass;

import java.util.List;
import java.util.Scanner;

public class ExperiencedStaff extends Staff<ExperiencedStaff> {
    private int yearOfExperience;
    private String proSkill;

    public ExperiencedStaff() {
    }

    public ExperiencedStaff(int yearOfExperience, String proSkill) {
        this.yearOfExperience = yearOfExperience;
        this.proSkill = proSkill;
    }

    public int getYearOfExperience() {
        return yearOfExperience;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setYearOfExperience(int yearOfExperience) {
        this.yearOfExperience = yearOfExperience;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    public void inputData(Scanner input, List<ExperiencedStaff> arr) {
        super.inputData(input, arr);
        System.out.println("Please input the year of experience:");
        this.yearOfExperience = Integer.parseInt(input.nextLine());
        System.out.println("Please input staff's pro-skill:");
        this.proSkill = input.nextLine();
    }

    @Override
    public void showInfo() {
        System.out.printf("%-15s%-20s%-15s%-15d%-20s%-15s%-25d%-25s\n", super.getStaffId(), super.getFullName(), super.getBirthDay(), super.getPhone(), super.getEmail(), super.getStaffType(), yearOfExperience, proSkill);
    }
}
