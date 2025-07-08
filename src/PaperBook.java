public class PaperBook extends Book {
    protected int quantity;
    public PaperBook(String isbn, String title, String author, int yearPublished, double price, int quantity) {
        super(isbn, title, author, yearPublished, price);
        this.quantity = quantity;
    }

    @Override
    public String getBookType() {
        return "Paper Book";
    }

    public int getQuantity() {
        return quantity;
    }
    public void removeFromStock(int amount) {
        if (amount <= quantity) {
            quantity -= amount;
            System.out.println(quantity+ " Remaining items in stock" );
        } else {
            System.out.println("Not enough stock to remove " + amount + " items.");
        }
    }
    public void addToStock(int amount) {
        if (amount > 0) {
            quantity += amount;
            System.out.println(quantity + " Remaining items in stock");
        } else {
            System.out.println("Cannot add a non-positive amount to stock.");
        }
    }

}
