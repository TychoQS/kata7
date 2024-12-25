package software.ulpgc.kata7.architecture.io;

import software.ulpgc.kata7.architecture.model.Title;

import java.io.IOException;
import java.util.List;

public interface DatabaseResponseAdapter {
    List<Title> adapt() throws IOException;
}
