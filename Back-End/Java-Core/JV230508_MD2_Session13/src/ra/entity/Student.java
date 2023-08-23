package ra.entity;

import java.io.Serializable;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Student implements IEntity, Serializable {
    private String studentID;
    private String studentName;
    private String birthday;
    private int age;
    private boolean sex;
    private float mark_html;
    private float mark_css;
    private float mark_javascript;
    private float avgMark;
    private String rank;

    public Student() {
    }

    public Student(String studentID, String studentName, String birthday, int age, boolean sex, float mark_html, float mark_css, float mark_javascript, float avgMark, String rank) {
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

    public String getBirthday() {
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

    public void setBirthday(String birthday) {
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
        do {
            System.out.println("Please input student ID:");
            this.studentID = input.nextLine();
            if (this.studentID.startsWith("P") && this.studentID.length() == 4) {
                if (studentList.size() == 0) {
                    break;
                } else {
                    boolean checkDuplicateID = false;
                    for (Student student : studentList) {
                        if (student.getStudentID().equals(this.studentID)) {
                            System.err.println("The inputted ID is exist!");
                            checkDuplicateID = true;
                        }
                    }
                    if (checkDuplicateID) {
                        System.err.println("The inputted ID is exist!");
                    } else {
                        break;
                    }
                }
            } else {
                System.err.println("The student ID should follow this format: B****!");
            }
        } while (true);
        // validate student name
        do {
            System.out.println("Please input student name:");
            this.studentName = input.nextLine();
            if (this.studentName.length() > 10 && this.studentName.length() < 50) {
                break;
            } else {
                System.err.println("Student name should contain 10-50 characters!");
            }
        } while (true);
        //validate birthday
        do {
            System.out.println("Please input student birthday(dd/mm/yyyy):");
            String str = input.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
            try {
                Date birthday = sdf.parse(str);
                this.birthday = sdf.format(birthday);
                int year = Integer.parseInt(yearFormat.format(birthday));
                if (year > 2005) {
                    this.age = Year.now().getValue() - year;
                    break;
                } else {
                    System.err.println("The year of birth should greater than 2005!");
                }
            } catch (ParseException ex1) {
                System.out.println("The inputted format is invalid.Please try again!");
            } catch (Exception ex) {
                System.err.println("Some errs occur while inputting birthday");
            }
        } while (true);
        // validate sex
        this.sex = Student.validateSex(input);
        // validate mark_html
        do {
            try {
                System.out.println("Please input html mark:");
                this.mark_html = Float.parseFloat(input.nextLine());
                if (this.mark_html >= 0 && this.mark_html <= 10) {
                    break;
                } else {
                    System.err.println("All mark should be from 0 to 10");
                }
            } catch (NumberFormatException ex1) {
                System.err.println("Inputted data is not float format!");
            } catch (Exception ex) {
                System.err.println("Some errs occur while inputting html mark!");
            }

        } while (true);
        // validate mark_css
        do {
            try {
                System.out.println("Please input css mark:");
                this.mark_css = Float.parseFloat(input.nextLine());
                if (this.mark_css >= 0 && this.mark_css <= 10) {
                    break;
                } else {
                    System.err.println("All mark should be from 0 to 10");
                }
            } catch (NumberFormatException ex1) {
                System.err.println("Inputted data is not float format!");
            } catch (Exception ex) {
                System.err.println("Some errs occur while inputting css mark!");
            }
        } while (true);
        // validate mark_javascript
        do {
            try {
                System.out.println("Please input javascript mark:");
                this.mark_javascript = Float.parseFloat(input.nextLine());
                if (this.mark_javascript >= 0 && this.mark_javascript <= 10) {
                    break;
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

    @Override
    public void displayData() {
        System.out.printf("%-15s%-20s%-20s%-15d%-15b%-15f%-15f%-15f%-15f\n", this.studentID, this.studentName,
                this.birthday, this.age, this.sex, this.mark_html, this.mark_css, this.mark_javascript,
                this.avgMark, this.rank);
    }

    @Override
    public void calAge() {

    }

    @Override
    public void calAvgMark_Rank() {
        this.avgMark = (this.mark_html + this.mark_css + this.mark_javascript) / 3;
    }
}
