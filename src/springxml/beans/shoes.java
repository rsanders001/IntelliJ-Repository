package springxml.beans;

import java.util.Date;

public class shoes {
    private int shoeID;
    private String style;
    private String color;
    private Double retail;
    private Date date;
    private String description;

    public shoes() {
    }

    //Getters
    public int getShoeID() {
        return shoeID;
    }

    public String getStyle() {
        return style;
    }

    public String getColor() {
        return color;
    }

    public Double getRetail() {
        return retail;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }
//Setters
    public void setShoeID(int shoeID) {
        this.shoeID = shoeID;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRetail(Double retail) {
        this.retail = retail;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
