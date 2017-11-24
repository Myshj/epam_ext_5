package models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Record {
    private final String firstName;
    private final String lastName;
    private final LocalDate birthDate;
    private final String phoneNumber;
    private final Address address;
}
