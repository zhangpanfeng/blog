package com.darren.test.template;

public abstract class Template {

    protected final double getMoney() {
        String type = doAccountType();
        double rate = doAccountRate();
        double money = caculateMoney(type, rate);

        return money;

    }

    protected abstract String doAccountType();

    protected abstract double doAccountRate();

    private double caculateMoney(String type, double rate) {
        double money = 0.0;
        if ("TYPE_ONE".equals(type)) {
            money = 100;
        } else if ("TYPE_TWO".equals(type)) {
            money = 200;
        }

        money = money * rate;

        return money;
    }
}
