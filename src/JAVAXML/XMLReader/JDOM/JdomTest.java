package JAVAXML.XMLReader.JDOM;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class JdomTest {
    public static void main(String[] args) {
        SAXBuilder saxBuilder = new SAXBuilder();
        FileInputStream is = null;
        InputStreamReader isr=null;
        try {
            is = new FileInputStream("XML\\books.xml");
            isr=new InputStreamReader(is, "utf-8");//inputstreamreader字符流可以设置以什么格式编码输入指定xml文件，就不会乱码（编码格式要与文件的编码格式一致）
            Document document = saxBuilder.build(isr);
            Element rootElement = document.getRootElement();
            List<Element> childrenOne = rootElement.getChildren();
            for (Element children : childrenOne) {
                System.out.println("*******开始遍历第" + (childrenOne.indexOf(children)+1)+ "本书的属性值！******");
                //知道属性名1
//                Attribute attribute=children.getAttribute("id");
//                String name = attribute.getName();
//                String value = attribute.getValue();
//                System.out.print("属性名：" + name + "-->");
//                System.out.println("属性值：" + value);
                //知道属性名2
               String value=children.getAttributeValue("id");
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
                System.out.println("*******结束遍历第" + (childrenOne.indexOf(children)+1)+ "本书的属性值！******");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
