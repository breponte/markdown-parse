// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;


public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        int currentIndex = 0;

        while(currentIndex < markdown.length()) {
            // Flag to keep track of exclamation
            boolean flag = false;
            int nextOpenBracket = markdown.indexOf("[", currentIndex);

            // For test case 1 (bug with text after paren)
            if(nextOpenBracket == -1) {
                break;
            }

            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            int openParen = markdown.indexOf("(", nextCloseBracket);
            int closeParen = markdown.indexOf(")", openParen);

            // For test case 5 (test-file3)
            if(closeParen == -1) {
                break;
            }

            // For test case 2 (bug for paren inside link)
            if(markdown.charAt(closeParen - 1) == '(') {
                closeParen = markdown.indexOf(")", closeParen + 1);
            }

            // For test case 3 (bug with image instead of link)
            if(nextOpenBracket > 0 && markdown.charAt(nextOpenBracket - 1) == '!') {
                flag = true;
            }

            // For both test case 2 and 3
            if(nextCloseBracket + 1 == openParen && !flag) {
                toReturn.add(markdown.substring(openParen + 1, closeParen));
            }

            currentIndex = closeParen + 1;
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}