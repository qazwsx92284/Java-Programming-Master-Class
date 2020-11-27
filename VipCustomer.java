package com.company;

public class VipCustomer {
    private String name;
    private double creditLimit;
    private String emailAddress;


    public VipCustomer(String name, double creditLimit, String email) {
        this.name = name;
        this.emailAddress = email;
        this.creditLimit = creditLimit;
    }
    public VipCustomer() {
    }
    public VipCustomer(String name, double creditLimit){
        this.name = name;
        this.creditLimit = creditLimit;
    }


    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public double getCreditLimit() {
        return creditLimit;
    }
}
