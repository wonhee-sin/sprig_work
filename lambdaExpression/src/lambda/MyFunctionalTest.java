package lambda;

public class MyFunctionalTest {

	public static void main(String[] args) {
		
		MyFunctionalEx fi;
		
		fi = () ->{
			String str ="Hello~ lambda";
			System.out.println(str);
		};
		fi.method();
		
		//축약 문법
		fi = () -> System.out.println("Hello~ lambda");
		fi.method();

		System.out.println("=================================");
		
		MyFunctionalInterface fi2;
		
		fi2 = x ->{
			x = x +10;
			System.out.println(x);
		};
		fi2.method(10);
		
		//축약
		fi2 = x -> System.out.println(x+10);
		fi2.method(10);
		
		//제곱수
		fi2 = x -> System.out.println(x*x);
		fi2.method(5);
		
		System.out.println("=================================");
		
		MyNumber num;
		
		num = (x,y) -> {
			return (x >= y) ? x:y;
		};
		System.out.println(num.getMath(10, 20));
		
		//{}와 return 생략 가능
		num = (x,y) -> (x >= y) ? x:y;
		System.out.println("더 큰 수는 " + num.getMath(20, 10));
		
		System.out.println("=================================");
		
		StringConcat sc;
		
		sc = (s1, s2) -> System.out.println(s1+" "+s2);
		sc.makeString("hill", "state");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
