package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MEMBERSHIP_TYPE;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.RenewCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new RenewCommand object
 */
public class RenewCommandParser implements Parser<RenewCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the RenewCommand
     * and returns an RenewCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public RenewCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_MEMBERSHIP_TYPE);

        Index index;

        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (ParseException pe) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, RenewCommand.MESSAGE_USAGE), pe);
        }

        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_MEMBERSHIP_TYPE);
        RenewCommand.RenewPersonDescriptor renewPersonDescriptor = new RenewCommand.RenewPersonDescriptor();

        if (argMultimap.getValue(PREFIX_MEMBERSHIP_TYPE).isPresent()) {
            renewPersonDescriptor.setMembershipType(
                    ParserUtil.parseType(argMultimap.getValue(PREFIX_MEMBERSHIP_TYPE).get()));
        }

        return new RenewCommand(index, renewPersonDescriptor);
    }

}
