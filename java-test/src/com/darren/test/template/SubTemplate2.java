package com.darren.test.template;

public class SubTemplate2 extends Template {

    @Override
    protected String doAccountType() {
        return "TYPE_TWO";
    }

    @Override
    protected double doAccountRate() {
        return 0.6;
    }

}
