package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's emergency contact in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidEmergencyContact(String)}
 */
public class EmergencyContact {
    public static final String MESSAGE_CONSTRAINTS =
            "Emergency contacts should only contain numbers, and it should be 8 digits long starting with 6,8 or 9";
    public static final String VALIDATION_REGEX = "^[689]\\d{7}$";
    public final String value;

    /**
     * Constructs an {@code EmergencyContact}.
     *
     * @param emergencyContact A valid emergency contact.
     */
    public EmergencyContact(String emergencyContact) {
        requireNonNull(emergencyContact);
        checkArgument(isValidEmergencyContact(emergencyContact), MESSAGE_CONSTRAINTS);
        value = emergencyContact;
    }

    /**
     * Returns true if a given string is a valid email.
     */
    public static boolean isValidEmergencyContact(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof EmergencyContact)) {
            return false;
        }

        EmergencyContact otherEmergencyContact = (EmergencyContact) other;
        return value.equals(otherEmergencyContact.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
