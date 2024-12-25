package software.ulpgc.kata7.app.windows;

import software.ulpgc.kata7.architecture.io.TextInput;

import javax.swing.*;

public class SwingTextInput implements TextInput {
    private final JTextField textField;

    public SwingTextInput(JTextField textField) {
        this.textField = textField;
    }

    @Override
    public String getText() {
        return textField.getText();
    }
}
