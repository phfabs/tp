package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.FilterCommand;
import seedu.address.model.person.AgeEqualsPredicate;
import seedu.address.model.person.JoinDateAfterPredicate;
import seedu.address.model.person.JoinDateBeforePredicate;

public class FilterCommandParserTest {

    private FilterCommandParser parser = new FilterCommandParser();

    @Test
    public void parse_ageEquals_success() {
        FilterCommand expectedCommand = new FilterCommand(new AgeEqualsPredicate(21));
        assertParseSuccess(parser, " age=/21", expectedCommand);
    }

    @Test
    public void parse_joinDateAfter_success() {
        FilterCommand expectedCommand =
                new FilterCommand(new JoinDateAfterPredicate(new seedu.address.model.person.MembershipJoinDate(
                        "01-01-2024").getDate()));
        assertParseSuccess(parser, " j>/01-01-2024", expectedCommand);
    }

    @Test
    public void parse_joinDateBefore_success() {
        FilterCommand expectedCommand =
                new FilterCommand(new JoinDateBeforePredicate(new seedu.address.model.person.MembershipJoinDate(
                        "01-01-2024").getDate()));
        assertParseSuccess(parser, " j</01-01-2024", expectedCommand);
    }

    @Test
    public void parse_invalidAge_failure() {
        assertParseFailure(parser, " age=/abc",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, FilterCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ", String.format(MESSAGE_INVALID_COMMAND_FORMAT, FilterCommand.MESSAGE_USAGE));
    }
}
