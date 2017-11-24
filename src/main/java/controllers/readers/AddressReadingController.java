package controllers.readers;

import models.Address;
import utils.Displayable;

import java.io.InputStream;
import java.util.concurrent.Callable;

public class AddressReadingController extends ReadingController<Address> {

    private final Callable<String> streetReader;
    private final Callable<String> buildingReader;
    private final Callable<String> apartmentReader;

    public AddressReadingController(
            InputStream input,
            Displayable view,
            Displayable inputErrorView,
            Callable<String> streetReader,
            Callable<String> buildingReader,
            Callable<String> apartmentReader
    ) {
        super(input, view, inputErrorView);
        this.streetReader = streetReader;
        this.buildingReader = buildingReader;
        this.apartmentReader = apartmentReader;
    }

    @Override
    protected void onMessage(String message) {

    }

    @Override
    protected void onStarted() {
        super.onStarted();
        try {
            result = new Address(
                    streetReader.call(),
                    buildingReader.call(),
                    apartmentReader.call()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        stop();
    }
}
