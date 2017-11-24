import controllers.JournalDisplayController;
import controllers.MainMenuController;
import controllers.RecordAddingController;
import controllers.readers.AddressReadingController;
import controllers.readers.RecordReadingController;
import controllers.readers.ValidatedReadingController;
import lombok.val;
import models.Record;
import service.DateValidator;
import service.StringRegexValidator;
import utils.Repository;
import views.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

public abstract class Main {
    public static void main(String[] args) {
        init(args[0]);
    }

    private static void init(String language) {
        Locale.setDefault(Locale.forLanguageTag(language));
        val strings = ResourceBundle.getBundle("strings");
        val regexes = ResourceBundle.getBundle("regexes");
        val journal = new Repository<Record>();
        val inputErrorView = new InputErrorView(strings.getString("wrongInput"));
        new MainMenuController(
                System.in,
                new RecordAddingController(
                        System.in,
                        new SingleMessageView(
                                strings.getString("newRecordAddition"),
                                strings.getString("enterNamePhoneAddress")
                        ),
                        inputErrorView,
                        new RecordReadingController(
                                System.in,
                                new SingleMessageView(
                                        strings.getString("inputRecord"),
                                        strings.getString("allFieldsRequired")
                                ),
                                inputErrorView,
                                new SingleMessageView(
                                        strings.getString("recordAdded"),
                                        strings.getString("allFieldsCorrect")
                                ),
                                new ValidatedReadingController<>(
                                        System.in,
                                        new SingleMessageView(
                                                strings.getString("enterFirstName"),
                                                strings.getString("enterFirstNameHint")
                                        ),
                                        inputErrorView,
                                        new StringRegexValidator(regexes.getString("firstName")),
                                        s -> s
                                ),
                                new ValidatedReadingController<>(
                                        System.in,
                                        new SingleMessageView(
                                                strings.getString("enterLastName"),
                                                strings.getString("enterLastNameHint")
                                        ),
                                        inputErrorView,
                                        new StringRegexValidator(regexes.getString("lastName")),
                                        s -> s
                                ),
                                new ValidatedReadingController<>(
                                        System.in,
                                        new SingleMessageView(
                                                strings.getString("enterBirthDate"),
                                                strings.getString("enterBirthDateHint")
                                        ),
                                        inputErrorView,
                                        new DateValidator(),
                                        LocalDate::parse
                                ),
                                new ValidatedReadingController<>(
                                        System.in,
                                        new SingleMessageView(
                                                strings.getString("enterPhoneNumber"),
                                                strings.getString("enterPhoneNumberHint")
                                        ),
                                        inputErrorView,
                                        new StringRegexValidator(regexes.getString("phoneNumber")),
                                        s -> s
                                ),
                                new AddressReadingController(
                                        System.in,
                                        new SingleMessageView(
                                                strings.getString("enterAddress"),
                                                strings.getString("allFieldsRequired")
                                        ),
                                        inputErrorView,
                                        new ValidatedReadingController<>(
                                                System.in,
                                                new SingleMessageView(
                                                        strings.getString("enterStreet"),
                                                        strings.getString("enterStreetHint")
                                                ),
                                                inputErrorView,
                                                new StringRegexValidator(regexes.getString("streetName")),
                                                s -> s
                                        ),
                                        new ValidatedReadingController<>(
                                                System.in,
                                                new SingleMessageView(
                                                        strings.getString("enterBuilding"),
                                                        strings.getString("enterBuildingHint")
                                                ),
                                                inputErrorView,
                                                new StringRegexValidator(regexes.getString("buildingNumber")),
                                                s -> s
                                        ),
                                        new ValidatedReadingController<>(
                                                System.in,
                                                new SingleMessageView(
                                                        strings.getString("enterApartment"),
                                                        strings.getString("enterApartmentHint")
                                                ),
                                                inputErrorView,
                                                new StringRegexValidator(regexes.getString("apartmentNumber")),
                                                s -> s
                                        )
                                )
                        ),
                        journal
                ),

                new JournalDisplayController(
                        System.in,
                        new JournalView(
                                strings.getString("typeOptionNumberAndPressEnter"),
                                journal,
                                new RecordView(
                                        new AddressView(
                                                strings.getString("addressStreetLabel"),
                                                strings.getString("addressBuildingLabel"),
                                                strings.getString("addressApartmentLabel"),
                                                null
                                        ),
                                        strings.getString("recordLabel"),
                                        strings.getString("recordFirstNameLabel"),
                                        strings.getString("recordLastNameLabel"),
                                        strings.getString("recordBirthDateLabel"),
                                        strings.getString("recordPhoneNumberLabel"),
                                        strings.getString("recordAddressLabel"),
                                        null
                                )
                        ),
                        inputErrorView
                ),
                //new MainMenuView(strings.getString("typeOptionNumberAndPressEnter")),
                new MenuView(
                        strings.getString("typeOptionNumberAndPressEnter"),
                        strings.getString("mainMenuHeader"),
                        Arrays.asList(
                                strings.getString("mainMenuChoice1"),
                                strings.getString("mainMenuChoice2"),
                                strings.getString("mainMenuChoice3")
                        )
                ),
                inputErrorView
        ).run();
    }
}
