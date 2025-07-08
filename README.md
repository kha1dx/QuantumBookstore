Development Note
This project was fully implemented by me, 
and all methods and logic were developed based on my own reasoning to solve the challenge.
I used an AI assistant to explore more efficient coding patterns and as a guide to ensure my design adhered to professional best practices.
The role of the AI was that of a tutor and a reviewer, while the core development work remained my own.

Project Structure
QuantumBookstore.java: The main engine of the application. It holds the inventory and contains all the core business logic (addBook, buyBook, removeOutdatedBooks).

Book.java: The abstract base class for all book types.

PaperBook.java, EBook.java, ShowcaseBook.java: Concrete implementations for each type of book.

Sellable.java, Shippable.java, Mailable.java: Interfaces that define the "capabilities" of different book types.

ShippingService.java, MailService.java: Simple classes that simulate external services for processing deliveries.

Main.java: A comprehensive test suite that demonstrates all functionalities and covers various success, failure, and edge cases to ensure the system's accuracy.

