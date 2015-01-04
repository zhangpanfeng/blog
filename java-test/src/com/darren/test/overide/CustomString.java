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
        }
        if (obj instanceof CustomString) {
            CustomString customString = (CustomString) obj;
            return customString.value.equals(value);
        }

        return false;
    }

    @Override
    public int hashCode() {
        // return super.hashCode();
        return 1;
    }

}
