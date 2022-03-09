import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testFile1() throws IOException {
        String contents= Files.readString(Path.of("C:/Users/bkeko/Documents/GitHub/markdown-parse/test-file.md"));
        List<String> expect = List.of("https://something.com", "some-page.html");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void snippet1() throws IOException {
        String contents = Files.readString(Path.of("C:/Users/bkeko/Documents/GitHub/markdown-parse/snippet-1.md"));
        List<String> expect = List.of("`google.com","google.com", "ucsd.edu");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void snippet2() throws IOException {
        String contents = Files.readString(Path.of("C:/Users/bkeko/Documents/GitHub/markdown-parse/snippet-2.md"));
        List<String> expect = List.of("a.com","a.com(())", "example.com");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void snippet3() throws IOException {
        String contents = Files.readString(Path.of("C:/Users/bkeko/Documents/GitHub/markdown-parse/snippet-3.md"));
        List<String> expect = List.of("https://ucsd-cse15l-w22.github.io/");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }
}
