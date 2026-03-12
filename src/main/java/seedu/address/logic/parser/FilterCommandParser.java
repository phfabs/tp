package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import java.util.function.Predicate;

import seedu.address.logic.commands.FilterCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Person;
import seedu.address.model.person.StatusMatchesPredicate;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MEMBERSTATUS;

/**
 * Parses input arguments and creates a new FilterCommand object.
 */
public class FilterCommandParser implements Parser<FilterCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the FilterCommand
     * and returns an FilterCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public FilterCommand parse(String args) throws ParseException {
        requireNonNull(args);

        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_MEMBERSTATUS);

        Predicate<Person> predicate = person -> true;

        // Filter by status
        if (argMultimap.getValue(PREFIX_MEMBERSTATUS).isPresent()) {
            String status = argMultimap.getValue(PREFIX_MEMBERSTATUS).get();
            predicate = predicate.and(new StatusMatchesPredicate(status));
        }

        // If no filters provided
        if (argMultimap.getValue(PREFIX_MEMBERSTATUS).isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FilterCommand.MESSAGE_USAGE));
        }

        return new FilterCommand(predicate);
    }
}
