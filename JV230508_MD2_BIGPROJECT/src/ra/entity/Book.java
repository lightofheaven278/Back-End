package ra.entity;

import java.io.Serializable;
import java.time.Year;
import java.util.List;
import java.util.Scanner;

public class Book implements IEntity<Book>, Serializable {
    String id;
    String title;
    String author;
    String publisher;
    int year;
    String description;
    int categoryId;

    public Book() {
    }

    public Book(String id, String title, String author, String publisher, int year, String description, int categoryId) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.description = description;
        this.categoryId = categoryId;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYear() {
        return year;
    }

    public String getDescription() {
        return description;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public void input(Scanner input, List<Book> bookList) {
        this.id = validateBookId(input, bookList);
        this.title = validateBookTitle(input, bookList);
        this.author = validateBookAuthor(input);
        this.publisher = validatePublisher(input);
        this.year = validateYear(input);
        this.description = validateDescription(input);
    }

    public static String validateBookId(Scanner input, List<Book> bookList) {
        do {
            System.out.println("Please input book ID:");
            String id = input.nextLine();
            if (!id.trim().equals("") && id.startsWith("B") && id.length() == 4) {
                if (bookList.size() == 0) {
                    return id;
                } else {
                    if (!checkDuplicateBook(bookList, id)) {
                        return id;
                    } else {
                        System.err.println("The inputted ID is already exist. Please try another!");
                    }
                }
            } else {
                System.err.println("The ID should not a blank and follow this format: B***");
            }
        } while (true);
    }

    public static String validateBookTitle(Scanner input, List<Book> bookList) {
        do {
            System.out.println("Please input book title:");
            String title = input.nextLine();
            if (!title.trim().equals("") && title.length() > 6 && title.length() < 50) {
                if (!checkDuplicateBook(bookList, title)) {
                    return title;
                } else {
                    System.err.println("The inputted title is already exist. Please try another!");
                }
            } else {
                System.err.println("The book title should contain 6-50 characters!");
            }
        } while (true);
    }

    public static String validateBookAuthor(Scanner input) {
        do {
            System.out.println("Please input author of book:");
            String author = input.nextLine();
            if (!author.trim().equals("")) {
                return author;
            } else {
                System.err.println("The author name should not be a blank!");
            }
        } while (true);
    }

    public static String validatePublisher(Scanner input) {
        do {
            System.out.println("Please input the publisher name:");
            String publisher = input.nextLine();
            if (!publisher.trim().equals("")) {
                return publisher;
            } else {
                System.err.println("The publisher name should not be a blank!");
            }
        } while (true);
    }

    public static Integer validateYear(Scanner input) {
        do {
            try {
                System.out.println("Please input published year:");
                int year = Integer.parseInt(input.nextLine());
                int actualYear = Year.now().getValue();
                if (year >= 1970 && year <= actualYear) {
                    return year;
                } else {
                    System.err.println("Published Year should be from 1970 to now!");
                }
            } catch (NumberFormatException ex1) {
                System.err.println("The inputted year is not an integer format");
            } catch (Exception ex) {
                System.err.println("Err appears while inputting published year!");
            }
        } while (true);
    }

    public static String validateDescription(Scanner input) {
        do {
            System.out.println("Please input description of book:");
            String description = input.nextLine();
            if (!description.trim().equals("")) {
                return description;
            } else {
                System.err.println("The description of book should not be a blank");
            }
        } while (true);
    }

    public static boolean checkDuplicateBook(List<Book> bookList, String arr) {
        boolean checkDuplicate = false;
        for (Book book : bookList) {
            if (book.getId().equals(arr)) {
                checkDuplicate = true;
                break;
            }
        }
        return checkDuplicate;
    }

    @Override
    public void output() {
        System.out.printf("%-15s%-20s%-20s%-20s%-20d%-20s%-15d\n", this.id, this.title, this.author,
                this.publisher, this.year, this.description, this.categoryId);
    }
}
