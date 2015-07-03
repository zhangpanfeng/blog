package com.darren.test.clone;

public class Address {
    private String state;
    private int number;

    public Address() {

    }

    public Address(String state, int number) {
        this.state = state;
        this.number = number;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Address [state=" + state + ", number=" + number + "]";
    }

}
