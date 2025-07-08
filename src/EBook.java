public class EBook extends Book implements Sellable, Mailable {
    protected String fileType;

    public EBook(String isbn, String title, String author, int yearPublished, double price, String fileType) {
        super(isbn, title, author, yearPublished, price);
        this.fileType = fileType;
    }

    @Override
    public String getBookType() {
        return "E Book";
    }

    public String getFileType() {
        return fileType;
    }
    @Override
    public boolean canBeSold() {
        return true;
    }

    @Override
    public void sendByEmail(String email) {
        System.out.println("Quantum book store: Sending EBook '" + this.getTitle()
                + "' (" + this.getFileType() + ") to email: " + email);
    }

}
