package seedu.address.testutil;

import seedu.address.logic.commands.RenewCommand;
import seedu.address.logic.commands.RenewCommand.RenewPersonDescriptor;
import seedu.address.model.person.MembershipType;
import seedu.address.model.person.Person;

/**
 * A utility class to help with building EditPersonDescriptor objects.
 */
public class RenewPersonDescriptorBuilder {

    private RenewPersonDescriptor descriptor;

    public RenewPersonDescriptorBuilder() {
        descriptor = new RenewPersonDescriptor();
    }

    public RenewPersonDescriptorBuilder(RenewPersonDescriptor descriptor) {
        this.descriptor = new RenewPersonDescriptor(descriptor);
    }
    /**
     * Returns an {@code RenewPersonDescriptor} with fields containing {@code person}'s membership type
     */
    public RenewPersonDescriptorBuilder(Person person) {
        descriptor = new RenewCommand.RenewPersonDescriptor();
        descriptor.setMembershipType(person.getMembershipType());
    }
    /**
     * Sets the {@code MembershipType} of the {@code RenewPersonDescriptor} that we are building.
     */
    public RenewPersonDescriptorBuilder withType(String type) {
        descriptor.setMembershipType(new MembershipType(type));
        return this;
    }

    public RenewPersonDescriptor build() {
        return descriptor;
    }
}
