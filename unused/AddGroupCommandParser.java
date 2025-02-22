package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.logic.commands.AddGroupCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.group.Group;

/**
 * Parses input arguments and creates a new AddGroupCommand object
 */
public class AddGroupCommandParser implements Parser<AddGroupCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the
     * AddGroupCommand.
     *
     * @param args refer to the subsequent arguments after the initial command word.
     * @return an AddGroupCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddGroupCommand parse(String args) throws ParseException {
        try {
            requireNonNull(args);
            String trimmedArgs = args.trim();
            Group newGroup = ParserUtil.parseGroup(trimmedArgs);
            return new AddGroupCommand(newGroup);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(
                            MESSAGE_INVALID_COMMAND_FORMAT, AddGroupCommand.MESSAGE_USAGE),
                    pe);
        }
    }
}
