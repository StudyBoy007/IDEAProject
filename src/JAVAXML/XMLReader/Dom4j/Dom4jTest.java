package JAVAXML.XMLReader.Dom4j;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;
import java.util.List;

public class Dom4jTest {
    public static void main(String[] args) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new File("XML\\books.xml"));
            Element rootElement = document.getRootElement();
            //通过迭代器获得孩子节点
            Iterator<Element> childrensOne = rootElement.elementIterator();
            int k=0;
            while (childrensOne.hasNext()) {
                System.out.println("*******开始遍历第" + (k+1)+ "本书的属性值！******");
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
                List<Attribute>attributes=children.attributes();
                for (Attribute attribute:attributes){
                    String name=attribute.getName();
                    String value=attribute.getValue();
                    System.out.print("属性名：" + name + "-->");
                    System.out.println("属性值：" + value);
                }
                Iterator<Element> childrensTwo=children.elementIterator();
                int i=0;
                while (childrensTwo.hasNext()){
                    Element childrenTwo=childrensTwo.next();
                    String name=childrenTwo.getName();
                    String value=childrenTwo.getText(); //1.getStringValue类似与dom中的gettextcontent 2.getText只获取标签中的内容，嵌套标签中内容不会输出
                    System.out.print(children.getName() + "的第" + (i++ +1) + "子节点名称为：" + name);
                    System.out.println(",其值为：-->" + value);
                }
                System.out.println("*******结束遍历第" + (k++ +1)+ "本书的属性值！******");
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }
}
