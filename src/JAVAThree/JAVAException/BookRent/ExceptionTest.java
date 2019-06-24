package JAVAThree.JAVAException.BookRent;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExceptionTest {
public static void main(String[] args) {
	Book []books={
			new Book(1, "��������"),new Book(2, "һǧ��һҹ"),new Book(3, "���Ʋ��"),new Book(4, "�䶯Ǭ��")};
	while(true){
		try {
//			System.out.println("������һ������");
//			Scanner input=new Scanner(System.in);
//			String a=input.next();
//			System.out.println(a);
			Scanner input=new Scanner(System.in);
			Map<String, Book>map=new HashMap<String, Book>();
			for (Book book : books) {
				map.put(book.getBookName(), book);
			}
			System.out.println("����ͼ������:");
			String bName=input.next();
			System.out.println("book:"+map.get(bName).getBookName());
			break;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("���鲻����");
		}
	}

	
}
}
