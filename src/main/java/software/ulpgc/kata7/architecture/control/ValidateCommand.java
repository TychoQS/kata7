package software.ulpgc.kata7.architecture.control;

import software.ulpgc.kata7.architecture.view.DialogDisplayer;
import software.ulpgc.kata7.architecture.io.TextInput;
import software.ulpgc.kata7.architecture.io.DatabaseTitleLoader;

public class ValidateCommand implements Command {
    public static final String GOOD_ANSWER_MESSAGE = "You are right!";
    public static final String BAD_ANSWER_MESSAGE = "You are wrong";
    public static final int GOOD_ANSWER_MESSAGE_TYPE = 1;
    public static final int BAD_ANSWER_MESSAGE_TYPE = 0;
    private final TextInput input;
    private final DatabaseTitleLoader loader;
    private final DialogDisplayer display;

    public ValidateCommand(TextInput input, DatabaseTitleLoader loader, DialogDisplayer display) {
        this.input = input;
        this.loader = loader;
        this.display = display;
    }


    @Override
    public void execute() {
        boolean isCorrect = AnswerValidator.validate(input.getText(), loader.load(DisplayNextTitleCommand.getI()));
        display.display(
                isCorrect ? GOOD_ANSWER_MESSAGE : BAD_ANSWER_MESSAGE,
                isCorrect ? GOOD_ANSWER_MESSAGE_TYPE : BAD_ANSWER_MESSAGE_TYPE
        );
    }
}
