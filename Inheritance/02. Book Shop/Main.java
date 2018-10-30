
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Programming {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String author = reader.readLine();
        String title = reader.readLine();
        double price = Double.parseDouble(reader.readLine());
        Book b;
        GoldenEditionBook gb;
        try{
            b = new Book(title,author,price);
            gb = new GoldenEditionBook(title,author,price);
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }
        System.out.println(b);
        System.out.println(gb);



    }
}

class Book {
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        setTitle(title);
        setAuthor(author);
        setPrice(price);
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public double getPrice() {
        return this.price;
    }

    protected void setTitle(String title) {
        if (title.length() < 3) {
            throw new IllegalArgumentException("Title not valid!");
        }
        this.title = title;
    }

    protected void setAuthor(String author) {
        Pattern pattern = Pattern.compile("[\\d]+");
        Matcher m = pattern.matcher(author);
        if (m.find() || author.length() < 3) {
            throw new IllegalArgumentException("Author not valid!");
        }
        this.author = author;
    }

    protected void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price not valid!");
        }
        this.price = price;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName())
                .append("\n").append("Title: ").append(this.getTitle())
                .append("\n").append("Author: ").append(this.getAuthor())
                .append("\n").append("Price: ").append(this.getPrice())
                .append("\n");
        return sb.toString();
    }
}

class GoldenEditionBook extends Book {
    public GoldenEditionBook(String title, String author, double price) {
        super(title, author, price);
    }

    public double getPrice() {
        return super.getPrice() + super.getPrice() * 0.3;
    }

}
//bad practice just for testing purpose










