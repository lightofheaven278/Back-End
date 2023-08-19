package ra.run;

import ra.entity.Categories;
import ra.entity.Product;

import java.util.*;

public class ShopManagement {
    static List<Categories> categoriesList = new ArrayList<>();
    static List<Product> productList = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            System.out.println("******************Shop Management********************");
            System.out.println("1. Categories management");
            System.out.println("2. Product management");
            System.out.println("3. Exit");
            System.out.println("Please input your choice:");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    ShopManagement.categoriesManagement();
                    break;
                case 2:
                    ShopManagement.productManagement();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.err.println("The inputted choice is out of scope");
            }
        } while (true);
    }

    public static void categoriesManagement() {
        boolean isExit = true;
        do {
            System.out.println("******************Categories Management********************");
            System.out.println("1. Input new catalog");
            System.out.println("2. Display data");
            System.out.println("3. Update catalog name");
            System.out.println("4. Delete empty catalog by catalog ID");
            System.out.println("5. Exit");
            System.out.println("Please input your choice:");
            int catalogChoice = Integer.parseInt(input.nextLine());
            switch (catalogChoice) {
                case 1:
                    Categories catalog = new Categories();
                    catalog.inputData(input, categoriesList);
                    categoriesList.add(catalog);
                    break;
                case 2:
                    System.out.printf("%-15s%-15s%-15s\n", "Catalog ID", "Catalog Name", "Catalog Status");
                    for (Categories a : categoriesList) {
                        a.displayData();
                    }
                    break;
                case 3:
                    int indexUpdate = ShopManagement.getCategoriesUpdateIndex();
                    System.out.println("Please input the new catalog name:");
                    String newCatalogName = input.nextLine();
                    categoriesList.get(indexUpdate).setCatalogName(newCatalogName);
                    break;
                case 4:
                    System.out.println("Please input the catalog ID of catalog you wanna delete:");
                    String catalogIdInput = input.nextLine();
                    int indexDeleteCatalog = ShopManagement.getCategoriesDeleteIndex(catalogIdInput);
                    boolean checkProduct = false;
                    for (Product product : productList) {
                        if (catalogIdInput.equals(product.getCatalogIdOfProduct())) {
                            checkProduct = true;
                        }
                    }
                    if (checkProduct) {
                        System.out.println("Cannot delete catalog which is not empty!!!");
                    } else {
                        categoriesList.remove(indexDeleteCatalog);
                    }
                    break;
                case 5:
                    isExit = false;
                    break;
                default:
                    System.err.println("The inputted choice is out of scope");
            }
        } while (isExit);
    }

    public static int getCategoriesUpdateIndex() {
        System.out.println("Please input the catalog ID of catalog you wanna update name:");
        String catalogIdInput = input.nextLine();
        int index = 0;
        for (int i = 0; i < categoriesList.size(); i++) {
            if (catalogIdInput.equals(categoriesList.get(i).getCatalogId())) {
                index = i;
            }
        }
        return index;
    }

    public static int getCategoriesDeleteIndex(String catalogIdInput) {
        int index = 0;
        for (int i = 0; i < categoriesList.size(); i++) {
            if (catalogIdInput.equals(categoriesList.get(i).getCatalogId())) {
                index = i;
            }
        }
        return index;
    }

    public static void productManagement() {
        boolean isExit = true;
        do {
            System.out.println("******************Product Management********************");
            System.out.println("1. Input new product");
            System.out.println("2. Display product info");
            System.out.println("3. Update product price by product ID");
            System.out.println("4. Delete product by catalog ID");
            System.out.println("5. Sort products info by ascending price");
            System.out.println("6. Sort products info by ascending name");
            System.out.println("7. Total up the number of products in each catalog");
            System.out.println("8. Search product info by product name");
            System.out.println("9. Exit");
            System.out.println("Please input your choice(product):");
            int productChoice = Integer.parseInt(input.nextLine());
            switch (productChoice) {
                case 1:
                    System.out.println("---------Catalog---------");
                    for (int i = 0; i < categoriesList.size(); i++) {
                        System.out.printf("%d. %s\n", i + 1, categoriesList.get(i).getCatalogName());
                    }
                    System.out.println("Please choose the catalog of product:");
                    boolean checkFormat = true;
                    do {
                        try {
                            int chooseCatalog = Integer.parseInt(input.nextLine());
                            Product product = new Product();
                            product.inputData(input, productList);
                            product.setCatalogIdOfProduct(categoriesList.get(chooseCatalog - 1).getCatalogId());
                            productList.add(product);
                            checkFormat = false;
                        } catch (NumberFormatException exVar1) {
                            System.err.println("The inputted data cannot be converted into number. Please input an integer!!!");
                        }
                    } while (checkFormat);
                    break;
                case 2:
                    System.out.printf("%-20s%-20s%-15s%-20s%-35s%-20s\n", "Product ID", "Product Name", "Price", "Title", "Catalog ID of Product", "Status");
                    for (Product a : productList) {
                        a.displayData();
                    }
                    break;
                case 3:
                    int indexUpdateProduct = ShopManagement.getIndexUpdateProduct();
                    if (indexUpdateProduct == -1) {
                        break;
                    } else {
                        System.out.println("Please input the new price of product:");
                        boolean checkFormat3 = true;
                        do {
                            try {
                                float newProductPrice = Float.parseFloat(input.nextLine());
                                productList.get(indexUpdateProduct).setPrice(newProductPrice);
                                checkFormat3 = false;
                            } catch (NumberFormatException exVar2) {
                                System.err.println("The inputted data cannot be converted into number. Please input a number!!!");
                            }
                        } while (checkFormat3);
                    }
                    break;
                case 4:
                    int indexDeleteProduct = ShopManagement.getIndexDeleteProduct();
                    if (indexDeleteProduct == -1) {
                        break;
                    } else {
                        productList.remove(indexDeleteProduct);
                    }
                    break;
                case 5:
                    productList.sort(Comparator.comparing(Product::getPrice));
                    break;
                case 6:
                    productList.sort(Comparator.comparing(Product::getProductName));
                    break;
                case 7:
                    List<String> listCatalogId = new ArrayList<>();
                    List<Integer> statisticList = new ArrayList<>();
                    List<String> listCatalogName = new ArrayList<>();
                    boolean checkDuplicate = false;
                    // add elements to lisCatalogId
                    for (int i = 0; i < productList.size(); i++) {
                        for (int j = i + 1; j < productList.size(); j++) {
                            if (productList.get(i).getCatalogIdOfProduct().equals(productList.get(j).getCatalogIdOfProduct())) {
                                checkDuplicate = true;
                            }
                        }
                        if (!checkDuplicate) {
                            listCatalogId.add(productList.get(i).getCatalogIdOfProduct());
                        }
                    }
                    // add elements to listCatalogName
                    for (int i = 0; i < listCatalogId.size(); i++) {
                        for (int j = 0; j < categoriesList.size(); j++) {
                            if (listCatalogId.get(i).equals(categoriesList.get(j).getCatalogId())) {
                                listCatalogName.add(categoriesList.get(j).getCatalogName());
                            }
                        }
                    }
                    // add elements to statisticList
                    for (int i = 0; i < listCatalogId.size(); i++) {
                        int countDuplicate = 0;
                        for (int j = 0; j < productList.size(); j++) {
                            if (listCatalogId.get(i).equals(productList.get(j).getCatalogIdOfProduct())) {
                                countDuplicate++;
                            }
                        }
                        statisticList.add(countDuplicate);
                    }
                    for (int i = 0; i < listCatalogName.size(); i++) {
                        System.out.printf("There is(are) %d product(s) in catalog named %s\n", statisticList.get(i), listCatalogName.get(i));
                    }
                    break;
                case 8:
                    System.out.println("Please input the name of product you wanna search:");
                    String productNameInput = input.nextLine();
                    System.out.printf("%-20s%-20s%-15s%-20s%-35s%-20s\n", "Product ID", "Product Name", "Price", "Title", "Catalog ID of Product", "Status");
                    for (Product a : productList) {
                        if (a.getProductName().toLowerCase().contains(productNameInput.toLowerCase())) {
                            a.displayData();
                        }
                    }
                    break;
                case 9:
                    isExit = false;
                    break;
                default:
                    System.err.println("The inputted choice is out of scope");
            }
        } while (isExit);
    }

    public static int getIndexUpdateProduct() {
        System.out.println("Please input the ID of product you wanna update:");
        do {
            String updateProductId = input.nextLine();
            if (updateProductId.startsWith("P") && updateProductId.length() == 5) {
                int index = 0;
                for (int i = 0; i < productList.size(); i++) {
                    if (updateProductId.equals(productList.get(i).getProductId())) {
                        index = i;
                        break;
                    } else {
                        System.err.println("There is no product ID match with inputted ID");
                        index = -1;
                    }
                }
                return index;
            } else {
                System.err.println("Please input the correct format of product ID(exp: P****)!");
            }
        } while (true);
    }

    public static int getIndexDeleteProduct() {
        System.out.println("please input the ID of product you wanna delete");

        do {
            String deleteProductID = input.nextLine();
            if (deleteProductID.startsWith("P") && deleteProductID.length() == 5) {
                int index1 = 0;
                for (int i = 0; i < productList.size(); i++) {
                    if (deleteProductID.equals(productList.get(i).getProductId())) {
                        index1 = i;
                        break;
                    } else {
                        System.err.println("There is no product ID match with inputted ID");
                        index1 = -1;
                    }
                }
                return index1;
            } else {
                System.err.println("Please input the correct format of product ID(exp: P****)!");
            }
        } while (true);
    }
}
