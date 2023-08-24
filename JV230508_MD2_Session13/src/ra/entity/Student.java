package ra.entity;

import java.io.Serializable;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Student implements IEntity, Serializable {
    private String studentID;
    private String studentName;
    private Date birthday;
    private int age;
    private boolean sex;
    private float mark_html;
    private float mark_css;
    private float mark_javascript;
    private float avgMark;
    private String rank;

    public Student() {
    }

    public Student(String studentID, String studentName, Date birthday, int age, boolean sex, float mark_html, float mark_css, float mark_javascript, float avgMark, String rank) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.birthday = birthday;
        this.age = age;
        this.sex = sex;
        this.mark_html = mark_html;
        this.mark_css = mark_css;
        this.mark_javascript = mark_javascript;
        this.avgMark = avgMark;
        this.rank = rank;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public int getAge() {
        return age;
    }

    public boolean isSex() {
        return sex;
    }

    public float getMark_html() {
        return mark_html;
    }

    public float getMark_css() {
        return mark_css;
    }

    public float getMark_javascript() {
        return mark_javascript;
    }

    public float getAvgMark() {
        return avgMark;
    }

    public String getRank() {
        return rank;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public void setMark_html(float mark_html) {
        this.mark_html = mark_html;
    }

    public void setMark_css(float mark_css) {
        this.mark_css = mark_css;
    }

    public void setMark_javascript(float mark_javascript) {
        this.mark_javascript = mark_javascript;
    }

    public void setAvgMark(float avgMark) {
        this.avgMark = avgMark;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public void inputData(Scanner input, List<Student> studentList) {
        // validate studentID
        this.studentID = validateStudentID(input, studentList);
        // validate student name
        this.studentName = validateStudentName(input);
        //validate birthday
        this.birthday = validateBirthday(input);
        // validate sex
        this.sex = validateSex(input);
        // validate mark_html
        this.mark_html = validateHtmlMark(input);
        // validate mark_css
        this.mark_css = validateCssMark(input);
        // validate mark_javascript
        this.mark_javascript = validateJavascriptMark(input);
    }

    public static String validateStudentID(Scanner input, List<Student> studentList) {
        do {
            System.out.println("Please input student ID:");
            String studentID = input.nextLine();
            if (studentID.startsWith("S") && studentID.length() == 4) {
                if (studentList.size() == 0) {
                    return studentID;
                } else {
                    boolean checkDuplicateID = false;
                    for (Student student : studentList) {
                        if (student.getStudentID().equals(studentID)) {
                            checkDuplicateID = true;
                        }
                    }
                    if (checkDuplicateID) {
                        System.err.println("The inputted ID is exist!");
                    } else {
                        return studentID;
                    }
                }
            } else {
                System.err.println("The student ID should follow this format: S****!");
            }
        } while (true);
    }

    public static String validateStudentName(Scanner input) {
        do {
            System.out.println("Please input student name:");
            String studentName = input.nextLine();
            if (studentName.length() > 10 && studentName.length() < 50) {
                return studentName;
            } else {
                System.err.println("Student name should contain 10-50 characters!");
            }
        } while (true);
    }

    public static Date validateBirthday(Scanner input) {
        do {
            System.out.println("Please input student birthday(dd/mm/yyyy):");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date birthday = sdf.parse(input.nextLine());
                Calendar cal = Calendar.getInstance();
                cal.setTime(birthday);
                int year = cal.get(Calendar.YEAR);
                if (year <= 2005) {
                    return birthday;
                } else {
                    System.err.println("The year of birth should greater than 2005!");
                }
            } catch (ParseException ex1) {
                System.out.println("The inputted format is invalid.Please try again!");
            } catch (Exception ex) {
                System.err.println("Some errs occur while inputting birthday");
            }
        } while (true);
    }

    public static float validateHtmlMark(Scanner input) {
        do {
            try {
                System.out.println("Please input html mark:");
                float mark_html = Float.parseFloat(input.nextLine());
                if (mark_html >= 0 && mark_html <= 10) {
                    return mark_html;
                } else {
                    System.err.println("All mark should be from 0 to 10");
                }
            } catch (NumberFormatException ex1) {
                System.err.println("Inputted data is not float format!");
            } catch (Exception ex) {
                System.err.println("Some errs occur while inputting html mark!");
            }

        } while (true);
    }

    public static float validateCssMark(Scanner input) {
        do {
            try {
                System.out.println("Please input css mark:");
                float mark_css = Float.parseFloat(input.nextLine());
                if (mark_css >= 0 && mark_css <= 10) {
                    return mark_css;
                } else {
                    System.err.println("All mark should be from 0 to 10");
                }
            } catch (NumberFormatException ex1) {
                System.err.println("Inputted data is not float format!");
            } catch (Exception ex) {
                System.err.println("Some errs occur while inputting css mark!");
            }
        } while (true);
    }

    public static boolean validateSex(Scanner input) {
        do {
            System.out.println("Please input gender:");
            String str = input.nextLine();
            if (str.equals("True") || str.equals("False")) {
                return Boolean.parseBoolean(str);
            } else {
                System.err.println("Student gender value should be 'True' or 'False'!");
            }
        } while (true);
    }

    public static float validateJavascriptMark(Scanner input) {
        do {
            try {
                System.out.println("Please input javascript mark:");
                float mark_javascript = Float.parseFloat(input.nextLine());
                if (mark_javascript >= 0 && mark_javascript <= 10) {
                    return mark_javascript;
                } else {
                    System.err.println("All mark should be from 0 to 10");
                }
            } catch (NumberFormatException ex1) {
                System.err.println("Inputted data is not float format!");
            } catch (Exception ex) {
                System.err.println("Some errs occur while inputting javascript mark!");
            }
        } while (true);
    }

    @Override
    public void displayData() {
        String sex = this.sex ? "Male" : "Female";
        System.out.printf("%-15s%-20s%-20td-%tb-%tY%-15d%-15b%-15.1f%-15.1f%-20.1f%-15.1f%-15s\n", this.studentID,
                this.studentName, this.birthday, this.age, sex, this.mark_html, this.mark_css, this.mark_javascript,
                this.avgMark, this.rank);
    }

    @Override
    public void calAge() {
        Date actualYear = new Date();
        this.age = actualYear.getYear() - this.birthday.getYear();
    }

    @Override
    public void calAvgMark_Rank(List<Student> studentList) {
        this.avgMark = (this.mark_html + this.mark_css + this.mark_javascript) / 3;
        if (this.avgMark < 5) {
            this.rank = "Low";
        } else if (this.avgMark < 7) {
            this.rank = "Intermediate";
        } else if (this.avgMark < 8) {
            this.rank = "Good";
        } else if (this.avgMark < 9) {
            this.rank = "Excellence";
        } else {
            this.rank = "Master";
        }
    }
}
