package seedu.address.model.person;

import java.util.function.Predicate;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Tests that a {@code Person}'s {@code MemberStatus} matches the one given.
 */
public class StatusMatchesPredicate implements Predicate<Person> {
    private final String status;

    public StatusMatchesPredicate(String status) {
        this.status = status;
    }

    @Override
    public boolean test(Person person) {
        return person.getMemberStatus().memberStatus.equalsIgnoreCase(status);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof StatusMatchesPredicate)) {
            return false;
        }

        StatusMatchesPredicate otherStatusMatchesPredicate = (StatusMatchesPredicate) other;
        return status.equals(otherStatusMatchesPredicate.status);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("status", this.status).toString();
    }
}

