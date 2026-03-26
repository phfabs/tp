package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.ArrayDeque;
import java.util.Deque;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Stores recently executed undoable commands for use by {@link UndoCommand}.
 */
public class CommandHistory {
    private static final int DEFAULT_CAPACITY = 20;

    private final Deque<Command> history;
    private final int capacity;

    /**
     * Creates an empty command history with a fixed capacity.
     */
    public CommandHistory() {
        this.history = new ArrayDeque<>();
        this.capacity = DEFAULT_CAPACITY;
    }

    /**
     * Adds a command to history, evicting the oldest command when full.
     *
     * @param command command to store.
     */
    public void push(Command command) {
        requireNonNull(command);

        if (history.size() == capacity) {
            history.removeFirst();
        }

        history.addLast(command);
    }

    /**
     * Returns whether there are no commands to undo.
     *
     * @return {@code true} if history has no commands.
     */
    public boolean isEmpty() {
        return history.isEmpty();
    }

    /**
     * Returns the number of stored commands.
     *
     * @return number of commands in history.
     */
    public int size() {
        return history.size();
    }

    /**
     * Returns the most recently stored command without removing it.
     *
     * @return last command in history.
     */
    public Command peek() {
        return history.peekLast();
    }

    /**
     * Removes and returns the most recently stored command.
     *
     * @return last command in history.
     */
    public Command pop() {
        return history.removeLast();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("historySize", history.size())
                .add("capacity", capacity)
                .toString();
    }
}
