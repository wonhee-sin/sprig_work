package streamex;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Book{
	private String name;
	private int price;

	public Book(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public int getPrice() {
		return price;
	}
	public String getName() {
		return name;
	}
	

}
public class StreamTest4 {

	public static void main(String[] args) {
		List<Book> list = Arrays.asList(
				new Book ("자바", 25000),	
				new Book ("파이썬", 19000),	
				new Book ("안드로이드", 30000)	
				);
		
		Stream<Book> stream = list.stream();
		System.out.println(stream.mapToInt(b->b.getPrice()).sum());
	
		stream = list.stream();
		stream.filter(b->b.getPrice() > 20000).map(b->b.getName()).sorted().forEach(b->System.out.println(b));
	
	}

}
