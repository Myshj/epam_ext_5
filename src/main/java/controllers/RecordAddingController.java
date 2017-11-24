package controllers;

import models.Record;
import utils.Displayable;
import utils.Repository;

import java.io.InputStream;
import java.util.concurrent.Callable;

public class RecordAddingController extends UserInputController {
    private final Callable<Record> recordReader;
    private final Repository<Record> journal;

    public RecordAddingController(
            InputStream input,
            Displayable view,
            Displayable inputErrorView,
            Callable<Record> recordReader,
            Repository<Record> journal
    ) {
        super(input, view, inputErrorView);
        this.recordReader = recordReader;
        this.journal = journal;
    }

    @Override
    protected void onMessage(String message) {

    }

    @Override
    protected void onStarted() {
        super.onStarted();
        try {
            journal.add(
                    recordReader.call()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        stop();
    }
}
