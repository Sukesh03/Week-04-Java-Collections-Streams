import org.junit.jupiter.api.*;
import java.io.IOException;
import java.nio.file.*;

import static org.junit.jupiter.api.Assertions.*;

public class FileProcessorTest {

    private static final String TEST_FILE = "testfile.txt";

    @AfterEach
    public void tearDown() throws IOException {
        Files.deleteIfExists(Paths.get(TEST_FILE));
    }

    @Test
    public void testWriteAndReadFromFile() throws IOException {
        String content = "Hello, file!";
        FileProcessor.writeToFile(TEST_FILE, content);

        String readContent = FileProcessor.readFromFile(TEST_FILE);
        assertEquals(content, readContent, "Content read should match content written");
    }

    @Test
    public void testFileExistsAfterWrite() throws IOException {
        FileProcessor.writeToFile(TEST_FILE, "Some data");
        assertTrue(Files.exists(Paths.get(TEST_FILE)), "File should exist after writing");
    }

    @Test
    public void testReadFromNonExistentFileThrowsException() {
        String nonexistentFile = "nonexistent.txt";
        assertThrows(IOException.class, () -> FileProcessor.readFromFile(nonexistentFile));
    }
}
