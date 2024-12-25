package software.ulpgc.kata7.architecture.io;

import software.ulpgc.kata7.architecture.model.Title;

public interface TitleDeserializer {
    Title deserialize(String line);
}
