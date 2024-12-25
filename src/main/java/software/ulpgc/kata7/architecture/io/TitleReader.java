package software.ulpgc.kata7.architecture.io;

import software.ulpgc.kata7.architecture.model.Title;

import java.io.IOException;

public interface TitleReader extends AutoCloseable {
    Title read() throws IOException;
}
