package com.darren.test.clone;

public class FalseClone {
    private int id;
    private String name;

    public FalseClone(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FalseClone [id=" + id + ", name=" + name + "]";
    }

    public static void main(String[] args) {

        FalseClone falseClone1 = new FalseClone(1, "001");
        System.out.println(falseClone1);
        FalseClone falseClone2 = falseClone1;
        falseClone2.setId(2);
        falseClone2.setName("002");
        System.out.println(falseClone1);
        System.out.println(falseClone2);
    }
}
