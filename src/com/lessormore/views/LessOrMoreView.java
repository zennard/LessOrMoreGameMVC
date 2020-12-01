package com.lessormore.views;

import java.util.List;

public class LessOrMoreView {
    public static final String GREETINGS = "Welcome to Less or More game!";
    public static final String NUMBER_GENERATED = "Magic number was generated!";
    public static final String INTERVAL_INFO = "Current interval is:";
    public static final String LEFT_BRACKET = "(";
    public static final String RIGHT_BRACKET = ")";
    public static final String SEMI_COLON = ";";
    public static final String SPACE_SIGN = " ";
    public static final String GREATER_SIGN = ">";
    public static final String LESS_SIGN = "<";
    public static final String MAGIC_NUMBER_VALUE = "Magic number value is";
    public static final String THAN_YOUR_VALUE = "than your value";
    public static final String MAGIC_NUMBER_IS_GUESSED = "Magic number was guessed!";
    public static final String OUT_OF_INTERVAL = "This number is out of interval range!";
    public static final String NOT_A_NUMBER = "Your input is not a number, please enter new value with number type";
    public static final String INPUT_REQUEST = "Please try to guess magic number:";
    public static final String USERS_WAY = "Your way:";

    public void printMessage(String msg) {
        System.out.println(msg);
    }

    public String concatenateString(String... messages) {
        StringBuilder res = new StringBuilder();
        for (String s : messages) {
            res.append(s);
        }
        return res.toString();
    }

    public void showUsersWay(List<Integer> userGuesses) {
        StringBuilder usersHistory = new StringBuilder();
        usersHistory.append(LessOrMoreView.USERS_WAY + LessOrMoreView.SPACE_SIGN);
        for (int num : userGuesses) {
            usersHistory.append(num);
            usersHistory.append(LessOrMoreView.SPACE_SIGN);
        }
        System.out.println(usersHistory);
    }

    public void numberIsTooSmall(int usersGuess) {
        printMessage(LessOrMoreView.MAGIC_NUMBER_VALUE +
                LessOrMoreView.SPACE_SIGN + LessOrMoreView.GREATER_SIGN +
                LessOrMoreView.SPACE_SIGN + LessOrMoreView.THAN_YOUR_VALUE +
                LessOrMoreView.SPACE_SIGN + usersGuess);
    }

    public void numberIsTooBig(int usersGuess) {
        printMessage(LessOrMoreView.MAGIC_NUMBER_VALUE +
                LessOrMoreView.SPACE_SIGN + LessOrMoreView.LESS_SIGN +
                LessOrMoreView.SPACE_SIGN + LessOrMoreView.THAN_YOUR_VALUE +
                LessOrMoreView.SPACE_SIGN + usersGuess);
    }

    public void congratulateUser(int usersGuess) {
        printMessage(LessOrMoreView.MAGIC_NUMBER_IS_GUESSED);
        printMessage(LessOrMoreView.MAGIC_NUMBER_VALUE +
                LessOrMoreView.SPACE_SIGN + usersGuess);
    }

    public void showCurrentInterval(int leftBorder, int rightBorder) {
        printMessage(LessOrMoreView.INTERVAL_INFO + LessOrMoreView.SPACE_SIGN +
                LessOrMoreView.LEFT_BRACKET + leftBorder +
                LessOrMoreView.SEMI_COLON + rightBorder +
                LessOrMoreView.RIGHT_BRACKET);
    }
}
