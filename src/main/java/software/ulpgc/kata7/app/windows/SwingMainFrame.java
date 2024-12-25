package software.ulpgc.kata7.app.windows;

import software.ulpgc.kata7.architecture.control.Command;
import software.ulpgc.kata7.architecture.view.TitleDisplayer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class SwingMainFrame extends JFrame {
    public static final String WINDOWS_TITLE_TEXT = "Guess the release date game";
    private final Map<String, Command> commands;
    private SwingMovieNameJPanelCreator movieNameJPanelCreator;
    private SwingPlayerAnswerJPanelCreator playerAnswerJPanelCreator;

    public SwingMainFrame() throws IOException {
        commands = new HashMap<>();
        this.setTitle(WINDOWS_TITLE_TEXT);
        this.setIconImage(getIcon());
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.add(titlePane());
        this.add(mainPane());
    }

    private Image getIcon() throws IOException {
        return getIconAsImage();
    }

    private Image getIconAsImage() throws IOException {
        InputStream iconAsStream = SwingMainFrame.class.getResourceAsStream("/icon.png");
        return ImageIO.read(iconAsStream);
    }

    public Command put(String key, Command value) {
        return commands.put(key, value);
    }

    public TitleDisplayer getTitleDisplayer() {
        return movieNameJPanelCreator.getSwingTitleDisplayer();
    }

    public JTextField getTextField() {
        return playerAnswerJPanelCreator.getTextField();
    }

    private Component mainPane() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(movieNamePanel());
        panel.add(playerAnswerPanel());
        return panel;
    }

    private Component playerAnswerPanel() {
        this.playerAnswerJPanelCreator = new SwingPlayerAnswerJPanelCreator(commands);
        return this.playerAnswerJPanelCreator.create();
    }

    private Component movieNamePanel() {
        this.movieNameJPanelCreator = new SwingMovieNameJPanelCreator();
        return this.movieNameJPanelCreator.create();
    }

    private Component titlePane() {
        return new SwingTitleJPanelCreator().create();
    }
}
