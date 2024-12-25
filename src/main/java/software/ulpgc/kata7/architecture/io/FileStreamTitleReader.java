package software.ulpgc.kata7.architecture.io;

import software.ulpgc.kata7.architecture.model.Title;

import java.io.*;

public class FileStreamTitleReader implements TitleReader{
    private final TitleDeserializer deserializer;
    private final BufferedReader reader;

    public FileStreamTitleReader(InputStream fileStream, TitleDeserializer deserializer) throws IOException {
        this.deserializer = deserializer;
        this.reader = new BufferedReader(new InputStreamReader(fileStream));
        this.reader.readLine();
    }

    @Override
    public Title read() throws IOException {
        return deserializer(reader.readLine());
    }

    private Title deserializer(String line) {
        return line != null ? deserializer.deserialize(line) : null;
    }

    @Override
    public void close() throws Exception {
        this.reader.close();
    }
}
