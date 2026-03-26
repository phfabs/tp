package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.RENEW_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.RENEW_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TYPE_BOB;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.RenewCommand.RenewPersonDescriptor;
import seedu.address.testutil.RenewPersonDescriptorBuilder;

public class RenewPersonDescriptorTest {

    @Test
    public void equals() {
        // same values -> returns true
        RenewPersonDescriptor descriptorWithSameValues = new RenewPersonDescriptor(RENEW_DESC_AMY);
        assertTrue(RENEW_DESC_AMY.equals(descriptorWithSameValues));

        // same object -> returns true
        assertTrue(RENEW_DESC_AMY.equals(RENEW_DESC_AMY));

        // null -> returns false
        assertFalse(RENEW_DESC_AMY.equals(null));

        // different types -> returns false
        assertFalse(RENEW_DESC_AMY.equals(5));

        // different values -> returns false
        assertFalse(RENEW_DESC_AMY.equals(RENEW_DESC_BOB));

        // different type -> returns false
        RenewPersonDescriptor renewedAmy = new RenewPersonDescriptorBuilder(
                RENEW_DESC_AMY).withType(VALID_TYPE_BOB).build();
        assertFalse(RENEW_DESC_AMY.equals(renewedAmy));

    }

    @Test
    public void toStringMethod() {
        RenewPersonDescriptor renewPersonDescriptor = new RenewPersonDescriptor();
        String expected = RenewPersonDescriptor.class.getCanonicalName() + "{type="
                + renewPersonDescriptor.getType().orElse(null) + "}";
        assertEquals(expected, renewPersonDescriptor.toString());
    }
}
