package seedu.address.model.person;

/**
 * Represents a Member's ID in the address book.
 */
public class MemberId {
    private final int id;

    public MemberId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("M%03d", id);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof MemberId)) {
            return false;
        }

        MemberId otherId = (MemberId) other;
        return this.id == (otherId.id);
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
