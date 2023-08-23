package ra.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class Book implements Serializable {
    private String bookId;
    private String bookName;
    private Float price;


    public Book() {
    }

    public Book(String bookId, String bookName, Float price) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.price = price;
    }

    public String getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public Float getPrice() {
        return price;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void inputData(Scanner input, List<Book> arr) {
        System.out.println("Please input book ID:");
        this.bookId = input.nextLine();
        System.out.println("Please input book name:");
        this.bookName = input.nextLine();
        boolean checkOut = true;
        do {
            try {
                System.out.println("Please input book price:");
                this.price = Float.parseFloat(input.nextLine());
                checkOut = false;
            } catch (NumberFormatException ex1) {
                System.err.println("The inputted price is not a number. Please try again!");
            }
        } while (checkOut);
    }

    public void displayData() {
        System.out.printf("%-15s%-15s%-15.1f\n", this.bookId, this.bookName, this.price);
    }
}
