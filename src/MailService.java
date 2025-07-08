class MailService {
    public static void processEmail(Mailable item, String email) {
        item.sendByEmail(email);
    }
}
