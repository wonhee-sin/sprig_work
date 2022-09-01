package streamex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {
		/*List<String> companyList = new ArrayList<>();
		companyList.add("LG");
		companyList.add("Samsung");
		companyList.add("Hyudai"); */
		
		
		List<String> companyList = Arrays.asList("LG", "Samsung", "현대");
		
		for(String c : companyList){
			System.out.println(c);
		}
		
		//Stream 클래서 - 람다식으로 구현
		Stream<String> stream = companyList.stream();
		stream.forEach(c -> System.out.println(c));
	}

}
