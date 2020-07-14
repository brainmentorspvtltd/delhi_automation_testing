package collections;

import java.util.HashSet;

class Book{
	private String title;
	private double price;
	private String author;
	public Book() {}
	public Book(String title, double price, String author) {
		super();
		this.title = title;
		this.price = price;
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + ", author=" + author + "]\n";
	}
	@Override
	public int hashCode() {
		return author.length() + (int)price;
	}
	
	@Override
	public boolean equals(Object object) {
		if(object instanceof Book) {
			Book book =(Book) object; // downcasting
			if(this.author.equals(book.author) && this.price==book.price && this.title.equals(book.title)) {
				return true;
			}
		}
		return false;
	}
}
public class BookSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Book> bookSet = new HashSet<>();
		Book book1 = new Book("Java",900,"Herbert");
		System.out.println(book1.hashCode());
		bookSet.add(book1);
		bookSet.add(new Book("LetUsC",700,"Yashwant"));
		bookSet.add(new Book("LetUsC",700,"Yashwant"));
		Book book2 = new Book("Java",900,"Herbert");
		System.out.println(book2.hashCode());
		bookSet.add(book2);
		System.out.println(bookSet);

	}

}
