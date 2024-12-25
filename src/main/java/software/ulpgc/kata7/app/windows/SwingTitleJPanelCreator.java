package software.ulpgc.kata7.app.windows;

import javax.swing.*;
import java.awt.*;

public class SwingTitleJPanelCreator implements JPanelCreator {

    public static final String TITLE_TEXT = "CAN YOU GUESS THE RELEASE DATE OF THIS MOVIE?";
    public static final String FONT_NAME = "Arial";
    private final JPanel titlePane;

    public SwingTitleJPanelCreator() {
        this.titlePane = new JPanel();
        this.titlePane.add(titlePaneLabel());
    }

    private Component titlePaneLabel() {
        JLabel label = new JLabel(TITLE_TEXT);
        label.setFont(getFont());
        return label;
    }

    @Override
    public JPanel create() {
        return titlePane;
    }

    private Font getFont() {
        return new Font(FONT_NAME, Font.BOLD | Font.ITALIC, getAdaptedFontSize());
    }

    private int getAdaptedFontSize() {
        return Toolkit.getDefaultToolkit().getScreenSize().width / 50;
    }
}
