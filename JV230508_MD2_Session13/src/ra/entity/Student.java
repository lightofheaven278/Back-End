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
import java.util.regex.Pattern;

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
        this.studentID = validateStudentID(input, studentList);
        // validate student name
        this.studentName = validateStudentName(input);
        //validate birthday
        this.birthday = isValidDate(input);
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

    public static String isValidDate(Scanner input) {
        do {
            System.out.println("Please input birthday:");
            String birthday = input.nextLine();
            // First check for the pattern
            if (!Pattern.matches("^\\d{1,2}/\\d{1,2}/\\d{4}", birthday)) {
                System.err.println("The inputted data is no matched with format : dd/mm/yyyy!");
                ;
            }
            // Parse the date parts to integers
            String[] parts = birthday.split("/");
            int day = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);

            // Check the ranges of month and year
            if (year >= 2005 || month == 0 || month > 12) {
                System.err.println("Year should be less than 2005, and month should be from 1 to 12!");
            } else {
                int[] monthLength = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

                // Adjust for leap years
                if (year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)) {
                    monthLength[1] = 29;
                }

                // Check the range of the day
                if (day > 0 && day <= monthLength[month - 1]) {
                    return birthday;
                } else {
                    System.err.println("Inputted day is not correct. Please try again!");
                }
            }
        } while (true);
    }
//    public static String validateBirthday(Scanner input) {
//        do {
//            System.out.println("Please input student birthday(dd/mm/yyyy):");
//            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//            SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
//            try {
//                Date birthday = sdf.parse(input.nextLine());
//                System.out.println("birthday: "+ birthday);
//                String myBirthday = sdf.format(birthday);
//                System.out.println("myBirthday: "+ myBirthday);
//                int year = Integer.parseInt(yearFormat.format(birthday));
//                Calendar calendar = Calendar.getInstance();
//                calendar.setTime(birthday);
//                int inputMonth = calendar.get(Calendar.MONTH) + 1;
//                System.out.println("input month: " + inputMonth);
//                if (year <= 2005) {
//                    return myBirthday;
//                } else {
//                    System.err.println("The year of birth should be greater than 2005!");
//                }
//            } catch (ParseException ex1) {
//                System.out.println("The inputted format is invalid.Please try again!");
//            } catch (Exception ex) {
//                System.err.println("Some errs occur while inputting birthday");
//            }
//        } while (true);
//    }

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
        System.out.printf("%-15s%-20s%-20s%-15d%-15b%-15.1f%-15.1f%-20.1f%-15.1f%-15s\n", this.studentID,
                this.studentName, this.birthday, this.age, sex, this.mark_html, this.mark_css, this.mark_javascript,
                this.avgMark, this.rank);
    }

    @Override
    public void calAge(Scanner input) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        try {
            Date birthday = sdf.parse(this.birthday);
            int year = Integer.parseInt(yearFormat.format(birthday));
            this.age = Year.now().getValue() - year;
        } catch (ParseException ex1) {
            System.err.println("The inputted format is invalid. Please try again!");
        } catch (Exception ex) {
            System.err.println("Some errs occur while inputting data!");
        }
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
