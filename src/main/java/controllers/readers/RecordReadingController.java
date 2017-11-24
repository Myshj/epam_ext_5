package controllers.readers;

import models.Address;
import models.Record;
import utils.Displayable;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.concurrent.Callable;


public class RecordReadingController extends ReadingController<Record> {

    private final Displayable recordAddedView;


    private final Callable<String> firstNameReader;


    private final Callable<String> lastNameReader;


    private final Callable<LocalDate> birthDateReader;


    private final Callable<String> phoneNumberReader;


    private final Callable<Address> addressReader;

    public RecordReadingController(
            InputStream input,
            Displayable view,
            Displayable inputErrorView,
            Displayable recordAddedView,
            Callable<String> firstNameReader,
            Callable<String> lastNameReader,
            Callable<LocalDate> birthDateReader,
            Callable<String> phoneNumberReader,
            Callable<Address> addressReader
    ) {
        super(input, view, inputErrorView);
        this.recordAddedView = recordAddedView;

        this.firstNameReader = firstNameReader;
        this.lastNameReader = lastNameReader;
        this.birthDateReader = birthDateReader;
        this.phoneNumberReader = phoneNumberReader;
        this.addressReader = addressReader;
    }

    @Override
    protected void onMessage(String message) {
    }

    @Override
    protected void onStarted() {
        super.onStarted();
        try {
            result = new Record(
                    firstNameReader.call(),
                    lastNameReader.call(),
                    birthDateReader.call(),
                    phoneNumberReader.call(),
                    addressReader.call()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        recordAddedView.display();
        stop();
    }
}
