package lambda;

@FunctionalInterface
interface PrintString{
	void showString(String str);
}

public class LambdaTest {
	public static void main(String[] args) {
		
		PrintString lambdaPrint = str -> System.out.println(str);
		lambdaPrint.showString("Hello, Java");
		
		printString(lambdaPrint);
		
		PrintString str = returnPrint();
		str.showString("Hello");
	}
	
	public static void printString(PrintString p) {
		p.showString("Hello, Java");
	}
	
	public static PrintString returnPrint() {
		return s -> System.out.println(s + ", Java");
	}
}
