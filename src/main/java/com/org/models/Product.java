package com.org.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "product")
public class Product implements com.org.models.Entity, Serializable {
    private static final long serialVersionUID = -4525913610632158800L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code")
    @Id
    protected long code;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "price")
    private float price;

    @Column(name = "rating")
    private float rating;

    @Column(name = "total_points")
    private int totalPoints;

    @Column(name = "votes")
    private int votes;

    @Column(name = "image_url")
    private String imageUrl;

    public Product() {
    }

    public Product(long code, String productName, float price, float rating, int totalPoints, int votes,
            String imageUrl) {
        this.code = code;
        this.productName = productName;
        this.price = price;
        this.rating = rating;
        this.totalPoints = totalPoints;
        this.votes = votes;
        this.imageUrl = imageUrl;
    }

    public long getCode() {
        return this.code;
    }

    public void setCode(long code) {
        this.code = code;
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

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
