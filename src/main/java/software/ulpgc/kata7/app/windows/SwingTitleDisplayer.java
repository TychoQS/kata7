package software.ulpgc.kata7.app.windows;

import software.ulpgc.kata7.architecture.model.Title;
import software.ulpgc.kata7.architecture.view.TitleDisplayer;

import javax.swing.*;
import java.awt.*;

public class SwingTitleDisplayer extends JLabel implements TitleDisplayer {

    public static final String FONT_NAME = "Arial";

    public SwingTitleDisplayer() {
        this.setFont(new Font(FONT_NAME, Font.PLAIN, 40));
    }

    @Override
    public void display(Title title) {
        this.setText(title.title());
    }
}
