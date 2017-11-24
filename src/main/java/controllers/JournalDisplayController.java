package controllers;

import utils.Displayable;

import java.io.InputStream;

public class JournalDisplayController extends UserInputController {

    private static final String BACK = "1";

    public JournalDisplayController(
            InputStream input,
            Displayable view,
            Displayable inputErrorView
    ) {
        super(input, view, inputErrorView);
    }

    @Override
    protected void onMessage(String message) {
        switch (message) {
            case BACK:
                stop();
                return;
            default:
                displayErrorView();
                break;
        }
        displayView();
    }
}
