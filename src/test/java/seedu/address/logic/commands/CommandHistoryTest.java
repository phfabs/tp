package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CommandHistoryTest {

    @Test
    public void pushPopPeekSize_capacityAndOrder() {
        CommandHistory history = new CommandHistory();
        assertTrue(history.isEmpty());
        assertEquals(0, history.size());
        assertEquals(null, history.peek());

        Command first = new StubCommand("first");
        history.push(first);
        assertFalse(history.isEmpty());
        assertEquals(1, history.size());
        assertEquals(first, history.peek());

        Command[] commands = new Command[21];
        commands[0] = first;
        for (int i = 1; i < commands.length; i++) {
            commands[i] = new StubCommand("c" + i);
            history.push(commands[i]);
        }

        assertEquals(20, history.size());
        assertEquals(commands[20], history.peek());
        assertEquals(commands[20], history.pop());

        Command lastPopped = null;
        for (int i = 0; i < 19; i++) {
            lastPopped = history.pop();
        }
        assertEquals(commands[1], lastPopped);
        assertTrue(history.isEmpty());
    }

    @Test
    public void toStringMethod_includesSizeAndCapacity() {
        CommandHistory history = new CommandHistory();
        history.push(new StubCommand("first"));

        String expected = CommandHistory.class.getCanonicalName() + "{historySize=1, capacity=20}";
        assertEquals(expected, history.toString());
    }

    private static class StubCommand extends Command {
        private final String id;

        private StubCommand(String id) {
            this.id = id;
        }

        @Override
        public CommandResult execute(seedu.address.model.Model model) {
            return new CommandResult(id);
        }
    }
}
