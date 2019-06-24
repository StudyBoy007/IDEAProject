package JAVAThree.JAVACollection.Map;

/**
 * Create by czq
 * time on 2019/6/21  9:39
 */
public class Num {
    public int num;

    public Num(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Num)) return false;

        Num num1 = (Num) o;

        return num == num1.num;
    }

    @Override
    public int hashCode() {
        return num;
    }
}
