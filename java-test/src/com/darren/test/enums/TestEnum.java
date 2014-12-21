package com.darren.test.enums;

public enum TestEnum {
    AAA("AAA"), BBB("BBB"), AAA_BBB("AAA BBB");

    private String name;

    private TestEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
