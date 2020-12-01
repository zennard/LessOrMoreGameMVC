package com.lessormore;

import com.lessormore.controllers.LessOrMoreController;
import com.lessormore.models.LessOrMoreModel;
import com.lessormore.views.LessOrMoreView;

public class Main {
    public static void main(String[] args) {
        LessOrMoreModel model = new LessOrMoreModel();
        LessOrMoreView view = new LessOrMoreView();

        LessOrMoreController controller = new LessOrMoreController(model, view);
        controller.processUser();
    }
}
