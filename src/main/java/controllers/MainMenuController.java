package controllers;

import utils.Displayable;

import java.io.InputStream;

public class MainMenuController extends UserInputController {
    private static final String DISPLAY_ALL = "1";
    private static final String ADD_NEW = "2";
    private static final String EXIT = "3";

    private final UserInputController recordReader;

    private final UserInputController journalDisplayer;


    public MainMenuController(
            InputStream input,
            UserInputController recordReader,
            UserInputController journalDisplayer,
            Displayable view,
            Displayable inputErrorView
    ) {
        super(input, view, inputErrorView);
        this.recordReader = recordReader;
        this.journalDisplayer = journalDisplayer;
    }

    @Override
    protected void onMessage(String message) {
        switch (message) {
            case DISPLAY_ALL:
                journalDisplayer.run();
                break;
            case ADD_NEW:
                recordReader.run();
                break;
            case EXIT:
                stop();
                return;
            default:
                displayErrorView();
                break;
        }
        displayView();
    }
}
