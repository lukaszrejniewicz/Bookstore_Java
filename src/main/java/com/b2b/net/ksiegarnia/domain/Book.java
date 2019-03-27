package com.b2b.net.ksiegarnia.domain;

public class Book {

    private String title;
    private String pesel;
    private double price;

    public Book(String title, String pesel, double price) {
        this.title = title;
        this.pesel = pesel;
        this.price = price;
    }

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
