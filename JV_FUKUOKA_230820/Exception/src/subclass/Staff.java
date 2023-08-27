package subclass;

import java.util.List;
import java.util.Scanner;

public class Staff<E> {
    private String staffId;
    private String fullName;
    private int birthDay;
    private int phone;
    private String email;
    private String staffType;
    private int staffCount;

    public Staff() {
    }

    public Staff(String staffId, String fullName, int birthDay, int phone, String email, String staffType, int staffCount) {
        this.staffId = staffId;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.phone = phone;
        this.email = email;
        this.staffType = staffType;
        this.staffCount = staffCount;
    }

    public String getStaffId() {
        return staffId;
    }

    public String getFullName() {
        return fullName;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public int getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getStaffType() {
        return staffType;
    }

    public int getStaffCount() {
        return staffCount;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStaffType(String staffType) {
        this.staffType = staffType;
    }

    public void setStaffCount(int staffCount) {
        this.staffCount = staffCount;
    }

    public void inputData(Scanner input, List<E> arr) {
        System.out.println("Please input staff ID:");
        this.staffId = input.nextLine();
        System.out.println("Please input full name of staff:");
        this.fullName = input.nextLine();
        System.out.println("Please input birthday of staff:");
        this.birthDay = Integer.parseInt(input.nextLine());
        System.out.println("Please input staff phone:");
        this.phone = Integer.parseInt(input.nextLine());
        System.out.println("Please input email of staff:");
        this.email = input.nextLine();
        System.out.println("Please input staff type:");
        this.staffType = input.nextLine();
    }

    public void showInfo() {
        System.out.printf("%-15s%-20s%-15s%-15d%-20s%-15s%-15d", staffId, fullName, birthDay, phone, email, staffType, staffCount);
    }
}
