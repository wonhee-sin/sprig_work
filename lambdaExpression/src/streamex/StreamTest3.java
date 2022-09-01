package streamex;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest3 {

	public static void main(String[] args) {
		List<Customer> list = Arrays.asList(
			new Customer("이순신", 40, 100),
			new Customer("강감찬", 30, 100),
			new Customer("홍길동", 14, 100)
			);
		Stream<Customer> stream = list.stream();
		stream.forEach(c -> System.out.println(
				"이름: " + c.getName() + " 나이: " +c.getAge() + " 비용: " + c.getCost()));
		
		int sum = list.stream().mapToInt(c ->c.getCost()).sum();
		System.out.println("총 여행 비용: " + sum);
		
		stream = list.stream();
		stream.filter(c-> c.getAge() > 20).map(c-> c.getName()).forEach(c-> System.out.println(c));
		
		list.stream().filter(c-> c.getAge() >=20).map(c->c.getName())
		.sorted().forEach(s->System.out.println(s));
	
	
	
	
	
	
	
	}
}