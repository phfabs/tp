package seedu.address.model.person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 * Represents the start date of a member's membership
 */
public class MembershipExpiryDate {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public final String value;
    public final LocalDate expiryDate;
    /**
     * represents the expiry date of member's membership
     * @param date date the member joined the gym
     * @param type refers to the type of membership a gym member has chosen
     */
    public MembershipExpiryDate(LocalDate date, MembershipType type) {
        if (type.toString().equalsIgnoreCase("annual")) {
            this.expiryDate = date.plusYears(1);
            this.value = date.plusYears(1).format(FORMATTER);
        } else {
            this.expiryDate = date.plusMonths(1);
            this.value = date.plusMonths(1).format(FORMATTER);
        }
    }

    /**
     *
     */
    public MembershipExpiryDate(String date) {
        this.value = date;
        this.expiryDate = LocalDate.parse(date, FORMATTER);
    }

    /**
     *
     */
    public MembershipExpiryDate(LocalDate date) {
        this.value = date.format(FORMATTER);
        this.expiryDate = date;
    }

    public LocalDate getExpiryDate() {
        return this.expiryDate;
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
        if (!(other instanceof MembershipExpiryDate)) {
            return false;
        }

        MembershipExpiryDate otherExpiryDate = (MembershipExpiryDate) other;
        return this.value.equals(otherExpiryDate.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
