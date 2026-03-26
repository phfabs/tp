package seedu.address.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CommandHistoryTest {

    @Test
    public void previous_emptyHistory_returnsEmpty() {
        CommandHistory history = new CommandHistory();
        assertEquals(null, history.previous());
        assertEquals(0, history.size());
    }

    @Test
    public void next_emptyHistory_returnsEmpty() {
        CommandHistory history = new CommandHistory();
        assertEquals(null, history.next());
        assertEquals(0, history.size());
    }

    @Test
    public void addAndNavigate_cyclesThroughCommands() {
        CommandHistory history = new CommandHistory();

        history.add("first");
        history.add("second");

        assertEquals(2, history.size());

        // At end: previous yields "second", then "first".
        assertEquals("second", history.previous());
        assertEquals("first", history.previous());
        assertEquals(null, history.previous());

        // Navigate forward: "second", then blank.
        assertEquals("second", history.next());
        assertEquals(null, history.next());

        // At end again: previous yields "second".
        assertEquals("second", history.previous());
    }

    @Test
    public void next_oneCommand_returnsEmptyAtEnd() {
        CommandHistory history = new CommandHistory();
        history.add("only");

        assertEquals("only", history.previous());
        assertEquals(null, history.next());
        assertEquals(null, history.next());
        assertEquals("only", history.previous());
    }
}

