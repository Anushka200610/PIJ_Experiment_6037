import java.time.LocalDate;

public class Book {

    String name;
    String authorName;
    double price;
    String publisherName;
    String genre;
    String ISBN;
    LocalDate dateOfPublishing;

    // Default constructor
    public Book() {
        name = "Unknown";
        authorName = "Unknown";
        price = 0.0;
        publisherName = "Not specified";
        genre = "Uncategorised";
        ISBN = "000000";
        dateOfPublishing = LocalDate.of(2020, 1, 1);
    }

    // Parameterized constructor (throws exception)
    public Book(String name, String authorName, String genre, double price)
            throws InvalidPriceException {

        if (price < 0) {
            throw new InvalidPriceException("Price cannot be negative");
        }

        this.name = name;
        this.authorName = authorName;
        this.genre = genre;
        this.price = price;
        this.publisherName = "Unknown";
        this.ISBN = "N/A";
        this.dateOfPublishing = LocalDate.now();
    }

    // Another parameterized constructor
    public Book(String name, String authorName, double price, String ISBN)
            throws InvalidPriceException {

        if (price < 0) {
            throw new InvalidPriceException("Price cannot be negative");
        }

        this.name = name;
        this.authorName = authorName;
        this.price = price;
        this.ISBN = ISBN;
        this.genre = "General";
        this.publisherName = "Unknown";
        this.dateOfPublishing = LocalDate.now();
    }

    // Copy constructor
    public Book(Book b) {
        this.name = b.name;
        this.authorName = b.authorName;
        this.price = b.price;
        this.publisherName = b.publisherName;
        this.genre = b.genre;
        this.ISBN = b.ISBN;
        this.dateOfPublishing = b.dateOfPublishing;
    }

    // Method to display book details
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Author: " + authorName);
        System.out.println("Genre: " + genre);
        System.out.println("Price: " + price);
        System.out.println("ISBN: " + ISBN);
        System.out.println("Publisher: " + publisherName);
        System.out.println("Date: " + dateOfPublishing);
        System.out.println("--------------------------------");
    }
}