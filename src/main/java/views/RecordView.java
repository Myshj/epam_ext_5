package views;

import lombok.AllArgsConstructor;
import lombok.Setter;
import models.Record;

@AllArgsConstructor
public class RecordView extends View {
    private final AddressView addressView;
    private final String recordLabel;
    private final String recordFirstNameLabel;
    private final String recordLastNameLabel;
    private final String recordBirthDateLabel;
    private final String recordPhoneNumberLabel;
    private final String recordAddressLabel;
    @Setter
    private Record record;

    @Override
    void displayHeader() {

    }

    @Override
    void displayBody() {
        System.out.printf("%s; ", recordLabel);
        System.out.printf("%s %s; ", recordFirstNameLabel, record.getFirstName());
        System.out.printf("%s %s; ", recordLastNameLabel, record.getLastName());
        System.out.printf("%s %s; ", recordBirthDateLabel, record.getBirthDate());
        System.out.printf("%s %s; ", recordPhoneNumberLabel, record.getPhoneNumber());
        addressView.setAddress(record.getAddress());
        System.out.printf("%s ", recordAddressLabel);
        addressView.display();
        System.out.println();
    }

    @Override
    void displayFooter() {

    }
}
