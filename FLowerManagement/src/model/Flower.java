package model;

import java.io.Serializable;


public class Flower implements Serializable{
    private String id, description, importDate, category;
    private double unitPrice;

    public Flower() {
    }

    public Flower(String id, String description, String importDate, double unitPrice, String category) {
        this.id = id;
        this.description = description;
        this.importDate = importDate;
        this.category = category;
        this.unitPrice = unitPrice;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImportDate() {
        return importDate;
    }

    public void setImportDate(String importDate) {
        this.importDate = importDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return this.id+ "," + this.description + "," + this.importDate+ "," + this.unitPrice+ "," + this.category;
    }
    
    
}
