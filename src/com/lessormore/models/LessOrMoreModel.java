package com.lessormore.models;

import java.util.LinkedList;
import java.util.List;

public class LessOrMoreModel {
    private int magicNumber;
    private int leftBorder;
    private int rightBorder;
    private List<Integer> way;

    public List<Integer> getWay() {
        return way;
    }

    public LessOrMoreModel() {
        way = new LinkedList<>();
    }

    public void setMagicNumber() {
        this.magicNumber = generateMagicNumber(leftBorder, rightBorder);
    }

    private int generateMagicNumber(int min, int max) {
        return (int) (Math.floor(Math.random() * (max - min - 1)) + min + 1);
    }

    public void setLeftBorder(int leftBorder) {
        this.leftBorder = leftBorder;
        way.add(leftBorder);
    }

    public void setRightBorder(int rightBorder) {
        this.rightBorder = rightBorder;
        way.add(rightBorder);
    }

    public void setPrimaryBorders(int leftBorder, int rightBorder) {
        this.leftBorder = leftBorder;
        this.rightBorder = rightBorder;
    }

    public boolean isValidBorder(int value) {
        if (value <= leftBorder || value >= rightBorder) return false;
        return true;
    }

    public int getMagicNumber() {
        return magicNumber;
    }

    public int getLeftBorder() {
        return leftBorder;
    }

    public int getRightBorder() {
        return rightBorder;
    }


}
