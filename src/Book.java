import java.time.LocalDate;

public abstract class Book {
    protected String isbn;
    protected String title;
    protected String author;
    protected int yearPublished;
    protected double price;


    public Book(String isbn, String title, String author, int yearPublished, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.price = price;

    }

    //getters methods
    public double getPrice() {
        return price;
    }
    public int getYearPublished() {
        return yearPublished;
    }
    public String getAuthor() {
        return author;
    }
    public String getTitle() {
        return title;
    }
    public String getIsbn() {
        return isbn;
    }

    public abstract String getBookType();
    public boolean isOutDated(int yearLimit) {
        int currentYear = LocalDate.now().getYear();
        return (currentYear - yearPublished) > yearLimit;
    }

}