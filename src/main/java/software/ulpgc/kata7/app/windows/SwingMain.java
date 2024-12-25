package software.ulpgc.kata7.app.windows;

import software.ulpgc.kata7.app.io.sqlite.DatabaseTitleWriter;
import software.ulpgc.kata7.architecture.control.DisplayNextTitleCommand;
import software.ulpgc.kata7.architecture.io.*;
import software.ulpgc.kata7.architecture.control.ValidateCommand;
import software.ulpgc.kata7.app.io.sqlite.DatabaseTitlesReader;
import software.ulpgc.kata7.app.io.sqlite.ImportCommand;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

public class SwingMain {

    public static final String DB_RELATIVE_PATH = "data/titles.db";
    public static final String INPUT_RELATIVE_PATH = "/data/title.basics.tsv";

    public static void main(String[] args) throws Exception {
        importFrom(getInputStream());
        TitleLoader loader = new DatabaseTitleLoader(new DatabaseTitlesReader(new File(DB_RELATIVE_PATH)).read());
        SwingMainFrame mainFrame = new SwingMainFrame();
        mainFrame.put("another-title", new DisplayNextTitleCommand(loader, mainFrame.getTitleDisplayer()));
        mainFrame.put("validate", new ValidateCommand(new SwingTextInput(mainFrame.getTextField()), (DatabaseTitleLoader) loader, new SwingValidateDialogDisplayer()));
        mainFrame.getTitleDisplayer().display(loader.load(0));
        mainFrame.setVisible(true);
    }

    private static InputStream getInputStream() {
        return SwingMain.class.getResourceAsStream(INPUT_RELATIVE_PATH);
    }

    private static void importFrom(InputStream inputStream) throws Exception {
        try (TitleReader reader = getTitleReader(inputStream); TitleWriter writer = getTitleWriter()){
            new ImportCommand(reader, writer).execute();
        }
    }

    private static TitleReader getTitleReader(InputStream inputStream) throws IOException {
        return new FileStreamTitleReader(inputStream, new TsvTitleDeserializer());
    }

    private static TitleWriter getTitleWriter() throws SQLException {
        File outputFile = new File(DB_RELATIVE_PATH);
        createIfNotExists(outputFile.getParentFile());
        return new DatabaseTitleWriter(deleteIfExists(outputFile));
    }

    private static File deleteIfExists(File file) {
        if (file.exists()) file.delete();
        return file;
    }

    private static void createIfNotExists(File directory) {
        if (!directory.exists()) directory.mkdirs();
    }
}
