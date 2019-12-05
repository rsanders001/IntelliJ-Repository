package hibernate.entity;


import hibernate.DateUtils;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Date;

/**Only one table created so no mapping relationships are used**/
@Entity
@Table(name="shoes")

public class shoes {
    @Autowired
    private SessionFactory sessionFactory;
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

    public shoes(String style, String color, Double retail, Date releaseeDate, String description) {
        //this.shoeId = shoeId;
        this.style = style;
        this.color = color;
        this.retail = retail;
        this.releaseDate = releaseeDate;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateAdded() {
        return releaseDate;
    }

    public void setDateAdded(Date dateAdded) {
        this.releaseDate = dateAdded;
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