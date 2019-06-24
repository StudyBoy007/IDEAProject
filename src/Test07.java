public class Test07 {
    public static void main(String[] args) {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("ni haoa  a");
        System.out.println(stringBuilder.length());
//        stringBuilder.delete(0, stringBuilder.length());
        stringBuilder=new StringBuilder();
        System.out.println(stringBuilder.length());
        String a="a";
        String b="b";
        int c=a.compareTo(b);
        System.out.println(c);
    }

}
