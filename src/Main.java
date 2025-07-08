import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Quantum book store: Starting Quantum Bookstore System Test\n");

        QuantumBookstore bookstore = new QuantumBookstore();

        // Test 1: Adding books
        System.out.println("=== Test 1: Adding Books ===");
        bookstore.addBook(new PaperBook("978-1234567890", "Java Programming", "John Smith", 2020, 45.99, 10));
        bookstore.addBook(new EBook("978-0987654321", "Python Basics", "Jane Doe", 2022, 29.99, "PDF"));
        bookstore.addBook(new ShowcaseBook("978-1111222233", "Advanced Algorithms", "Bob Johnson", 2023, 0.00));
        bookstore.addBook(new PaperBook("978-5555666677", "Old Programming Book", "Old Author", 2010, 25.00, 5));

        System.out.println();
        bookstore.displayInventory();

        // Test 2: Buying books
        System.out.println("\n=== Test 2: Buying Books ===");
        try {
            double amount1 = bookstore.buyBook("978-1234567890", 2, "customer@email.com", "123 Main St");
            System.out.println("Quantum book store: Paid amount: $" + amount1);

            double amount2 = bookstore.buyBook("978-0987654321", 1, "customer@email.com", "123 Main St");
            System.out.println("Quantum book store: Paid amount: $" + amount2);
        } catch (Exception e) {
            System.out.println("Quantum book store: Error - " + e.getMessage());
        }

        // Test 3: Trying to buy showcase book (should fail)
        System.out.println("\n=== Test 3: Trying to Buy Showcase Book ===");
        try {
            bookstore.buyBook("978-1111222233", 1, "customer@email.com", "123 Main St");
        } catch (Exception e) {
            System.out.println("Quantum book store: Error - " + e.getMessage());
        }

        // Test 4: Trying to buy more than available stock
        System.out.println("\n=== Test 4: Trying to Buy More Than Available Stock ===");
        try {
            bookstore.buyBook("978-1234567890", 20, "customer@email.com", "123 Main St");
        } catch (Exception e) {
            System.out.println("Quantum book store: Error - " + e.getMessage());
        }

        // Test 5: Removing outdated books
        System.out.println("\n=== Test 5: Removing Outdated Books ===");
        List<Book> removedBooks = bookstore.removeOutdatedBooks(10);
        System.out.println("Quantum book store: Removed " + removedBooks.size() + " outdated books");

        System.out.println("\n=== Final Inventory ===");
        bookstore.displayInventory();

        System.out.println("\nQuantum book store: Test completed successfully!");
    }}