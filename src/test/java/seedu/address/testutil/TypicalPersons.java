package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_DATEOFBIRTH_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DATEOFBIRTH_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMERGENCY_CONTACT_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMERGENCY_CONTACT_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GENDER_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GENDER_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TYPE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TYPE_BOB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.person.Person;

/**
 * A utility class containing a list of {@code Person} objects to be used in tests.
 */
public class TypicalPersons {

    public static final Person ALICE = new PersonBuilder()
            .withName("Alice Pauline")
            .withEmergencyContact("81236811")
            .withEmail("alice@example.com")
            .withPhone("94351253")
            .withGender("F")
            .withDateOfBirth("01-01-1990")
            .withJoinDate("11-03-2026")
            .withExpiryDate("11-03-2027")
            .withType("Annual")
            .build();
    public static final Person BENSON = new PersonBuilder()
            .withName("Benson Meier")
            .withEmergencyContact("83110225")
            .withEmail("johnd@example.com")
            .withPhone("98765432")
            .withGender("M")
            .withDateOfBirth("01-01-1990")
            .withType("Annual")
            .build();
    public static final Person CARL = new PersonBuilder()
            .withName("Carl Kurz")
            .withPhone("95352563")
            .withGender("M")
            .withDateOfBirth("01-01-1990")
            .withEmail("heinz@example.com")
            .withType("Annual")
            .withEmergencyContact("98556704").build();
    public static final Person DANIEL = new PersonBuilder()
            .withName("Daniel Meier")
            .withPhone("87652533")
            .withGender("M")
            .withDateOfBirth("01-01-1990")
            .withEmail("cornelia@example.com")
            .withEmergencyContact("88431033")
            .withType("Annual")
            .build();
    public static final Person ELLE = new PersonBuilder()
            .withName("Elle Meyer").withPhone("94822243")
            .withGender("F").withDateOfBirth("01-01-1990")
            .withType("Annual")
            .withEmail("werner@example.com")
            .withEmergencyContact("98540329").build();
    public static final Person FIONA = new PersonBuilder()
            .withName("Fiona Kunz").withPhone("94824278")
            .withGender("F").withDateOfBirth("01-01-1990")
            .withType("Annual")
            .withEmail("lydia@example.com")
            .withEmergencyContact("90112275").build();
    public static final Person GEORGE = new PersonBuilder()
            .withName("George Best").withPhone("94824421")
            .withGender("M").withDateOfBirth("01-01-1990")
            .withType("Annual")
            .withEmail("anna@example.com")
            .withEmergencyContact("94118693").build();

    // Manually added
    public static final Person HOON = new PersonBuilder()
            .withName("Hoon Meier").withPhone("84824241")
            .withGender("M").withDateOfBirth("01-01-1990")
            .withType("Annual")
            .withEmail("stefan@example.com")
            .withEmergencyContact("88002476").build();
    public static final Person IDA = new PersonBuilder()
            .withName("Ida Mueller").withPhone("84821316")
            .withGender("F").withDateOfBirth("01-01-1990")
            .withType("Annual")
            .withEmail("hans@example.com")
            .withEmergencyContact("98540083").build();

    // Manually added - Person's details found in {@code CommandTestUtil}
    public static final Person AMY = new PersonBuilder()
            .withName(VALID_NAME_AMY).withPhone(VALID_PHONE_AMY)
            .withGender(VALID_GENDER_AMY).withDateOfBirth(VALID_DATEOFBIRTH_AMY)
            .withType(VALID_TYPE_AMY)
            .withEmail(VALID_EMAIL_AMY)
            .withEmergencyContact(VALID_EMERGENCY_CONTACT_AMY).build();
    public static final Person BOB = new PersonBuilder().withName(VALID_NAME_BOB).withPhone(VALID_PHONE_BOB)
            .withGender(VALID_GENDER_BOB).withDateOfBirth(VALID_DATEOFBIRTH_BOB)
            .withEmail(VALID_EMAIL_BOB)
            .withType(VALID_TYPE_BOB)
            .withEmergencyContact(VALID_EMERGENCY_CONTACT_BOB).build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalPersons() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical persons.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Person person : getTypicalPersons()) {
            ab.addPerson(person);
        }
        return ab;
    }

    public static List<Person> getTypicalPersons() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}
