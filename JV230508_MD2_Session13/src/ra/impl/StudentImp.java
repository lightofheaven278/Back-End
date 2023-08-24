package ra.impl;

import ra.entity.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentImp {
    static Scanner input = new Scanner(System.in);
    static List<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        do {
            readDataFromFile();
            System.out.println("--------------Menu------------");
            System.out.println("1. Input student info");
            System.out.println("2. Calculate student's age");
            System.out.println("3. Calculate student's average mark and classification");
            System.out.println("4. Sort student info in ascending age order");
            System.out.println("5. Show statistics of number of students by rank");
            System.out.println("6. Update student info by student ID");
            System.out.println("7. Search student info by student name");
            System.out.println("8. Exit");
            System.out.println("Please input your choice:");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1 -> StudentImp.addNewStudent(input, studentList);
                case 2 -> StudentImp.calculateAge(input);
                case 3 -> StudentImp.calculateAvgMark_Rank();
                case 4 -> StudentImp.sortStudentInfoByAgeAscending();
                case 5 -> StudentImp.showStatistics();
                case 6 -> StudentImp.updateStudentInfo();
                case 7 -> StudentImp.searchStudentInfoByName();
                case 8 -> {
                    StudentImp.writeDataToFile(studentList);
                    System.exit(0);
                }
                default -> System.err.println("The inputted choice is out of scope!");
            }

        } while (true);
    }

    public static void addNewStudent(Scanner input, List<Student> studentList) {
        Student newStudent = new Student();
        newStudent.inputData(input, studentList);
        studentList.add(newStudent);
        StudentImp.writeDataToFile(studentList);
    }

    public static void calculateAge(Scanner input) {
        for (Student student : studentList) {
            student.calAge();
        }
        StudentImp.writeDataToFile(studentList);
    }

    public static void calculateAvgMark_Rank() {
        for (Student student : studentList) {
            student.calAvgMark_Rank(studentList);
        }
        StudentImp.writeDataToFile(studentList);
    }

    public static void sortStudentInfoByAgeAscending() {
        System.out.printf("%-15s%-20s%-20s%-15s%-15s%-15s%-15s%-20s%-15s%-20s\n",
                "Student ID", "Student Name", "Birthday", "Age", "Sex", "HTML Mark", "CSS Mark",
                "Javascript Mark", "Avg Mark", "Rank");
        studentList.sort(Comparator.comparing(Student::getAge));
        for (Student student : studentList) {
            student.displayData();
        }
    }

    public static void showStatistics() {
        int countLow = 0;
        int countIntermediate = 0;
        int countGood = 0;
        int countExcellence = 0;
        int countMaster = 0;
        for (Student student : studentList) {
            switch (student.getRank()) {
                case "Low" -> countLow++;
                case "Intermediate" -> countIntermediate++;
                case "Good" -> countGood++;
                case "Excellence" -> countExcellence++;
                case "Master" -> countMaster++;
            }
        }
        System.out.printf("There is(are) %d student has(have) rank Low\n", countLow);
        System.out.printf("There is(are) %d student has(have) rank Intermediate\n", countIntermediate);
        System.out.printf("There is(are) %d student has(have) rank Good\n", countGood);
        System.out.printf("There is(are) %d student has(have) rank Excellence\n", countExcellence);
        System.out.printf("There is(are) %d student has(have) rank Master\n", countMaster
        );
    }

    public static void updateStudentInfo() {
        System.out.println("Please input ID of student you wanna update info:");
        String studentId = Student.validateStudentID(input, studentList);
        int index = -1;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getStudentID().equals(studentId)) {
                index = i;
            }
        }
        if (index != -1) {
            studentList.get(index).setStudentName(Student.validateStudentName(input));
            studentList.get(index).setBirthday(Student.validateBirthday(input));
            studentList.get(index).setSex(Student.validateSex(input));
            studentList.get(index).setMark_html(Student.validateHtmlMark(input));
            studentList.get(index).setMark_css(Student.validateCssMark(input));
            studentList.get(index).setMark_javascript(Student.validateJavascriptMark(input));
            studentList.get(index).calAge();
            studentList.get(index).calAvgMark_Rank(studentList);
            writeDataToFile(studentList);
        } else {
            System.err.println("The inputted ID is not exist!");
        }
    }

    public static void searchStudentInfoByName() {
        System.out.println("Please input the student name or keyword of name:");
        String searchName = input.nextLine();
        System.out.printf("%-15s%-20s%-20s%-15s%-15s%-15s%-15s%-20s%-15s%-20s\n",
                "Student ID", "Student Name", "Birthday", "Age", "Sex", "HTML Mark", "CSS Mark",
                "Javascript Mark", "Avg Mark", "Rank");
        for (Student student : studentList) {
            if (student.getStudentName().toLowerCase().contains(searchName.toLowerCase())) {
                student.displayData();
            }
        }
    }

    public static void writeDataToFile(List<Student> studentList) {
        File newFile = new File("listStudent.txt");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(newFile);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(studentList);
            oos.flush();
        } catch (FileNotFoundException ex1) {
            System.err.println("Cannot find the file!");
        } catch (IOException ex2) {
            System.err.println("Err appears while writing stream!");
        } catch (Exception ex) {
            System.err.println("Some errs occur while writing stream!");
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex1) {
                System.err.println("Err appears while closing stream!");
            } catch (Exception ex) {
                System.err.println("Some errs occur while closing stream!");
            }
        }
    }

    public static void readDataFromFile() {
        File newReadFile = new File("listStudent.txt");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(newReadFile);
            ois = new ObjectInputStream(fis);
            if (ois.readObject() != null) {
                studentList = (List<Student>) ois.readObject();
            }
        } catch (FileNotFoundException ex1) {
            System.err.println("Cannot find the file!");
        } catch (ClassNotFoundException ex2) {
            System.err.println("Class is not exist!");
        } catch (IOException ex3) {
            System.err.println("Err appears while reading stream!");
        } catch (Exception ex) {
            System.err.println("Some errs occur while reading stream!");
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex1) {
                System.err.println("Err appears while closing stream!");
            } catch (Exception ex) {
                System.err.println("Some errs occur while closing stream!");
            }
        }
    }
}
