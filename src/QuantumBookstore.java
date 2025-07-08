import java.util.*;
public class QuantumBookstore {
    protected Map<String, Book> inventory;

    public QuantumBookstore() {
        inventory = new HashMap<>();
    }

    public void addBook(Book book) {
        inventory.put(book.getIsbn(), book);
        System.out.println("Quantum book store: Added " + book.getBookType() + " - " + book.getTitle());
    }

    public List<Book> removeOutdatedBooks(int yearLimit) {
        List<Book> removedBooks = new ArrayList<>();
        Iterator<Map.Entry<String, Book>> iterator = inventory.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Book> entry = iterator.next();
            Book book = entry.getValue();

            if (book.isOutdated(yearLimit)) {
                removedBooks.add(book);
                iterator.remove();
                System.out.println("Quantum book store: Removed outdated book - " + book.getTitle());
            }
        }

        return removedBooks;
    }

    public double buyBook(String isbn, int quantity, String email, String address) {
        Book book = inventory.get(isbn);

        if (book == null) {
            throw new IllegalArgumentException("Book with ISBN " + isbn + " not found");
        }

        if (!(book instanceof Sellable sellableBook)) {
            throw new IllegalArgumentException("This book type is not for sale");
        }

        if (!sellableBook.canBeSold()) {
            throw new IllegalArgumentException("Book is not available for sale");
        }

        double totalAmount = sellableBook.getPrice() * quantity;

        if (book instanceof PaperBook paperBook) {
            paperBook.removeFromStock(quantity);
        }

        if (book instanceof Shippable) {
            ShippingService.processShipping((Shippable) book, address, quantity);
        }

        if (book instanceof Mailable) {
            MailService.processEmail((Mailable) book, email);
        }
        System.out.println("Quantum book store: Purchase completed. Total amount: $" + totalAmount);
        return totalAmount;
    }


    public void displayInventory() {
        System.out.println("Quantum book store: Current Inventory:");
        for (Book book : inventory.values()) {
            String sellableStatus = (book instanceof Sellable) ? "Sellable" : "Not for sale";
            String shippableStatus = (book instanceof Shippable) ? "Shippable" : "Not shippable";
            String mailableStatus = (book instanceof Mailable) ? "Mailable" : "Not mailable";

            System.out.println("  " + book + " [" + sellableStatus + ", " + shippableStatus + ", " + mailableStatus + "]");
        }
    }
    public Book getBook(String isbn) {
        return inventory.get(isbn);
    }
}

