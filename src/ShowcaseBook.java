public class ShowcaseBook extends Book {

    public ShowcaseBook(String isbn, String title, String author, int yearPublished, double price) {
        super(isbn, title, author, yearPublished, price);
    }

    @Override
    public String getBookType() {
        return "Showcase Book";
    }
}
