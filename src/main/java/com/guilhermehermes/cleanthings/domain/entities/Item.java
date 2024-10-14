package com.guilhermehermes.cleanthings.domain.entities;


import lombok.Data;

@Data
public class Item extends BaseEntity{

    private String description;
    private Double price;

    private double width;
    private double height;
    private double length;
    private double weight;

    public Item() {
        super();
    }

    public Item(String description, Double price, double width, double height, double length, double weight) {
        super();
        this.description = description;
        this.price = price;
        this.width = width;
        this.height = height;
        this.length = length;
        this.weight = weight;
    }

    public double getVolume() {
        return this.width/100 * this.height/100 * this.length/100;
    }

    public double getDensity() {
        return this.weight / this.getVolume();
    }


}
