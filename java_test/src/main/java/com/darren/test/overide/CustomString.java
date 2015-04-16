package com.darren.test.overide;

public class CustomString {

    private String value;

    public CustomString() {
        this("");
    }

    public CustomString(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {

            return true;
        } else if (obj instanceof CustomString) {
            CustomString customString = (CustomString) obj;

            return customString.value.equals(value);
        } else {

            return false;
        }
    }

    @Override
    public int hashCode() {
        // return super.hashCode();
        return 1;
    }

}
