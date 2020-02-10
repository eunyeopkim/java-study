package prob3;

public class CurrencyConverterTest {

	public static void main(String[] args) {
		CurrencyConverter cc = new CurrencyConverter();
		
		cc.setRate(1170);
		System.out.println("백만원은 "+cc.toDollar(1000000)+"달러입니다.");
		System.out.println("백달러는 "+cc.toKRW(100)+"원입니다.");

	}

}
