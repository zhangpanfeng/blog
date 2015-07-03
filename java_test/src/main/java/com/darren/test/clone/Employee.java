package com.darren.test.clone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Employee implements Cloneable, Serializable {
    private static final long serialVersionUID = 1096570103031159951L;
    private int id;
    private String name;
    private Address address;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Employee(int id, String name, Address address) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", address=" + address + "]";
    }

    @Override
    protected Employee clone() {
        Employee employee = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);
            oos.close();

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            employee = (Employee) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return employee;
    }

    public static void main(String[] args) {
        System.out.println("克隆之前：");

        Address add1 = new Address("中国1", 1);
        Employee emp1 = new Employee(1, "001", add1);
        System.out.println(emp1);
        System.out.println("====================");

        System.out.println("克隆之后");

        Employee emp2 = emp1.clone();
        emp2.setName("002");
        emp2.setId(2);
        emp2.setAddress(new Address("中国2", 2));

        System.out.println(emp1);
        System.out.println("-----");
        System.out.println(emp2);
    }
}
