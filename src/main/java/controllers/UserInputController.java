package controllers;

import utils.Displayable;
import utils.InputStreamOperator;

import java.io.InputStream;

public abstract class UserInputController extends InputStreamOperator {

    private final Displayable view;

    private final Displayable inputErrorView;

    protected UserInputController(
            InputStream input,
            Displayable view,
            Displayable inputErrorView
    ) {
        super(input);
        this.view = view;
        this.inputErrorView = inputErrorView;
    }

    protected void displayView() {
        view.display();
    }

    protected void displayErrorView() {
        inputErrorView.display();
    }

    @Override
    protected void onStarted() {
        displayView();
    }
}
