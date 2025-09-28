// FileLoaderTest.java

package be.ecam.basics.exercises;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;


class FileLoaderTest {

    @Test
    void missingFileShouldPropagateIOException() {
        // Use a random path that should not exist
        Path p = Path.of("Z:/definitely/not/there/" + System.nanoTime() + ".txt");
        assertThrows(IOException.class, () -> FileLoader.firstLine(p));
    }

    @Test
    void readsFirstLine() throws IOException {
        // Create file, write 2 lines in it, read the first line and close the file.
        Path tmp = Files.createTempFile("fileloader", ".txt");
        try {
            Files.writeString(tmp, "hello\nworld\n", StandardCharsets.UTF_8);
            String line = FileLoader.firstLine(tmp);
            assertEquals("hello", line);
        } finally {
            Files.deleteIfExists(tmp);
        }
    }
}
