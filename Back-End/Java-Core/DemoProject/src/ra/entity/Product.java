package ra.entity;

import ra.IShop;

import java.util.List;
import java.util.Scanner;

public class Product implements IShop<Product> {
    private String productId;
    private String productName;
    private float price;
    private String title;
    private String catalogIdOfProduct;
    private boolean productStatus;

    public Product() {
    }

    public Product(String productId, String productName, float price, String title, String catalogIdOfProduct, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.title = title;
        this.catalogIdOfProduct = catalogIdOfProduct;
        this.productStatus = productStatus;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCatalogIdOfProduct() {
        return catalogIdOfProduct;
    }

    public void setCatalogIdOfProduct(String catalogIdOfProduct) {
        this.catalogIdOfProduct = catalogIdOfProduct;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public void inputData(Scanner input, List<Product> productList) {
        System.out.println("Please input the product ID:");
        do {
            this.productId = input.nextLine();
            boolean checkId = false;
            if (this.productId.startsWith("P") && this.productId.length() == 5) {
                if (productList.size() == 0) {
                    break;
                } else {
                    for (Product product : productList) {
                        if (this.productId.equals(product.getProductId())) {
                            System.err.println("The inputted ID is already existed. Please try another!");
                            checkId = true;
                        }
                    }
                    if (!checkId) {
                        break;
                    }
                }
            } else {
                System.err.println("Please input the correct format of product ID(exp: P****)!");
            }
        } while (true);
        System.out.println("Please input the product name:");
        do {
            this.productName = input.nextLine();
            boolean checkName = false;
            if (productList.size() == 0) {
                break;
            } else {
                for (Product a : productList) {
                    if (this.productName.equals(a.productName)) {
                        System.err.println("The inputted product name is already existed. Please try another!");
                        checkName = true;
                    }
                }
                if (!checkName) {
                    break;
                }
            }
        } while (true);
        System.out.println("Please input price of product:");
        boolean checkFormat1 = true;
        do {
            try {
                this.price = Float.parseFloat(input.nextLine());
                checkFormat1 = false;
            } catch (NumberFormatException exVar2) {
                System.err.println("The inputted data cannot be converted into number. Please input a number!!!");
            }
        } while (checkFormat1);
        System.out.println("Please input title of product:");
        this.title = input.nextLine();
        System.out.println("Please input the product status:");
        this.productStatus = Boolean.parseBoolean(input.nextLine());
    }

    @Override
    public void displayData() {
        System.out.printf("%-20s%-20s%-15.1f%-20s%-35s%-15b\n", this.productId, this.productName, this.price, this.title, this.catalogIdOfProduct, this.productStatus);
    }
}
