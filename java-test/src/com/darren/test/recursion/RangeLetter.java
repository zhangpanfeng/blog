package com.darren.test.recursion;

public class RangeLetter {
    private String source;
    private int count;

    public RangeLetter(String source) {
        this.source = source;
    }

    public void display() {
        circulate(source.length());
    }

    private void circulate(int size) {
        for (int i = 0; i < size; i++) {
            char firstLetter = source.charAt(i);
            String right = source.substring(0, i) + source.substring(i + 1);
            rotate(firstLetter, right, size - 1);
        }
    }

    private void rotate(char firstLetter, String right, int times) {
        right = right.substring(1) + right.substring(0, 1);
        displayWord(firstLetter, right);
        if (times == 1) {
            return;
        }
        rotate(firstLetter, right, times - 1);
    }

    private void displayWord(char firstLetter, String right) {
        String word = String.valueOf(firstLetter) + right;
        System.out.print("[" + ++count + ": " + word + "]  ");
        if (count % 6 == 0) {
            System.out.println();
        }
    }
}
