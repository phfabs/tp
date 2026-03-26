package seedu.address.model.person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 * Represents the start date of a member's membership
 */
public class MembershipExpiryDate {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public final LocalDate expiryDate;
    /**
     * represents the expiry date of member's membership
     * @param date date the member joined the gym
     * @param type refers to the type of membership a gym member has chosen
     */
    public MembershipExpiryDate(LocalDate date, MembershipType type) {
        if (type.toString().equalsIgnoreCase("annual")) {
            this.expiryDate = date.plusYears(1);
        } else {
            this.expiryDate = date.plusMonths(1);
        }
    }

    /**
     *
     */
    public MembershipExpiryDate(String date) {
        this.expiryDate = LocalDate.parse(date, FORMATTER);
    }

    /**
     *
     */
    public MembershipExpiryDate(LocalDate date) {
        this.expiryDate = date;
    }

    public LocalDate getExpiryDate() {
        return this.expiryDate;
    }

    @Override
    public String toString() {
        return expiryDate.format(FORMATTER);
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
        return this.expiryDate.equals(otherExpiryDate.expiryDate);
    }

    @Override
    public int hashCode() {
        return expiryDate.hashCode();
    }
}
