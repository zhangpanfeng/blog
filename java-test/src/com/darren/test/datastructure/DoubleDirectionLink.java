package com.darren.test.datastructure;

public class DoubleDirectionLink {
    private int value;
    private DoubleDirectionLink next;
    private DoubleDirectionLink previous;

    public DoubleDirectionLink(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public DoubleDirectionLink getNext() {
        return next;
    }

    public void setNext(DoubleDirectionLink next) {
        this.next = next;
    }

    public DoubleDirectionLink getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleDirectionLink previous) {
        this.previous = previous;
    }

}
