package software.ulpgc.kata7.app.io.sqlite;

import software.ulpgc.kata7.architecture.control.Command;
import software.ulpgc.kata7.architecture.io.TitleReader;
import software.ulpgc.kata7.architecture.io.TitleWriter;
import software.ulpgc.kata7.architecture.model.Title;

public class ImportCommand implements Command {


    private final TitleReader reader;
    private final TitleWriter writer;

    public ImportCommand(TitleReader reader, TitleWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public void execute() {
        try {
            while (true) {
                Title title = reader.read();
                if (title == null) break;
                writer.write(title);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
