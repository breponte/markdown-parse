import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testOriginalFile() throws IOException {
        Path fileName = Path.of("C:/Users/bkeko/Documents/GitHub/markdown-parse-clone2/break0.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("https://something.com", "some-page.html"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void testBreakFile1() throws IOException {
        Path fileName = Path.of("C:/Users/bkeko/Documents/GitHub/markdown-parse-clone2/break1.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("https://something.com", "some-page.html"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void testBreakFile2() throws IOException {
        Path fileName = Path.of("C:/Users/bkeko/Documents/GitHub/markdown-parse-clone2/break2.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("https://something().com"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void testBreakFile3() throws IOException {
        Path fileName = Path.of("C:/Users/bkeko/Documents/GitHub/markdown-parse-clone2/break3.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of(), MarkdownParse.getLinks(contents));
    }

    @Test
    public void testBreakFile4() throws IOException {
        Path fileName = Path.of("C:/Users/bkeko/Documents/GitHub/markdown-parse-clone2/break4.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("https://something.com", "some-page.html"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void testBreakFile5() throws IOException {
        Path fileName = Path.of("C:/Users/bkeko/Documents/GitHub/markdown-parse-clone2/break5.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of(), MarkdownParse.getLinks(contents));
    }

    @Test
    public void testBreakFile6() throws IOException {
        Path fileName = Path.of("C:/Users/bkeko/Documents/GitHub/markdown-parse-clone2/break6.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of(), MarkdownParse.getLinks(contents));
    }

    @Test
    public void testBreakFile7() throws IOException {
        Path fileName = Path.of("C:/Users/bkeko/Documents/GitHub/markdown-parse-clone2/break7.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of(), MarkdownParse.getLinks(contents));
    }

    @Test
    public void testBreakFile8() throws IOException {
        Path fileName = Path.of("C:/Users/bkeko/Documents/GitHub/markdown-parse-clone2/break8.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of(), MarkdownParse.getLinks(contents));
    }
}