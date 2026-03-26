package seedu.address.model.person;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Predicate;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Tests that a {@code Person}'s age is less than the given value.
 */
public class AgeLessThanPredicate implements Predicate<Person> {
    private final int age;

    public AgeLessThanPredicate(int age) {
        this.age = age;
    }

    @Override
    public boolean test(Person person) {
        int personAge = Period.between(person.getDateOfBirth().dateOfBirth, LocalDate.now()).getYears();
        return personAge < age;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof AgeLessThanPredicate otherPredicate)) {
            return false;
        }

        return age == otherPredicate.age;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("ageLessThan", age).toString();
    }
}
