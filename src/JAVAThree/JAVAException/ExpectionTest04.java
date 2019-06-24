package JAVAThree.JAVAException;

//异常链,异常提示从上往下看才是正确的异常产生顺序
public class ExpectionTest04 {
    public static void main(String[] args) {
        ExpectionTest04 obj = new ExpectionTest04();
        try {
            obj.test2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void test1() throws DrunkException {
        throw new DrunkException("开车别喝酒~");
    }

    public void test2() {
        try {
            test1();
        } catch (DrunkException e) {
//            RuntimeException newexc = new RuntimeException("司机一滴酒，亲人两行泪~");
            RuntimeException newexc = new RuntimeException(e);
//            newexc.initCause(e); //新异常可以用initCause方法引用原始异常，也可以直接把原始异常的e对象当做创建新异常时的参数
            throw newexc;
        }
    }
}
