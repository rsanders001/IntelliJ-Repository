package hibernate.entity;


import hibernate.DateUtils;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="shoes")
public class shoes {
    //PRIMARY KEY
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="shoeId")
    private int shoeId;
    @Column(name="style")
    private String style;
    @Column(name="color")
    private String color;
    @Column(name="retail")
    private double retail;
    @Column(name="releaseDate")
    private Date releaseDate;
    @Column(name="description")
    private String description;

    public shoes() {
        // no-arg constructor
    }

    public shoes(int shoeId, String style, String color, Double retail, Date releaseeDate, String description) {
        this.shoeId = shoeId;
        this.style = style;
        this.color = color;
        this.retail = retail;
        this.releaseDate = releaseeDate;
    }

    public int getShoeId() {
        return shoeId;
    }

    public void setShoeId(int id) {
        this.shoeId = id;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getRetail() {
        return retail;
    }

    public void setRetail(Double retail) {
        this.retail = retail;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Shoe{" +
                "id=" + shoeId +
                ", style=" + style +
                ", color='" + color +
                ", retail=" + retail +
                ", dateAdded=" + DateUtils.formatDate(releaseDate) +
                ", description=" + description +
                '}';
    }
}