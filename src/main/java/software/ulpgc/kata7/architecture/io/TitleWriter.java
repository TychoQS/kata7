package software.ulpgc.kata7.architecture.io;

import software.ulpgc.kata7.architecture.model.Title;

import java.io.IOException;

public interface TitleWriter extends AutoCloseable {
    void write(Title title) throws IOException;
}
