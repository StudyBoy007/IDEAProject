package JAVAXML.XMLReader.SAX;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class SAXTest {
    public static void main(String[] args) {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {
            SAXParser parser = spf.newSAXParser();
            SAXParseHandler handler = new SAXParseHandler();
            parser.parse("XML\\books.xml", handler);
            List<Book>books=handler.getBookList();
            for (Book book:books){
                System.out.println(book);
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
