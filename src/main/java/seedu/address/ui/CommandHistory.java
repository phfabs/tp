package seedu.address.ui;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores previously entered commands and allows navigating through them.
 */
public class CommandHistory {

    private final List<String> commands = new ArrayList<>();
    private int pointer = 0; // points to the "current" history index; commands.size() means blank/new entry

    /**
     * Adds the given command to history and moves the pointer to the end.
     *
     * @param command command to add
     */
    public void add(String command) {
        requireNonNull(command);
        commands.add(command);
        pointer = commands.size();
    }

    /**
     * Returns the previous command (if any) and moves the pointer backwards.
     *
     * @return the previous command, or {@code null} if no previous command exists
     */
    public String previous() {
        if (pointer <= 0) {
            return null;
        }

        pointer--;
        return commands.get(pointer);
    }

    /**
     * Returns the next command (if any) and moves the pointer forwards.
     * If the pointer moves past the most recent command, it will point to a blank entry.
     *
     * @return the next command, or {@code null} if no next command exists
     */
    public String next() {
        if (commands.isEmpty()) {
            pointer = 0;
            return null;
        }

        if (pointer < commands.size() - 1) {
            pointer++;
            return commands.get(pointer);
        }

        pointer = commands.size();
        return null;
    }

    /**
     * Returns the number of commands stored in history.
     *
     * @return command count
     */
    public int size() {
        return commands.size();
    }
}

