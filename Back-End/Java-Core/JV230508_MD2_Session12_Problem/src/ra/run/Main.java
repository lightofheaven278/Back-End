package ra.run;

import ra.entity.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Book> bookList = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            System.out.println("--------------MENU-------------");
            System.out.println("1. Input book's info");
            System.out.println("2. Write info to file demo.txt");
            System.out.println("3. Read file demo.txt and print book whose price is from 10000 to 200000");
            System.out.println("4. Exit");
            System.out.println("Please input your choice:");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1 -> {
                    Book newBook = new Book();
                    newBook.inputData(input, bookList);
                    bookList.add(newBook);
                }
                case 2 -> {
                    Main.writeDataToFile(bookList);
                    System.out.printf("%-15s%-15s%-15s\n", "Book ID", "Book Name", "Price");
                    for (Book book : bookList) {
                        book.displayData();
                    }
                    System.out.println("The inputted data has already been written to file!");
                }
                case 3 -> {
                    List<Book> listBookRead = Main.readDataFromFile();
                    System.out.printf("%-15s%-15s%-15s\n", "Book ID", "Book Name", "Price");
                    for (Book book : listBookRead) {
                        if (book.getPrice() > 10000 && book.getPrice() < 20000) {
                            book.displayData();
                        }
                    }
                }
                case 4 -> System.exit(0);
                default -> System.err.println("The inputted choice is out of scope!");
            }
        } while (true);
    }

    public static void writeDataToFile(List<Book> arr) {
        File newFile = new File("demo.txt");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(newFile);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(arr);
        } catch (FileNotFoundException ex1) {
            System.err.println("File is not exist!");
        } catch (IOException ex2) {
            System.err.println("Err appears while writing data!");
        } catch (Exception ex) {
            System.err.println("There is an err. Please try again!");
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException ex1) {
                System.err.println("Err appears while closing stream!");
            } catch (Exception ex) {
                System.err.println("Err appears while closing any stream!");
            }
        }
    }

    public static List<Book> readDataFromFile() {
        File file = new File("demo.txt");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        List<Book> listBookRead = null;
        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            listBookRead = (List<Book>) ois.readObject();
        } catch (FileNotFoundException ex1) {
            System.err.println("The file is not exist!");
        } catch (IOException ex2) {
            System.err.println("Err appears while reading file!");
        } catch (Exception ex) {
            System.err.println("There are some err appear while reading file!");
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex1) {
                System.err.println("Err appears while closing stream");
            } catch (Exception ex) {
                System.err.println("There are some err appearing while closing stream");
            }
        }
        return listBookRead;
    }
}
