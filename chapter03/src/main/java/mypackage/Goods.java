package mypackage;

public class Goods {

	public static int countOfGoods;

	public Goods() {
		Goods.countOfGoods = Goods.countOfGoods + 1; // 생략가능

	}

	public String name; // 모든 접근제한 x
	protected int price; // 같은 패키지 + 자식 접근 가능
	int countStock; // 같은 패키지
	private int countSold; // 하나의 클래스에서만

}
