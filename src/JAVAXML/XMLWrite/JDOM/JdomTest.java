package JAVAXML.XMLWrite.JDOM;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.EscapeStrategy;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.*;
import java.util.List;

public class JdomTest {
    public static void main(String[] args) {
        JdomTest test = new JdomTest();
        test.parseXml();
        test.createXml("File\\jdomRss.xml");
    }

    /**
     * 解析xml
     */
    public static void parseXml() {
        SAXBuilder saxBuilder = new SAXBuilder();
        FileInputStream is = null;
        InputStreamReader isr = null;
        try {
            is = new FileInputStream("XML\\books.xml");
            isr = new InputStreamReader(is, "utf-8");//inputstreamreader字符流可以设置以什么格式编码输入指定xml文件，就不会乱码（编码格式要与文件的编码格式一致）
            Document document = saxBuilder.build(isr);
            Element rootElement = document.getRootElement();
            List<Element> childrenOne = rootElement.getChildren();
            for (Element children : childrenOne) {
                System.out.println("*******开始遍历第" + (childrenOne.indexOf(children) + 1) + "本书的属性值！******");
                //知道属性名1
//                Attribute attribute=children.getAttribute("id");
//                String name = attribute.getName();
//                String value = attribute.getValue();
//                System.out.print("属性名：" + name + "-->");
//                System.out.println("属性值：" + value);
                //知道属性名2
                String value = children.getAttributeValue("id");
                System.out.print("属性名：id-->");
                System.out.println("属性值：" + value);

//                List<Attribute> attributes = children.getAttributes();
//                for (Attribute attribute : attributes) {
//                    String name = attribute.getName();
//                    String value = attribute.getValue();
//                    System.out.print("属性名：" + name + "-->");
//                    System.out.println("属性值：" + value);
//                }
                List<Element> childrenTwo = children.getChildren();
                for (Element twochildren : childrenTwo) {
                    System.out.print(children.getName() + "的第" + (childrenTwo.indexOf(twochildren) + 1) + "子节点名称为：" + twochildren.getName());
                    System.out.println(",其值为：-->" + twochildren.getValue());
                }
                System.out.println("*******结束遍历第" + (childrenOne.indexOf(children) + 1) + "本书的属性值！******");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成xml
     */

    public static void createXml(String url) {
        //1.生成根节点
        Element rss = new Element("rss");
        //2.给节点添加属性值
        rss.setAttribute("version", "2.0");
        //3.生成dmocument,其中写入根节点，所以前面要先创建一个根节点
        //        Document document = new Document(rss);
        Document document = new Document();
        document.setRootElement(rss);
        //4.添加子节点
        Element channel = new Element("channel");
        rss.addContent(channel);
        Element title = new Element("title");
        //给节点之间添加内容
        title.setText("<国内最新新闻>");
        channel.addContent(title);
        //创建xml生成的格式
//        Format format=Format.getPrettyFormat();
        Format format=Format.getCompactFormat();
        format.setIndent("");
        format.setEncoding("utf-8");
        //生成xml文件
        XMLOutputter outputter = new XMLOutputter(format);
        try {
            outputter.output(document, new FileOutputStream(url));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
