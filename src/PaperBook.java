public class PaperBook extends Book implements Shippable, Sellable {
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
    public boolean removeFromStock(int amount) {
        if (amount <= quantity) {
            quantity -= amount;
            System.out.println(quantity+ " Remaining items in stock" );
            return true;
        } else {
            System.out.println("Not enough stock to remove " + amount + " items.");
            return false;
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

    @Override
    public boolean canBeSold() {
        return quantity > 0;
    }

    @Override
    public void ship(String address, int quantity) {
        System.out.println("Quantum book store: Shipping " + quantity + " copy(ies) of '"
                + this.getTitle() + "' to address: " + address);
    }
}
