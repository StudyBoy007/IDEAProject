package JAVAThree.JAVAException.BookRent;

public class Book {
    private int bookNumber;
    private String bookName;

    public Book(int bookNumber, String bookName) {
        this.bookNumber = bookNumber;
        this.bookName = bookName;
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }


}
