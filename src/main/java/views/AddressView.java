package views;

import lombok.AllArgsConstructor;
import lombok.Setter;
import models.Address;

@AllArgsConstructor
public class AddressView extends View {

    private final String streetLabel;
    private final String buildingLabel;
    private final String apartmentLabel;
    @Setter
    private Address address;

    @Override
    void displayHeader() {

    }

    @Override
    void displayBody() {

        System.out.printf("%s %s; ", streetLabel, address.getStreet());
        System.out.printf("%s %s; ", buildingLabel, address.getBuilding());
        System.out.printf("%s %s; ", apartmentLabel, address.getApartment());
    }

    @Override
    void displayFooter() {

    }
}
