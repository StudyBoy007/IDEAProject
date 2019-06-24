package JAVAXML.XMLWrite.Dom4j;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class Dom4jTest {
    public static void main(String[] args) {
        Dom4jTest test = new Dom4jTest();
        test.createXml("File\\rssTest.xml");

    }

    /**
     * 解析xml
     */
    public static void parseXml() {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new File("XML\\books.xml"));
            Element rootElement = document.getRootElement();
            //通过迭代器获得孩子节点
            Iterator<Element> childrensOne = rootElement.elementIterator();
            int k = 0;
            while (childrensOne.hasNext()) {
                System.out.println("*******开始遍历第" + (k + 1) + "本书的属性值！******");
                Element children = childrensOne.next();
                //知道属性名1
//                String value1=children.attributeValue("id");
//                System.out.print("属性名：id-->");
//                System.out.println("属性值：" + value1);
                //知道属性名2
//                Attribute attribute=children.attribute("id");
//                String name1 = attribute.getName();
//                String value1 = attribute.getValue();
//                System.out.print("属性名：" + name1 + "-->");
//                System.out.println("属性值：" + value1);


                //不知道属性名
                List<Attribute> attributes = children.attributes();
                for (Attribute attribute : attributes) {
                    String name = attribute.getName();
                    String value = attribute.getValue();
                    System.out.print("属性名：" + name + "-->");
                    System.out.println("属性值：" + value);
                }
                Iterator<Element> childrensTwo = children.elementIterator();
                int i = 0;
                while (childrensTwo.hasNext()) {
                    Element childrenTwo = childrensTwo.next();
                    String name = childrenTwo.getName();
                    String value = childrenTwo.getText(); //1.getStringValue类似与dom中的gettextcontent 2.getText只获取标签中的内容，嵌套标签中内容不会输出
                    System.out.print(children.getName() + "的第" + (i++ + 1) + "子节点名称为：" + name);
                    System.out.println(",其值为：-->" + value);
                }
                System.out.println("*******结束遍历第" + (k++ + 1) + "本书的属性值！******");
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建xml文件
     */

    public static void createXml(String url) {
        //1.创建Document对象，代表整个xml文档
        Document document = DocumentHelper.createDocument();
        //2.创建根节点 ,
        Element rss = document.addElement("rss");
        //3.向rss中添加属性,添加属性
        rss.addAttribute("version", "2.0");
        //4.生成子节点,生成孩子节点
        Element channel = rss.addElement("channel");
        Element title = channel.addElement("title");

        //5.给节点之间添加内容
        title.setText("<！[CDATA[国内最新新闻]]>"); //<>会自动转义
        //6.生成xml文档格式
        OutputFormat format = OutputFormat.createPrettyPrint(); //自动给一个好看的漂亮格式的xml（带换行和缩进）
        format.setEncoding("utf-8");//设置编码
        //7.生成文件,通过流的方式生成文件
        XMLWriter writer;
        try {
            writer = new XMLWriter(new FileOutputStream(url), format);
            //设置是否转义，true转，false不转
            writer.setEscapeText(false);
            writer.write(document);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}