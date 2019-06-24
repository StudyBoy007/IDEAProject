package JAVAXML.XMLReader.SAX;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SAXParseHandler extends DefaultHandler {
    private int i;
    private Book book;
    private String value;
    private List<Book> bookList = new ArrayList<>();

    public List<Book> getBookList() {
        return bookList;
    }

    /*
    标识解析开始
    */

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("************SAX解析开始************");
    }

    /*
    标识解析结束
     */

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("************SAX解析结束************");
    }


    /*
   用来遍历xml的开始标签,每走到一个开始标签就执行一次该方法
    */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if (qName.equals("book")) {
            book = new Book();
            i++;
            System.out.println("*******开始遍历第" + i + "本书的遍历！******");
            //已知节点的属性名称的话-->attributes可以通过getvalue的方式直接得到指定的属性名称的属性值,
//              String value=attributes.getValue("id");
//            System.out.println("book的属性值为: "+value);

            //不知道节点的属性名称和个数的话
            int attrnum = attributes.getLength();
            for (int i = 0; i < attrnum; i++) {
                String attrName = attributes.getQName(i);
//                String attrValue=attributes.getValue(i);//通过索引获得对应的value值
                String attrValue = attributes.getValue(attrName);//通过属性名称获取对应的属性值

                System.out.print(qName + "元素的第" + (i + 1) + "个属性的名称为:" + attrName);
                System.out.println(",其值为-->" + attrValue);
                if (attrName.equals("id")) {
                    book.setId(Integer.parseInt(attrValue));
                }
            }
        } else if (!qName.equals("book") && !qName.equals("bookstore")) {
            System.out.print("节点名是：" + qName);
        }
    }

    /*
    遍历xml的结束标签
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if (qName.equals("book")) {
            bookList.add(book);
            book = null;
            System.out.println("*******结束遍历第" + i + "本书的遍历！******");
        } else if (qName.equals("name")) {
            book.setName(value);
        } else if (qName.equals("author")) {
            book.setAuthor(value);
        } else if (qName.equals("year")) {
            book.setYear(Integer.valueOf(value));
        } else if (qName.equals("language")) {
            book.setLanguage(value);
        }else if (qName.equals("price")) {
            book.setPrice(Double.parseDouble(value));
        }
    }

    /*
    获取element节点之间的内容
  */

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        value = new String(ch, start, length);
        if (!value.trim().equals("")) {
            System.out.println(",其值为-->" + value);
        }
    }
}
