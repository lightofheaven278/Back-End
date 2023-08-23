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
                case 1:
                    Student newStudent = new Student();
                    newStudent.inputData(input, studentList);
                    studentList.add(newStudent);
                    StudentImp.writeDataToFile(studentList);
                    break;
                case 2:
                    break;
                case 3:
                    for (Student student : studentList) {
                        student.calAvgMark_Rank();
                        if (student.getAvgMark() < 5) {
                            student.setRank("Low");
                        } else if (student.getAvgMark() < 7) {
                            student.setRank("Mediocre");
                        } else if (student.getAvgMark() < 8) {
                            student.setRank("Good");
                        } else if (student.getAvgMark() < 9) {
                            student.setRank("Excellence");
                        } else {
                            student.setRank("Master");
                        }
                    }
                    break;
                case 4:
                    studentList.sort(Comparator.comparing(Student::getAge));
                    for (Student student : studentList) {
                        student.displayData();
                    }
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.err.println("The inputted choice is out of scope!");
            }

        } while (true);
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

    public static List<Student> readDataFromFile() {
        File newReadFile = new File("listStudent.text");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        List<Student> readStudentList = null;
        try {
            fis = new FileInputStream(newReadFile);
            ois = new ObjectInputStream(fis);
            readStudentList = (List<Student>) ois.readObject();
        } catch (FileNotFoundException ex1) {
            System.err.println("Cannot find the file!");
        } catch (IOException ex2) {
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
        return readStudentList;
    }
}
