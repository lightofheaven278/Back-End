package ra.entity;

import ra.IShop;

import java.util.List;
import java.util.Scanner;

public class Categories implements IShop<Categories> {
    private String catalogId;
    private String catalogName;
    private boolean catalogStatus;

    public Categories() {

    }

    public Categories(String catalogId, String catalogName, boolean status) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.catalogStatus = status;
    }

    public String getCatalogId() {
        return catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public boolean isStatus() {
        return catalogStatus;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public void setStatus(boolean status) {
        this.catalogStatus = status;
    }

    @Override
    public void inputData(Scanner input, List<Categories> categoriesList) {
        System.out.println("Please input the catalog ID:");
        // validate catalog ID
        do {
            this.catalogId = input.nextLine();
            boolean checkCatalogId = false;
            if (categoriesList.size() == 0) {
                break;
            } else {
                for (Categories a : categoriesList) {
                    if (this.catalogId.equals(a.catalogId)) {
                        System.err.println("The inputted catalog ID is already existed. Please try another!");
                        checkCatalogId = true;
                    }
                }
                if (!checkCatalogId) {
                    break;
                }
            }
        } while (true);
        System.out.println("Please input the catalog name:");
        // validate catalog name
        do {
            this.catalogName = input.nextLine();
            boolean checkCatalogName = false;
            if (categoriesList.size() == 0) {
                break;
            } else {
                for (Categories b : categoriesList) {
                    if (this.catalogName.equals(b.catalogName)) {
                        System.err.println("The inputted catalog name is already existed. Please try another!");
                        checkCatalogName = true;
                    }
                }
                if (checkCatalogName) {
                    break;
                }
            }
        } while (true);
        System.out.println("Please input the catalog status:");
        this.catalogStatus = Boolean.parseBoolean(input.nextLine());
    }

    @Override
    public void displayData() {
        System.out.printf("%-15s%-15s%-15b\n", this.catalogId, this.catalogName, this.catalogStatus);
    }
}
