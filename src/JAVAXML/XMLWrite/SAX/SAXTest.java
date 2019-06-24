package JAVAXML.XMLWrite.SAX;

import com.sun.xml.internal.stream.events.AttributeImpl;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class SAXTest {
    public static void main(String[] args) {
        SAXTest test = new SAXTest();
        test.creatXml("File\\Secoond.xml");
    }

    public static ArrayList<Book> parseXml() {
        ArrayList<Book> books = null;
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {
            SAXParser parser = spf.newSAXParser();
            SAXParseHandler handler = new SAXParseHandler();
            parser.parse("XML\\books.xml", handler);
            books = handler.getBookList();
            for (Book book : books) {
                System.out.println(book);
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }

    /**
     * 生成xml
     */
    public static void creatXml(String url) {
        ArrayList<Book> books = parseXml();
        //创建transformerFactory对象
        SAXTransformerFactory sff = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
        try {
            //通过 SAXTransformerFactory对象创建TransformerHandler对象
            TransformerHandler handler = sff.newTransformerHandler();
            //通过TransformerHandler对象创建transformer对象，transformer对象可以对生成文件的属性进行设置
            Transformer tf = handler.getTransformer();
            //设置生成文件的属性,设置必须要在handler.setResult()的前面，在后面的话便会失效了
            tf.setOutputProperty(OutputKeys.INDENT, "yes");//换行
            tf.setOutputProperty(OutputKeys.ENCODING, "utf-8");//编码
            //创建Result对象
            Result result = new StreamResult(new FileOutputStream(url));
            //将result对象与handler关联,这一步必须要在startDocument之前
            handler.setResult(result);
            //通过handler对象对xml内容进行编写
            //打开document
            handler.startDocument();
            AttributesImpl attributes = new AttributesImpl();//这个属性集是后面所有节点公用的，除了第一个节点后面每个节点使用前
            //最好使用clear()方法清空一下该对象
            //添加节点
            handler.startElement("", "", "bookstore", attributes);
            for (Book book : books) {
                attributes.clear();
                attributes.addAttribute("", "", "id", "", Integer.toString(book.getId()));
                handler.startElement("", "", "book", attributes);
                if (book.getName() != null && book.getName().trim() != "") {
                    attributes.clear();
                    handler.startElement("", "", "name", attributes);
                    //添加节点中间文本
                    handler.characters(book.getName().toCharArray(), 0, book.getName().length());
                    handler.endElement("", "", "name");
                }
                if (book.getAuthor() != null&&book.getAuthor().trim()!="") {
                    attributes.clear();
                    handler.startElement("", "", "author", attributes);
                    //添加节点中间文本
                    handler.characters(book.getAuthor().toCharArray(), 0, book.getAuthor().length());
                    handler.endElement("", "", "author");
                }
                handler.endElement("", "", "book");
            }
            handler.endElement("", "", "bookstore");

            //关闭duocument
            handler.endDocument();


        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}