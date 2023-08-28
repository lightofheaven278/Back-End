package ra.run;

import ra.entity.Book;
import ra.entity.Category;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BookImp {
    /**
     * Text color
     */
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    /**
     * Background color
     */
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    /**
     * Bold format
     */
    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
    public static final String WHITE_BOLD = "\033[1;37m";  // WHITE
    /**
     * Underline
     */
    public static final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
    public static final String RED_UNDERLINED = "\033[4;31m";    // RED
    public static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
    public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
    public static final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
    public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
    public static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
    public static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE

    /**
     * Global variable
     */
    static List<Category> categoryList = new ArrayList<>();
    static List<Book> bookList = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            try {
                System.out.println("-----------Library Management-----------");
                System.out.println("1. Category Management");
                System.out.println("2. Book Management");
                System.out.println("3. Exit");
                System.out.println("Please input your choice:");
                int choice = Integer.parseInt(input.nextLine());
                switch (choice) {
                    case 1 -> BookImp.categoryManagement();
                    case 2 -> BookImp.bookManagement();
                    case 3 -> System.exit(0);
                    default -> System.err.println("The inputted choice is out of scope!");
                }
            } catch (NumberFormatException ex1) {
                System.err.println("The inputted choice is not an integer format. Please try again!");
            } catch (Exception ex) {
                System.err.println("Err appears while inputting choice!");
            }
        } while (true);
    }

    /**
     * Category management
     */
    public static void categoryManagement() {
        boolean checkOutCategory = true;
        do {
            readCategoryListFromFile();
            System.out.println("------------Category Management------------");
            System.out.println("1. Add new category");
            System.out.println("2. Display category info");
            System.out.println("3. Show statistics of the number of books in each category");
            System.out.println("4. Update info of category");
            System.out.println("5. Delete category");
            System.out.println("6. Exit");
            System.out.println("Please input your choice:");
            // validate choice's inputted format by try-catch
            try {
                int choice = Integer.parseInt(input.nextLine());
                switch (choice) {
                    // Add a new category
                    case 1 -> {
                        addNewCategory();
                        writeCategoryListToFile();
                    }
                    // Read data from file, then sort by name and display category
                    case 2 -> {
                        readCategoryListFromFile();
                        displayCategoryInfoAfterSortByName();
                    }
                    // Show statistics info
                    case 3 -> showStatisticsInfo();
                    // Update category info
                    case 4 -> {
                        updateInfoOfCategory();
                        writeCategoryListToFile();
                    }
                    // Delete category info
                    case 5 -> {
                        deleteCategory();
                        writeCategoryListToFile();
                    }
                    // Exit category management system
                    case 6 -> {
                        writeCategoryListToFile();
                        checkOutCategory = false;
                    }
                    default -> System.err.println("The inputted choice is out of scope!");
                }
            } catch (NumberFormatException ex1) {
                System.err.println("The inputted choice is not an integer format");
            } catch (Exception ex) {
                System.err.println("Err appears while inputting choice");
            }
        } while (checkOutCategory);
    }

    /**
     * Delete Category
     */
    public static void deleteCategory() {
        System.out.println("Please input the ID of category you wanna delete:");
        int categoryIdDelete = Integer.parseInt(input.nextLine());
        boolean removed = categoryList.removeIf(category -> category.getId() == categoryIdDelete);
        if (removed) {
            System.out.println("Category with ID" + categoryIdDelete + " removed.");
        } else {
            System.out.println("The inputted ID is not exist!");
        }
        BookImp.writeCategoryListToFile();
    }

    /**
     * Update info of category
     */
    public static void updateInfoOfCategory() {
        do {
            try {
                System.out.println("Please input the category ID you wanna update!");
                int categoryIdUpdate = Integer.parseInt(input.nextLine());
                int indexCategoryUpdate = BookImp.getIndexCategoryUpdate(categoryIdUpdate);
                if (indexCategoryUpdate == -1) {
                    System.err.println("The inputted ID is not exist!");
                } else {
                    categoryList.get(indexCategoryUpdate).setName(Category.validateCategoryName(input, categoryList));
                    categoryList.get(indexCategoryUpdate).setStatus(Category.inputBoolean(input));
                    System.out.println("Category with ID " + categoryIdUpdate + " was updated!");

                    break;
                }
            } catch (NumberFormatException ex1) {
                System.err.println("The inputted ID is not an integer format!");
            } catch (Exception ex) {
                System.err.println("There are some errs occur while inputting category ID for update!");
            }
        } while (true);
    }

    /**
     * Show statistics info
     */
    public static void showStatisticsInfo() {
        if (categoryList.size() == 0) {
            System.err.println("There is no category!");
        } else {
            BookImp.statisticsCategory();
        }
    }

    /**
     * Display category info after sorting by name
     */
    public static void displayCategoryInfoAfterSortByName() {
        categoryList.sort(Comparator.comparing(Category::getName));
        System.out.print("------------------Categories List----------------------\n");
        System.out.printf("| " + PURPLE_BOLD + PURPLE_UNDERLINED + "%-12s" + ANSI_RESET + " |" + PURPLE_BOLD + PURPLE_UNDERLINED + " %-15s"
                        + ANSI_RESET + " |" + PURPLE_BOLD + PURPLE_UNDERLINED + " %-8s" + ANSI_RESET + " |\n",
                "CATEGORY ID", "CATEGORY NAME", "STATUS");
        for (Category category : categoryList) {
            System.out.print("-------------------------------------------------------\n");
            category.output();
        }
        System.out.print("-------------------------------------------------------\n");
        System.out.println();
    }

    /**
     * Add new category
     */
    public static void addNewCategory() {
        Category newCategory = new Category();
        newCategory.input(input, categoryList);
        categoryList.add(newCategory);
    }

    /**
     * Get index for updating category
     *
     * @param categoryIdUpdate:pass an integer value to match with available ID in category list
     * @return : return value of index for updating category infor
     */
    public static int getIndexCategoryUpdate(int categoryIdUpdate) {
        int indexUpdate = 0;
        boolean IdMatch = false;
        for (int i = 0; i < categoryList.size(); i++) {
            if (categoryList.get(i).getId() == categoryIdUpdate) {
                indexUpdate = i;
                IdMatch = true;
            }
        }
        if (IdMatch) {
            return indexUpdate;
        } else {
            indexUpdate = -1;
        }
        return indexUpdate;
    }

    /**
     * Total up number of books in each category of category list
     */
    public static void statisticsCategory() {
        List<Integer> categoryIdList = new ArrayList<>();
        List<String> categoryNameList = new ArrayList<>();
        List<Integer> statisticsList = new ArrayList<>();
        // add category ID to categoryIdList
        for (Category category : categoryList) {
            categoryIdList.add(category.getId());
        }
        // add category name to categoryNameList
        for (Integer id : categoryIdList) {
            for (Category category : categoryList) {
                if (id == category.getId()) {
                    categoryNameList.add(category.getName());
                }
            }
        }
        // add number of books of each category to statisticsList
        for (Integer id : categoryIdList) {
            int countDuplicate = 0;
            for (Book book : bookList) {
                if (id == book.getCategoryId()) {
                    countDuplicate++;
                }
            }
            statisticsList.add(countDuplicate);
        }
        for (int i = 0; i < categoryIdList.size(); i++) {
            System.out.printf("There is(are) %d book(s) in category " +
                            "which has ID %d and is named %s\n",
                    statisticsList.get(i), categoryIdList.get(i), categoryNameList.get(i));
        }
    }

    /**
     * Write category info to file categories.txt
     */
    public static void writeCategoryListToFile() {
        File categoryFile = new File("categories.txt");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(categoryFile);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(categoryList);
            oos.flush();
        } catch (FileNotFoundException ex1) {
            System.err.println("Cannot file the file!");
        } catch (IOException ex2) {
            System.err.println("Err appears while writing data!");
        } catch (Exception ex) {
            System.err.println("There are some errs occur while writing data!");
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
                System.err.println("There are some errs occur while closing stream!");
            }
        }
    }

    /**
     * Read category from file categories.txt
     */
    public static void readCategoryListFromFile() {
        File newCategoryFile = new File("categories.txt");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(newCategoryFile);
            ois = new ObjectInputStream(fis);
            categoryList = (List<Category>) ois.readObject();
        } catch (FileNotFoundException ex1) {
            System.err.println("Cannot find the file!");
        } catch (IOException ex2) {
            System.err.println("Err appears while reading stream!");
        } catch (Exception ex) {
            System.err.println("There are some errs occur while reading stream!");
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (ois != null) {
                    ois.close();
                }
            } catch (FileNotFoundException ex1) {
                System.err.println("Cannot file the file");
            } catch (IOException ex2) {
                System.err.println("Err appears while closing stream!");
            } catch (Exception ex) {
                System.err.println("There are some errs occur while closing stream!");
            }
        }
    }

    /**
     * Read category info from file categories.txt
     */
    static boolean checkOutBook = true;

    /**
     * Book Management
     */
    public static void bookManagement() {

        do {
            readBookListFromFile();
            System.out.println("--------------Book Management-------------");
            System.out.println("1. Add a new book");
            System.out.println("2. Update book info");
            System.out.println("3. Delete book info");
            System.out.println("4. Search book");
            System.out.println("5. Display book by category");
            System.out.println("6. Exit");
            try {
                System.out.println("Please input your choice:");
                int choice = Integer.parseInt(input.nextLine());
                switch (choice) {
                    // Read data from file, then add new book and write book list to file
                    case 1 -> {
                        readCategoryListFromFile();
                        addNewBook();
                        writeBookListToFile();
                    }
                    // Update book info and then write updated info to file
                    case 2 -> {
                        updateBookInfo();
                        writeBookListToFile();
                    }
                    // Delete book info and then write book list to file
                    case 3 -> {
                        deleteBookInfo();
                        writeBookListToFile();
                    }
                    // Read book info from file and search book in book list by book name
                    case 4 -> {
                        readBookListFromFile();
                        searchBookInfoByBookName();
                    }
                    // Read book info from file and then display book info by category
                    case 5 -> {
                        readBookListFromFile();
                        displayBookInfoByCategory();
                    }
                    // Exit book management system
                    case 6 -> checkOutBook = false;
                    default -> System.err.println("The inputted choice is out of scope!");
                }
            } catch (NumberFormatException ex1) {
                System.err.println("The inputted choice is not integer format!");
            } catch (Exception ex) {
                System.err.println("There are some errs occur while inputting choice!");
            }
        } while (checkOutBook);
    }

    /**
     * Search book info by book name
     */
    public static void searchBookInfoByBookName() {
        System.out.println("Please input name of book you wanna search:");
        String searchName = input.nextLine();
        boolean checkSearchName = false;
        System.out.printf("%-15s%-20s%-20s%-20s%-20s%-20s%-15s\n", "Book ID", "Title", "Author",
                "Publisher", "Published Year", "Description", "Category ID");
        for (Book book : bookList) {
            if (book.getTitle().toLowerCase().contains(searchName.toLowerCase())) {
                book.output();
                checkSearchName = true;
            }
        }
        if (!checkSearchName || bookList.size() == 0) {
            System.err.println("There is no book has the name you wanna search!");
        }
    }

    /**
     * Delete book info
     */
    public static void deleteBookInfo() {
        System.out.println("Please input ID of book you wanna delete info:");
        String bookIdDelete = input.nextLine();
        boolean removed = bookList.removeIf(book -> book.getId().equals(bookIdDelete));
        if (removed) {
            System.out.println("The book with ID " + bookIdDelete + "has been deleted!");
            writeBookListToFile();
        } else {
            System.err.println("The inputted ID is not exist!");
        }
    }

    /**
     * Update book info
     */
    public static void updateBookInfo() {
        System.out.println("Please input ID of book you wanna update info:");
        String bookIdUpdate = input.nextLine();
        do {
            if (!bookIdUpdate.startsWith("B") || bookIdUpdate.length() != 4) {
                System.err.println("Book ID should follow this format: B***");
            } else {
                break;
            }
        } while (true);
        int indexUpdateBook = BookImp.getIndexUpdateBook(bookIdUpdate);
        bookList.get(indexUpdateBook).setTitle(Book.validateBookTitle(input, bookList));
        bookList.get(indexUpdateBook).setAuthor(Book.validateBookAuthor(input));
        bookList.get(indexUpdateBook).setPublisher(Book.validatePublisher(input));
        bookList.get(indexUpdateBook).setYear(Book.validateYear(input));
        bookList.get(indexUpdateBook).setDescription(Book.validateDescription(input));
    }

    /**
     * Add new book to book list
     */
    public static void addNewBook() {
        System.out.println("-----------Category Name----------");
        if (categoryList.size() == 0) {
            System.err.println("Please input data for category!");
            checkOutBook = false;
        } else {
            for (int i = 0; i < categoryList.size(); i++) {
                System.out.println((i + 1) + ". " + categoryList.get(i).getName());
            }
        }
        do {
            try {
                System.out.println("Please input the number representing the category name:");
                int choiceNum = Integer.parseInt(input.nextLine());
                Book newBook = new Book();
                newBook.input(input, bookList);
                newBook.setCategoryId(categoryList.get(choiceNum - 1).getId());
                bookList.add(newBook);

                break;
            } catch (NumberFormatException ex1) {
                System.err.println("The inputted data is not an integer format!");
            } catch (Exception ex) {
                System.err.println("There are some errs occur while inputting choice number!");
            }
        } while (true);
    }

    /**
     * Display book info by category
     */
    public static void displayBookInfoByCategory() {
        for (Category category : categoryList) {
            System.out.println(category.getName());
            System.out.printf("%-15s%-20s%-20s%-20s%-20s%-20s%-15s\n", "Book ID", "Title", "Author", "Publisher",
                    "Published Year", "Description", "Category ID");
            for (Book book : bookList) {
                if (category.getId() == book.getCategoryId()) {
                    book.output();
                }
            }
        }
    }

    /**
     * Get index of book need to update in book list
     *
     * @param bookIdUpdate: pass through method a book ID that would be inputted previously to match with ID available
     *                      in book list
     * @return : return the value of index for updating book info
     */
    public static int getIndexUpdateBook(String bookIdUpdate) {
        int indexUpdate = 0;
        boolean checkBookId = false;
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getId().equals(bookIdUpdate)) {
                indexUpdate = i;
                checkBookId = true;
            }
        }
        if (!checkBookId) {
            indexUpdate = -1;
            System.err.println("The inputted ID is not exist!");
        }
        return indexUpdate;
    }

    /**
     * Write book info to file books.txt
     */
    public static void writeBookListToFile() {
        File newBookFile = new File("books.txt");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(newBookFile);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(bookList);
            oos.flush();
        } catch (FileNotFoundException ex1) {
            System.err.println("Cannot find the file!");
        } catch (IOException ex2) {
            System.err.println("Err appears while writing stream!");
        } catch (Exception ex) {
            System.err.println("There are some errs occur while writing stream!");
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
                System.err.println("There are some errs occur while closing stream");
            }
        }
    }

    /**
     * Read book info from file books.txt
     */
    public static void readBookListFromFile() {
        File newBookRead = new File("books.txt");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(newBookRead);
            ois = new ObjectInputStream(fis);
            bookList = (List<Book>) ois.readObject();
        } catch (FileNotFoundException ex1) {
            System.err.println("Cannot find the file!");
        } catch (IOException ex2) {
            System.err.println("Err appears while reading stream!");
        } catch (Exception ex) {
            System.err.println("There are some errs occur while reading stream!");
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
                System.err.println("There are some errs occur while closing stream!");
            }
        }
    }
}
