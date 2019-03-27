package com.b2b.net.ksiegarnia.domain;

public class Customer {

    private String pesel;
    private String surname;
    private String name;

    public Customer(String pesel, String surname, String name) {
        this.pesel = pesel;
        this.surname = surname;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        Customer customer = (Customer) o;
        if (customer.getName().equals(name) && customer.getPesel().equals(pesel) && customer.getSurname().equals(surname)) {
            result = true;
        }
        return result;
    }

}
