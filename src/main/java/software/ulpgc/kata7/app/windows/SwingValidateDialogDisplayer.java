package software.ulpgc.kata7.app.windows;

import software.ulpgc.kata7.architecture.view.DialogDisplayer;

import javax.swing.*;

public class SwingValidateDialogDisplayer implements DialogDisplayer {
    @Override
    public void display(String message, int messageType) {
        JOptionPane.showMessageDialog(null, message, "Validation comment", messageType);
    }
}
