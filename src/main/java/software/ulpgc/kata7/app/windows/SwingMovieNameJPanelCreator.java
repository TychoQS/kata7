package software.ulpgc.kata7.app.windows;

import software.ulpgc.kata7.architecture.view.TitleDisplayer;

import javax.swing.*;
import java.awt.*;

public class SwingMovieNameJPanelCreator implements JPanelCreator {
    private final TitleDisplayer swingTitleDisplayer;
    private final JPanel pane;

    public SwingMovieNameJPanelCreator() {
        this.swingTitleDisplayer = new SwingTitleDisplayer();
        this.pane = new JPanel();
        this.pane.add((Component) swingTitleDisplayer);
    }

    public TitleDisplayer getSwingTitleDisplayer() {
        return swingTitleDisplayer;
    }

    @Override
    public JPanel create() {
        return pane;
    }
}
