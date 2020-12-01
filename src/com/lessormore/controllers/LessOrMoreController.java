package com.lessormore.controllers;

import com.lessormore.GlobalConstants;
import com.lessormore.models.LessOrMoreModel;
import com.lessormore.views.LessOrMoreView;

import java.util.List;
import java.util.Scanner;

public class LessOrMoreController {
    private LessOrMoreModel model;
    private LessOrMoreView view;

    public LessOrMoreController(LessOrMoreModel model, LessOrMoreView view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        Scanner sc = new Scanner(System.in);
        initializeModel();

        view.printMessage(LessOrMoreView.GREETINGS);
        view.printMessage(LessOrMoreView.NUMBER_GENERATED);
        while (true) {
            showCurrentInterval();
            int usersGuess = takeIntInputWithScanner(sc);
            int magicNumber = model.getMagicNumber();

            if (isGameEnded(usersGuess)) {
                showGameResults(usersGuess);
                return;
            }

            if (usersGuess < magicNumber) {
                model.setLeftBorder(usersGuess);
                view.numberIsTooSmall(usersGuess);
            } else if (usersGuess > magicNumber) {
                model.setRightBorder(usersGuess);
                view.numberIsTooBig(usersGuess);
            }
        }
    }

    private void initializeModel() {
        model.setPrimaryBorders(GlobalConstants.PRIMARY_MIN_BORDER,
                GlobalConstants.PRIMARY_MAX_BORDER);
        model.setMagicNumber();
    }

    private boolean isGameEnded(int usersGuess) {
        return usersGuess == model.getMagicNumber();
    }

    private void showCurrentInterval() {
        view.showCurrentInterval(model.getLeftBorder(), model.getRightBorder());
    }

    private void showGameResults(int usersGuess) {
        view.congratulateUser(usersGuess);

        List<Integer> way = model.getWay();
        way.add(usersGuess);

        view.showUsersWay(way);
    }

    public int takeIntInputWithScanner(Scanner sc) {
        int number;

        while (true) {
            view.printMessage(LessOrMoreView.INPUT_REQUEST);
            if (!sc.hasNextInt()) {
                view.printMessage(LessOrMoreView.NOT_A_NUMBER);
            } else if (!model.isValidBorder(number = sc.nextInt())) {
                view.printMessage(LessOrMoreView.OUT_OF_INTERVAL);
                showCurrentInterval();
            } else {
                break;
            }
        }

        return number;
    }
}
