package ra.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class Category implements IEntity<Category>, Serializable {
    int id;
    String name;
    boolean status;

    public Category() {
    }

    public Category(int id, String name, boolean status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void input(Scanner input, List<Category> categoryList) {
        this.id = validateCategoryId(input, categoryList);
        this.name = validateCategoryName(input, categoryList);
        System.out.println("Please input status of category:");
        this.status = inputBoolean(input);
    }

    /**
     * Validate category ID
     * @param input: declare input function to input data from keyboard
     * @param categoryList: pass into method an array object of category
     * @return : retrieve an integer value of inputted ID that is already validated
     */
    public static Integer validateCategoryId(Scanner input, List<Category> categoryList) {
        do {
            try {
                System.out.println("Please input the category ID:");
                int id = Integer.parseInt(input.nextLine());
                if (id <= 0) {
                    System.err.println("The category ID should be an integer which is greater than 0");
                } else {
                    if (categoryList.size() == 0) {
                        return id;
                    } else {
                        boolean checkId = false;
                        for (Category category : categoryList) {
                            if (category.getId() == id) {
                                System.err.println("The inputted ID is already exist. Please try another!");
                                checkId = true;
                            }
                        }
                        if (!checkId) {
                            return id;
                        }
                    }
                }
            } catch (NumberFormatException ex1) {
                System.err.println("The inputted data format is not integer format. Please try again!");
            } catch (Exception ex) {
                System.err.println("Err appears while inputting category ID");
            }
        } while (true);
    }

    /**
     * Validate category name
     * @param input: pass through method Scanner input
     * @param categoryList: pass through an object-array list
     * @return : return a string value of validated name inputted from keyboard
     */
    public static String validateCategoryName(Scanner input, List<Category> categoryList) {
        do {
            try {
                System.out.println("Please input the category name:");
                String name = input.nextLine();
                if (!name.trim().equals("")) {
                    if (name.length() > 6 && name.length() < 30) {
                        boolean checkName = false;
                        for (Category category : categoryList) {
                            if (category.getName().equals(name)) {
                                checkName = true;
                            }
                        }
                        if (!checkName) {
                            return name;
                        } else {
                            System.err.println("The inputted category name is already exist. Please try another!");
                        }
                    } else {
                        System.err.println("Category name should contain 6-30 characters!");
                    }
                } else {
                    System.err.println("Category name should not be a blank!");
                }
            } catch (Exception ex) {
                System.err.println("Err appears while inputting category name");
            }
        } while (true);
    }

    /**
     * Validate category status
     * @param input: pass through Scanner input for inputting value from keyboard
     * @return : return the boolean value of status
     */
    public static boolean inputBoolean(Scanner input) {
        do {
            String status = input.nextLine();
            if (status.equalsIgnoreCase("true") || status.equalsIgnoreCase("false")) {
                return Boolean.parseBoolean(status);
            } else {
                System.err.println("The status of category should be 'true' or 'false'");
                System.out.println("Please input status of category:");
            }
        } while (true);
    }

    /**
     * Display data to console
     */
    @Override
    public void output() {
        System.out.printf("| %-12d | %-15s | %-8b |\n", this.id, this.name, this.status);
    }
}
