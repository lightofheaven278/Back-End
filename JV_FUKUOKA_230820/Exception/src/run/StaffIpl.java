package run;

import subclass.ExperiencedStaff;
import subclass.Fresher;
import subclass.Intern;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StaffIpl {
    static Scanner input = new Scanner(System.in);
    static List<ExperiencedStaff> experiencedStaffList = new ArrayList<>();
    static List<Fresher> fresherList = new ArrayList<>();
    static List<Intern> internList = new ArrayList<>();

    public static void main(String[] args) {
        do {
            System.out.println("-------------Staff Classification------------");
            System.out.println("1. Experience");
            System.out.println("2. Fresher");
            System.out.println("3. Intern");
            System.out.println("4. Exit");
            System.out.println("Please input type of staff you wanna input info:");
            int staffType = Integer.parseInt(input.nextLine());
            switch (staffType) {
                case 1 -> StaffIpl.experiencedStaffManagement();
                case 2 -> StaffIpl.FresherManagement();
                case 3 -> StaffIpl.InternManagement();
                case 4 -> System.exit(0);
                default -> System.err.println("The inputted staff type is out of scope!");
            }
        } while (true);
    }

    public static void experiencedStaffManagement() {
        boolean checkOut = true;
        do {
            readExpStaffInfoFromFile();
            System.out.println("--------------Experienced Staff Management-----------------");
            System.out.println("1. Add new staff");
            System.out.println("2. Display staff info");
            System.out.println("3. Update staff info");
            System.out.println("4. Delete staff info");
            System.out.println("5. Sort info in ascending order of birthday");
            System.out.println("6. Sort info in descending order of birthday");
            System.out.println("7. Sort info in ascending order of full name");
            System.out.println("8. Exit");
            System.out.println("Please input your choice:");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1 -> {
                    ExperiencedStaff newExperiencedStaff = new ExperiencedStaff();
                    newExperiencedStaff.inputData(input, experiencedStaffList);
                    experiencedStaffList.add(newExperiencedStaff);
                    writeExpStaffInfoToList();
                }
                case 2 -> {
                    System.out.println("------------------Staff Info---------------------");
                    System.out.printf("%-15s%-20s%-15s%-15s%-20s%-15s%-25s%-25s\n", "Staff ID", "Full Name", "Birthday",
                            "Phone", "Email", "Staff Type", "Year of Experience", "Pro-Skill");
                    for (ExperiencedStaff staff : experiencedStaffList) {
                        staff.showInfo();
                    }
                }
                case 3 -> {
                    int indexUpdate = StaffIpl.getIndexUpdateExpStaff();
                    if (indexUpdate == -1) {
                        System.err.println("The inputted ID is not exist!");
                    } else {
                        System.out.println("Please input new name of staff:");
                        String newName = input.nextLine();
                        experiencedStaffList.get(indexUpdate).setFullName(newName);
                        System.out.println("Staff info has been updated successfully!");
                        writeExpStaffInfoToList();
                    }
                }
                case 4 -> {
                    System.out.println("Please input the ID of staff you wanna delete info:");
                    String deleteStaffID = input.nextLine();
                    int indexDelete = 0;
                    if (experiencedStaffList.size() == 0) {
                        break;
                    }
                    for (int i = 0; i < experiencedStaffList.size(); i++) {
                        if (experiencedStaffList.get(i).getStaffId().equals(deleteStaffID)) {
                            indexDelete = i;
                        }
                    }
                    experiencedStaffList.remove(indexDelete);
                    System.out.println("Staff info has been deleted!");
                    writeExpStaffInfoToList();
                }
                case 5 -> experiencedStaffList.sort(Comparator.comparing(ExperiencedStaff::getBirthDay));
                case 6 -> experiencedStaffList.sort((Comparator.comparing(ExperiencedStaff::getBirthDay).reversed()));
                case 7 -> experiencedStaffList.sort(Comparator.comparing(ExperiencedStaff::getFullName));
                case 8 -> {
                    writeExpStaffInfoToList();
                    checkOut = false;
                }
                default -> System.err.println("The inputted choice is out of scope!");
            }
        } while (checkOut);
    }

    public static void writeExpStaffInfoToList() {
        File file = new File("expStaff.txt");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(experiencedStaffList);
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

    public static void readExpStaffInfoFromFile() {
        File newFile = new File("expStaff.txt");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(newFile);
            ois = new ObjectInputStream(fis);
            experiencedStaffList = (List<ExperiencedStaff>) ois.readObject();
        } catch (FileNotFoundException ex1) {
            System.err.println("Cannot file the file to read!");
        } catch (IOException ex2) {
            System.err.println("Err appears while reading stream!");
        } catch (Exception ex) {
            System.err.println("Some errs appear while reading stream!");
        } finally {
            checkClosingStream(fis, ois);
        }
    }

    private static void checkClosingStream(FileInputStream fis, ObjectInputStream ois) {
        try {
            if (fis != null) {
                fis.close();
            }
            if (ois != null) {
                ois.close();
            }
        } catch (IOException ex1) {
            System.err.println("Err appears while closing reading stream!");
        } catch (Exception ex) {
            System.err.println("Some errs occur while closing reading stream!");
        }
    }

    public static int getIndexUpdateExpStaff() {
        System.out.println("Please input the ID of staff you wanna edit info:");
        String updateStaffID = input.nextLine();
        int indexUpdate = 0;
        for (int i = 0; i < experiencedStaffList.size(); i++) {
            if (experiencedStaffList.get(i).getStaffId().equals(updateStaffID)) {
                indexUpdate = i;
            } else {
                indexUpdate = -1;
            }
        }
        return indexUpdate;
    }

    public static void FresherManagement() {
        boolean checkOut1 = true;
        do {
            readFresherStaffInfoFromFile();
            System.out.println("--------------Fresher Management-----------------");
            System.out.println("1. Add new fresher");
            System.out.println("2. Display fresher info");
            System.out.println("3. Update fresher info");
            System.out.println("4. Delete fresher info");
            System.out.println("5. Sort info in ascending order of birthday");
            System.out.println("6. Sort info in descending order of birthday");
            System.out.println("7. Sort info in ascending order of full name");
            System.out.println("8. Exit");
            System.out.println("Please input your choice:");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1 -> {
                    Fresher newFresher = new Fresher();
                    newFresher.inputData(input, fresherList);
                    fresherList.add(newFresher);
                    writeFresherStaffInfoToList();
                }
                case 2 -> {
                    readFresherStaffInfoFromFile();
                    System.out.println("------------------Staff Info---------------------");
                    System.out.printf("%-15s%-20s%-15s%-15s%-20s%-15s%-20s%-20s%-20s\n", "Staff ID", "Full Name",
                            "Birthday", "Phone", "Email", "Staff Type", "Graduated Year", "Graduated Rank", "Education");
                    for (Fresher staff : fresherList) {
                        staff.showInfo();
                    }
                }
                case 3 -> {
                    int indexUpdateFresher = StaffIpl.getIndexUpdateFresher();
                    if (indexUpdateFresher == -1) {
                        System.err.println("The inputted ID is not exist!");
                    } else {
                        System.out.println("Please input new name of fresher:");
                        String newFresherName = input.nextLine();
                        fresherList.get(indexUpdateFresher).setFullName(newFresherName);
                        System.out.println("Fresher name has been updated successfully!");
                        writeFresherStaffInfoToList();
                    }
                }
                case 4 -> {
                    System.out.println("Please input ID of fresher you wanna delete:");
                    String inputDeleteFresher = input.nextLine();
                    boolean remove = fresherList.removeIf(fresher -> fresher.getStaffId().equals(inputDeleteFresher));
                    if (remove) {
                        writeFresherStaffInfoToList();
                    } else {
                        System.err.println("The inputted ID is not exist!");
                    }
                }
                case 5 -> fresherList.sort(Comparator.comparing(Fresher::getBirthDay));
                case 6 -> fresherList.sort((Comparator.comparing(Fresher::getBirthDay).reversed()));
                case 7 -> fresherList.sort(Comparator.comparing(Fresher::getFullName));
                case 8 -> {
                    writeFresherStaffInfoToList();
                    checkOut1 = false;
                }
                default -> System.err.println("The inputted choice is out of scope!");
            }
        } while (checkOut1);
    }

    public static void writeFresherStaffInfoToList() {
        File file = new File("fresherStaff.txt");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(fresherList);
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

    public static void readFresherStaffInfoFromFile() {
        File newFile = new File("fresherStaff.txt");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(newFile);
            ois = new ObjectInputStream(fis);
            fresherList = (List<Fresher>) ois.readObject();
        } catch (FileNotFoundException ex1) {
            System.err.println("Cannot file the file to read!");
        } catch (IOException ex2) {
            System.err.println("Err appears while reading stream!");
        } catch (Exception ex) {
            System.err.println("Some errs appear while reading stream!");
        } finally {
            checkClosingStream(fis, ois);
        }
    }

    public static int getIndexUpdateFresher() {
        System.out.println("Please input the ID of fresher you wanna edit info:");
        String updateFresherID = input.nextLine();
        int indexUpdate = 0;
        for (int i = 0; i < fresherList.size(); i++) {
            if (fresherList.get(i).getStaffId().equals(updateFresherID)) {
                indexUpdate = i;
            } else {
                indexUpdate = -1;
            }
        }
        return indexUpdate;
    }

    public static void InternManagement() {
        boolean checkOut2 = true;
        do {
            writeInternStaffInfoToList();
            System.out.println("--------------Intern Management-----------------");
            System.out.println("1. Add new intern");
            System.out.println("2. Display intern info");
            System.out.println("3. Update intern info");
            System.out.println("4. Delete intern info");
            System.out.println("5. Sort info in ascending order of birthday");
            System.out.println("6. Sort info in descending order of birthday");
            System.out.println("7. Sort info in ascending order of full name");
            System.out.println("8. Exit");
            System.out.println("Please input your choice:");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1 -> {
                    Intern newIntern = new Intern();
                    newIntern.inputData(input, internList);
                    internList.add(newIntern);
                    writeInternStaffInfoToList();
                }
                case 2 -> {
                    readInternStaffInfoFromFile();
                    System.out.println("------------------Staff Info---------------------");
                    System.out.printf("%-15s%-20s%-15s%-15s%-20s%-15s%-20s%-20s%-20s", "Staff ID", "Full Name",
                            "Birthday", "Phone", "Email", "Staff Type", "Major", "Semester", "University Name");
                    for (Intern staff : internList) {
                        staff.showInfo();
                    }
                }
                case 3 -> {
                    int indexUpdateIntern = StaffIpl.getIndexUpdateIntern();
                    if (indexUpdateIntern == -1) {
                        System.out.println("There is no ID matched with inputted ID!");
                    } else {
                        System.out.println("Please input name of staff:");
                        String newInternName = input.next();
                        internList.get(indexUpdateIntern).setFullName(newInternName);
                        System.out.println("Intern info has been updated!");
                        writeInternStaffInfoToList();
                    }
                }
                case 4 -> {
                    System.out.println("Please input ID of intern you wanna delete info:");
                    String inputDeleteInternId = input.nextLine();
                    boolean removeIntern = internList.removeIf(intern -> intern.getStaffId().
                            equals(inputDeleteInternId));
                    if (removeIntern) {
                        System.out.println("Intern info has been deleted!");
                        writeInternStaffInfoToList();
                    } else {
                        System.err.println("The inputted ID is not exist!");
                    }
                }
                case 5 -> internList.sort(Comparator.comparing(Intern::getBirthDay));
                case 6 -> internList.sort((Comparator.comparing(Intern::getBirthDay).reversed()));
                case 7 -> internList.sort(Comparator.comparing(Intern::getFullName));
                case 8 -> {
                    writeInternStaffInfoToList();
                    checkOut2 = false;
                }
                default -> System.err.println("The inputted choice is out of scope!");
            }
        } while (checkOut2);
    }

    public static void writeInternStaffInfoToList() {
        File file = new File("internStaff.txt");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(internList);
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

    public static void readInternStaffInfoFromFile() {
        File newFile = new File("internStaff.txt");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(newFile);
            ois = new ObjectInputStream(fis);
            internList = (List<Intern>) ois.readObject();
        } catch (FileNotFoundException ex1) {
            System.err.println("Cannot file the file to read!");
        } catch (IOException ex2) {
            System.err.println("Err appears while reading stream!");
        } catch (Exception ex) {
            System.err.println("Some errs appear while reading stream!");
        } finally {
            checkClosingStream(fis, ois);
        }
    }

    public static int getIndexUpdateIntern() {
        int indexUpdate = 0;
        String updateInternId = input.nextLine();
        for (int i = 0; i < internList.size(); i++) {
            if (internList.get(i).equals(updateInternId)) {
                indexUpdate = i;
            } else {
                indexUpdate = -1;
            }
        }
        return indexUpdate;
    }
}
