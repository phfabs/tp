package seedu.address.model.person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 * Represents the start date of a member's membership
 */
public class MembershipJoinDate {
    public static final String MESSAGE_CONSTRAINTS =
            "Membership join date should be in the format DD-MM-YYYY and should be a valid date.";
    public static final String VALIDATION_REGEX = "^((0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-((19|20)\\d\\d))$";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public final LocalDate currDate;

    /**
     * Constructs a {@code MembershipJoinDate} object with the current date.
     */
    public MembershipJoinDate() {
        this.currDate = LocalDate.now();
    }
    /**
     * Constructs a {@code MembershipJoinDate} object with the specified date string.
     * @param date membership join date as a string
     */
    public MembershipJoinDate(String date) {
        this.currDate = LocalDate.parse(date, FORMATTER);
    }
    public LocalDate getDate() {
        return currDate;
    }

    @Override
    public String toString() {
        return currDate.format(FORMATTER);
    }

    /**
     * Returns true if a given string is a valid membership join date.
     */
    public static boolean isValidJoinDate(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof MembershipJoinDate)) {
            return false;
        }

        MembershipJoinDate otherJoinDate = (MembershipJoinDate) other;
        return this.currDate.equals(otherJoinDate.currDate);
    }

    @Override
    public int hashCode() {
        return currDate.hashCode();
    }
}
