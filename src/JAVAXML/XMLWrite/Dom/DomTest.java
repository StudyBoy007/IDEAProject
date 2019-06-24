package JAVAXML.XMLWrite.Dom;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class DomTest {
    public static void main(String[] args) {
        DomTest test = new DomTest();
        test.createXml("File\\first.xml");
    }

    /**
     * 创建DocumentBUilder对象
     */
    public static DocumentBuilder getDB() {
        DocumentBuilder db = null;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return db;
    }


    /**
     * 解析xml文件
     *
     * @param url
     */
    public static void xmlParse(String url) {
        try {
            Document document = getDB().parse(url);
            //获得节点集
            NodeList books = document.getElementsByTagName("book");
            System.out.println("一共有" + books.getLength() + "本书！"); //获取nodelist集合的长度
            for (int i = 0; i < books.getLength(); i++) {
                System.out.println("*******开始遍历第" + (i + 1) + "本书的属性值！******");
                //获取nodelist中的某个节点
                Node book = books.item(i);
                //   System.out.println(book.getTextContent()); //直接得出该节点中包含的text类型节点的value值,不过该节点下还包含多少的
                //element类型的节点，都会得出最里面的text类型的节点的value值
                //可以不通过获取属性集合，直接通过属性的名称来获取属性的值，element对象有一个叫做getAttribute（）方法
                Element elementBook = (Element) book;
                String idvalue = elementBook.getAttribute("id");
//                System.out.println(book.getNodeName()+"节点的属性id的值为"+idvalue);
                //不知道属性的名称，遍历book的属性
                NamedNodeMap attrs = book.getAttributes();
                //获取属性的个数
                System.out.println("第" + (i + 1) + "本书共有" + attrs.getLength() + "个属性！");
                for (int j = 0; j < attrs.getLength(); j++) {
                    Node attr = attrs.item(j);
                    String name = attr.getNodeName();
                    String value = attr.getNodeValue();
                    System.out.print("属性名：" + name + "-->");
                    System.out.println("属性值：" + value);
                }
                NodeList childNodes = book.getChildNodes();
                System.out.println("*******第" + (i + 1) + "本书共有" + childNodes.getLength() + "个子节点！*******");
                for (int k = 0; k < childNodes.getLength(); k++) {
                    //区分两种不同的node，text node 和 element node
                    if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
                        System.out.print(book.getNodeName() + "的第" + (k + 1) + "子节点名称为：" + childNodes.item(k).getNodeName());
                        //将name 这些节点中间的内容不会当作是name这个element节点的值，而是当作element节点的子节点text node的value值
//                        String content=childNodes.item(k).getChildNodes().item(0).getNodeValue();
//                        System.out.println(",其值为：-->"+content);

//                       System.out.println(",其值为：-->"+childNodes.item(k).getTextContent());
                        System.out.println(",其值为：-->" + childNodes.item(k).getFirstChild().getNodeValue());
                    }
                }
                System.out.println("*******结束遍历第" + (i + 1) + "本书的属性值！******");
            }


        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成xml文件
     */
    public static void createXml(String url) {
        DocumentBuilder documentBuilder = getDB();
        Document document = documentBuilder.newDocument();//创建document对象
        //将生成得xml文档得上方得属性standalone设置为yes,默认为no
        document.setXmlStandalone(true);
        //创建一个element的节点
        Element bookstore = document.createElement("bookstore");
        //给根节点添加子节点
        Element book = document.createElement("book");
        //给节点添加属性
        book.setAttribute("id", "1");
        Element name=document.createElement("name");
        //给节点中添加内容
        name.setTextContent("小王子");
        book.appendChild(name);
        //添加孩子节点得方法
        bookstore.appendChild(book);
        //将整个bookstore节点添加到dom树中
        document.appendChild(bookstore);


        //将创建得xml文件生成
        TransformerFactory tff = TransformerFactory.newInstance();
        try {
            Transformer tf = tff.newTransformer();
            //设置输出得方式属性
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            //通过document对象创建dom资源对象
            DOMSource domSource = new DOMSource(document);
            //创建流结果的对象，说明生成xml文件的路径
            Result sr = new StreamResult(new File(url));
            tf.transform(domSource, sr);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}

