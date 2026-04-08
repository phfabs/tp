package seedu.address.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntSupplier;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Region;
import seedu.address.logic.TabCompleter;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * The UI component that is responsible for receiving user command inputs.
 */
public class CommandBox extends UiPart<Region> {

    public static final String ERROR_STYLE_CLASS = "error";
    private static final String FXML = "CommandBox.fxml";
    private final CommandHistory commandHistory = new CommandHistory();

    private final CommandExecutor commandExecutor;
    private final TabCompleter tabCompleter;
    private List<String> completionCandidates = new ArrayList<>();
    private int completionIndex = -1;

    @FXML
    private TextField commandTextField;

    /**
     * Creates a {@code CommandBox} with the given {@code CommandExecutor}.
     */
    public CommandBox(CommandExecutor commandExecutor, IntSupplier listSizeSupplier) {
        super(FXML);
        this.commandExecutor = commandExecutor;
        this.tabCompleter = new TabCompleter(listSizeSupplier);
        // calls #setStyleToDefault() whenever there is a change to the text of the command box.
        commandTextField.textProperty().addListener((unused1, unused2, unused3) -> setStyleToDefault());

        // Use an event filter so Tab is intercepted before JavaFX's focus traversal system.
        commandTextField.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            switch (event.getCode()) {
            case TAB:
                handleTabPressed();
                event.consume();
                break;
            case UP:
                resetCompletion();
                showPreviousCommand();
                event.consume();
                break;
            case DOWN:
                resetCompletion();
                showNextCommand();
                event.consume();
                break;
            default:
                resetCompletion();
                break;
            }
        });
    }

    /**
     * Handles the Enter button pressed event.
     */
    @FXML
    private void handleCommandEntered() {
        String commandText = commandTextField.getText();
        if (commandText.equals("")) {
            return;
        }

        try {
            commandExecutor.execute(commandText);
            commandHistory.add(commandText);
            commandTextField.setText("");
        } catch (CommandException | ParseException e) {
            setStyleToIndicateCommandFailure();
        }
    }

    /**
     * Focuses the command box and appends the given character.
     * Used to redirect keypresses from elsewhere in the window.
     */
    public void focusAndType(String character) {
        commandTextField.requestFocus();
        commandTextField.appendText(character);
        commandTextField.positionCaret(commandTextField.getText().length());
    }

    public boolean isFocused() {
        return commandTextField.isFocused();
    }

    /**
     * Sets the command box style to use the default style.
     */
    private void setStyleToDefault() {
        commandTextField.getStyleClass().remove(ERROR_STYLE_CLASS);
    }

    /**
     * Sets the command box style to indicate a failed command.
     */
    private void setStyleToIndicateCommandFailure() {
        ObservableList<String> styleClass = commandTextField.getStyleClass();

        if (styleClass.contains(ERROR_STYLE_CLASS)) {
            return;
        }

        styleClass.add(ERROR_STYLE_CLASS);
    }

    /**
     * Represents a function that can execute commands.
     */
    @FunctionalInterface
    public interface CommandExecutor {
        /**
         * Executes the command and returns the result.
         *
         * @see seedu.address.logic.Logic#execute(String)
         */
        CommandResult execute(String commandText) throws CommandException, ParseException;
    }

    /**
     * Handles Tab key press by cycling through completions for the current input.
     */
    private void handleTabPressed() {
        String currentText = commandTextField.getText();

        if (completionCandidates.isEmpty()) {
            List<String> candidates = tabCompleter.getCompletions(currentText);
            candidates.removeIf(c -> c.equals(currentText));
            if (candidates.isEmpty()) {
                return;
            }
            completionCandidates = candidates;
            completionIndex = 0;
        } else {
            completionIndex = (completionIndex + 1) % completionCandidates.size();
        }
        String completion = completionCandidates.get(completionIndex);
        commandTextField.setText(completion);
        commandTextField.positionCaret(completion.length());
    }

    /**
     * Clears the current completion cycle state.
     */
    private void resetCompletion() {
        completionCandidates = new ArrayList<>();
        completionIndex = -1;
    }

    /**
     * Represents a function that shows the previous command in the command history.
     * The cursor will be at the end of the text in the command box after this function is called.
     */
    private void showPreviousCommand() {
        String previousCommand = commandHistory.previous();
        if (previousCommand == null) {
            return;
        }

        commandTextField.setText(previousCommand);
        commandTextField.positionCaret(commandTextField.getText().length());
    }

    /**
     * Represents a function that shows the next command in the command history.
     * The cursor will be at the end of the text in the command box after this function is called.
     */
    private void showNextCommand() {
        String nextCommand = commandHistory.next();
        if (nextCommand == null) {
            commandTextField.setText("");
            return;
        }

        commandTextField.setText(nextCommand);
        commandTextField.positionCaret(commandTextField.getText().length());
    }

}
