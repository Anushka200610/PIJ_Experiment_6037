import java.util.ArrayList;

public class ArrayListOfBooks {

    public static void main(String[] args) {

        ArrayList<Book> bookList = new ArrayList<>();

        // Default constructor
        Book b1 = new Book();
        bookList.add(b1);

        try {
            // Valid books
            Book b2 = new Book("Eclipse", "Stephenie Meyer", "Fiction", 455.5);
            Book b3 = new Book("Atomic Habits", "James Clear", 899.99, "123456");

            // Copy constructor
            Book b4 = new Book(b2);
            b4.name = "Harry Potter and the Deathly Hallows";
            b4.authorName = "J.K. Rowling";

            Book b5 = new Book(b3);
            b5.name = "The Lord of the Rings";
            b5.authorName = "J.R.R. Tolkien";
            b5.genre = "Fiction";

            // Add to ArrayList
            bookList.add(b2);
            bookList.add(b3);
            bookList.add(b4);
            bookList.add(b5);

            // ❌ Invalid price (exception test)
            Book b6 = new Book("Invalid Book", "Unknown", "Fiction", -200);
            bookList.add(b6);

        } catch (InvalidPriceException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        // Display all books
        System.out.println("\n--- All Books ---");
        bookList.forEach(Book::display);

        // Calculate average price
        double sum = 0;
        for (Book b : bookList) {
            sum += b.price;
        }
        double avg = sum / bookList.size();
        System.out.println("Average Price of Books: " + avg);

        // Print Fiction books using forEach()
        System.out.println("\n--- Fiction Books ---");
        bookList.forEach(b -> {
            if ("Fiction".equalsIgnoreCase(b.genre)) {
                System.out.println(b.name + " by " + b.authorName);
            }
        });
    }
}