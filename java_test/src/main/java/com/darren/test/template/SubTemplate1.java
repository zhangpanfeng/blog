package com.darren.test.template;

public class SubTemplate1 extends Template {

    @Override
    protected String doAccountType() {
        return "TYPE_ONE";
    }

    @Override
    protected double doAccountRate() {
        return 0.5;
    }

}
